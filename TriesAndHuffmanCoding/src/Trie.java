
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
class TrieNode {

    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {

    TrieNode root;
    int numWords;

    public Trie() {
        root = new TrieNode('\0');
    }
    
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    
    public void autoComplete(TrieNode root, String word, String output, int length) {
        if (word.length() == 0) {
            if(root == null)
                return;
//            // for dictionary searching
//            //return root.isTerminating;
//            // for pattern matching
            
            if(root.isTerminating) {
                //System.out.println(output);
            }
            for(int i = 0; i < root.children.length; i ++) {
                if(root.children[i] != null) {
                    if(root.isTerminating)
                        map.put(output, true);
                    String w = output + root.children[i].data;
                    autoComplete(root.children[i], "", w, length);
                }
            }
            if(length < output.length() && root.childCount == 0 && root.isTerminating) {
                map.put(output, true);
            }
        } else{
            int childIndex = word.charAt(0) - 'a';
            if (root.children[childIndex] != null) {
                String w = output + root.children[childIndex].data;
                autoComplete(root.children[childIndex], word.substring(1), w, ++length);
            }
        }
    }
    
    public void autoComplete(ArrayList<String> input, String w) {
        for(int i = 0; i < input.size(); i ++)
            add(input.get(i));
        autoComplete(root, w, "", 0);
        Set<String> set = map.keySet();
        for(String st : set) {
            System.out.println(st);
        }
    }
    
    public void add(TrieNode root, String word) {
        if (word.length() == 0) {
            if (!root.isTerminating) {
                root.isTerminating = true;
                numWords++;
            }
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    public void patternMatchingAdd(String word) {
        if (word.length() == 0) {
            return;
        }
        add(word);
        patternMatchingAdd(word.substring(1));
        //patternMatchingAdd(word.substring(0, word.length() - 1));
    }

    public boolean patternMatching(ArrayList<String> input, String pattern) {
	// Complete this function
        // Return the output as specified in question
        for(int i = 0; i < input.size(); i ++)
            patternMatchingAdd(input.get(i));
        return search(pattern);
    }
    
    public boolean findIfPalindromePair(ArrayList<String> vect) {
        // Complete this function
        // Return the output as specified in question
        for(int i = 0; i < vect.size(); i ++) {
            String r = "";
            for(int j = 1; j <= vect.get(i).length(); j ++) {
                r = r + vect.get(i).charAt(vect.get(i).length() - j);
            }
            if(vect.get(i).equals(r))
                return true;
            patternMatchingAdd(r);
            for(int j = 0; j < vect.size(); j ++) {
                if(vect.get(j) != vect.get(i)) {
                    if(search(vect.get(j)) == true)
                        return true;
                }
            }
            patternMatchingRemove(vect.get(i));
        }
        return false;
    }
    
    public void patternMatchingRemove(String word) {
        if (word.length() == 0) {
            return;
        }
        remove(word);
        patternMatchingAdd(word.substring(1));
        //patternMatchingAdd(word.substring(0, word.length() - 1));
    }
    
    public void remove(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = false;
            numWords--;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        remove(child, word.substring(1));
        if (!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
    }

    public void remove(String word) {
        remove(root, word);
    }

    public boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            // for dictionary searching
            //return root.isTerminating;
            // for pattern matching
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        if (root.children[childIndex] != null) {
            return search(root.children[childIndex], word.substring(1));
        }
        return false;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    public int countWords() {
        // Write your code here
        return numWords;
    }
}

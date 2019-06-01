
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();
        ArrayList<String> input = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i ++)
            input.add(scan.next());
        //System.out.println(t.findIfPalindromePair(input));
        String st = scan.next();
        System.out.println();
        t.autoComplete(input, st);
    }
}

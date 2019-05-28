
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ExtractUniqueCharacters {
    public static String uniqueChar(String str){
        // Write your code here
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        String output = "";
        for(int i = 0; i < str.length(); i ++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), true);
                output = output + str.charAt(i);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(uniqueChar(s));
    }
}

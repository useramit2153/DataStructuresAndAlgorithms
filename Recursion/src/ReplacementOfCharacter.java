/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReplacementOfCharacter {
    
    public static String replaceCharacter(String input, char c1, char c2){
        if(input.length() == 0){
            return input;
        }
        String ans = "";
        if(input.charAt(0) == c1){
            ans = ans + c2;
        } else {
            ans = ans + input.charAt(0);
        }
        String smallans = replaceCharacter(input.substring(1), c1, c2);
        return ans + smallans;
    }
    
    public static void main(String[] args) {
        String st = "abacd";
        char c1 = 'a';
        char c2 = 'x';
        String ans = replaceCharacter(st, c1, c2);
        System.out.println(ans);
    }
}

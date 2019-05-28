/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class CheckPalindrome {
    
    public static String reverse = "";
    
    public static boolean isStringPalindrome(String input){
        if(input.length() <= 0){
            return false;
        }
        char s = input.charAt(input.length() - 1);
        reverse = reverse + s;
        String smallinput = input.substring(0, input.length() - 1);
        boolean smallans = isStringPalindrome(smallinput);
        if(reverse.compareTo(input) == 0){
            return true;
        }
//        reverse = reverse + input.charAt(0);
//        if(input == reverse){
//            System.out.println("hello");
//        }
        
        return smallans;
    }
    
    public static void main(String[] args) {
        String st = "toot";
        boolean ans = isStringPalindrome(st);
        System.out.println(ans);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class RemoveDuplicates {
    
    public static String removeConsecutiveDuplicates(String s){
        if(s.length() <= 1){
            return s;
        }
        String ans = "";
        ans = ans + s.charAt(0);
        String smallans = removeConsecutiveDuplicates(s.substring(1));
        // return on condition
        if(smallans.charAt(0) == ans.charAt(0)){
            return ans + smallans.substring(1);
        } else {
            return ans + smallans;
        }
    }
    
    public static void main(String[] args) {
        String st = "aabccba";
        String ans = removeConsecutiveDuplicates(st);
        System.out.println(ans);
    }
    
}

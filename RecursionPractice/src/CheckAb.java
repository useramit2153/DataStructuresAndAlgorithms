/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class CheckAb {
    
    public static int flag = 0;
    
    public static boolean checkAB(String input) {
        if(input.length() <= 0) {
            return true;
        }
        if(input.charAt(0) == 'a') {
            flag = 1;
            return checkAB(input.substring(1));
        }
        if(input.length() > 1) {
            if(input.substring(0, 2).compareTo("bb") == 0 && flag == 1) {
                flag = 2;
                return checkAB(input.substring(2));
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        String st = "abbabbaaabbabbaaaaaa";
        System.out.println(checkAB(st));
    }
    
}

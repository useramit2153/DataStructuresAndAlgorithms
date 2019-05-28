/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PrintAllCodes {
    
    public static char getChar(int n) {
        char[] c = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return c[n];
    }
    
    public static void getAllAns(String input, String output) {
        
        if(input.length() <= 0) {
            System.out.println(output);
            return;
        }
        
        int n1 = Integer.parseInt("" + input.charAt(0));
        if(n1 > 0 && n1 < 27) {
            String smallOutput1 = output + getChar(n1);
            getAllAns(input.substring(1), smallOutput1);
        }
        if(input.length() >= 2) {
            int n2 = Integer.parseInt("" + input.charAt(0) + input.charAt(1));
            if(n2 > 0 && n2 < 27) {
                String smallOutput2 = output + getChar(n2);
                getAllAns(input.substring(2), smallOutput2);
            }
        }
    }
    
    public static void printAllPossibleCodes(String input) {
        getAllAns(input, "");
    }
    
    public static void main(String[] args) {
        String input = "1123456";
        printAllPossibleCodes(input);
    }
    
}

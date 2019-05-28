/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PrintSubsequences {
    
    public static void printsubsequences(String input, String output) {
        if(input.length() <= 0) {
            System.out.println(output);
            return;
        }
        printsubsequences(input.substring(1), output);
        printsubsequences(input.substring(1), output + input.charAt(0));
    }
    
    public static void printsubsequences(String st){
        printsubsequences(st, "");
    }
    
    public static void main(String[] args) {
        String st = "xyz";
        printsubsequences(st);
    }
    
}

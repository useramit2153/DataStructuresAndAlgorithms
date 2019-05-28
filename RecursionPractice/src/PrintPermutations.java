/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PrintPermutations {
    
    public static void getAns(String input, String output) {
        
        if(input.length() <= 0) {
            System.out.println(output);
            return;
        }
        
        for(int i = 0; i < input.length(); i ++) {
            getAns((input.substring(0, i) + input.substring(i + 1)), output + input.charAt(i));
        }
        
    }
    
    public static void permutations(String input) {
        
        getAns(input, "");
        
    }
    
    public static void main(String[] args) {
        String str = "agd";
        permutations(str);
    }
    
}

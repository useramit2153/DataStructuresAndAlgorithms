/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PrintKeypadCode {
    
    public static String[] helper(int n){
        switch(n){
            case 2:
                String[] code2 = {"a", "b", "c"};
                return code2;
            case 3:
                String[] code3 = {"d", "e", "f"};
                return code3;
            case 4:
                String[] code4 = {"g", "h", "i"};
                return code4;
            case 5:
                String[] code5 = {"j", "k", "l"};
                return code5;
            case 6:
                String[] code6 = {"m", "n", "o"};
                return code6;
            case 7:
                String[] code7 = {"p", "q", "r", "s"};
                return code7;
            case 8:
                String[] code8 = {"t", "u", "v"};
                return code8;
            case 9:
                String[] code9 = {"w", "x", "y", "z"};
                return code9;
        }
        String[] code = {""};
        return code;
    } 
    
    private static void printKeypad(int input, String output) {
        if(input <= 0) {
            System.out.println(output);
            return;
        }
        
        String[] temp = helper((input % 10));
        for(int i = 0; i < temp.length; i ++){
            printKeypad(input / 10, temp[i] + output);
        }
    }
    
    public static void printKeypad(int input) {
        printKeypad(input, "");
    }
    
    public static void main(String[] args) {
        int n = 23;
        printKeypad(n);
    }
    
}

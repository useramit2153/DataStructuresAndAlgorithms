/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StringToInteger {
    
    public static int smallans = 0;
    
    public static int convertStringToInt(String input){
        if(input.length() <= 0){
            return smallans;
        }
        smallans = (smallans * 10) + Integer.parseInt("" + input.charAt(0));
        convertStringToInt(input.substring(1, input.length()));
        return smallans;
    }
    
    public static void main(String[] args) {
        String st = "675";
        int ans = convertStringToInt(st);
        System.out.println(ans);
    }
}

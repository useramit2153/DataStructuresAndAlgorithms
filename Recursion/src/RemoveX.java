/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class RemoveX {
    
    public static String smallans = "";
    
    public static String removeX(String input){
        if(input.length() <= 0){
            return smallans;
        }
        if(input.charAt(0) != 'x'){
            smallans = smallans + input.charAt(0);
        }
        removeX(input.substring(1, input.length()));
        return smallans;
    }
    
    public static void main(String[] args) {
        String st = "abcd";
        String ans = removeX(st);
        System.out.println(ans);
    }
}

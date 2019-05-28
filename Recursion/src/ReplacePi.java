/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReplacePi {
    
    public static String smallans = "";
    
    public static String replace(String input){
        String checkedSt = "";
        if(input.length() <= 0){
            return smallans;
        }
        if(input.length() > 1){
            checkedSt = input.substring(0, 2);
        }
        if(checkedSt.compareTo("pi") == 0){
            //System.out.println(checkedSt);
            //count = count + 3;
            //input = input.replaceFirst("pi", "3.14");
            smallans = smallans + "3.14";
            replace(input.substring(2, input.length()));
        } else{
            smallans = smallans + input.charAt(0);
            replace(input.substring(1, input.length()));
        }
        return smallans;
    }
    
    public static void main(String[] args) {
        String st = "pip";
        String ans = replace(st);
        System.out.println(ans);
    }
}

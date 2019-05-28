/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PairStar {
    
    public static String smallans = "";
    public static String sample = "";
    
    public static String addStars(String s){
        if(s.length() <= 0){
            return smallans;
        }
        if(sample.contains(s.charAt(0) + "")){
            smallans = smallans + "*" + s.charAt(0);
        } else {
            sample = "";
            sample = sample + s.charAt(0);
            smallans = smallans + s.charAt(0);
        }
        addStars(s.substring(1, s.length()));
        return smallans;
    }
    
    public static void main(String[] args) {
        String st = "xxyy";
        String ans = addStars(st);
        System.out.println(ans);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReturnAllCodes {
    
    public static char getChar(int n) {
        char[] c = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return c[n];
    }
    
    private static String[] getAns(String input, String output) {
        
        if(input.length() <= 0) {
            String[] temp = new String[0];
            int n = Integer.parseInt(output);
            if(n > 0 && n < 27) {
                temp = new String[1];
                char c = getChar(n);
                temp[0] = "" + c;
            }
            return temp;
        }
        
        String[] smallAns1 = getAns(input.substring(1), "" + input.charAt(0));
        String[] smallAns2 = new String[0];
        if(input.length() > 1) {
            smallAns2 = getAns(input.substring(2), "" + input.charAt(0) + input.charAt(1));
        }
        
        int l = 8;
        if(output != ""){
            l = Integer.parseInt(output);
        }
        
        String[] ans = new String[0];
        if(l > 0 && l < 27) {
            ans = new String[smallAns1.length + smallAns2.length];
            int count = 0;
        
            for(int i = 0; i < smallAns1.length; i ++) {
                if(output == "") {
                    ans[count] = smallAns1[i];
                } else {
                    char c = getChar(l);
                    ans[count] = c + smallAns1[i];
                }
                count ++;
            }
            for(int i = 0; i < smallAns2.length; i ++) {
                if(output == "") {
                    ans[count] = smallAns2[i];
                } else {
                    char c = getChar(l);
                    ans[count] = c + smallAns2[i];
                }
                count ++;
            }
        }
        return ans;
        
    }
    
    public static String[] getCode(String input){
	String[] ans = getAns(input, "");
        return ans;
    }
    
    public static void main(String[] args) {
        String input = "35411";
        String[] ans = getCode(input);
        for(int i = 0; i < ans.length; i ++) {
            System.out.println(ans[i]);
        }
    }
    
}

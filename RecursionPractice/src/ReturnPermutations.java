/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReturnPermutations {
    
    public static String[] permutationOfString(String input) {
        if(input.length() <= 2) {
            String[] temp;
            if(input.length() <= 1) {
                temp = new String[1];
                temp[0] = input;
                return temp;
            }
            temp = new String[2];
            temp[0] = input;
            temp[1] = "" + input.charAt(1) + input.charAt(0);
            return temp;
        }
        
        String[] smallAns = permutationOfString(input.substring(1));
        String[] ans = new String[(smallAns[0].length() + 1) * smallAns.length];
        int count = 0;
        for(int i = 0; i < smallAns.length; i ++) {
            for(int j = 0; j <= smallAns[i].length(); j ++) {
                ans[count] = smallAns[i].substring(0, j) + input.charAt(0) + smallAns[i].substring(j);
                count ++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String str = "abc";
        String[] ans = permutationOfString(str);
        for(int i = 0; i < ans.length; i ++) {
            System.out.println(ans[i]);
        }
    }
    
}

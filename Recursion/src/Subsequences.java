/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class Subsequences {
    
    public static String[] findSubsequences(String str){
        if(str.length() == 0) {
            String[] ans = {""};
            return ans;
        }
        String[] smallans = findSubsequences(str.substring(1));
        String[] ans = new String[smallans.length * 2];
        for(int i = 0; i < smallans.length; i ++) {
            ans[i] = smallans[i];
        }
        for(int i = 0; i < smallans.length; i ++){
            ans[smallans.length + i] = str.charAt(0) + smallans[i];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String st = "xyz";
        String[] ans = findSubsequences(st);
        for(int i = 0; i < ans.length; i ++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
}

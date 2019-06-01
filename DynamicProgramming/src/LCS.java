/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class LCS {
    
    public static int lcs(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return 0;
        }
        if(s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            int op1 = lcs(s, t.substring(1));
            int op2 = lcs(s.substring(1), t);
            return Math.max(op1, op2);
        }
    }
    
    public static int lcsM(int[][] output, String s, String t) {
        int m = s.length();
        int n = t.length();
        if(output[m][n] != -1)
            return output[m][n];
        if(s.length() == 0 || t.length() == 0) {
            output[m][n] = 0;
            return output[m][n];
        }
        if(s.charAt(0) == t.charAt(0)) {
            output[m][n] = 1 + lcs(s.substring(1), t.substring(1));
            return output[m][n];
        } else {
            int op1 = lcs(s, t.substring(1));
            int op2 = lcs(s.substring(1), t);
            output[m][n] = Math.max(op1, op2);
            return output[m][n];
        }
    }
    
    public static int lcsM(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] output = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++)
            output[i][0] = 0;
        for(int j = 0; j <= n; j ++)
            output[0][j] = 0;
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                output[i][j] = -1;
            }
        };
        int ans = lcsM(output, s, t);
//        for(int i = 0; i <= m; i ++) {
//            for(int j = 0; j <= n; j ++) {
//                System.out.print(output[i][j] + " ");
//            }
//            System.out.println();
//        };
        return ans;
    }
    
    public static int lcsDP(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] output = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++)
            output[i][0] = 0;
        for(int j = 0; j <= n; j ++)
            output[0][j] = 0;
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(s.charAt(m - i) == t.charAt(n - j)) {
                    output[i][j] = 1 + output[i - 1][j - 1];
                } else {
                    output[i][j] = Math.max(output[i][j - 1], output[i - 1][j]);
                }
            }
        }
//        for(int i = 0; i <= m; i ++) {
//        	for(int j = 0; j <= n; j ++) {
//        		System.out.print(output[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        return output[m][n];
    }
    
    public static void main(String[] args) {
        String s = "adgei";
        String t = "abegi";
        System.out.println(lcsDP(s, t));
        System.out.println(lcsM(s, t));
        System.out.println(lcs(s, t));
    }
}

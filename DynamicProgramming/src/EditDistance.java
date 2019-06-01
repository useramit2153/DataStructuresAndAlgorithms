/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class EditDistance {

    public static int editDistance(String s1, String s2) {
		//Your class should be named Solution
        //* Don't write main().
        //* Don't read input, it is passed as function argument.
        //* Return output and don't print it.

	//write your code here
        if(s1.length() == 0 && s2.length() != 0)
            return s2.length();
        if(s1.length() != 0 && s2.length() == 0)
            return s1.length();
        if(s1.length() == 0 && s2.length() == 0)
            return 0;
        
        int op1 = 0, op2 = 0, op3 = 0;
        if(s1.charAt(0) == s2.charAt(0)) {
            return editDistance(s1.substring(1), s2.substring(1));
        } else {
            op1 = editDistance(s1, s2.substring(1));
            op2 = editDistance(s1.substring(1), s2);
            op3 = editDistance(s1.substring(1), s2.substring(1));
            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }
    
    public static int editDistanceM(int[][] output, String s1, String s2) {
		//Your class should be named Solution
        //* Don't write main().
        //* Don't read input, it is passed as function argument.
        //* Return output and don't print it.

	//write your code here
        if(s1.length() == 0 && s2.length() != 0) {
            output[s1.length()][s2.length()] = s2.length();
            return output[s1.length()][s2.length()];
        }
        if(s1.length() != 0 && s2.length() == 0) {
            output[s1.length()][s2.length()] = s1.length();
            return output[s1.length()][s2.length()];
        }
        if(s1.length() == 0 && s2.length() == 0) {
            output[s1.length()][s2.length()] = 0;
            return output[s1.length()][s2.length()];
        }
        if(output[s1.length()][s2.length()] != -1)
            return output[s1.length()][s2.length()];
        
        int op1 = 0, op2 = 0, op3 = 0;
        if(s1.charAt(0) == s2.charAt(0))
            output[s1.length()][s2.length()] = editDistanceM(output, s1.substring(1), s2.substring(1));
        else {
            op1 = editDistanceM(output, s1, s2.substring(1));
            op2 = editDistanceM(output, s1.substring(1), s2);
            op3 = editDistanceM(output, s1.substring(1), s2.substring(1));
            output[s1.length()][s2.length()] = 1 + Math.min(op1, Math.min(op2, op3));
        }
        return output[s1.length()][s2.length()];
    }
    
    public static int editDistanceM(String s1, String s2) {
		//Your class should be named Solution
        //* Don't write main().
        //* Don't read input, it is passed as function argument.
        //* Return output and don't print it.

	//write your code here
        int[][] output = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i ++) {
            output[i][0] = i;
        }
        for(int i = 0; i <= s2.length(); i ++) {
            output[0][i] = i;
        }
        for(int i = 1; i <= s1.length(); i ++) {
            for(int j = 1; j <= s2.length(); j ++) {
                output[i][j] = -1;
            }
        }
        return editDistanceM(output, s1, s2);
    }
    
    public static int editDistanceDP(String s1, String s2) {
		//Your class should be named Solution
        //* Don't write main().
        //* Don't read input, it is passed as function argument.
        //* Return output and don't print it.

	//write your code here
        int[][] output = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i ++) {
            output[i][0] = i;
        }
        for(int i = 0; i <= s2.length(); i ++) {
            output[0][i] = i;
        }
        for(int i = 1; i <= s1.length(); i ++) {
            for(int j = 1; j <= s2.length(); j ++) {
                if(s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j))
                    output[i][j] = output[i - 1][j - 1];
                else
                    output[i][j] = 1 + Math.min(output[i][j - 1], Math.min(output[i - 1][j - 1], output[i - 1][j]));
            }
        }
        return output[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(editDistanceDP("asdfasdfasdfasdfasdfasdfasdfgasdgasd", "asdgasdgaasdf"));
        System.out.println(editDistanceM("asdfasdfasdfasdfasdfasdfasdfgasdgasd", "asdgasdgaasdf"));
        System.out.println(editDistance("asdfasdfasdfasdfasdfasdfasdfgasdgasd", "asdgasdgaasdf"));
    }
}

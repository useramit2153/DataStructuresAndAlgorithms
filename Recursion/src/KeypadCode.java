/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class KeypadCode {
    
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
    
    public static String[] keypad(int n){
        if(n <= 1){
            String[] ans = {""};
            return ans;
        }
        String[] smallAns = keypad(n / 10);
        String[] ans, temp;
        if(smallAns[0] == ""){
            smallAns = helper(n);
            ans = new String[smallAns.length];
            for(int i = 0; i < smallAns.length; i ++){
                ans[i] = smallAns[i];
            }
        } else {
            temp = helper(n % 10);
            ans = new String[smallAns.length * temp.length];
            int k = 0;
            for(int i = 0; i < smallAns.length; i ++) {
                for(int j = 0; j < temp.length; j ++) {
                    ans[k] = smallAns[i] + temp[j];
                    k ++;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int n = 24;
        String[] str = keypad(n);
        for(int i = 0; i < str.length; i ++){
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }
    
}

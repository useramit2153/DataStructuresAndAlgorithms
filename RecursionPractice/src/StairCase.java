/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StairCase {
    
    public static int staircase(int n) {
        if(n == 0) {
            return 1;
        } else if (n > 0){
            int count1 = staircase(n - 1);
            int count2 = staircase(n - 2);
            int count3 = staircase(n - 3);
            int count = count1 + count2 + count3;
            return count;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        int n = 2;
        int ans = staircase(n);
        System.out.println(ans);
    }
    
}

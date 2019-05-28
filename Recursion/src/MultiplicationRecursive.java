/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MultiplicationRecursive {
    
    public static int multiplyTwoIntegers(int m, int n){
        if(n <= 1){
            return m;
        }
        int smallans = multiplyTwoIntegers(m, n - 1);
        return m + smallans;
    }
    
    public static void main(String[] args) {
        int m = 12;
        int n = 5;
        int ans = multiplyTwoIntegers(m, n);
        System.out.println(ans);
    }
}

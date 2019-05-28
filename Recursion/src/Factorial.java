/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class Factorial {
    public static int fact(int n){
        
        if(n <= 0){
            return 1;
        }
        
        int smallans = fact(n - 1);
        
        return n * smallans;
    }
    public static void main(String[] args) {
        int n = 3;
        int ans = fact(n);
        System.out.println(ans);
    }
}

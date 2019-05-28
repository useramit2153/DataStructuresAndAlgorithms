/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class SumOfNaturalNumbers {
    
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        
        int smallans = sum(n - 1);
        
        return smallans + n;
    }
    
    public static void main(String[] args) {
        int n = Math.abs(4);
        int ans = sum(n);
        System.out.println(ans);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class NumberOfDigits {
    
    public static int count(int n){
        
        if(n == 0){
            return 0;
        }
        
        int smallans = count(n / 10);
        return smallans + 1;
    }
    
    public static void main(String[] args) {
        int n = 10;
        int ans = count(n);
        System.out.println(ans);
    }
}

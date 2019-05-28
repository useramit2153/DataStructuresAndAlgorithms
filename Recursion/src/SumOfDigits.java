/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class SumOfDigits {
    
    public static int sumOfDigits(int input){
        if(input <= 0){
            return 0;
        }
        int smallans = sumOfDigits(input / 10);
        return (input % 10) + smallans;
    }
    
    public static void main(String[] args) {
        int n = 671;
        int ans = sumOfDigits(n);
        System.out.println(ans);
    }
}

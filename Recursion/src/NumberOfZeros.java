/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class NumberOfZeros {
    
    public static int count = 0;
    
    public static int countZerosRec(int input){
        if(input <= 0){
            return 0;
        }
        countZerosRec(input / 10);
        if(input % 10 == 0)
            count ++;
        return count;
    }
    
    public static void main(String[] args) {
        int n = 1048089608;
        int ans = countZerosRec(n);
        System.out.println(ans);
    }
}

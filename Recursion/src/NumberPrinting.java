/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class NumberPrinting {
    
    public static void print(int n){
        if(n <= 0){
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }
    
    public static void main(String[] args) {
        int n = 6;
        print(n);
        System.out.println();
    }
}

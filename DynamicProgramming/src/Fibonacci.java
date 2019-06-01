/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class Fibonacci {
    public static int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
    
    public static int fibM(int n, int[] arr) {
        if(arr[n] != -1)
            return arr[n];
        if(n == 0 || n == 1){
            arr[n] = n;
            return arr[n];
        }
        arr[n] = fibM(n - 1) + fibM(n - 2);
        return arr[n];
    }
    
    public static int fibM(int n) {
        int[] arr = new int[n + 1];
        for(int i = 0; i < n + 1; i ++)
            arr[i] = -1;
        return fibM(n, arr);
    }
    
    public static int fibDP(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 2; i <= n; i ++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
    
    public static void main(String[] args) {
        int n = 44;
        System.out.println("Dynamic Version: " + fibDP(n));
        System.out.println("Memorization Version: " + fibM(n));
        System.out.println("Static Version: " + fib(n));
    }
}

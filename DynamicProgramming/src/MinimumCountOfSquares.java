/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MinimumCountOfSquares {

    public static int minCount(int n) {
        // Write your code here
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            count = minCount(n - (int) Math.pow(i, 2));
            if (min > count) {
                min = count;
            }
        }
        return min + 1;
    }

    public static int minCountDP(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int j = 1; j < n + 1; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= (int) Math.sqrt(j); i++) {
                if (min > arr[j - (int) Math.pow(i, 2)]) {
                    min = arr[j - (int) Math.pow(i, 2)];
                }
                arr[j] = 1 + min;
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(minCountDP(n));
        System.out.println(minCount(n));
    }
}

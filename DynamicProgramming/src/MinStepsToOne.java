/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MinStepsToOne {

    public static int countStepsTo1(int n) {
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (n == 1) {
            return 0;
        }
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        int opt3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            opt1 = countStepsTo1(n / 2);
        }
        if (n % 3 == 0) {
            opt2 = countStepsTo1(n / 3);
        }
        opt3 = countStepsTo1(n - 1);
        return Math.min(opt1, Math.min(opt2, opt3)) + 1;
    }

    public static int countStepsTo1M(int n, int[] arr) {
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (arr[n] != -1) {
            return arr[n];
        }
        if (n == 1) {
            arr[n] = 0;
            return arr[n];
        }
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        int opt3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            opt1 = countStepsTo1(n / 2);
        }
        if (n % 3 == 0) {
            opt2 = countStepsTo1(n / 3);
        }
        opt3 = countStepsTo1(n - 1);
        arr[n] = Math.min(opt1, Math.min(opt2, opt3)) + 1;
        return arr[n];
    }

    public static int countStepsTo1M(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = -1;
        }
        return countStepsTo1M(n, arr);
    }

    public static int countStepsTo1DP(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        for(int i = 2; i < n + 1; i ++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            if(i % 2 == 0)
                a = arr[i / 2];
            if(i % 3 == 0)
                b = arr[i / 3];
            c = arr[i - 1];
            arr[i] = Math.min(a, Math.min(b, c)) + 1;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(countStepsTo1DP(n));
        System.out.println(countStepsTo1M(n));
        System.out.println(countStepsTo1(n));
    }
}

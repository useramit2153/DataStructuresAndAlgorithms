/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StairCase {

    public static long staircase(int n) {

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        long[] arr = new long[n + 4];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i < n + 1; i ++)
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(staircase(n));
    }
}

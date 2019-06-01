
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amith
 */
public class MinimumCostPath {

    public static int minCostPath(int input[][], int i, int j) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (i >= input.length && j >= input[0].length) {
            return 0;
        } else if (i >= input.length || j >= input[0].length) {
            return Integer.MAX_VALUE;
        }
        int value1 = minCostPath(input, i + 1, j);
        int value2 = minCostPath(input, i + 1, j + 1);
        int value3 = minCostPath(input, i, j + 1);
        return (input[i][j] + Math.min(value1, Math.min(value2, value3)));
    }

    public static int minCostPath(int input[][]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        return minCostPath(input, 0, 0);
    }

    public static int minCostPathM(int input[][], int output[][], int i, int j) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (i >= input.length || j >= input[0].length) {
            return Integer.MAX_VALUE;
        }
        if (output[i][j] != -1) {
            return output[i][j];
        }
        int value1 = minCostPathM(input, output, i + 1, j);
        int value2 = minCostPathM(input, output, i + 1, j + 1);
        int value3 = minCostPathM(input, output, i, j + 1);
        output[i][j] = input[i][j] + Math.min(value1, Math.min(value2, value3));
        return output[i][j];
    }

    public static int minCostPathM(int input[][]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[][] output = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                output[i][j] = -1;
            }
        }
        output[input.length - 1][input[0].length - 1] = input[input.length - 1][input[0].length - 1];
        return minCostPathM(input, output, 0, 0);
    }

    private static int mincostPathDP(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] output = new int[m][n];
        output[m - 1][n - 1] = input[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            output[m - 1][j] = output[m - 1][j + 1] + input[m - 1][j];
        }
        for (int i = m - 2; i >= 0; i--) {
            output[i][n - 1] = output[i + 1][n - 1] + input[i][n - 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                output[i][j] = input[i][j] + Math.min(output[i + 1][j], Math.min(output[i + 1][j + 1], output[i][j + 1]));
            }
        }
        return output[0][0];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        System.out.println(mincostPathDP(arr));
        System.out.println(minCostPath(arr));
        System.out.println(minCostPathM(arr));
    }
}

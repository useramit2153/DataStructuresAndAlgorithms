
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
public class KnapSack {

    public static int knapsack(int[] weight, int value[], int maxWeight, int n) {
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (n == 0 || maxWeight == 0) {
            return 0;
        }

        int v1 = 0, v2 = 0, result = 0;
        int[] tw = new int[n - 1];
        int[] tv = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            tw[i] = weight[i + 1];
            tv[i] = value[i + 1];
        }
        if (weight[0] <= maxWeight) {
            v1 = value[0];
            v1 = v1 + knapsack(tw, tv, maxWeight - weight[0], n - 1);
            v2 = 0;
            v2 = v2 + knapsack(tw, tv, maxWeight, n - 1);
            result = Math.max(v1, v2);
        } else {
            result = result + knapsack(tw, tv, maxWeight, n - 1);
        }
        return result;
    }

    public static int knapsackM(int[] weight, int[] value, int[][] output, int maxWeight, int n) {
        if (n == 0 || maxWeight == 0) {
            output[n][maxWeight] = 0;
            return output[n][maxWeight];
        }

        if (output[n][maxWeight] != -1) {
            return output[n][maxWeight];
        }

        int v1 = 0, v2 = 0, result = 0;
        int[] tw = new int[n - 1];
        int[] tv = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            tw[i] = weight[i];
            tv[i] = value[i];
        }
        if (weight[n - 1] <= maxWeight) {
            v1 = value[n - 1];
            v1 = v1 + knapsackM(tw, tv, output, maxWeight - weight[n - 1], n - 1);
            v2 = value[n - 1];
            v2 = v2 + knapsackM(tw, tv, output, maxWeight, n - 1);
            result = Math.min(v1, v2);
        } else {
            result = result + knapsackM(tw, tv, output, maxWeight, n - 1);
        }
        output[n][maxWeight] = result;
        return output[n][maxWeight];
    }

    public static int knapsackM(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int[][] output = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= maxWeight; i++) {
            output[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            output[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                output[i][j] = -1;
            }
        }
        int o = knapsackM(weight, value, output, maxWeight, n);
        for(int i = 0; i < output.length; i ++) {
            for(int j = 0; j < output[i].length; j ++)
                System.out.print(output[i][j] + " ");
            System.out.println();
        }
        return o;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = scan.nextInt();
        }
        int maxWeight = scan.nextInt();
        System.out.println(knapsackM(weight, value, maxWeight));
        System.out.println(knapsack(weight, value, maxWeight, n));
    }

}

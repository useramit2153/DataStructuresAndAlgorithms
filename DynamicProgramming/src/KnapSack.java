
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
            v2 = 0;
            v2 = v2 + knapsackM(tw, tv, output, maxWeight, n - 1);
            result = Math.max(v1, v2);
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
        return knapsackM(weight, value, output, maxWeight, n);
    }
    
    public static int knapsackSpaceOptimizedDP(int weight[], int value[], int n, int maxWeight) {
    	int[][] storage = new int[2][maxWeight + 1];
    	for(int i = 0; i < n; i ++) {
    		if(i % 2 == 0) {
    			for(int j = 0; j <= maxWeight; j ++) {
        			if(weight[i] <= j)
        				storage[0][j] = Math.max(value[i] + storage[1][j - weight[i]], storage[1][j]);
        			else
        				storage[0][j] = storage[1][j];
        		}
    		}
    		else {
    			for(int j = 0; j <= maxWeight; j ++) {
        			if(weight[i] <= j)
        				storage[1][j] = Math.max(value[i] + storage[0][j - weight[i]], storage[0][j]);
        			else
        				storage[1][j] = storage[0][j];
        		}
    		}
    	}
    	return (n + 1) % 2 == 0 ? storage[0][maxWeight] : storage[1][maxWeight];
    }
    
    public static int knapsackDP(int weight[], int value[], int n, int maxWeight) {
    	int[][] storage = new int[n + 1][maxWeight + 1];
    	for(int i = 0; i <= n; i ++)
    		storage[i][0] = 0;
    	for(int j = 0; j <= maxWeight; j ++)
    		storage[0][j] = 0;
    	
    	for(int i = 1; i <= n; i ++) {
    		for(int j = 1; j <= maxWeight; j ++) {
    			if(weight[i - 1] <= j)
    				storage[i][j] = Math.max(value[i - 1] + storage[i - 1][j - weight[i - 1]], storage[i - 1][j]);
    			else
    				storage[i][j] = storage[i - 1][j];
    		}
    	}
    	
    	return storage[n][maxWeight];
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
        System.out.println(knapsackSpaceOptimizedDP(weight, value, n, maxWeight));
        System.out.println(knapsackDP(weight, value, n, maxWeight));
        System.out.println(knapsackM(weight, value, maxWeight));
        System.out.println(knapsack(weight, value, maxWeight, n));
    }

}

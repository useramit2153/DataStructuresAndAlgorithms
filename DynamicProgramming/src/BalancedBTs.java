/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class BalancedBTs {
    
    public static int countBalancedBTs(int height, int mod) {
        if(height == 0 || height == 1) {
            return 1;
        }
        int x = countBalancedBTs(height - 1, mod);
        int y = countBalancedBTs(height - 2, mod);
        long res1 = (long)x * x;
        long res2 = (long)x * y * 2;
        int value1 = (int)(res1 % mod);
        int value2 = (int)(res2 % mod);
        return (value1 + value2) % mod;
    }
    
    public static int countBalancedBTs(int height) {
        int mod = (int)Math.pow(10, 9) + 7;
        return countBalancedBTs(height, mod);
    }
    
    public static int countBalancedBTsDP(int height, int mod) {
        int[] arr = new int[height + 2];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= height; i ++) {
            long res1 = (long)arr[i - 1] * arr[i - 1];
            long res2 = (long)arr[i - 1] * arr[i - 2] * 2;
            int value1 = (int)(res1 % mod);
            int value2 = (int)(res2 % mod);
            arr[i] = (value1 + value2) % mod;
        }
        return arr[height];
    }
    
    public static int countBalancedBTsDP(int height) {
        int mod = (int)Math.pow(10, 9) + 7;
        return countBalancedBTsDP(height, mod);
    }
    
    public static void main(String[] args) {
        System.out.println(countBalancedBTsDP(6));
        System.out.println(countBalancedBTs(6));
    }
}

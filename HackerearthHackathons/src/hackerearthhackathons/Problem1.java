/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerearthhackathons;

import java.util.Scanner;

/**
 * @author amith
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T --> 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++ i) {
                a[i] = in.nextInt();
            }
            int ans = solve(n, p, a);
            System.out.println(ans);
        }
    }
    
    public static int solve(int n, int p, int[] a) {
        int ans = 0;
        int and = a[0];
        for(int i = 1; i < 2; i ++)
            and = and & a[i];
        ans = and - p;
        return ans;
    }
}

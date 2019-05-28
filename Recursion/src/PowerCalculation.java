
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
public class PowerCalculation {
    
    public static int power(int x, int n){
        if(n <= 0){
            return 1;
        }
        int smallans = power(x, n - 1);
        return x * smallans;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int n = scan.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
    }
}

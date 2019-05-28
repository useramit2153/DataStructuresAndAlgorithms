
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
public class ArrayRotate {
    
    public static void rotate(int[] arr, int d) {
	while(d > 0) {
            int temp = arr[0];
            for(int i = 0; i < arr.length - 1; i ++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            d --;
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = scan.nextInt();
        }
        int d = scan.nextInt();
        rotate(arr, d);
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}

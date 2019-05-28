
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
public class CheckArrayRotation {
    
    public static int arrayRotateCheck(int[] arr){
        int min = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i ++) {
            if(min > arr[i])
                break;
            count ++;
        }
        if(count != arr.length)
            return count;
        else
            return 0;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = scan.nextInt();
        }
        int ans = arrayRotateCheck(arr);
        System.out.println(ans);
    }
}

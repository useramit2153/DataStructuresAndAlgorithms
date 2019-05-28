
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
public class BinarySearch {
    
    public static int binarySearch(int input[], int element, int si, int ei) {
        if(si >= ei) {
            return -1;
        }
        int mid = (si + ei) / 2;
        if(input[mid] == element) {
            return mid;
        } else {
            if(element < input[mid])
                return binarySearch(input, element, si, mid - 1);
            else
                return binarySearch(input, element, mid + 1, ei);
        }
    }
    
    public static int binarySearch(int input[], int element) {
        int ans = binarySearch(input, element, 0, input.length - 1);
        return ans;
    }
    
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = scan.nextInt();
        }
        int x;
        x = scan.nextInt();
        int ans = binarySearch(arr, x);
        System.out.println(ans);
    }
    
}

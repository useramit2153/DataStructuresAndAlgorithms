
import java.util.HashMap;
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
public class PrintIntersection {
    
    public static void intersection(int arr1[], int arr2[]) {
        
        int m = arr1.length;
        int n = arr2.length;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        if(m >= n) {
            for(int i = 0; i < m; i ++)
                map.put(arr1[i], false);
            for(int i = 0; i < n; i ++) {
                if(!map.containsKey(arr2[i]))
                    continue;
                System.out.print(arr2[i] + " ");
            }
        } else {
            for(int i = 0; i < n; i ++)
                map.put(arr2[i], false);
            for(int i = 0; i < m; i ++) {
                if(!map.containsKey(arr1[i]))
                    continue;
                System.out.print(arr1[i] + " ");
            }
        }
        System.out.println();
    } 
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int[] arr1 = new int[m];
        for(int i = 0; i < m; i ++) {
            arr1[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i ++) {
            arr2[i] = scan.nextInt();
        }
        System.out.print("Intersection of two arrays is "); 
        intersection(arr1, arr2);
    }
}

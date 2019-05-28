
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class KSorted {
    public static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for(; i < k; i ++) {
            pq.add(arr[i]);
        }
        for(; i < arr.length; i ++) {
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }
        for(int j = arr.length - k; j < arr.length; j ++) {
            arr[j] = pq.remove();
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        sortKSorted(arr, 4);
        for(int i = 0; i < arr.length; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}


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
public class KthLargestElement {
    public static int sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for(; i < k; i ++) {
            pq.add(arr[i]);
        }
        for(; i < arr.length; i ++) {
            int min = pq.element();
            if(min < arr[i]) {
                arr[i - k] = pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.remove();
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 11, 13, 4, 1, 20};
        System.out.println(sortKSorted(arr, 4));
    }
}

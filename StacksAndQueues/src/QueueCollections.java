
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class QueueCollections {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] arr = {5, 2, 8, 1};
        for(int i = 0; i < arr.length; i ++) {
            queue.add(arr[i]);
        }
        System.out.println(queue.size());
        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }
}

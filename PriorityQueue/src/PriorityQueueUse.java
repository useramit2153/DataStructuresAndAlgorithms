
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
public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
//        Priority_Queue_Min q = new Priority_Queue_Min();
//        q.insert(1);
//        q.insert(3);
//        q.insert(6);
//        q.insert(5);
//        q.insert(9);
//        q.insert(8);
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        System.out.println(q.removeMin());
//        Priority_Queue_Max q = new Priority_Queue_Max();
//        q.insert(1);
//        q.insert(3);
//        q.insert(5);
//        q.insert(6);
//        q.insert(8);
//        q.insert(9);
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
//        System.out.println(q.removeMax());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] arr = {9, 1, 0, 4, 7, 3};
        for(int i = 0; i < arr.length; i ++) {
            pq.add(i);
        }
        System.out.println(pq.element());
        while(!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }
}

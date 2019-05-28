
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
public class BuyTheTicket {
    public static int buyTicket(int input[], int k) {
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Return output and don't print it.
        * Taking input and printing output is handled automatically.
        */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < input.length; i ++) {
            pq.add(input[i]);
            q.add(i);
        }
        int c = 0;
        while(!pq.isEmpty()) {
            int temp = pq.remove();
            while(input[q.element()] != temp) {
                int t = q.poll();
                q.add(t);
            }
            c ++;
            if(k == q.poll())
                break;
        }
        return c;
    }
    public static void main(String[] args) {
        int[] arr = {3, 9, 4};
        System.out.println(buyTicket(arr, 2));
    }
}

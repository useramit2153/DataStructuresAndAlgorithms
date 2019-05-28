
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReverseQueue {
    
    private static Queue<Integer> q = new LinkedList<Integer>();
    private static Stack<Integer> s = new Stack<Integer>();
    
    public static void reverseQueue(Queue<Integer> q) {
        // Write your code here
        while(!q.isEmpty())
            s.push(q.poll());
        while(!s.isEmpty())
            q.add(s.pop());
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        for(int i = 0; i < n; i ++)
            q.add(scan.nextInt());
        
        reverseQueue(q);
        
        for(int i = 0; i < n; i ++)
            System.out.print(q.poll() + " ");
        System.out.println();
    }
}

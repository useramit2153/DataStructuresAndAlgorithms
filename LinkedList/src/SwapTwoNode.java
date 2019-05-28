
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
public class SwapTwoNode {
    
    public static Node<Integer> takeInput() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        
        while(data != -1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            } else {
                Node<Integer> temp = head;
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        
        return head;
    }
    
    public static  Node<Integer> swap_nodes(Node<Integer> head,int i,int j){
        
        if(i > j) {
            int temp = i;
            i = j;
            j = temp;
        }
        
        Node<Integer> p1 = head, c1, p2 = head, c2;
        
        while(i > 1) {
            p1 = p1.next;
            i --;
        }
        c1 = p1.next;
        while(j > 1) {
            p2 = p2.next;
            j --;
        }
        c2 = p2.next;
        
        if(i == 0) {
            p2.next = head;
            p2 = head.next;
            head.next = c2.next;
            c2.next = p2;
            return c2;
        } else if(j - i == 1) {
            p2.next = c2.next;
            c2.next = p2;
            p1.next = c2;
            return head;
        } else {
            p1.next = c2;
            p2.next = c1;
            p2 = c1.next;
            c1.next = c2.next;
            c2.next = p2;
            return head;
        }
    }
    
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        Node<Integer> head = takeInput();
        int i = scan.nextInt();
        int j = scan.nextInt();
        head = swap_nodes(head, i, j);
        print(head);
    }
    
}

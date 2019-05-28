
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
public class BubbleSortOfLinkedList {
    
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
    
    public static int length(Node<Integer> head){
	int count = 0;
        while(head != null) {
            count ++;
            head = head.next;
        }
        return count;
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
    
    public static Node<Integer> bubbleSort(Node<Integer> head) {
        
        Node<Integer> temp = head, p, c, n;
        int i, j;
        
        for(int m = 0; m < length(head); m ++) {
            p = head;
            c = p.next;
            i = 0;
            j = 1;
            while(c != null) {
                if(p.data > c.data) {
                    // swap
                    head = swap_nodes(head, i, j);
                } else
                    p = p.next;
                c = p.next;
                i ++;
                j ++;
                temp = head;
            }
            temp = temp.next;
        }
        
        return head;
    }
    
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = bubbleSort(head);
        print(head);
    }
    
}

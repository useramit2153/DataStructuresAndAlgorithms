
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
public class MergeTwoSortedLL {
    
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
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        
        return head;
    }
    
    public static Node<Integer> mergeTwoList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> head = null, tail = null;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                if(head == null)
                    head = head1;
                else
                    tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                if(head == null)
                    head = head2;
                else
                    tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null)
            tail.next = head1;
        if(head2 != null)
            tail.next = head2;
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
        Node<Integer> head1 = takeInput();
        Node<Integer> head2 = takeInput();
        Node<Integer> head = mergeTwoList(head1, head2);
        print(head);
    }
    
}

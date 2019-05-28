
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
public class KReverse {
    
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
    
    public static Node<Integer> reverseRecursiveBest(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;
        
        Node<Integer> smallHead = reverseRecursiveBest(head.next);
        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;
        return smallHead;
    }
    
    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        
        Node<Integer> temp = head, tail = head, smallHead, actualHead = null, smallTail = null;
        
        while(temp != null) {
            int K = k;
            smallHead = temp;
            tail = smallHead;
            while(K > 1 && tail.next != null) {
                tail = tail.next;
                K --;
            }
            temp = tail.next;
            tail.next = null;
            if(actualHead == null){
                actualHead = reverseRecursiveBest(smallHead);
                smallTail = smallHead;
            }
            else {
                smallTail.next = reverseRecursiveBest(smallHead);
                smallTail = smallHead;
            }
        }
        
        return actualHead;
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
        head = kReverse(head, 2);
        print(head);
    }
    
}

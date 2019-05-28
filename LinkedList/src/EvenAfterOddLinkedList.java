
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
public class EvenAfterOddLinkedList {
    
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
    
    public static Node<Integer> sortEvenOdd(Node<Integer> head) {
        Node<Integer> oh = null, ot = null, eh = null, et = null;
        while(head != null) {
            if(head.data % 2 != 0) {
                if(oh == null) {
                    oh = head;
                    ot = head;
                } else {
                    ot.next = head;
                    ot = head;
                }
                head = head.next;
                ot.next = null;
            }
            else {
                if(eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
                head = head.next;
                et.next = null;
            }
        }
        if(oh == null)
            return eh;
        else {
            ot.next = eh;
            return oh;
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
        Node<Integer> head = takeInput();
        head = sortEvenOdd(head);
        print(head);
    }
    
}


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
public class MidpointOfLinkedList {
    
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
    
    public static int printMiddel(Node<Integer> head) {
        Node<Integer> temp = head;
        while(head.next != null) {
            if(head.next.next == null)
                break;
            temp = temp.next;
            head = head.next.next;
        }
        return temp.data;
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        int ans = printMiddel(head);
        System.out.println(ans);
    }
}

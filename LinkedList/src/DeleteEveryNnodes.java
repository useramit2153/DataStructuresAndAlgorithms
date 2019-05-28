
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
public class DeleteEveryNnodes {
    
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
    
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        
        Node<Integer> temp = head;
        
        while(temp != null) {
            int m = M;
            while(m > 1 && temp != null) {
                temp = temp.next;
                m --;
            }
            if(temp == null)
                break;
            int n = N;
            while(n > 0 && temp.next != null) {
                temp.next = temp.next.next;
                n --;
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
        Scanner scan = new Scanner(System.in);
        Node<Integer> head = takeInput();
        int m = scan.nextInt();
        int n = scan.nextInt();
        head = skipMdeleteN(head, m, n);
        print(head);
    }
    
}


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
public class AppendLastNToFirst {
    
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
    
    public static Node<Integer> append(Node<Integer> root, int n) {
        
        int fn = length(root) - n;
        int i = 0;
        Node<Integer> temp = root;
        Node<Integer> h;
        
        while(i < fn - 1) {
            temp = temp.next;
            i ++;
        }
        h = temp.next;
        temp.next = null;
        
        temp = h;
        while(temp.next != null)
            temp = temp.next;
        temp.next = root;
        root = h;
        return root;
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
        head = append(head, 3);
        print(head);
    }
    
}

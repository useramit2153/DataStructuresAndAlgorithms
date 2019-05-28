
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
public class PrintIthNode {
    
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
    
    public static void printIth(Node<Integer> head, int i){
        if(i < length(head)) {
            int count = 0;
            while(count < i) {
                head = head.next;
                count ++;
            }
            System.out.println(head.data);
        }
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printIth(head, n);
    }
}

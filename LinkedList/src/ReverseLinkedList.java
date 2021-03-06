
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
public class ReverseLinkedList {
    
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
    
    public static void printReverseRecursive(Node<Integer> root) {
        if(root == null){
            //System.out.print(root.data + " ");
            return;
        }
        printReverseRecursive(root.next);
        System.out.print(root.data + " ");
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printReverseRecursive(head);
    }
    
}

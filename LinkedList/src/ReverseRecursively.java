
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
public class ReverseRecursively {
    
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
    
    public static Node<Integer> reverseRecursiveBest(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;
        
        Node<Integer> smallHead = reverseRecursiveBest(head.next);
        Node<Integer> tail = head.next;
        tail.next = head;
        head.next = null;
        return smallHead;
    }
    
    public static DoubleNode reverseRecursiveBetter(Node<Integer> head) {
        if(head == null || head.next == null) {
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        
        DoubleNode smallAns = reverseRecursiveBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        
        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }
    
    public static Node<Integer> reverseRecursive(Node<Integer> root) {
        if(root.next == null)
            return root;
        Node<Integer> head = reverseRecursive(root.next);
        Node<Integer> temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = root;
        root.next = null;
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
        //head = reverseRecursive(head);
        head = reverseRecursiveBest(head);
        //print(head);
        print(head);
    }
}

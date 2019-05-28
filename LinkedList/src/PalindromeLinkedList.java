
import java.util.Objects;
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
public class PalindromeLinkedList {
    
    public static Node<Integer> head = null, tail;
    
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
    
    public static int length(Node<Integer> head){
	int count = 0;
        while(head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }
    
    public static Node<Integer> reverseRecursive(Node<Integer> root) {
        if(root == null)
            return head;
        reverseRecursive(root.next);
        Node<Integer> newNode = new Node<Integer>(root.data);
        if(head == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        return head;
    }
    
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static boolean isPalindrome_2(Node<Integer> head) {
        int n = length(head);
        int i = 0;
        int j = n / 2;
        Node<Integer> temp = head;
        int c = 0;
        while(c < n / 2) {
            temp = temp.next;
            c ++;
        }
        temp = reverseRecursive(temp);
        while(i < n / 2 && j < n) {
            if(head.data != temp.data)
                return false;
            head = head.next;
            temp = temp.next;
            i ++;
            j ++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        System.out.println(isPalindrome_2(head));
    }
}

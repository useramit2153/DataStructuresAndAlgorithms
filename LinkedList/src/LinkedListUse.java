
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
public class LinkedListUse {
    
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
    
    public static Node<Integer> insertRecursively(Node<Integer> head, int data, int pos) {
        if(pos == 0){
            Node<Integer> newNode = new Node<Integer>(data);
            newNode.next = head;
            //System.out.println(head.data);
            return newNode;
        }
        
        if(head == null)
            return head;
        
        head.next = insertRecursively(head.next, data, pos - 1);
        return head;
    }
    
    public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {
        if(pos == 0 && head != null){
            return head.next;
        }
        
        if(head == null)
            return head;
        
        head.next = deleteRecursively(head.next, pos - 1);
        return head;
    }
    
    public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
        
        if(pos < length(head)) {
            Node<Integer> newNode = new Node<Integer>(data);
            if(pos == 0) {
                newNode.next = head;
                return newNode;
            }
            Node<Integer> temp = head;
            int i = 0;
            while(i < pos - 1){
                temp = temp.next;
                i ++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
        
    }
    
    public static Node<Integer> delete(Node<Integer> head, int pos) {
        if(pos < length(head)) {
            if(pos == 0){
                head = head.next;
                return head;
            }
            
            Node<Integer> temp = head;
            int i = 0;
            while(i < pos - 1) {
                temp = temp.next;
                i ++;
            }
            if(temp.next != null)
                temp.next = temp.next.next;
            else
                temp.next = null;
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
        
        // Input of Linked List
        Node<Integer> head = takeInput();
        
        // Insertion of element in Linked List
        int pos = scan.nextInt();
        //int data = scan.nextInt();
        //head = insert(head, data, pos);
        
        head = deleteRecursively(head, pos);
        
        // Deletion of element from Linked List
        //head = delete(head, pos);
        
        print(head);
        
    }
}

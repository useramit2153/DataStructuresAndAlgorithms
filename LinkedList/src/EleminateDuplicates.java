
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
public class EleminateDuplicates {
    
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
    
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        
        Node<Integer> temp = head;
        if(temp != null) {
            while(temp.next != null) {
                Node<Integer> t = temp.next;
                while(Objects.equals(temp.data, t.data)){
                    temp.next = t.next;
                    t.next = null;
                    t = temp.next;
                    if(t == null)
                        break;
                }
                temp = temp.next;
                if(temp == null)
                    break;
            }
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
        
        Node<Integer> head = takeInput();
        head = removeDuplicates(head);
        print(head);
        
    }
}

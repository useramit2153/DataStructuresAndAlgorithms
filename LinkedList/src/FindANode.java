
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
public class FindANode {
    
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
    
    public static int indexOfNIter(Node<Integer> head, int n) {
        Node<Integer> temp = head;
        int count = 0;
        while(temp != null) {
            if(temp.data == n)
                return count;
            count ++;
            temp = temp.next;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Node<Integer> head = takeInput();
        int n = scan.nextInt();
        int ans = indexOfNIter(head, n);
        System.out.println(ans);
    }
}

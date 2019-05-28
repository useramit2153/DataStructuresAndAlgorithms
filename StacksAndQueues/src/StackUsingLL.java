/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StackUsingLL<T> {
    
    private int top;
    private Node<T> head;
    
    public StackUsingLL() {
        top = -1;
        head = null;
    }
    
    public void push(T elem) {
        top ++;
        Node<T> newNode = new Node<T>(elem);
        if(head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public T pop() throws StackEmptyException {
        if(head == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        T data = head.data;
        head = head.next;
        top --;
        return data;
    }
    
    public T top() throws StackEmptyException {
        if(head == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return head.data;
    }
    
    public int size() {
        return top + 1;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
}

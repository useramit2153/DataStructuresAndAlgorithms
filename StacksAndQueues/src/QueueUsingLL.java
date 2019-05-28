/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class QueueUsingLL<T> {
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public T front() throws QueueEmptyException {
        if(front == null)
            throw new QueueEmptyException();
        return front.data;
    }
    
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if(front == null)
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
        size ++;
    }
    
    public T dequeue() throws QueueEmptyException {
        if(front == null)
            throw new QueueEmptyException();
        T data = front.data;
        front = front.next;
        size --;
        return data;
    }
    
}

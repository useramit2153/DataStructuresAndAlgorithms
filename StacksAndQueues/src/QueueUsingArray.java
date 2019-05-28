/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class QueueUsingArray {
    
    private int[] data;
    private int front;
    private int rear;
    private int size;
    
    public QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int n) {
        data = new int[n];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    int size() {
        return size;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    int front() throws QueueEmptyException {
        if(size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }
    
    void enqueue(int element) throws QueueFullException{
        
        if(size == data.length)
            //throw new QueueFullException();
            doubleCapacity();
            
        if(size == 0)
            front = 0;
        
        rear = (rear + 1) % data.length;
        size ++;
        data[rear] = element;
        
    }
    
    int dequeue() throws QueueEmptyException {
        
        if(size == 0)
            throw new QueueEmptyException();
        
        int temp = data[front];
        front = (front + 1) % data.length;
        size --;
//        if(size == 0) {
//            front = -1;
//            rear = -1;
//        }
        return temp;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[temp.length * 2];
        int count = 0;
        for(int i = front; i < temp.length; i ++) {
            data[count] = temp[i];
            count ++;
        }
        for(int i = 0; i < front; i ++) {
            data[count] = temp[i];
            count ++;
        }
        front = 0;
        rear = temp.length - 1;
    }
    
}

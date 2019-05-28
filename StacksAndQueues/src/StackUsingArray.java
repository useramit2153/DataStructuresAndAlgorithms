
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StackUsingArray {
    
    private int[] data;
    private int top = -1;
    
    public StackUsingArray() {
        data = new int[10];
    }
    
    public StackUsingArray(int n) {
        data = new int[n];
    }
    
    public void doubleSize() {
        int[] temp = data;
        data = new int[temp.length * 2];
        for(int i = 0; i < temp.length; i ++)
            data[i] = temp[i];
    }
    
    public void push(int elem) {
        if(size() == data.length)
            doubleSize();
        top ++;
        data[top] = elem;
    }
    
    public int pop() throws StackEmptyException {
        if(top == -1) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int temp = data[top];
        top --;
        return temp;
    }
    
    public int top() throws StackEmptyException {
        if(top == -1) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }
    
    public int size() {
        return top + 1;
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
}

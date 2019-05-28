/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class StackUse {
    
    public static void main(String[] args) throws StackEmptyException {
//        StackUsingArray stack = new StackUsingArray();
//        for(int i = 0; i < 5; i ++) {
//            stack.push(i);
//        }
//        System.out.println(stack.top());
//        System.out.println(stack.size());
//        while(stack.size() != 0)
//            System.out.println(stack.pop() + " ");
//        System.out.println();
        StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
        for(int i = 0; i < 5; i ++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.size());
        while(stack.size() != 0)
            System.out.println(stack.pop() + " ");
        System.out.println();
    }
    
}

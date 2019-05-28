
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class ReverseStack {
    
    private static Stack<Integer> s1 = new Stack<Integer>();
    
    public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s1.addAll(s2);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        for(int i = 0; i < n; i ++)
            s1.push(scan.nextInt());
        
        Stack<Integer> s2 = new Stack<Integer>();
        reverseStack(s1, s2);
        
        for(int i = 0; i < n; i ++)
            System.out.print(s1.pop() + " ");
        System.out.println();
    }
    
}

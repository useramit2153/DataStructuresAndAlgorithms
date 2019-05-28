
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
public class BalancedParenthesis {
    
    public static boolean checkBalanced(String st) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < st.length(); i ++) {
            if(st.charAt(i) == '(' || st.charAt(i) == '{' || st.charAt(i) == '[')
                stack.push(st.charAt(i));
            if(st.charAt(i) == ')') {
                if(stack.size() == 0)
                    return false;
                if(stack.pop() != '(')
                    return false;
            }
            if(st.charAt(i) == '}') {
                if(stack.size() == 0)
                    return false;
                if(stack.pop() != '{')
                    return false;
            }
            if(st.charAt(i) == ']') {
                if(stack.size() == 0)
                    return false;
                if(stack.pop() != '[')
                    return false;
            }
        }
        if(stack.size() != 0)
            return false;
        else
            return true;
    }
    
    public static void main(String[] args) {
        String st = ")))";
        System.out.println(checkBalanced(st));
    }
    
}


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
public class CheckRedundantBrackets {
    
    public static boolean checkRedundantBrackets(String st) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < st.length(); i ++) {
            stack.push(st.charAt(i));
            if(st.charAt(i) == ')'){
                int count = 0;
                while(stack.pop() != '('){
                    count ++;
                }
                if(count == 1)
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String st = "(((a + b) + (c + d)))";
        System.out.println(checkRedundantBrackets(st));
    }
}

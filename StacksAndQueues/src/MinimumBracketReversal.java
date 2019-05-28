
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
public class MinimumBracketReversal {
    
    public static int countBracketReversals(String input){
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for(int i = 0; i < input.length(); i ++) {
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
                count ++;
            }
            if(input.charAt(i) == '}'){
                if(stack.isEmpty()){
                    stack.push(input.charAt(i));
                    count ++;
                }
                else if(stack.peek() == '}'){
                    stack.push(input.charAt(i));
                    count ++;
                }
                else{
                    if(stack.pop() == '{')
                        count --;
                }
            }
        }
        if(count % 2 != 0)
            return -1;
        else {
            count = 0;
            while(!stack.isEmpty()) {
                int c1 = stack.pop();
                int c2 = stack.pop();
//                System.out.println(c1 + " " + c2);
                if(c1 == c2)
                    count ++;
                else
                    count += 2;
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        String st = "}}}{";
        System.out.println(countBracketReversals(st));
    }
}

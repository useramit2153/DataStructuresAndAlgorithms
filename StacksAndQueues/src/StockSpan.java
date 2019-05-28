
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
public class StockSpan {
    
    public static int[] stockSpan(int[] price) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int[] arr = new int[price.length];
        for(int i = 0; i < price.length; i ++) {
            if(s2.isEmpty()){
                s2.push(price[i]);
                s1.push(1);
            } else {
                if(price[i] < s2.peek()) {
                    s2.push(price[i]);
                    s1.push(1);
                } else {
                    int count = 0;
                    while(s2.peek() < price[i]){
                        s2.pop();
                        count = count + s1.pop();
                        if(s2.isEmpty())
                            break;
                    }
                    count ++;
                    s1.push(count);
                    s2.push(price[i]);
                }
            }
            arr[i] = s1.peek();
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] price = new int[n];
        for(int i = 0; i < n; i ++)
            price[i] = scan.nextInt();
        int[] si = stockSpan(price);
        for(int i = 0; i < n; i ++)
            System.out.print(si[i] + " ");
        System.out.println();
    }
}

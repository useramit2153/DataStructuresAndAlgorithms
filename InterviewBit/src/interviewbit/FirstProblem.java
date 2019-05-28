/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewbit;

import java.util.ArrayList;

/**
 *
 * @author amith
 */
public class FirstProblem {

    /**
     * @param args the command line arguments
     */
    
    public static int solve(String A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < A.length(); i ++)
            arr.add((int)A.charAt(i));
        arr.sort(null);
        int min = Integer.MAX_VALUE;
        int element = arr.get(0);
        for(int i = 0; i < arr.size() - 1; i ++) {
            if(min > Math.abs(arr.get(i) - arr.get(i + 1))) {
                min = Math.abs(arr.get(i) - arr.get(i + 1));
                element = arr.get(i);
            }
        }
        int ans = 0;
        for(int i = 0; i < A.length(); i ++) {
            ans = ans + Math.abs((int)A.charAt(i) - element);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(solve("c"));
    }
    
}

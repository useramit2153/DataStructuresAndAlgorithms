
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class LongestConsecutiveSubsequence {
    public static ArrayList<Integer> longestSubsequence(int[] arr){
        // Write your code here
        int maxLength = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for(int i = 0; i < arr.length; i ++)
            map.put(arr[i], true);
        for(int value : arr) {
            if(!map.containsKey(value - 1)) {
                int temp = value;
                while(map.containsKey(temp)){
                    temp ++;
                }
                if(maxLength < temp - value) {
                    maxLength = temp - value;
                    start = value;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < maxLength; i ++)
            ans.add(start + i);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 14, 4, 10, 2, 11};
        ArrayList<Integer> list = longestSubsequence(arr);
        for(int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }
}

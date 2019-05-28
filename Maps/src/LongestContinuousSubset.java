
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class LongestContinuousSubset {
    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) {
	//  write your code here.
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.size(); i ++) {
            sum = sum + arr.get(i);
            int length = 0;
            if(sum == 0)
                length = i + 1;
            if(map.containsKey(sum))
                length = i - map.get(sum);
            else
                map.put(sum, i);
            if(maxLength < length)
                maxLength = length;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i ++)
            arr.add(scan.nextInt());
        System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
    }
}

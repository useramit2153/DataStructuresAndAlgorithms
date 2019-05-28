
import dynamicarray.DynamicArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */

public class SubsetsSum {
    
    public static int[][] pSubsets(int[] input, int[] output, int k) {
        if(input.length <= 0) {
            int[][] temp = new int[0][];
            if(k == 0) {
                temp = new int[1][output.length];
                for(int i = 0; i < output.length; i ++) {
                    temp[0][i] = output[i];
                }
                return temp;
            } else {
                return temp;
            }
        }
        
        int[] temp = new int[input.length - 1];
        for(int i = 0; i < temp.length; i ++) {
            temp[i] = input[i + 1];
        }
        int[][] temp1 = pSubsets(temp, output, k);
        int[][] temp2 = new int[0][];
        if(input[0] <= k) {
            DynamicArray d = new DynamicArray();
            for(int i = 0; i < output.length; i ++) {
                d.add(output[i]);
            }
            d.add(input[0]);
            output = new int[d.size()];
            output = d.getArray();
            temp2 = pSubsets(temp, output, k - input[0]);
        }
        int[][] ans = new int[temp1.length + temp2.length][];
        int count = 0;
        if(temp1.length == 0 && temp2.length != 0) {
            for(int i = 0; i < temp2.length; i ++) {
                ans[i] = new int[temp2[i].length];
                for(int j = 0; j < temp2[i].length; j ++) {
                    ans[count][j] = temp2[i][j];
                }
                count ++;
            }
        }
        else if(temp2.length == 0 && temp1.length != 0) {
            for(int i = 0; i < temp1.length; i ++) {
                ans[i] = new int[temp1[i].length];
                for(int j = 0; j < temp1[i].length; j ++) {
                    ans[count][j] = temp1[i][j];
                }
                count ++;
            }
        } else if(temp1.length != 0 && temp2.length != 0){
            for(int i = 0; i < temp2.length; i ++) {
                ans[count] = new int[temp2[i].length];
                for(int j = 0; j < temp2[i].length; j ++) {
                    ans[count][j] = temp2[i][j];
                }
                count ++;
            }
            for(int i = 0; i < temp1.length; i ++) {
                ans[count] = new int[temp1[i].length];
                for(int j = 0; j < temp1[i].length; j ++) {
                    ans[count][j] = temp1[i][j];
                }
                count ++;
            }
        }
        return ans;
    }
    
    public static int[][] subsetsSumK(int[] input, int k) {
        int[] output = new int[0];
        int[][] answer = pSubsets(input, output, k);
        return answer;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;
        int[][] ans = subsetsSumK(arr, k);
        
//        System.out.println(ans[0]);
        
        for(int i = 0; i < ans.length; i ++) {
            for(int j = 0; j < ans[i].length; j ++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

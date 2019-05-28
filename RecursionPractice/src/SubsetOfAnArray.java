/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */

public class SubsetOfAnArray {
    
    public static int[][] subsets(int input[]) {
        if(input.length <= 0) {
            int[][] ans = new int[1][0];
            return ans;
        }
        
        int[] temp = new int[input.length - 1];
        for(int i = 0; i < input.length - 1; i ++) {
            temp[i] = input[i + 1];
        }
        int[][] smallAns = subsets(temp);
        
        
        int count = 1;
        int smallLength = smallAns.length;
        
        int[][] ans = new int[smallLength * 2][1];
        for(int i = 0; i < smallAns.length; i ++) {
            ans[i] = new int[smallAns[i].length];
            for(int j = 0; j < smallAns[i].length; j ++) {
                ans[i][j] = smallAns[i][j];
            }
        }
        
        ans[smallAns.length][0] = input[0];
        for(int i = smallAns.length + 1; i < smallLength * 2; i ++) {
            ans[i] = new int[smallAns[count].length + 1];
            ans[i][0] = input[0];
            for(int j = 0; j < smallAns[count].length; j ++) {
                ans[i][j + 1] = smallAns[count][j];   
            }
            count ++;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {20, 12};
        int[][] ans = subsets(arr);
        
        for(int i = 0; i < ans.length; i ++) {
            for(int j = 0; j < ans[i].length; j ++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

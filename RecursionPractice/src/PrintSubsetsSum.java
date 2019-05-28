
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
public class PrintSubsetsSum {
    public static void pSubsets(int[] input, int[] output, int k) {
        if(input.length <= 0) {
            if(k == 0) {
                for(int i = 0; i < output.length; i ++) {
                    System.out.print(output[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        
        int[] temp = new int[input.length - 1];
        for(int i = 0; i < temp.length; i ++) {
            temp[i] = input[i + 1];
        }
        pSubsets(temp, output, k);
        if(input[0] <= k) {
            DynamicArray d = new DynamicArray();
            for(int i = 0; i < output.length; i ++) {
                d.add(output[i]);
            }
            d.add(input[0]);
            output = new int[d.size()];
            output = d.getArray();
            pSubsets(temp, output, k - input[0]);
        }
    }
    
    public static void printSubsetsSumTok(int[] input, int k) {
        int[] output = new int[0];
        pSubsets(input, output, k);
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;
        printSubsetsSumTok(arr, k);
    }
}

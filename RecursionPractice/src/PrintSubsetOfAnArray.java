/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */

import dynamicarray.DynamicArray;

public class PrintSubsetOfAnArray {
    
    public static void pSubsets(int[] input, int[] output) {
        if(input.length <= 0) {
            for(int i = 0; i < output.length; i ++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        
        int[] temp = new int[input.length - 1];
        for(int i = 0; i < temp.length; i ++) {
            temp[i] = input[i + 1];
        }
        pSubsets(temp, output);
        DynamicArray d = new DynamicArray();
        for(int i = 0; i < output.length; i ++) {
            d.add(output[i]);
        }
        d.add(input[0]);
        output = new int[d.size()];
        output = d.getArray();
        pSubsets(temp, output);
    }
    
    public static void printSubsets(int input[]) {
        int[] output = new int[0];
        pSubsets(input, output);
    }
    
    public static void main(String[] args) {
        int[] arr = {15, 20, 12};
        printSubsets(arr);
    }    
}

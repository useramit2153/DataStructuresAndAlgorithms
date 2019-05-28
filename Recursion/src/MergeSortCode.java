/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MergeSortCode {
    
    public static void merge(int[] input, int si, int ei){
        int i = si;
        int mid = (si + ei) / 2;
        int j = mid + 1;
        int k = 0;
        int[] temparr = new int[ei + 1];
        while(i <= mid && j <= ei){
            if(input[i] > input[j]){
                temparr[k] = input[j];
                j ++;
            } else {
                temparr[k] = input[i];
                i ++;
            }
            k ++;
        }
        while(i <= mid){
            temparr[k] = input[i];
            i ++;
            k ++;
        }
        while(j <= ei){
            temparr[k] = input[j];
            j ++;
            k ++;
        }
        k = 0;
        for(int m = si; m <= ei; m ++){
            input[m] = temparr[k];
            k ++;
        }
    }
    
    public static void mSort(int[] input, int si, int ei) {
        if(si >= ei){
            return;
        }
        int mid = (si + ei) / 2;
        mSort(input, si, mid);
        mSort(input, mid + 1, ei);
        merge(input, si, ei);
    }
    
    public static void mergeSort(int[] input) {
        mSort(input, 0, input.length - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 5, 4, 3};
        mergeSort(arr);
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}

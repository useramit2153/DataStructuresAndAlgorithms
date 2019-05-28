/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class QuickSortTimeComplexity {
    
    private static int partion(int[] input, int si, int ei) {
        int pivot = input[si];
        int count = 0;
        for(int i = si + 1; i <= ei; i ++){
            if(input[i] <= pivot){
                count ++;
            }
        }
        int pivotPosition = si + count;
        input[si] = input[pivotPosition];
        input[pivotPosition] = pivot;
        int i = si;
        int j = ei;
        while(i < pivotPosition && j > pivotPosition){
            if(input[i] <= pivot){
                i ++;
            } else {
                if(input[j] > pivot){
                    j --;
                } else {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                    i ++;
                    j --;
                }
            }
        }
        return pivotPosition;
    }
    
    private static void qSort(int[] input, int si, int ei) {
        if(si >= ei){
            return;
        }
        int pivotPosition = partion(input, si, ei);
        qSort(input, si, pivotPosition - 1);
        qSort(input, pivotPosition + 1, ei);
    }
    
    public static void quickSort(int[] input){
        qSort(input, 0, input.length - 1);
    }
    
    public static void main(String[] args) {
        for(int i = 10; i <= 10000; i *= 10) {
            int[] input = new int[i];
            for(int j = 0; j < i; j ++) {
                input[j] = input.length - 1;
            }
            long startTime = System.currentTimeMillis();
            quickSort(input);
            long endTime = System.currentTimeMillis();
            System.out.println("Time By Sort for " + i + " elements " + (endTime - startTime));
        }
    }
    
}

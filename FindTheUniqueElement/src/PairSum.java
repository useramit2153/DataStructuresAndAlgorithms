
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
public class PairSum {
    
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
    
    private static void quickSort(int[] input){
        qSort(input, 0, input.length - 1);
    }
    
    public static void pairSum(int[] arr, int num) {
        
        quickSort(arr);
        
        int i = 0, j = arr.length - 1; 
        int count = 0;
        
        while (i != j && j > i && i < arr.length - 1 && j > 0)  {
            if ((arr[i] + arr[j]) > num )  {
                j --;
            }
                  
            else if ((arr[j] + arr[i]) < num)  { 
                i ++;
            }
            
            else {
                System.out.println(arr[i] + " " + arr[j]);
                if(arr[j - 1] == arr[j] && i != j - 1){
                    j --;
                    count ++;
                } 
                else {
                    if(arr[i] == arr[i + 1]) {
                        j = j + count;
                        count = 0;
                    }
                    else
                        j --;
                    i ++;
                }
            } 
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++)
            arr[i] = scan.nextInt();
        int x = scan.nextInt();
        pairSum(arr, x);
    }
}
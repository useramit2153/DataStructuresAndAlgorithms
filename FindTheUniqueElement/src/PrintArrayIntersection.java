
import java.util.Arrays;
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
public class PrintArrayIntersection {
    
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
    
    // Prints union of arr1[0..m-1] and arr2[0..n-1] 
    void printUnion(int arr1[], int arr2[], int m, int n)
    { 
        // Before finding union, make sure arr1[0..m-1]  
        // is smaller 
        if (m > n)  
        { 
            int tempp[] = arr1; 
            arr1 = arr2; 
            arr2 = tempp; 
  
            int temp = m; 
            m = n; 
            n = temp; 
        } 
  
        // Now arr1[] is smaller 
        // Sort the first array and print its elements (these two 
        // steps can be swapped as order in output is not important) 
        Arrays.sort(arr1); 
        for (int i = 0; i < m; i++) 
            System.out.print(arr1[i] + " "); 
  
        // Search every element of bigger array in smaller array 
        // and print the element if not found 
        for (int i = 0; i < n; i++)  
        { 
            if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1) 
                System.out.print(arr2[i] + " "); 
        } 
    } 
  
    // Prints intersection of arr1[0..m-1] and arr2[0..n-1] 
    public static void intersection(int a[], int b[]) {
        
        int n = a.length;
        int m = b.length;
        
        quickSort(a);
        quickSort(b);
        
        int i = 0, j = 0; 
      
        while (i < n && j < m)  { 
            if (a[i] > b[j])  { 
                j++; 
            }  
                  
            else if (b[j] > a[i])  { 
                i++; 
            }  
            else { 
            // when both are equal
                
                System.out.println(a[i]);
                i++; 
                j++; 
            } 
        } 
    } 
  
    // A recursive binary search function. It returns location of x in 
    // given array arr[l..r] is present, otherwise -1 
    int binarySearch(int arr[], int l, int r, int x)  
    { 
        if (r >= l)  
        { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then it can only  
            // be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present in array 
        return -1; 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        PrintArrayIntersection u_i = new PrintArrayIntersection();
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int[] arr1 = new int[m];
        for(int i = 0; i < m; i ++) {
            arr1[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i ++) {
            arr2[i] = scan.nextInt();
        } 
//        System.out.println("Union of two arrays is "); 
//        u_i.printUnion(arr1, arr2, m, n); 
        //System.out.println(""); 
        System.out.println("Intersection of two arrays is "); 
        intersection(arr1, arr2);
    } 
}
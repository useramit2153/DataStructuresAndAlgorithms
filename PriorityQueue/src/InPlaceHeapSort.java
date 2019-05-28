/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class InPlaceHeapSort {
    public static void inplaceHeapSort(int input[]) {
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Change in the given input itself.
        * Taking input and printing output is handled automatically.
        */
        for(int i = 0; i < input.length; i ++) {
            int childIndex = i;
            int parentIndex = (childIndex - 1) / 2;
        
            while(childIndex > 0) {
                if(input[childIndex] < input[parentIndex]) {
                    int temp = input[parentIndex];
                    input[parentIndex] =  input[childIndex];
                    input[childIndex]  = temp;
                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                } else
                    break;
            }
        }
        
        int size = input.length;
        for(int i = 0; i < input.length; i ++) {
            int temp = input[size - 1];
            input[size - 1] = input[0];
            input[0] = temp;
            size --;
            int parentIndex = 0;
            int leftChildIndex = 0 * 2 + 1;
            int rightChildIndex = 0 * 2 + 2;
            while (leftChildIndex < size || rightChildIndex < size) {
                if (leftChildIndex < size && rightChildIndex >= size) {
                    if (input[parentIndex] > input[leftChildIndex]) {
                        // Swap Left Child With Parent
                        temp = input[leftChildIndex];
                        input[leftChildIndex] =  input[parentIndex];
                        input[parentIndex] = temp;
                        parentIndex = leftChildIndex;
                    } else
                        break;
                } else if (leftChildIndex < size && rightChildIndex < size) {
                    if (input[parentIndex] > input[leftChildIndex] || input[parentIndex] > input[rightChildIndex]) {
                        if (input[leftChildIndex] <= input[rightChildIndex]) {
                            // Swap Left Child With Parent
                            temp = input[leftChildIndex];
                            input[leftChildIndex] = input[parentIndex];
                            input[parentIndex] = temp;
                            parentIndex = leftChildIndex;
                        } else if (input[rightChildIndex] < input[leftChildIndex]) {
                            // Swap Right ChildWith Parent
                            temp = input[rightChildIndex];
                            input[rightChildIndex] = input[parentIndex];
                            input[parentIndex] = temp;
                            parentIndex = rightChildIndex;
                        }
                    } else
                        break;
                }
                leftChildIndex = parentIndex * 2 + 1;
                rightChildIndex = parentIndex * 2 + 2;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 5, 4, 3};
        inplaceHeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

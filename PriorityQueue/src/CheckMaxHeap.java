
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
class MaxHeap {
    private ArrayList<Integer> heap;
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    boolean insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        
        while(childIndex > 0) {
            if(heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
                return false;
            } else
                return true;
        }
        return true;
    }
}
public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        MaxHeap heap = new MaxHeap();
        for(int i = 0; i < arr.length; i ++) {
            if(heap.insert(arr[i]) == false)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {98404, 77913, 46653, 55811, 70118, 44019, 9465, 18138, 11969};
        System.out.println(checkMaxHeap(arr));
    }
}

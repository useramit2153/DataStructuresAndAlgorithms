
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
class PQMaxComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        //To change body of generated methods, choose Tools | Templates.
        if(o1 < o2)
            return 1;
        else if(o1 > o2)
            return -1;
        else
            return 0;
    }
    
}
public class RunningMedian {
    public static void runningMedian(int arr[]) {
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        PQMaxComparator maxC = new PQMaxComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(maxC);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < arr.length; i ++) {
            if(maxHeap.size() == 0)
                maxHeap.add(arr[i]);
            else {
                if(arr[i] <= maxHeap.element())
                    maxHeap.add(arr[i]);
                else
                    minHeap.add(arr[i]);
            }
            while((maxHeap.size() - minHeap.size()) > 1) {
                int temp = maxHeap.remove();
                minHeap.add(temp);
            }
            while((minHeap.size() - maxHeap.size()) > 1) {
                int temp = minHeap.remove();
                maxHeap.add(temp);
            }
            if(maxHeap.size() > minHeap.size())
                System.out.println(maxHeap.element());
            else if(maxHeap.size() < minHeap.size())
                System.out.println(minHeap.element());
            else
                System.out.println((maxHeap.element() + minHeap.element()) / 2);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 2, 1, 3, 7, 5};
        runningMedian(arr);
    }
}

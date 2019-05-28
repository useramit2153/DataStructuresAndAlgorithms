
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
class MinPQComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        //To change body of generated methods, choose Tools | Templates.
        if(o2 > o1)
            return -1;
        else if(o1 > o2)
            return 1;
        else
            return 0;
    }
    
}
class MaxPQComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        //To change body of generated methods, choose Tools | Templates.
        if(o2 > o1)
            return 1;
        else if(o1 > o2)
            return -1;
        else
            return 0;
    }
    
}
class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //To change body of generated methods, choose Tools | Templates.
        if(o2.length() > o1.length())
            return 1;
        else if(o1.length() > o2.length())
            return -1;
        else
            return 0;
    }
    
}
public class PriorityQueueLibrary {
    public static void main(String[] args) {
        //int[] arr = {9, 1, 2, 5, 7, 3, 4};
        String[] arr = {"their", "a", "this", "at"};
        //MinPQComparator mc = new MinPQComparator();
        //MaxPQComparator maxc = new MaxPQComparator();
        StringLengthComparator sc = new StringLengthComparator();
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(maxc);
//        for(int i = 0; i < arr.length; i ++)
//            pq.add(arr[i]);
        PriorityQueue<String> pq = new PriorityQueue<String>(sc);
        for(int i = 0; i < arr.length; i ++) {
            pq.add(arr[i]);
        }
        for(int i = 0; i < arr.length; i ++)
            System.out.print(pq.remove() + " ");
        System.out.println();
    }
}

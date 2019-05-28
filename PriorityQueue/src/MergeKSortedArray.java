
import java.util.ArrayList;
import java.util.PriorityQueue;
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
public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Return output and don't print it.
        * Taking input and printing output is handled automatically.
        */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < input.size(); i ++) {
            for(int j = 0; j < input.get(i).size(); j ++) {
                pq.add(input.get(i).get(j));
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> kList = new ArrayList<ArrayList<Integer>>();
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        for(int i = 0; i < k; i ++) {
            int n = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < n; j ++) {
                list.add(scan.nextInt());
            }
            kList.add(list);
        }
        ArrayList<Integer> list = mergeKSortedArrays(kList);
        for(int i = 0; i < list.size(); i ++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

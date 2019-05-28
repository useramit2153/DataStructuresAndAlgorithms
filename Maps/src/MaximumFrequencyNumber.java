
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MaximumFrequencyNumber {
    
    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
        */
        HashMap<Integer, Integer> fre = new HashMap<Integer, Integer> ();
        int max = Integer.MIN_VALUE;
        int value = arr[0];
        for(int i = 0; i < arr.length; i ++) {
            if(fre.containsKey(arr[i])) {
                if(max < fre.get(arr[i])) {
                    max = fre.get(arr[i]);
                    value = arr[i];
                }
                fre.put(arr[i], fre.get(arr[i]) + 1);
            } else
                fre.put(arr[i], 1);
        }
        return value;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 5};
        int max = maxFrequencyNumber(arr);
        System.out.println(max);
    }
}

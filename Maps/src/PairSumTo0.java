
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
public class PairSumTo0 {
    
    public static void PairSum(int[] input, int size) {
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Print the desired output and don't return anything.
	 * Taking input is handled automatically.
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < size; i ++) {
            if(map.containsKey(0 - input[i])) {
                for(int j = 0; j < map.get(0 - input[i]); j ++)
                    System.out.println(Math.min(0 - input[i], input[i]) + " " + Math.max(0 - input[i], input[i]));
            }
            if(map.containsKey(input[i]))
                map.put(input[i], map.get(input[i]) + 1);
            else
                map.put(input[i], 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 2, 6, -2, 2, -6, 3};
        PairSum(arr, arr.length);
    }
}

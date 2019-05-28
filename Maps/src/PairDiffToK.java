
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
public class PairDiffToK {
    public static void PairSum(int[] input, int k) {
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Print the desired output and don't return anything.
	 * Taking input is handled automatically.
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < input.length; i ++){
            if(map.containsKey(input[i]))
                map.put(input[i], map.get(input[i]) + 1);
            else
                map.put(input[i], 1);
        }
        if(map.size() == 1 && k == 0) {
            for(int i = 0; i < (map.get(input[0]) - 1) * (map.get(input[0]) / 2); i ++)
                System.out.println(input[0] + " " + input[0]);
        } else {
            for(int i = 0; i < input.length; i ++) {
                if(map.containsKey(input[i] + k)) {
                    for(int j = 0; j < (map.get(input[i])) * (map.get(input[i] + k)); j ++)
                        System.out.println(Math.min(input[i] + k, input[i]) + " " + Math.max(input[i] + k, input[i]));
                }
                if(map.containsKey(input[i] - k)) {
                    for(int j = 0; j < (map.get(input[i])) * (map.get(input[i] - k)); j ++)
                        System.out.println(Math.min(input[i] - k, input[i]) + " " + Math.max(input[i] - k, input[i]));
                }
                map.put(input[i], 0);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, -1, 3, 5, 6, 0, -1, 2, 6};
        PairSum(arr, 3);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class FirstIndexOfNumber {
    
    public static int index = 0;
    
    public static int firstIndex(int input[], int x){
        if(input.length <= 1){
            if(input[0] == x){
                return index;
            }
            return -1;
        }
        
        if(input[0] == x){
            return index;
        }
        
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        index ++;
        int smallAns = firstIndex(smallInput, x);
//        if(smallAns == -1){
//            if(input[0] == x){
//                return index;
//            }
//        }
        return smallAns;
    }
    
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 6, 7, 8, 10, 15, 12};
        int n = 12;
        int ans = firstIndex(input, n);
        System.out.println(ans);
    }
}

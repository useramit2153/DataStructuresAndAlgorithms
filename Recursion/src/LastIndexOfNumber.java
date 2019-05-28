/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class LastIndexOfNumber {
    
    public static int index = 0;
    public static int count = 0;
    
    public static int lastIndex(int input[], int x){
        if(input.length <= 1){
            if(input[0] == x){
                return index - count;
            }
            return -1;
        }
        
//        if(input[0] == x){
//            return index;
//        }
        
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        index ++;
        int smallAns = lastIndex(smallInput, x);
        count ++;
        if(smallAns == -1){
            if(input[0] == x){
                return index - count;
            }
        }
        return smallAns;
    }
    
    public static void main(String[] args) {
        int input[] = {12, 12, 3, 6, 7, 8, 8, 12, 8, 12};
        int n = 100;
        int ans = lastIndex(input, n);
        System.out.println(ans);
    }
}

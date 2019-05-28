/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class CheckNumberInArray {
    
    public static boolean checkNumber(int input[], int x){
        if(input.length <= 1){
            if(input[0] == x){
                return true;
            }
            return false;
        }
        
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        boolean smallAns = checkNumber(smallInput, x);
        if(!smallAns){
            if(input[0] == x){
                return true;
            }
        }
        return smallAns;
    }
    
    public static void main(String[] args) {
        int input[] = {1, 2, 3};
        int n = 8;
        boolean ans = checkNumber(input, n);
        System.out.println(ans);
    }
}

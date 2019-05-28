/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author amith
 */
public class CheckSorted {
    
    public static boolean checkSorted(int input[]){
        if(input.length <= 1){
            return true;
        }
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        boolean smallAns = checkSorted(smallInput);
        if(!smallAns){
            return false;
        }
        if(input[0] <= input[1]){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkSorted_2(int input[]){
        if(input.length <= 1){
            return true;
        }
        if(input[0] > input[1]){
            return false;
        }
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        boolean smallAns = checkSorted_2(smallInput);
        return smallAns;
    }
    
    public static void main(String[] args) {
        int input[] = {1, 2, 3};
        System.out.println(checkSorted(input));
        System.out.println(checkSorted_2(input));
    }
}

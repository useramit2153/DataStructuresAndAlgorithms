
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class SumOfArray {
    
    public static int sum(int input[]){
        
        if(input.length <= 1){
            return input[0];
        }
        
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        int smallAns = sum(smallInput);
        return input[0] + smallAns;
    }
    
    public static void main(String[] args) {
        int input[] = {1, 2, 3};
        int ans = sum(input);
        System.out.println(ans);
    }
}

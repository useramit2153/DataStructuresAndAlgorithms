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
public class FindTheUniqueElement {
    
    public static int findUnique(int[] arr) {
        int s = 0;
        for(int i = 0; i < arr.length; i ++) {
            s = s ^ arr[i];
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i ++) {
            input[i] = scan.nextInt();
        }
        int ans = findUnique(input);
        System.out.println(ans);
    }
    
}

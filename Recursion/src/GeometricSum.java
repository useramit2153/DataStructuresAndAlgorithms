/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class GeometricSum {
    
    public static double findGeometricSum(int k){
        if(k == 0){
            return (1 / Math.pow(2, k));
        }
        double smallans = findGeometricSum(k - 1);
        return smallans + (1 / Math.pow(2, k));
    }
    
    public static void main(String[] args) {
        int n = 3;
        double ans = findGeometricSum(n);
        System.out.println(ans);
    }
}

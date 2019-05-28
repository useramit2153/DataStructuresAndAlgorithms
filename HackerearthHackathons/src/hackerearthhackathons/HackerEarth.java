/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerearthhackathons;

/**
 *
 * @author amith
 */
public class HackerEarth {
    public static void main(String[] args) throws Exception {
//        byte a = 6;
//        byte b = 10;
//        System.out.print((b % a) + ", ");
//        System.out.println(b == ((b / a) * a + (b % a)));
        
//        int val[10];
//        System.out.println(val[1]);
        
//        int val = 5;
//        while(val < 10) {
//            System.out.print(val + " ");
//            val ++;
//        }
        
        HackerEarth he = new HackerEarth();
        he.output();
    }
    
    void output() {
        long[] x = {7, 8, 9};
        long[] y = fix(x);
        System.out.print(x[0] + x[1] + x[2] + " ");
        System.out.println(y[0] + y[1] + y[2]);
    }
    
    long[] fix(long[] z) {
        z[1] = 4;
        return z;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_and_objects;

/**
 *
 * @author amith
 */
public class Fraction {
    
    int n, d;
    
    public static Fraction add(Fraction f1, Fraction f2) {
        Fraction f = new Fraction(((f1.n * f2.d) + (f2.n * f1.d)), (f1.d * f2.d));
        return f;
    }
    
    Fraction(int i, int i0) {
        n = i;
        d = i0;
        simplify();
    }

    void print() {
        if(d == 1){
            System.out.println(n);
        }
        else{
            System.out.println(n + "/" + d);    
        }
        
    }
    
    public void setNumerator(int i){
        n = i;
        simplify();
    }
    
    public void simplify(){
        int gcd = 1;
        for(int i = 2; i <= Math.min(n, d); i ++){
            if(n % i == 0 && d % i == 0){
                gcd = i;
            }
        }
        n = n / gcd;
        d = d / gcd;
    }

    public int getDenomirator() {
        return d;
    }

    void setDenomirator(int i) {
        d = i;
        simplify();
    }

    void add(Fraction f2) {
        n = (n * f2.d) + (f2.n * d);
        d = d * f2.d;
        simplify();
    }

    void multiply(Fraction f2) {
        n = n * f2.n;
        d = d * f2.d;
        simplify();
    }
}

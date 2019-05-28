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
public class FractionUse {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(20, 30); // 2/3
        f1.print();
        
        f1.setNumerator(12);  // 12/3 = 4
        int d = f1.getDenomirator();
        System.out.println(d);
        f1.print();  // 1
        
        f1.setNumerator(10);
        f1.setDenomirator(30);
        f1.print();     // 1/3
        
        Fraction f2 = new Fraction(3, 4);   // 3/4
        f1.add(f2);     // 13/12
        f1.print();
        f2.print();     // 3/4
        
        Fraction f3 = new Fraction(4, 5);   // 4/5
        f3.multiply(f2);
        f3.print();         // 3/5
        f2.print();         // 3/4
        
        Fraction f4 = Fraction.add(f1, f3);
        f1.print();
        f3.print();
        f4.print();
    }
}

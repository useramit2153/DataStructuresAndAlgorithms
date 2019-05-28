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
public class ComplexNumbers {
    int r, im, temp_r, temp_im;
    ComplexNumbers(int i, int i0) {
        r = i;
        im = i0;
    }

    void print() {
        System.out.println(r + " + i" + im);
    }

    void multiply(ComplexNumbers c3) {
        temp_r = r;
        temp_im = im;
        r = (temp_r * c3.r) - (temp_im * c3.im);
        im = (temp_r * c3.im) + (temp_im * c3.r);
    }

    void plus(ComplexNumbers c2) {
        r = r + c2.r;
        im = im + c2.im;
    }
}

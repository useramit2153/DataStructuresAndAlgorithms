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

abstract class A {
    int i;
    abstract void display();
}

class B extends A {
    int j;

    @Override
    void display() {
        System.out.println(j);
    }
    
}

public class AbstractUsage {
    public static void main(String[] args) {
        B obj = new B();
        obj.j = 2;
        obj.display();
    }
}

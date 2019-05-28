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

class Vehicle {
    public Vehicle() {
        System.out.println("Vehicle Class");
    }
    public void print() {
        System.out.println("hello world");
    }
}

class Car extends Vehicle {
    public Car() {
        System.out.println("Car Class");
    }
    public void print() {
        System.out.println("hello");
    }
}

public class FinalUsage {
    public static void main(String[] args) {
        
        Vehicle v = new Car();
        v.print();
        
    }
}

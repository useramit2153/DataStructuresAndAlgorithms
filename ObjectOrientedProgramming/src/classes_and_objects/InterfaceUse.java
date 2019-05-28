/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_and_objects;

import java.util.ArrayList;

/**
 *
 * @author amith
 */
interface M {
    public void method();
}
class One{
    public void method(){
        System.out.println("Class One method");
    }
}
class Two extends One implements M{
    public void method(){
        System.out.println("Class Two method");
    }
}
public class InterfaceUse extends Two{
    public static void main(String[] args){
        M m = new Two();
        m.method();
        One o = new Two();
        o.method();
        
        ArrayList<Integer> a = new ArrayList<>();
        a.size();
    }
}
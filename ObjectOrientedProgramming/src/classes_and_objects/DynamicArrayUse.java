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
public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();
        
        for(int i = 0; i < 100; i ++){
            d.add(i + 10);
        }
        
        System.out.println(d.size());
        
        d.set(4, 10);
        System.out.println(d.get(3));
        System.out.println(d.get(4));
        
        while(!d.isEmpty()){
            System.out.println(d.removeLast());
            System.out.println("size: " + d.size());
        }
    }
}

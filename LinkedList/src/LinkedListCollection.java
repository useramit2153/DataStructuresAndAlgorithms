
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class LinkedListCollection {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(30);
        list.addFirst(40);
        list.addLast(80);
        list.set(2, 100);
        
        System.out.println(list.size());
        
        for(int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }
}

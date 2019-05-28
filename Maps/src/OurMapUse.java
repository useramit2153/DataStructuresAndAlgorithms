/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class OurMapUse {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for(int i = 0; i < 20; i ++) {
            map.insert("abc" + i, 1 + i);
            System.out.println("i = " + i + " lf = " + map.loadFactor());
        }
        
        map.removeKey("abc3");
        map.removeKey("abc7");
        
        System.out.println();
        System.out.println();
        for(int i = 0; i < 20; i ++) {
            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
        }
    }
}


import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class MapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        // insert
        map.put("abc", 1);
        map.put("def", 2);
        map.put("abc1", 6);
        
        System.out.println("size: " + map.size());
        
        // check presence
        if(map.containsKey("abc")) {
            System.out.println("Has abc");
        }
        if(map.containsKey("abc1")) {
            System.out.println("Has abc1");
        }
        if(map.containsValue(2)) {
            System.out.println("has 2 as value");
        }
        
        // get value
        int v = 0;
        if(map.containsKey("abc1")) {
            v = map.get("abc1");
        }
        System.out.println(v);
        
        // remove
        int s = map.remove("abc");
        System.out.println(s);
        
        //iterate
        Set<String> keys = map.keySet();
        for(String str : keys) {
            System.out.println(str);
        }
    }
}

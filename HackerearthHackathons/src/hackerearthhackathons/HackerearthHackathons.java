/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerearthhackathons;

import java.util.*;
/**
 *
 * @author amith
 */
public class HackerearthHackathons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "hackerearth hackathons";
        StringTokenizer val = new StringTokenizer(s, "h");
        while(val.hasMoreElements())
            System.out.print(val.nextToken());
    }
    
}

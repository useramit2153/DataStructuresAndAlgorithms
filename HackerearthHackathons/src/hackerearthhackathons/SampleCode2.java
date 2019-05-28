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
public class SampleCode2 {
    public static void main(String[] args) throws Exception{
//        var xyFile:File = File.createTempFile();
//        if(xyFile.isDirectory() == true)
//        xyFile.deleteDirectory(true);
//        else
//        xyFile.deleteFile();
        
        TreeSet<StringBuffer> t = new TreeSet<StringBuffer>();
        t.add(new StringBuffer("H"));
        t.add(new StringBuffer("A"));
        t.add(new StringBuffer("C"));
        t.add(new StringBuffer("K"));
        System.out.println(t);
    }
}

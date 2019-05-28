/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerearthhackathons;

/**
 *
 * @author amith
 */
public class HackerEarth1 {
    public int a = 0;
    
    public HackerEarth1(String Hack) {
        a = 1;
    }
    
}

class Company extends HackerEarth1 {
    
    public Company(String Hack) {
        super(Hack);
        a = 2;
    }
    
    public static void main(String args[]) {
        Company comp = new Company("Hello HackerEarth");
        System.out.println(comp.a);
    }
}
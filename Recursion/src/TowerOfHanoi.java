/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class TowerOfHanoi {
    
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination){
        if(disks >= 1){
            towerOfHanoi(disks - 1, source, destination, auxiliary);
            System.out.println(source + " " + destination);
            towerOfHanoi(disks - 1, auxiliary, source, destination);
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'a', 'b', 'c');
    }
}

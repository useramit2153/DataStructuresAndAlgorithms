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
public class DynamicArray {
    
    private int data[];
    private int nextIndex;
    
    public DynamicArray(){
        data = new int[5];
        nextIndex = 0;
    }

    void add(int i) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(nextIndex == data.length){
            restructure();
        }
        data[nextIndex] = i;
        nextIndex ++;
        
    }

    int size() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return nextIndex;
        
    }

    void set(int i, int i0) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(i > nextIndex){
            return;
        }
        if(i < nextIndex){
            data[i] = i0;
        }
        else{
            add(i0);
        }
        
    }

    int get(int i) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(i > nextIndex){
            return -1;
        }
        return data[i];
        
    }

    boolean isEmpty() {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(size() == 0){
            return true;
        } else{
            return false;
        }
        
    }

    int removeLast() {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(size() == 0){
            return -1;
        }
        int value = data[nextIndex - 1];
        data[nextIndex -1] = 0;
        nextIndex --;
        return value;
        
    }

    private void restructure() {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int temp[] = data;
        data = new int[data.length * 2];
        for(int i = 0; i < temp.length; i ++){
            data[i] = temp[i];
        }
        
    }
}

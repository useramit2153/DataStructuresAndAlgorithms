/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */

class DynamicArray {
    
    private int data[];
    private int nextIndex;
    
    public DynamicArray(){
        data = new int[0];
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
    
    int[] getArray(){
        return data;
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
        data = new int[data.length + 1];
        for(int i = 0; i < temp.length; i ++){
            data[i] = temp[i];
        }
        
    }
}


public class AllIndexesOfNumbers {
    
    public static int index = 0;
    public static int count = -1;
    public static DynamicArray d = new DynamicArray();
    
    
    public static int[] allIndexes(int input[], int x){
        if(input.length <= 1){
            if(input[0] == x){
                d.add(index);
                return d.getArray();
            }
            return d.getArray();
        }
        
        if(input[0] == x){
            d.add(index);
        }
        
        int smallInput[] = new int[input.length - 1];
        for(int i = 0; i < smallInput.length; i ++){
            smallInput[i] = input[i + 1];
        }
        index ++;
        allIndexes(smallInput, x);
//        if(smallAns == -1){
//            if(input[0] == x){
//                return index;
//            }
//        }
        return d.getArray();
    }
    
    public static void main(String[] args) {
        int input[] = {8};
        int n = 9;
        int[] ans = allIndexes(input, n);
        for(int i = 0; i < ans.length; i ++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

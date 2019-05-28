package classes_and_objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class Polynomial {
    
    private DynamicArray coefficients;
    private int not = 0;
    
    Polynomial(){
        coefficients = new DynamicArray();
    }
    
    void setCoefficient(int degree, int coeff) {
        for(int temp = not; temp < degree; temp ++){
            coefficients.add(0);
        }
        coefficients.set(degree, coeff);
        //System.out.println(i);
        not ++;
    }
    
    DynamicArray getCoefficient(){
        return coefficients;
    }
    
    void print() {
        String st = "";
        for(int i = 0; i < coefficients.size(); i ++){
            if(i < coefficients.size() - 1 && coefficients.get(i) != 0){
                st = st + coefficients.get(i) + "x" + i + " ";
            }
            if(i == coefficients.size() - 1 && coefficients.get(i) != 0){
                st = st + coefficients.get(i) + "x" + i;
            }
        }
        System.out.println(st);
    }

    Polynomial add(Polynomial p2) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DynamicArray d1 = coefficients;
        DynamicArray d2 = p2.getCoefficient();
        for(int i = 0; i < Math.max(d1.size(), d2.size()); i ++){
            if(i < d2.size() && i < d1.size())
                setCoefficient(i, d1.get(i) + d2.get(i));
            else{
                if(i < d1.size())
                    setCoefficient(i, d1.get(i) + 0);
                if(i < d2.size())
                    setCoefficient(i, 0 + d2.get(i));
            }
        }
        return this;
        
    }

    Polynomial multiply(Polynomial p2) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DynamicArray d = new DynamicArray();
        DynamicArray d2 = p2.getCoefficient();
        //System.out.println(deg() * p2.deg());
        for(int i = 0; i <= deg() + p2.deg(); i ++){
            int s = 0;
            for(int j = 0; j <= deg(); j ++ ){
                for(int k = 0; k <= p2.deg(); k ++){
                    if(i == j + k){
                        s = s + coefficients.get(j) * d2.get(k);
                    }
                }
            }
            
            d.set(i, s);
        }
        
        coefficients = d;
        
        return this;
        
    }
    
    int deg(){
        return coefficients.size() - 1;
    }
    
    static Polynomial add(Polynomial p1, Polynomial p2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Polynomial p = new Polynomial();
        DynamicArray d1 = p1.getCoefficient();
        DynamicArray d2 = p2.getCoefficient();
        for(int i = 0; i < Math.max(d1.size(), d2.size()); i ++){
            if(i < d2.size() && i < d1.size())
                p.setCoefficient(i, d1.get(i) + d2.get(i));
            else{
                if(i < d1.size())
                    p.setCoefficient(i, d1.get(i) + 0);
                if(i < d2.size())
                    p.setCoefficient(i, 0 + d2.get(i));
            }
        }
        return p;
    }

    Polynomial subtract(Polynomial p2) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DynamicArray d1 = coefficients;
        DynamicArray d2 = p2.getCoefficient();
        for(int i = 0; i < Math.max(d1.size(), d2.size()); i ++){
            if(i < d2.size() && i < d1.size())
                setCoefficient(i, d1.get(i) - d2.get(i));
            else{
                if(i < d1.size())
                    setCoefficient(i, d1.get(i) - 0);
                if(i < d2.size())
                    setCoefficient(i, 0 - d2.get(i));
            }
        }
        return this;
    }
}

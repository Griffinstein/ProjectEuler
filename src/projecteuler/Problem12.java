/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.lang.Math;

/**
 *
 * @author Ed
 */
public class Problem12 implements EulerProblem {

    private final int max;
    private int count;
    
    public Problem12(int i){
        this.max = i;
        count = i;
    }
    
    @Override
    public String getSolution() {
        return "" + divisibleTriangularNum();
    }
    
    private int divisibleTriangularNum(){
        int result = 0;
        
        
        while (true){
            result = generateTriangularNum();
            
            if (workOutDivisors(result) > max)
                break;
        }
        
        return result;
    }
    
    private int generateTriangularNum(){
        int triNum = 0;
        
        for (int i = count; i>0; i--){
            triNum = triNum + i;
        }
        
        count++;
        
        return triNum;
    }
    
    private int workOutDivisors(int num){
        int divisors = 6;
        int halved = (int)Math.ceil(num/2);
           
        
        if (num%2 == 0 && num%3 == 0 && num%4 == 0 && num%5 == 0 ){
            for (int i = 6; i <= halved; i++){
                if (num%i == 0)
                    divisors ++;
            }
        }
        
        return divisors;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

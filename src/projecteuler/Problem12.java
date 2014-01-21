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
        result = generateTriangularNum();
        
        while (true){
            
            if (workOutDivisors(result) > max)
                break;
            
            result = result + count;
            count++;
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
        int divisors = 0;
        int halved = (int)Math.ceil(num/2);
        int numtx = (int)Math.sqrt(num);
        
        for (int i = 1; i <= numtx; i++){
            if (num%i == 0)
                divisors += 2;
        }
        
        if (numtx*numtx == num)
            divisors++;
        
        return divisors;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

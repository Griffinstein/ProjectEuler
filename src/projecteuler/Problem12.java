/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

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

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

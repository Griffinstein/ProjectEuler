/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author Ed
 */
public class Problem48 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + SelfPowers();
    }
    
    private int SelfPowers(){
        int answer = 0;
        
        BigInteger sum = BigInteger.valueOf(0);
        
        for (int i = 1; i <= 1000; i++){
            sum = sum;
        }
        
        return answer;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

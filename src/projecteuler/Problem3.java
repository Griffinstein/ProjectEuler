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
public class Problem3 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + LargestPrimeFactor();
    }
    
    private long LargestPrimeFactor() {
          long prime = 600851475143L;

          for (int i = 2; i < prime; i++) {
                  if (prime%i == 0){
                      //intlist.add(i);
                      prime = prime/i;
                      i = 2;
                  }
          }

          return prime;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

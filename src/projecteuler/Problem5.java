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
public class Problem5 implements EulerProblem{
    private final int max;

    public Problem5(int max){
        this.max = max;
    }
    
    @Override
    public String getSolution() {
        return "" + SmallestMultiple();
    }
    
    private int SmallestMultiple() {
      int output = 0;
      boolean found;

      while(true){
          output = output + max;
          found = true;
          for (int i = 1; i <= max; i++){
              if (output%i != 0){
                  found = false;
                  break;
              }
          }

          if (found)
              break;
      }

      return output;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

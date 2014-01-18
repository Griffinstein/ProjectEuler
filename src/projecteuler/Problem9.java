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
public class Problem9 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + SpecialPythagoreanTripley();
    }
    
    private int SpecialPythagoreanTripley(){
      boolean found = false;
      int output = 0;

      for (int a = 3; a < 333; a++){
          for (int b = a+1; b < 500; b++){
              for (int c = b+1; c < 500; c++){
                  if (a+b+c == 1000){
                      if ((a*a)+(b*b) == (c*c)){
                          found = true;
                          output = a * b * c;
                          break;
                      }
                  }
              }
              if (found)
                  break;
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

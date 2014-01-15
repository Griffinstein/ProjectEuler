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
public class Problem2 implements EulerProblem {
    private final int max;
    
    public Problem2(int max){
        this.max = max;
    }

    @Override
    public String getSolution() {
        return "" + EvenFibonacciNumbers();
    }
    
    private int EvenFibonacciNumbers() {
          int first = 1;
          int second = 2;
          int next;
          int sum = 2;

          while (true){
                  next = second + first;
                  if (next > max)
                          break;
                  if (next % 2 == 0)
                          sum += next;
                  first = second;
                  second = next;
          }
          return sum;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

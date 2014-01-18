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
public class Problem6 implements EulerProblem{
    private final int max;

    public Problem6(int max){
        this.max = max;
    }

    @Override
    public String getSolution() {
        return "" + (SquareOfSum() - SumOfSquares());
    }
          
    private int SumOfSquares() {
      int sum = 0;
      for (int j = 1; j <= max; j++ ) {
          sum += (j * j);
      }

      return sum;
    }

    private int SquareOfSum() {
      int sum = 0;
      for (int j = 1; j <= max; j++ ) {
          sum += j;
      }            
      sum = sum * sum;

      return sum;
    }

    @Override
    public String getAltSolution() {
        return "" + SquareOfSumAlt();
    }
          
    private int SquareOfSumAlt() {
        int sum = (max * (max+1)) / 2;
        sum = (sum * sum);
        
        int sq = (((2 * max) + 1)*(max + 1)*(max)) / 6;
        return (sum - sq);
    }
}

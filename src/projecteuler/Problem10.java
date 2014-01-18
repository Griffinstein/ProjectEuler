/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author Ed
 */
public class Problem10 implements EulerProblem{
    private final int max;

    public Problem10(int max){
        this.max = max;
    }
    
    @Override
    public String getSolution() {
        return "" + SummationOfPrimes();
    }
    
    private long SummationOfPrimes() {
      ArrayList<Integer> primeList = new ArrayList<>();
      boolean prime;
      primeList.add(2);
      primeList.add(3);
      double maxRoot;
      int increase = 2;

      for (int temp = 5; temp < max;) {
          temp += increase;
          if (increase == 2)
              increase = 4;
          else if (increase == 4)
              increase = 2;
          prime = true;
          maxRoot = Math.sqrt(primeList.get(primeList.size()-1));
          for (int j = 1; j < primeList.size(); j++) {
              if (temp%primeList.get(j) == 0){
                  prime = false;
                  break;
              }
              if (maxRoot < primeList.get(j))
                  break;
          }

          if (prime){
              primeList.add(temp);
          }
      }

      long sum = 0;
      for (Integer j:primeList)
         sum = sum + j;

      return sum;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
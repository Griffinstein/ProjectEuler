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
public class Problem7 implements EulerProblem{
    private final int target;

    public Problem7(int target){
        this.target = target;
    }
    
    @Override
    public String getSolution() {
        return "" + GetPrimeAt();
    }

    private int GetPrimeAt() {
      int temp = 1;
      ArrayList<Integer> primeList = new ArrayList<>();
      boolean primer;
      double maxRoot;

      primeList.add(2);

      for (int i = 0; i < target; i++) {
          while (true){
              primer = true;
              temp = temp + 2;
              maxRoot = Math.sqrt(primeList.get(primeList.size()-1));
              for (int j = 1; j < primeList.size(); j++) {
                  if (temp%primeList.get(j) == 0){
                      primer = false;
                      break;
                  }
                  if (maxRoot < primeList.get(j)){
                    break;
                  }
              }

              if (primer){
                  primeList.add(temp);
                  break;
              }
          }
      }
      return primeList.get(target-1);
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
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
public class Problem1 implements EulerProblem {
    private final int max;

    public Problem1(int max){
        this.max = max;
    }

    @Override
    public String getSolution(){
        return "" + MultipleOf3And5();
    }
    
    private int MultipleOf3And5() {
          int output = 0;
          for(int i=1; i<max; i++ ) {
                  if (i%3 == 0) 
                          output = output + i;
                  else if (i%5 == 0) 
                          output = output + i;
          }

          return output;
    }

    @Override
    public String getAltSolution() {
        return "" + MultipleOf3And5Alt();
    }
    
    
    private int MultipleOf3And5Alt() {
        int target = 999;       
        int output = NumOfMults(3,target) + NumOfMults(5,target) - NumOfMults(15,target);

        return output;
        //http://projecteuler.net/overview=001 for details
    }

    private int NumOfMults(int num, int X) {
        int answer = (int)Math.floor(X/num);
        answer = (num * (answer * (answer + 1))) / 2;
        return answer;
    }
}
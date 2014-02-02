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
public class Problem23 implements EulerProblem{

    private final int upperlimit = 28123;
    
    @Override
    public String getSolution() {
        return "" + NonAbundantSums();
   }

    private int NonAbundantSums(){
        int answer = 0;
        int temp;
        ArrayList<Integer> abunNum = new ArrayList<Integer>();
        Boolean[] sumNum = new Boolean[upperlimit];
        sumNum[0] = false;
        sumNum[1] = false;
        
        for (int i = 2; i<upperlimit; i++){
            sumNum[i] = false;
            if (Abundant(i))
                abunNum.add(i);
        }
        
        for (int i = 0; i<abunNum.size(); i++){
            for (int j = i; j<abunNum.size(); j++){
                temp = abunNum.get(i) + abunNum.get(j);
                if (temp < upperlimit)
                    sumNum[temp] = true;
            }
        }
        
        for (int i = 0; i<upperlimit; i++){
            if (!sumNum[i])
                answer = answer + i;
        }
        
        return answer;
    }
    
    private boolean Abundant(int num){
        int sumOfDivisors = 1;
        int numtx = (int)Math.sqrt(num);
        int lastnum = 0;
        
        for (int i = 2; i <= numtx; i++){
            if (num%i == 0) {
                sumOfDivisors = sumOfDivisors + i;
                lastnum = i;
                if (num/i != i)
                    sumOfDivisors = sumOfDivisors + (num/i);
            }
        }
        
        if (numtx*numtx == num && numtx != lastnum)
            sumOfDivisors = sumOfDivisors + numtx;

        if (sumOfDivisors > num)
            return true;
        else
            return false;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

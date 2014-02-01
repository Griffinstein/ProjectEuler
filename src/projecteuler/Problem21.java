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
public class Problem21 implements EulerProblem{
    private final int max = 10000;
    
    @Override
    public String getSolution() {
        return "" + AmicableNumbers();
    }
    
    private int AmicableNumbers(){
        int answer = 0;
        int[] numbers = new int[10000];
        
        for (int i = 0; i<max; i++){
            numbers[i] = workOutDivisors(i);
        }
        
        for (int i = 2; i<max; i++){
            for (int j = 2; j<max; j++){
                if (i != j && numbers[i] == j && numbers[j] == i)
                    answer += i;
            }
        }
        
        return answer;
    }
    
    private int workOutDivisors(int num){
        int sumOfDivisors = 1;
        int numtx = (int)Math.sqrt(num);
        
        for (int i = 2; i <= numtx; i++){
            if (num%i == 0) {
                sumOfDivisors = sumOfDivisors + i;
                sumOfDivisors = sumOfDivisors + (num/i);
            }
        }
        
        if (numtx*numtx == num)
            sumOfDivisors = sumOfDivisors + numtx;
        
        return sumOfDivisors;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

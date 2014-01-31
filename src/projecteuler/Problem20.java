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
public class Problem20 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + factorialDigitSum();
    }
    
    private int factorialDigitSum(){
        int answer = 0;
        int temp;
        int k;
        int[] bignumber = new int[500];
        bignumber[0] = 1;
        
        for (int i = 1; i <= 100; i++){
            for (int j = 498; j >= 0; j--){
                temp = bignumber[j] * i;
                bignumber[j] = temp % 10;
                bignumber[j + 1] = bignumber[j + 1] + (int)Math.floor(temp/10);
                k = j+1;
                while (bignumber[k] > 9){
                    temp = bignumber[k];
                    bignumber[k] = bignumber[k] % 10;
                    bignumber[k + 1] = bignumber[k + 1] + (int)Math.floor(temp/10);
                    k++;
                }
            }
        }
        
        for (int i = 499; i >= 0; i--){
            answer = answer + bignumber[i];
        }
        
        return answer;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

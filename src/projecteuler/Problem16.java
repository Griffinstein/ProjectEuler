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
public class Problem16 implements EulerProblem {

    @Override
    public String getSolution() {
        return "" + powerDigitSum();
    }
    
    private int powerDigitSum(){
        int answer = 0;
        int temp;
        int secTemp;
        int[] bigNumber = new int[1000];
        bigNumber[0] = 1;
        
        for (int i = 1; i <= 1000; i++){
            temp = 0;
            for (int j = 0; j < 1000; j++){
                secTemp = bigNumber[j]; 
                bigNumber[j] = ((secTemp * 2) + temp)%10;
                temp = (int)Math.floor(((secTemp * 2) + temp)/10);
            }
        }
        
        for (int i = 0; i < 1000; i++){
            answer = answer + bigNumber[i];
        }
        
        return answer;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

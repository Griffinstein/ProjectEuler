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
public class Problem26 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + ReciprocalCycles();
    }

    private int ReciprocalCycles(){
        int answer = 0;
        double temp;
        
        for (int i = 1; i<1000; i++){
            temp = (double)1/i;
            System.out.println(temp);
        }
        
        return answer;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

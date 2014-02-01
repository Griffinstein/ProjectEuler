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
public class Problem25 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + FibonaciNumberII();
    
    }
    
    private int FibonaciNumberII(){
        int temp = 0;
        int secondtemp;
        int count = 2;
        
        int[] first = new int[1000];
        int[] second = new int[1000];
        int[] sum = new int[1000];
        
        first[0] = 1;

        second[0] = 1;
        
        while (first[999] == 0){
            count++;
            for (int i = 0; i < 1000; i++){
                sum[i] = first[i] + second[i] + temp;
                secondtemp = sum[i]; 
                sum[i] = (secondtemp)%10;
                temp = (int)Math.floor((secondtemp)/10);
            }
            
            for (int i = 0; i < 1000; i++){
                second[i] = first[i];
                first[i] = sum[i];
            }
            temp = 0;
        }
        
        return count;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

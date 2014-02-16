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
        int length;
        double temp;
        String number;
        String[] parts;
        
        for (int i = 2; i<11; i++){
            temp = (double)1/i;
            number = String.valueOf(temp);
            
            parts = number.split("\\.");
  
            length = parts[1].length();
            
            if (length>answer)
                temp = Repeater(length, temp);
        }
        
        return answer;
    }
    
    
    private int Repeater(int length, double demicalnum){
        int answer = 0;
        int head = 0;
        int tail = 0;
        int temp;
        int[] array = new int[length];
        
        for (int i = 1; i<=length; i++){
            demicalnum = demicalnum*10;
            temp = (int)(demicalnum);
            demicalnum = demicalnum - temp;
            temp = temp;
            temp = (temp%10);
            array[i-1] = temp;
        }
        
        
        
        
        return answer;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

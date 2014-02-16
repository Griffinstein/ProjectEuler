/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.math.BigDecimal;

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
        int count = 0;
        int length;
        BigDecimal temp;
        int otherTemp;
        String number;
        String[] parts;
        BigDecimal a = new BigDecimal("1");
        BigDecimal b;
        
        for (int i = 2; i<1000; i++){
            b = new BigDecimal(i);
            
            temp = a.divide(b,100, BigDecimal.ROUND_HALF_UP);
            
            number = String.valueOf(temp);
            
            parts = number.split("\\.");
  
            length = parts[1].length();
            
            if (length>answer){
                otherTemp = Repeater(length, parts[1]);
                if (otherTemp > count){
                    count = otherTemp;
                    answer = i;
                }
            }
        }
        
        return answer;
    }
    
    
    private int Repeater(int length, String demicalnum){
        int answer = 0;
        int head = 0;
        int tail = 0;
        int temp;
        int count = 0;
        int startTail;
        int[] array = new int[length];
        
        for (int i = 0; i<length; i++){
            array[i] = demicalnum.charAt(i) - '0';
        }
        

        for (int i = 0; i<length-1; i++){
            head = i;
            tail = head;
            count = 0;
            
            for (int j = i+1; j<length; j++){
                tail = j;
                startTail = j;
                while (array[head] == array[tail] && head != startTail){
                    head++;
                    tail++;
                    count++;
                    if (head == length || tail == length)
                        break;
                }
                
                if (head == startTail){
                    if (tail<length-1){
                        if (array[head+1] == array[tail+1])
                            return count;
                    }                    
                }
                
                head = i;
                count = 0;
            }
            
            head++;
            i = head;
        }
        
        return answer;
    }
    
    private int[] longDivision(int i){
        int[] answer = new int[100];
        int reminder = 0;
        int leftover;
        
        
        
        return answer;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

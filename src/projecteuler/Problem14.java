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
public class Problem14 implements EulerProblem{

    private final int max = 1000000;
    private int terms = 1;
    private int[] arrayTerms;
    
    @Override
    public String getSolution() {
        return "" + CollatzSequence();
    }
    
    private int CollatzSequence(){
        int answer = 0;
        long temp;
        int tempTerms = 0;
        arrayTerms = new int[max+1];
        
        for (int i = 1; i < max; i++){
            
            temp = i;
            while (temp != 1){
                temp = collSeq(temp);
                
                if(temp < i){
                    terms = terms + arrayTerms[(int)temp];
                    break;
                }                
                terms++;
            }
            
            arrayTerms[i] = terms;
            
            if (terms > tempTerms){
                tempTerms = terms;
                answer = i;
            }            
            terms = 1;
        }
        
        return answer;
    }

    private long collSeq(long x){
        if (x % 2 == 0)
            return evenNum(x);
        else
            return oddNum(x);
    }
    
    private long evenNum(long x){
        return (x/2);
    }

    private long oddNum(long x){
        return ((x * 3) + 1);
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

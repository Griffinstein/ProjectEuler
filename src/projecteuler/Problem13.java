/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.lang.Math;

/**
 *
 * @author Ed
 */
public class Problem13 implements EulerProblem{

    int a = 58496;
    int b = 93760;
    
    @Override
    public String getSolution() {
        return "" + test();
    }
    
    private int test() {
        int num = 0;
        int temp = 0;
        int sum;
        
        num = a*150;
        
        int[] A = {5,8,4,9,6};
        int[] B = {9,3,7,6,0};
        int[] C = new int[5];
        
        for (int i = 4; i>=0; i--){
            sum = 0;
            for (int j = 0; j < 150; j++){
                sum = sum + A[i];
            }
            C[i] = (sum + temp)%10;
            temp = (int)Math.floor((sum + temp)/10);
        }

        C = C;
        
        return num;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

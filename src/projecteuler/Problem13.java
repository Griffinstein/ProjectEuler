/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ed
 */
public class Problem13 implements EulerProblem{

    final static String FILE_NAME = "src\\projecteuler\\Problem13.txt";
    private int[][] _numbers;
    
    @Override
    public String getSolution() {
        return "" + LargeSum();
    }
    
    private String LargeSum() {
        int temp = 0;
        int sum;
        
        _numbers = new int[100][50];
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                for (int i = 0; i < sCurrentLine.length(); i++){
                    _numbers[temp][i] = sCurrentLine.charAt(i) - '0';
                }
                temp++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        temp = 0;

        int[] C = new int[50];
        
        for (int i = 49; i>=0; i--){
            sum = 0;
            for (int j = 0; j < 100; j++){
                sum = sum + _numbers[j][i];
            }
            C[i] = (sum + temp)%10;
            temp = (int)Math.floor((sum + temp)/10);
        }
        
        String answer = "" + temp;
        temp = 10 - answer.length();
        
        for (int i = 0; i < temp; i++){
            answer = answer + "" + C[i];
        }
        
        return answer;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

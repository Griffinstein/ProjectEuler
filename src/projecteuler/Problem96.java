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
public class Problem96 implements EulerProblem {

    final static String FILE_NAME = "src\\projecteuler\\sudoku.txt";
    
    @Override
    public String getSolution() {
        return "" + SuDoku();
    }
    
    private int SuDoku(){
        int answer = 0;
        int[][][] grid = new int[50][9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine;
            
            for (int i = 0; i<50; i++){
                sCurrentLine = br.readLine();
                for (int j = 0; j<9; j++){
                    sCurrentLine = br.readLine();
                    for (int k = 0; k<9; k++){
                        grid[i][j][k] = sCurrentLine.charAt(k) - '0';
                    }
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                System.out.print(grid[0][j][k]);
            }
            System.out.println();
        }
        
        return answer;
    }
    
    private int[][] getGrid(){
        int[][] grid = new int[50][50];
        
        return grid;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

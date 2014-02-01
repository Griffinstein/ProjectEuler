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
public class Problem18 implements EulerProblem{

    final static String FILE_NAME = "src\\projecteuler\\Problem18.txt";
    
    @Override
    public String getSolution() {
        return "" + MaximumPathSumI();
    }
    
    private int MaximumPathSumI() {
        //TreeNode tree = new TreeNode();
        int temp;
        int row = 0;
        int column;
        //int row = 2;
        int grid [][] = new int [15][15];

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine;
            
            while ((sCurrentLine = br.readLine()) != null) {
                column = 0;
                for (int i = 0; i < sCurrentLine.length(); i+=3){
                    temp = ((sCurrentLine.charAt(i) - '0') * 10) + (sCurrentLine.charAt(i+1) - '0');
                    grid [row][column] = temp;
                    column++;
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        for (int i = 13; i >= 0; i--){
            for (int j = 14; j >= 0; j--){
                if (j == 14){
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }
                else{
                    if (grid[i+1][j] > grid[i+1][j+1])
                        grid[i][j] = grid[i][j] + grid[i+1][j];
                    else
                        grid[i][j] = grid[i][j] + grid[i+1][j+1];
                }
            }
        }
        
        
        /*
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine;
            sCurrentLine = br.readLine();
            tree.SetValue(Integer.parseInt(sCurrentLine));
            
            while ((sCurrentLine = br.readLine()) != null) {
                for (int i = 0; i < sCurrentLine.length(); i+=3){
                    temp = ((sCurrentLine.charAt(i) - '0') * 10) + (sCurrentLine.charAt(i+1) - '0');
                    tree.InsertTreeValue(temp);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        */
        return grid[0][0];
    }
    

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

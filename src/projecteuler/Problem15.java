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
public class Problem15 implements EulerProblem {

    private final int X = 21;
    private final int Y = 21;
    
    @Override
    public String getSolution() {
        return "" + latticePaths();
    }
    
    private long latticePaths(){
        long grid[][] = new long[X][Y];
        long tempx, tempy;
        
        for (int i = X-1; i>=0; i--){
            for (int j = Y-1; j>=0; j--){
                if (i != X-1)
                    tempx = grid[i+1][j];
                else
                    tempx = 0;
                
                if (j != Y-1)
                    tempy = grid[i][j+1];
                else
                    tempy = 0;
                
                if (tempx == 0 && tempy == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = tempx + tempy;
            }
        }
        
        for (int i = 0; i < X; i++){
            for (int j = 0; j < Y; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        
        return grid[0][0];
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

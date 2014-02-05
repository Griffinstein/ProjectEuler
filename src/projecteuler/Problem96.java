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
        int[][] currentgrid = new int[9][9];
        
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
        
        SolveGrid(grid, 0);
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                System.out.print(grid[0][j][k]);
            }
            System.out.println();
        }
        
        return answer;
    }
    
    private void SolveGrid(int[][][] mainGrid, int num){
        boolean[][][] answers = new boolean[9][9][10];
        int[][] grid = new int[9][9];
        int tempx = 0;
        int tempy = 0;
        int temp = 0;
        int tempcount = 0;
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                grid[j][k] = mainGrid[num][j][k];
                if (grid[j][k] != 0)
                    answers[j][k][0] = true;
            }
        }
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                if (grid[j][k] == 0){
                    tempcount = 0;
                    for (int i = 0; i<9; i++){
                        if (grid[j][i] != 0)
                            answers[j][k][grid[j][i]] = true;
                    }
                    for (int i = 0; i<9; i++){
                        if (grid[i][k] != 0)
                            answers[j][k][grid[i][k]] = true;
                    }
                    tempx = (int)Math.floor(j/3);
                    tempy = (int)Math.floor(k/3);
                    for (int x = (tempx*3); x<((tempx*3)+3); x++){
                        for (int y = (tempy*3); y<((tempy*3)+3); y++){
                            if (grid[x][y] != 0)
                                answers[j][k][grid[x][y]] = true;
                        }
                    }
                }
            }
        }
        
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                tempcount = 0;
                
                for (int i = 1; i<10; i++){
                    if (answers[j][k][i] == true){
                        tempcount++;
                        temp = i;
                    }
                }

                if (tempcount == 1){
                    grid[j][k] = temp;
                    answers[j][k][0] = true;
                }


                for (int l = 1; l<10; l++){
                    tempcount = 0;
                    for (int i = 0; i<9; i++){
                        if (grid[j][i] == 0){
                            if (answers[j][i][l] == false){
                                tempcount++;
                                temp = i;
                            }
                        }
                        if (tempcount > 1)
                            break;
                    }

                    if (tempcount == 1){
                        grid[j][temp] = l;
                        answers[j][temp][0] = true;
                        
                        for (int i = 0; i<9; i++){
                            answers[j][i][l] = true;
                        }
                        for (int i = 0; i<9; i++){
                            answers[i][temp][l] = true;
                        }
                        
                        tempx = (int)Math.floor(j/3);
                        tempy = (int)Math.floor(temp/3);
                        for (int x = (tempx*3); x<((tempx*3)+3); x++){
                            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                                answers[x][y][l] = true;
                            }
                        }
                    }
                }


                for (int l = 1; l<10; l++){
                    tempcount = 0;
                    for (int i = 0; i<9; i++){
                        if (grid[i][k] == 0){
                            if (answers[i][k][l] == false){
                                tempcount++;
                                temp = i;
                            }
                        }
                        if (tempcount > 1)
                            break;
                    }

                    if (tempcount == 1){
                        grid[temp][k] = l;
                        answers[temp][k][0] = true;
                        
                        for (int i = 0; i<9; i++){
                            answers[i][k][l] = true;
                        }
                        for (int i = 0; i<9; i++){
                            answers[temp][i][l] = true;
                        }
                        
                        tempx = (int)Math.floor(temp/3);
                        tempy = (int)Math.floor(k/3);
                        for (int x = (tempx*3); x<((tempx*3)+3); x++){
                            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                                answers[x][y][l] = true;
                            }
                        }
                    }
                }
            }
        }
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                System.out.print(grid[j][k]);
            }
            System.out.println();
        }
        
        answers = answers;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//NEED TO RESTUCTURE
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
        
        for (int i = 0; i<50; i++){
            SolveGrid(grid, 5);
        }
        
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
        int anothertemp = 0;
        int foundSquares = 81;
        boolean[][] vert = new boolean[3][10];
        boolean[][] horz = new boolean[3][10];
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                grid[j][k] = mainGrid[num][j][k];
                if (grid[j][k] != 0){
                    answers[j][k][0] = true;
                    foundSquares--;
                }
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
        
        while (foundSquares>0){
            for (int j = 0; j<9; j++){
                for (int k = 0; k<9; k++){
                    tempcount = 0;

                    ////CHECK IF A SQUARE CAN ONLY HOLD 1 NUMBER
                    if (grid[j][k] == 0){
                        for (int i = 1; i<10; i++){
                            if (answers[j][k][i] == false){
                                tempcount++;
                                temp = i;
                            }
                        }
                    }

                    if (tempcount == 1){
                        grid[j][k] = temp;
                        answers[j][k][0] = true;
                        System.out.println((k+1) +  " " + (j+1) + " is: " + temp);
                        foundSquares--;

                        UpdateAnswerArray(j, k, temp, answers);
                    }

                    ////CHECK IF A NUMBER CAN ONLY GO 1 PLACE IN A ROW
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
                            System.out.println((temp+1) +  " " + (j+1) + " is: " + l);
                            foundSquares--;

                            UpdateAnswerArray(j, temp, l, answers);
                        }
                    }

                    ////CHECK IF A NUMBER CAN ONLY GO 1 PLACE IN A COLUMN
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
                            System.out.println((k+1) +  " " + (temp+1) + " is: " + l);
                            foundSquares--;

                            UpdateAnswerArray(temp, k, l, answers);
                        }
                    }
                    
                    ////CHECK IF A NUMBER CAN ONLY GO 1 PLACE IN A SQUARE
                    tempx = (int)Math.floor(j/3);
                    tempy = (int)Math.floor(k/3);
                    for (int l = 1; l<10; l++){
                        tempcount = 0;
                        for (int x = (tempx*3); x<((tempx*3)+3); x++){
                            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                                if (grid[x][y] == 0){
                                    if (answers[x][y][l] == false){
                                        tempcount++;
                                        temp = x;
                                        anothertemp = y;
                                    }
                                }
                                if (tempcount > 1)
                                    break;
                            }
                            if (tempcount > 1)
                                break;
                        }

                        if (tempcount == 1){
                            grid[temp][anothertemp] = l;
                            answers[temp][anothertemp][0] = true;
                            System.out.println((anothertemp+1) +  " " + (temp+1) + " is: " + l);
                            foundSquares--;

                            UpdateAnswerArray(temp, anothertemp, l, answers);
                        }
                    }
                    
                    ////CHECK IF A NUMBER CAN ONLY EXIST IN 1 COLUMN IN A SQUARE
                    tempx = (int)Math.floor(j/3);
                    tempy = (int)Math.floor(k/3);
                    
                    for (int l = 1; l<10; l++){
                        temp = -1;
                        for (int x = (tempx*3); x<((tempx*3)+3); x++){
                            temp++;
                            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                                if (grid[x][y] == 0){
                                    if (!answers[x][y][l]){
                                        horz[temp][l] = true;
                                    }
                                }
                            }
                        }
                        anothertemp = -1;
                        for (int y = (tempy*3); y<((tempy*3)+3); y++){
                            anothertemp++;
                            for (int x = (tempx*3); x<((tempx*3)+3); x++){
                                if (grid[x][y] == 0){
                                    if (!answers[x][y][l]){
                                        vert[anothertemp][l] = true;
                                    }
                                }
                            }
                        }
                    }
                    
                    for (int l = 1; l<10; l++){
                        tempcount = 0;
                        for (int i = 0; i<3; i++){
                            if (horz[i][l]){
                                tempcount++;
                                temp = i;
                            }
                        }
                        if (tempcount == 1){
                            UpdateAnswerArrayExceptSquareRow((temp+(tempx*3)), l, answers, tempy);
                        }
                        
                        tempcount = 0;
                        for (int i = 0; i<3; i++){
                            if (vert[i][l]){
                                tempcount++;
                                temp = i;
                            }
                        }
                        if (tempcount == 1){
                            UpdateAnswerArrayExceptSquareColumn((temp+(tempy*3)), l, answers, tempx);
                        }
                    }
                }
            }
        }
        
        
        System.out.println("Printing grid " + (num + 1) + " solution.");
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                System.out.print(grid[j][k]);
            }
            System.out.println();
        }
        
        answers = answers;
    }
    
    private boolean[][][] UpdateAnswerArray(int x, int y, int num, boolean[][][] answers){
        for (int i = 0; i<9; i++){
            answers[x][i][num] = true;
        }
        
        for (int i = 0; i<9; i++){
            answers[i][y][num] = true;
        }
                       
        
        int tempx = (int)Math.floor(x/3);
        int tempy = (int)Math.floor(y/3);
        for (int i = (tempx*3); i<((tempx*3)+3); i++){
            for (int j = (tempy*3); j<((tempy*3)+3); j++){
                answers[i][j][num] = true;
            }
        }
        
        return answers;
    }

    private boolean[][][] UpdateAnswerArrayExceptSquareColumn(int colNum, int num, boolean[][][] answers, int badX){
        for (int i = 0; i<9; i++){
            if (i != badX && i != (badX+1) && i != (badX+2))
                answers[i][colNum][num] = true;
        }
                               
        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayExceptSquareRow(int rowNum, int num, boolean[][][] answers, int badY){     
        for (int i = 0; i<9; i++){
            if (i != badY && i != (badY+1) && i != (badY+2))
                answers[rowNum][i][num] = true;
        }
                               
        return answers;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

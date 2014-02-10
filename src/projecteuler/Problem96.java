/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
////NEED TO RESTUCTURE
/**
 *
 * @author Ed
 */
public class Problem96 implements EulerProblem {

    final static String FILE_NAME = "src\\projecteuler\\sudoku.txt";
    static int foundSquares;
    
    
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
        
        for (int i = 0; i<50; i++){
            answer = SolveGrid(grid, i, answer);
        }
        
        return answer;
    }
    
    private int SolveGrid(int[][][] mainGrid, int num, int answer){
        boolean[][][] answers = new boolean[9][9][10];
        int[][] grid = new int[9][9];
        int tempx = 0;
        int tempy = 0;
        foundSquares = 81;
        int lastFound = 0;
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                grid[j][k] = mainGrid[num][j][k];
                if (grid[j][k] != 0){
                    answers[j][k][0] = true;
                    foundSquares--;
                }
            }
        }
        
        answers = RefreshAnswersArray(answers, grid);
        
        while (foundSquares>0){
            if (lastFound == foundSquares){
                tempx = tempx;
                CheckImpliedSquares(grid, answers);
                CheckForNakedPairs(grid, answers);
                //CheckForNakedTriples(grid, answers);
                CheckForXWings(grid,answers);
                //break;
            }
            
            lastFound = foundSquares;
            
            Search(grid, answers);
        }

 
        /*System.out.println("Printing grid " + (num + 1) + " solution.");
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                System.out.print(grid[j][k]);
            }
            System.out.println();
        }*/
        
        int temp = (grid[0][0] * 100) + (grid[0][1] * 10) + grid[0][2];
        
        answer = answer + temp;
        
        return answer;
    }
    
    private boolean[][][] RefreshAnswersArray(boolean[][][] answers, int[][] grid){
        int tempx;
        int tempy;
        
        for (int j = 0; j<9; j++){
            for (int k = 0; k<9; k++){
                if (grid[j][k] == 0){
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
        
        return answers;
    }
    
    private boolean[][][] UpdateAnswerArray(int x, int y, int num, boolean[][][] answers){
        foundSquares--;
        
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

    private void CheckImpliedSquares(int[][] grid,  boolean[][][] answers){
        int tempy = 0;
        int tempx = 0;
        int temp = 0;
        int tempcount = 0;
        int anothertemp = 0;
        boolean[][] vert = new boolean[3][10];
        boolean[][] horz = new boolean[3][10];
        
        /*for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (grid[i][j] == 0){
                    System.out.print(i + "," + j + " can be: ");
                    for (int k = 1; k<10; k++){
                        if (!answers[i][j][k]){
                            System.out.print(k + ", ");
                        }
                    }
                    System.out.println();
                }
                 else
                    System.out.println(i + "," + j + " is: " + grid[i][j]);
            }
        }*/
        
        
        for (int i = 0; i<3; i++){//COLUMN OF SQUARES
            for (int j = 0; j<3; j++){//ROW OF SQUARES
                for (int l = 1; l<10; l++){//EACH NUMBER
                    temp = -1;
                    for (int x = (i*3); x < ((i*3)+3); x++){
                        temp++;
                        for (int y = (j*3); y < ((j*3)+3); y++){
                            if (grid[x][y] == 0){
                                if (!answers[x][y][l]){
                                    horz[temp][l] = true;
                                }
                            }
                        }
                    }
                    
                    for (int x = (i*3); x < ((i*3)+3); x++){
                        anothertemp = -1;
                        for (int y = (j*3); y < ((j*3)+3); y++){
                            anothertemp++;
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
                    for (int x = 0; x<3; x++){
                        if (horz[x][l]){
                            tempcount++;
                            temp = x;
                        }
                    }
                    if (tempcount == 1){
                        UpdateAnswerArrayExceptSquareRow((temp+(i*3)), l, answers, j);
                    }

                    tempcount = 0;
                    for (int x = 0; x<3; x++){
                        if (vert[x][l]){
                            tempcount++;
                            temp = x;
                        }
                    }
                    if (tempcount == 1){
                       UpdateAnswerArrayExceptSquareColumn((temp+(j*3)), l, answers, i);
                    }
                }
                
                for (int a = 0; a<3; a++){
                    for (int b = 0; b<10; b++){
                        horz[a][b] = false;
                        vert[a][b] = false;
                    }
                }
            }
        }
        
        int currentGrid;
        
        for (int l = 1; l<10; l++){
            for (int x = 0; x<9; x++){
                currentGrid = -1;
                for (int y = 0; y<9; y++){
                    if (grid[x][y] == 0){
                        if (!answers[x][y][l]){
                            if (currentGrid == -1)
                                currentGrid = (int)Math.floor(y/3);
                            else if (currentGrid != (int)Math.floor(y/3))
                                break;
                        }
                        if (currentGrid != -1 && y == 8)
                            UpdateAnswerArrayOnlySquareRow(l, answers, x, currentGrid);
                    }
                }
            }
            
            for (int x = 0; x<9; x++){
                currentGrid = -1;
                for (int y = 0; y<9; y++){
                    if (grid[y][x] == 0){
                        if (!answers[y][x][l]){
                            if (currentGrid == -1)
                                currentGrid = (int)Math.floor(y/3);
                            else if (currentGrid != (int)Math.floor(y/3))
                                break;
                        }
                        if (currentGrid != -1 && y == 8)
                            UpdateAnswerArrayOnlySquareColumn(l, answers, x, currentGrid);
                    }
                }
            }
        }
        
        
        /*for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (grid[i][j] == 0){
                    System.out.print(i + "," + j + " can be: ");
                    for (int k = 1; k<10; k++){
                        if (!answers[i][j][k]){
                            System.out.print(k + ", ");
                        }
                    }
                    System.out.println();
                }
                 else
                    System.out.println(i + "," + j + " is: " + grid[i][j]);
            }
        }*/
    
    }
    
    private boolean[][][] UpdateAnswerArrayOnlySquareColumn(int num, boolean[][][] answers, int colNum, int rowSqu){
        
        
        int tempx = rowSqu;
        int tempy = (int)Math.floor(colNum/3);

        for (int x = (tempx*3); x<((tempx*3)+3); x++){
            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                if (y != colNum)
                    answers[x][y][num] = true;
            }
        }

        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayExceptSquareColumn(int colNum, int num, boolean[][][] answers, int badX){
        int xPos = badX * 3;
        
        for (int i = 0; i<9; i++){
            if (i != xPos && i != (xPos+1) && i != (xPos+2)){
                if (i == 1 && colNum == 2 && num == 7)
                    i=i;   
                answers[i][colNum][num] = true;
            }
        }
                               
        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayOnlySquareRow(int num, boolean[][][] answers, int rowNum, int colSqu){
        
        
        int tempx = (int)Math.floor(rowNum/3);
        int tempy = colSqu;

        for (int x = (tempx*3); x<((tempx*3)+3); x++){
            for (int y = (tempy*3); y<((tempy*3)+3); y++){
                if (x != rowNum)
                    answers[x][y][num] = true;
            }
        }

        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayExceptSquareRow(int rowNum, int num, boolean[][][] answers, int badY){       
        int yPos = badY * 3;
        
        for (int i = 0; i<9; i++){
            if (i != yPos && i != (yPos+1) && i != (yPos+2)){
                if (rowNum == 0 && i == 6 && num == 4)
                    i=i;    
                answers[rowNum][i][num] = true;
            }
        }
                               
        return answers;
    }
    
    private void CheckForNakedPairs(int[][] grid,  boolean[][][] answers){
        int firstA = 0;
        int secondA = 0;
        int firstB = 0;
        int secondB = 0;
        int temp = 0;
        
        for (int i = 0; i<9; i++){
            for (int j = 0; j<8; j++) {
                temp = 0;
                if (grid [i][j] == 0){
                    for (int l = 1; l<10; l++){
                        if (!answers[i][j][l]){
                            temp++;
                            
                            if (temp == 1)
                                firstA = l;
                            else if (temp == 2)
                                secondA = l;
                            else
                                break;
                        }
                    }
                }
                
                
                
                if (temp == 2){
                    for (int k = j+1; k<9; k++){
                        temp = 0;
                        if (grid [i][k] == 0){
                            for (int l = 1; l<10; l++){
                                if (!answers[i][k][l]){
                                    temp++;
                                    
                                    if (temp == 1)
                                        firstB = l;
                                    else if (temp == 2)
                                        secondB = l;
                                    else
                                        break;
                                }
                            }
                        }
                        
                        if (temp == 2 && firstA == firstB && secondA == secondB){
                            UpdateAnswerArrayNakedPairRow(firstA, secondA, answers, i, j, k);
                        }
                    }
                }
            }
        }

        for (int i = 0; i<9; i++){
            for (int j = 0; j<8; j++) {
                temp = 0;
                if (grid [j][i] == 0){
                    for (int l = 1; l<10; l++){
                        if (!answers[j][i][l]){
                            temp++;
                            
                            if (temp == 1)
                                firstA = l;
                            else if (temp == 2)
                                secondA = l;
                            else
                                break;
                        }
                    }
                }
                
                
                
                if (temp == 2){
                    for (int k = j+1; k<9; k++){
                        temp = 0;
                        if (grid [k][i] == 0){
                            for (int l = 1; l<10; l++){
                                if (!answers[k][i][l]){
                                    temp++;
                                    
                                    if (temp == 1)
                                        firstB = l;
                                    else if (temp == 2)
                                        secondB = l;
                                    else
                                        break;
                                }
                            }
                        }
                        
                        if (temp == 2 && firstA == firstB && secondA == secondB){
                            UpdateAnswerArrayNakedPairColumn(firstA, secondA, answers, i, j, k);
                        }
                    }
                }
            }
        }
        
        
        
        
        
    }
    
    private boolean[][][] UpdateAnswerArrayNakedPairRow(int firstnum, int secondnum, boolean[][][] answers, int rowNum, int badA, int badB){
        
        for(int i = 0; i<9; i++){
            if (i != badA && i != badB){
                answers[rowNum][i][firstnum] = true;
                answers[rowNum][i][secondnum] = true;
            }
        }
        
        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayNakedPairColumn(int firstnum, int secondnum, boolean[][][] answers, int colNum, int badA, int badB){
        
        for(int i = 0; i<9; i++){
            if (i != badA && i != badB){
                answers[i][colNum][firstnum] = true;
                answers[i][colNum][secondnum] = true;
            }
        }
        
        return answers;
    }
    
    private void CheckForXWings(int[][] grid,  boolean[][][] answers){
        int temp;
        int colA = -1;
        int colB = -1;

        int rowA = -1;
        int rowB = -1;
        
        for (int l = 1; l<10; l++){
            //FOR COLUMNS
            for (int x = 0; x<8; x++){
                temp = 0;
                for (int y = 0; y<9; y++){
                    if (grid[x][y] == 0){
                        if (!answers[x][y][l]){
                            temp++;
                            
                            if (temp == 1)
                                colA = y;
                            else if (temp == 2)
                                colB = y;
                            else
                                break;
                        }
                    }
                }
                
                if (temp == 2){
                    for (int y = x+1; y<9; y++){
                        if (grid[y][colA] == 0 && grid[y][colB] == 0){
                            if (!answers[y][colA][l] && !answers[y][colB][l]){
                                temp = 0;
                                for (int i = 0; i<9; i++){
                                    if (grid[y][i] == 0){
                                        if (!answers[y][i][l]){
                                            temp++;
                                        }
                                        if (temp>2)
                                            break;
                                    }
                                }
                                if (temp == 2)
                                    UpdateAnswerArrayXWingColumn(l, answers, colA, colB, x, y);
                            }
                        }
                    }
                }
            }
            
            
            //FOR ROWS
            for (int x = 0; x<8; x++){
                temp = 0;
                for (int y = 0; y<9; y++){
                    if (grid[y][x] == 0){
                        if (!answers[y][x][l]){
                            temp++;
                            
                            if (temp == 1)
                                rowA = y;
                            else if (temp == 2)
                                rowB = y;
                            else
                                break;
                        }
                    }
                }
                
                if (temp == 2){
                    for (int y = x+1; y<9; y++){
                        if (grid[rowA][y] == 0 && grid[rowB][y] == 0){
                            if (!answers[rowA][y][l] && !answers[rowB][y][l]){
                                temp = 0;
                                for (int i = 0; i<9; i++){
                                    if (grid[i][y] == 0){
                                        if (!answers[i][y][l]){
                                            temp++;
                                        }
                                        if (temp>2)
                                            break;
                                    }
                                }
                                if (temp == 2)
                                    UpdateAnswerArrayXWingRow(l, answers, rowA, rowB, x, y);
                            }
                        }
                    }
                }
            }
            
        }
    }
    
    private boolean[][][] UpdateAnswerArrayXWingColumn(int num, boolean[][][] answers, int colA, int colB, int badA, int badB){       

        for (int i = 0; i<9; i++){
            if (i != badA && i != badB){
                answers[i][colA][num] = true;
                answers[i][colB][num] = true;
            }
        }
                               
        return answers;
    }
    
    private boolean[][][] UpdateAnswerArrayXWingRow(int num, boolean[][][] answers, int rowA, int rowB, int badA, int badB){       

        for (int i = 0; i<9; i++){
            if (i != badA && i != badB){
                answers[rowA][i][num] = true;
                answers[rowB][i][num] = true;
            }
        }
                               
        return answers;
    }
    
    private void Search(int[][] grid,  boolean[][][] answers){
        int tempy = 0;
        int tempx = 0;
        int temp = 0;
        int tempcount = 0;
        int anothertemp = 0;
        boolean jesus = true;
        boolean[][] vert = new boolean[3][10];
        boolean[][] horz = new boolean[3][10];
        
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
                        //System.out.println((k+1) +  " " + (j+1) + " is: " + temp);

                        UpdateAnswerArray(j, k, temp, answers);
                    }

                    //////CHECK IF A NUMBER CAN ONLY GO 1 PLACE IN A ROW
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
                            //System.out.println((temp+1) +  " " + (j+1) + " is: " + l);

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
                            //System.out.println((k+1) +  " " + (temp+1) + " is: " + l);

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
                            //System.out.println((anothertemp+1) +  " " + (temp+1) + " is: " + l);

                            UpdateAnswerArray(temp, anothertemp, l, answers);
                        }
                    }
                }
            }
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

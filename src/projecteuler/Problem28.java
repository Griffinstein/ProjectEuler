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
public class Problem28 implements EulerProblem{

    private final int max = 1001;
    
    @Override
    public String getSolution() {
        return "" + NumberSpiralDiagonals();
    }
    
    private int NumberSpiralDiagonals(){
        int answer = 0;
        int vertical = 1;
        int horizontal = 1;
        int currentMove = 1;
        int X = (int)Math.floor((double)max/2);
        int Y = X;
        int count = 1;
        int total = max*max;
        Boolean down = true;
        Boolean right = true;
        Boolean moveVertical = false;
        
        
        int[][] spiral = new int[max][max];
        
        while (count <= total){
            spiral[X][Y] = count;
            count++;
            
            if (currentMove == 0){
                if (moveVertical){
                    down = !down;
                    vertical++;
                    currentMove = horizontal;
                }
                else{
                    right = !right;
                    horizontal++;
                    currentMove = vertical;
                }
                
                moveVertical = !moveVertical;
            }
            
            if (moveVertical){
                if (down)
                    Y++;
                else
                    Y--;
            }
            else{
                if (right)
                    X++;
                else
                    X--;
            }
            currentMove--;
        }
        
        int j = 0;
        int i = 0;
        while(j < max && i < max){
            answer = answer + spiral[i][j];
            i++;
            j++;
        }
        j = max-1;
        i = 0;
        while(j > -1 && i < max){
            answer = answer + spiral[i][j];
            i++;
            j--;
        }
        
        X = (int)Math.floor((double)max/2);
        Y = X;
        
        answer = answer - spiral[X][Y];
        
        
        return answer;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

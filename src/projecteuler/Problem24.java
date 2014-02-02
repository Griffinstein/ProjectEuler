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
public class Problem24 implements EulerProblem{

    private final int max = 10;
    
    @Override
    public String getSolution() {
        return "" + LexicographicPermutations();
    }
    
    private int LexicographicPermutations(){
        int answer = 0;
        Boolean[] taken = new Boolean[max];
        taken = reset(taken);
        
        for (int a = 0; a < max; a++){
            while (taken[a]){
                a++;
                if (a == max)
                    break;
            }
            
            if (a == max)
                break;
                
            taken[a] = true;
                
            for (int b = 0; b < max; b++){
                while (taken[b]){
                    b++;
                    if (b == max)
                        break;
                }
                
                if (b == max)
                    break;
                
                taken[b] = true;
                
                for (int c = 0; c < max; c++){
                    while (taken[c]){
                        c++;
                        if (c == max)
                            break;   
                    }
                    
                    if (c == max)
                        break;   

                    taken[c] = true;
                    
                    for (int d = 0; d < max; d++){
                        while (taken[d]){
                            d++;
                            if (d == max)
                                break;   
                        }

                        if (d == max)
                            break;   

                        taken[d] = true;

                        for (int e = 0; e < max; e++){
                            while (taken[e]){
                                e++;
                                if (e == max)
                                    break;   
                            }
                            if (e == max)
                                break;   
                            taken[e] = true;
                            for (int f = 0; f < max; f++){
                                while (taken[f]){
                                    f++;
                                    if (f == max)
                                        break;   
                                }
                                if (f == max)
                                    break;   

                                taken[f] = true;

                                for (int g = 0; g < max; g++){
                                    while (taken[g]){
                                        g++;
                                        if (g == max)
                                            break;   
                                    }

                                    if (g == max)
                                        break;   

                                    taken[g] = true;

                                    for (int h = 0; h < max; h++){
                                        while (taken[h]){
                                            h++;
                                            if (h == max)
                                                break;   
                                        }

                                        if (h == max)
                                            break;   

                                        taken[h] = true;

                                        for (int i = 0; i < max; i++){
                                            while (taken[i]){
                                                i++;
                                                if (i == max)
                                                    break;   
                                            }

                                            if (i == max)
                                                break;   

                                            taken[i] = true;

                                            for (int j = 0; j < max; j++){
                                                while (taken[j]){
                                                    j++;
                                                    if (j == max)
                                                        break;   
                                                }

                                                if (j == max)
                                                    break;   

                                                taken[j] = true;

                                                answer++;
                                                if (answer == 1000000)
                                                    System.out.println(a+""+b+""+c+""+d+""+e+""+f+""+g+""+h+""+i+""+j);

                                                taken[j] = false;
                                            }
                                            taken[i] = false;
                                        }
                                        taken[h] = false;
                                    }  
                                    taken[g] = false;
                                }  
                                taken[f] = false;
                            }  
                            taken[e] = false;
                        }  
                        taken[d] = false;
                    }   
                    taken[c] = false;
                }   
                taken[b] = false;
            }    
            taken[a] = false;
        }
        
        return answer;
    }
    
    private Boolean[] reset(Boolean[] taken){
        for (int i = 0; i<max; i++)
            taken[i] = false;
        return taken;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

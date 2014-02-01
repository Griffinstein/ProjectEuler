/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ed
 */
public class Problem22 implements EulerProblem {

    final static String FILE_NAME = "src\\projecteuler\\Problem22.txt";
    
    @Override
    public String getSolution() {
        return "" + NamesScores();
    }
    
    private int NamesScores() {
        int answer = 0;
        ArrayList<String> names = new ArrayList<>();
        String delims = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine = br.readLine();
           
            String[] tokens = sCurrentLine.split(delims);
            int j = 0;
            
            for (int i = 0; i < tokens.length; i++){
                answer = answer + (AlphabeticalValue(tokens[i]) * (i+1));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return answer;
    }

    private String[] MergeSort(String[] names){
        return names;
    }
    
    private int AlphabeticalValue(String name){
        int answer = 0;
        
        String input = name.toLowerCase();// Make your input toLowerCase.
        int[] alphabetArray = new int[26];
        for ( int i = 0; i < input.length(); i++ ) {
            char ch=  input.charAt(i);
            int value = (int) ch;
            if (value >= 97 && value <= 122){
                alphabetArray[ch-'a']++;
            }
        }
        
        for (int i = 0; i < alphabetArray.length; i++) {
            if(alphabetArray[i]>0){
                answer = answer + (i+1);
                char ch = (char) (i+97);
                //System.out.println(ch +"  : "+alphabetArray[i]);   //Show the result.
            }         
        }
        
        return answer;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

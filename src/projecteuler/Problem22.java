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
import java.util.Arrays;
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
        String delims = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine = br.readLine();
           
            String[] tokens = sCurrentLine.split(delims);
            int j = 0;
            
            tokens = MergeSort(tokens);
            
            for (int i = 0; i < tokens.length; i++){
                answer = answer + (AlphabeticalValue(tokens[i]) * (i+1));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return answer;
    }

    private String[] MergeSort(String[] names){
        if (names.length > 1){
            int q = names.length/2;
            String[] leftArray = Arrays.copyOfRange(names, 0, q);
            String[] rightArray = Arrays.copyOfRange(names,q,names.length);
            
            leftArray = MergeSort(leftArray);
            rightArray = MergeSort(rightArray);
            
            String[] result = merge(leftArray,rightArray);
            
            return result;
        }
        else
            return names;
    }
    
    private String[] merge(String[] l, String[] r) {
        int lLen = l.length;
        int rLen = r.length;
        int lcount = 0;
        int rcount = 0;
        int count = 0;
        String[] result = new String[lLen+rLen];
        while (lLen > lcount || rLen > rcount){
            if (lLen > lcount && rLen > rcount){
                if (TestNames(l[lcount], r[rcount])){
                    result[count] = l[lcount];
                    lcount++;
                    count++;
                }
                else{
                    result[count] = r[rcount];
                    rcount++;
                    count++; 
                }
            }
            else if (lLen > lcount){
                result[count] = l[lcount];
                lcount++;
                count++;
            }
            else if (rLen > rcount){
                result[count] = r[rcount];
                rcount++;
                count++;                
            }
        }
        return result;
    }
    
    private boolean TestNames(String nameLeft, String nameRight){
        int length;
        String left = nameLeft.toLowerCase();
        String right = nameRight.toLowerCase();
        
        if (nameLeft.length() > nameRight.length())
            length = nameLeft.length();
        else
            length = nameRight.length();
        
        for (int i = 0; i<length; i++){
            if (left.charAt(i)!= right.charAt(i)){
                if (left.charAt(i) < right.charAt(i))
                    return true;
                else
                    return false;
            }
        }
        
        return true;
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
                answer = answer + ((i+1) * alphabetArray[i]);
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

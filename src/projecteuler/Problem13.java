/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.lang.Math;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ed
 */
public class Problem13 implements EulerProblem{

    int a = 58496;
    int b = 93760;
    final static String FILE_NAME = "C:\\Users\\Ed\\Documents\\NetBeansProjects\\ProjectEuler\\src\\projecteuler\\Problem13.txt";
    private int[][] _numbers;
    
    @Override
    public String getSolution() {
        return "" + test();
    }
    
    private int test() {
        int num = 0;
        int temp = 0;
        int sum;
        
        //num = a * 150;
        
        _numbers = new int[150][50];
        
        //BufferedReader reader = new BufferedReader(new FileReader("C:\Users\Ed\Documents\NetBeansProjects\ProjectEuler\src\projecteuler\Problem13.txt"));
        //String line = null;
        //while ((line = reader.readLine()) != null) {
        //    System.out.println(line);
        //}
        
        //List<Integer> integers = new ArrayList<Integer>();
        //Scanner fileScanner = new Scanner(new File(""));
        //while (fileScanner.hasNextInt()){
        //    integers.add(fileScanner.nextInt());
        //}
        
        //treat as a small file
        //List<String> lines = text.readSmallTextFile(FILE_NAME);
        //log(lines);
        //lines.add("This is a line added in code.");
        //text.writeSmallTextFile(lines, FILE_NAME);
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                for (int i = 0; i < sCurrentLine.length(); i++){
                    _numbers[temp][i] = sCurrentLine.charAt(i) - '0';
                }
                temp++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        temp = 0;
        
        //int[] A = {5,8,4,9,6};
        //int[] B = {9,3,7,6,0};
        int[] C = new int[50];
        
        for (int i = 49; i>=0; i--){
            sum = 0;
            for (int j = 0; j < 150; j++){
                sum = sum + _numbers[j][i];//A[i];
            }
            C[i] = (sum + temp)%10;
            temp = (int)Math.floor((sum + temp)/10);
        }

        C = C;
        
        
        return temp;
        
        //return 0;
    }
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

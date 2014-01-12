/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;  
//import java.util.Collections; 
//import java.util.List;

/**
 *
 * @author Ed
 */

public class ProjectEuler {
	  public static void main(String[] args) {
              MultipleOf3And5Alt();
            //  EvenFibonacciNumbers();
            //  LargestPrimeFactor();
            //  LargestPalindromeProduct();
            //  SmallestMultiple();
            //  SumSquareDifference();
	  }
	  
	  public static void MultipleOf3And5() {
		  int output = 0;
		  for(int i=1; i<1000; i++ ) {
			  if (i%3 == 0) 
				  output = output + i;
			  else if (i%5 == 0) 
				  output = output + i;
		  }
		  
		  System.out.println(output);
	  }
	  
          //http://projecteuler.net/overview=001 for details
          public static void MultipleOf3And5Alt() {
		  int tar = 999;       
                  int output = NumOfMults(3,tar) + NumOfMults(5,tar) - NumOfMults(15,tar);
		  
		  System.out.println(output);
	  }

          public static int NumOfMults(int num, int X) {
              int answer = (int)Math.floor(X/num);
              answer = (num * (answer * (answer + 1))) / 2;
              return answer;
	  }
          
	  public static void EvenFibonacciNumbers() {
		  int first = 1;
		  int second = 2;
		  int next;
		  int sum = 2;
		  
		  while (true){
			  next = second + first;
			  if (next > 4000000)
				  break;
			  if (next % 2 == 0)
				  sum += next;
			  first = second;
			  second = next;
		  }
		  System.out.println(sum);
	  }
	  
	  public static void LargestPrimeFactor() {
		  long prime = 600851475143L;
		  
		  //ArrayList<Integer> intlist = new ArrayList<>(); 
		  
		  for (int i = 2; i < prime; i++) {
			  if (prime%i == 0){
                              //intlist.add(i);
                              prime = prime/i;
                              i = 2;
			  }
		  }
                  //intlist.add((int)prime);

		  System.out.println(prime);
	  }
          
          public static void LargestPalindromeProduct(){
              int palindromic = 0;
              boolean found;
              for (int i = 100; i < 999; i++){
                  for (int j = i; j < 999; j++){
                      found = TestPalindrome(i*j);
                      if (found){
                          int temp = i*j;
                          if (palindromic < temp)
                              palindromic = temp;
                      }
                  }
              }
              
              System.out.println(palindromic);
          }
          
          public static boolean TestPalindrome(int i){
              int temp = i;
              
              ArrayList<Integer> digitList = new ArrayList<>();
              
              while(true){
                  digitList.add(temp % 10);
                  temp = (int)(Math.floor(temp/10));
                  if (temp == 0)
                      break;
              }
              
              int k = digitList.size() - 1;
              
              for (int j = 0; j < digitList.size(); j++){
                  if (digitList.get(j) != digitList.get(k))
                      break;
                  
                  if ((k - 1) == j || j == k)
                      return true;
                  
                  k--;
              }
              
              return false;
          }
          
          public static void SmallestMultiple() {
		  int output = 0;
                  boolean found;
                  
		  while(true){
                      output = output + 20;
                      found = true;
                      for (int i = 1; i <= 20; i++){
                          if (output%i != 0){
                              found = false;
                              break;
                          }
                      }
                      
                      if (found)
                          break;
		  }
		  
		  System.out.println(output);
	  }
          
          public static void SumSquareDifference() {
              int output;
              
              //output = SquareOfSum(100) - SumOfSquares(100);
              output = SquareOfSumAlt(100);
              // see http://projecteuler.net/overview=006 for details
              
              System.out.println(output);
	  }
          
          public static int SumOfSquares(int i) {
              int sum = 0;
              for (int j = 1; j <= i; j++ ) {
                  sum += (j * j);
              }
                 
              return sum;
	  }
          
          public static int SquareOfSum(int i) {
              int sum = 0;
              for (int j = 1; j <= i; j++ ) {
                  sum += j;
              }            
              sum = sum * sum;
                 
              return sum;
	  }
          
          public static int SquareOfSumAlt(int i) {
              int sum = (i * (i+1)) / 2;
              sum = (sum * sum);
              
              int sq = (((2 * i) + 1)*(i + 1)*(i)) / 6;
              
              return (sum - sq);
	  }
}	

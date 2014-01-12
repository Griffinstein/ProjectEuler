/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;  
import java.util.Collections; 
import java.util.List;

/**
 *
 * @author Ed
 */

public class ProjectEuler {
	  public static void main(String[] args) {
		  //MultipleOf3And5();
		  //EvenFibonacciNumbers();
		  LargestPrimeFactor();
	  }
	  
	  public static void MultipleOf3And5() {
		  int output = 0;
		  for(int i=1; i<1000; i++ ) {
			  
			  if (i%3 == 0) {
				  output = output + i;
			  }
			  else if (i%5 == 0) {
				  output = output + i; 
			  } 
		  }
		  
		  System.out.println(output);
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
		  long check = prime;
		  
		  ArrayList<Integer> intlist = new ArrayList<Integer>(); 
		  
		  for (int i = 2; i < check; i++) {
			  if (check%i == 0){
                              intlist.add(i);
                              check = check/i;
                              i = 2;
			  }
		  }
                  intlist.add((int)check);

		  System.out.println(check);
	  }
}	
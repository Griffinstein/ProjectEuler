/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;  
import java.math.BigInteger;  
//import java.util.Collections; 
//import java.util.List;

/**
 *
 * @author Ed
 */

public class ProjectEuler {
	  public static void main(String[] args) {
            //  MultipleOf3And5Alt();
            //  EvenFibonacciNumbers();
            //  LargestPrimeFactor();
            //  LargestPalindromeProduct();
            //  SmallestMultiple();
            //  SumSquareDifference();
            //  GetPrimeAt(10001);
            //  LargestProductSeries();
            //  SpecialPythagoreanTripley();
              SummationOfPrimes(2000000);
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
	  
          public static void MultipleOf3And5Alt() {
		  int target = 999;       
                  int output = NumOfMults(3,target) + NumOfMults(5,target) - NumOfMults(15,target);
		  
		  System.out.println(output);
                  //http://projecteuler.net/overview=001 for details
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
          
          public static void GetPrimeAt(int x) {
              int temp = 1;
              ArrayList<Integer> primeList = new ArrayList<>();
              boolean primer;
              double maxRoot;
              
              primeList.add(2);
              
              for (int i = 0; i < x; i++) {
		  while (true){
                      primer = true;
                      temp = temp + 2;
                      maxRoot = Math.sqrt(primeList.get(primeList.size()-1));
                      for (int j = 1; j < primeList.size(); j++) {
			  if (temp%primeList.get(j) == 0){
                              primer = false;
                              break;
			  }
                          if (maxRoot < primeList.get(j)){
                            break;
                          }
                      }
                      
                      if (primer){
                          primeList.add(temp);
                          break;
                      }
                  }
              }
              
              System.out.println(primeList.get(x-1));
          }
          
          public static void LargestProductSeries(){
              BigInteger series = new BigInteger("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
              BigInteger ten = new BigInteger("10");
              ArrayList<Integer> digitList = new ArrayList<>();
              int answer = 0;
              
              for (int i = 0; i < 1000; i++){
                  digitList.add((series.remainder(ten)).intValue());
                  series = series.divide(ten);
              }

              int i = 0;
              
              while (true){
                  if (digitList.get(i) != 0 ||
                      digitList.get(i+1) != 0 ||
                      digitList.get(i+2) != 0 ||
                      digitList.get(i+3) != 0 ||
                      digitList.get(i+4) != 0)
                      break;
                  i++;
              }
              
              for (; i < 995; i++){
                  if (digitList.get(i+4) == 0 || digitList.get(i+4) == 1)
                      i = i + 4;
                  else{
                      int newTemp = digitList.get(i) * 
                              digitList.get(i+1) * 
                              digitList.get(i+2) *
                              digitList.get(i+3) *
                              digitList.get(i+4);
                      if (answer < newTemp)
                          answer = newTemp;
                  }
              }
              
              System.out.println(answer);
          }
          
          public static void SpecialPythagoreanTripley(){
              boolean found = false;
              int output = 0;
              
              for (int a = 3; a < 333; a++){
                  for (int b = a+1; b < 500; b++){
                      for (int c = b+1; c < 500; c++){
                          if (a+b+c == 1000){
                              if ((a*a)+(b*b) == (c*c)){
                                  found = true;
                                  output = a * b * c;
                                  break;
                              }
                          }
                      }
                      if (found)
                          break;
                  }
                  if (found)
                      break;
              }
              
              System.out.println(output);
          }

          public static void SummationOfPrimes(int limit) {
              ArrayList<Integer> primeList = new ArrayList<>();
              boolean primer;
              primeList.add(2);
              double maxRoot;

              for (int temp = 3; temp < limit; temp = temp + 2) {
                  primer = true;
                  maxRoot = Math.sqrt(primeList.get(primeList.size()-1));
                  for (int j = 1; j < primeList.size(); j++) {
                      if (temp%primeList.get(j) == 0){
                          primer = false;
                          break;
                      }
                      if (maxRoot < primeList.get(j)){
                          break;
                      }
                  }

                  if (primer){
                      primeList.add(temp);
                  }
              }
              
              long sum = 0;
              for (Integer j:primeList)
                  sum = sum + j;
              
              System.out.println(sum);
          }
}	

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
            
             /**EulerProblem solution = new Problem1(1000) {};
             *  System.out.println(solution.getSolution());
             *  System.out.println(solution.getAltSolution());  
             *  @Problem 1: MultipleOf3And5
             */
              
             /**EulerProblem solution = new Problem2(4000000) {};
             *  System.out.println(solution.getSolution()); 
             *  @Problem 2: EvenFibonacciNumbers
             */
              
             /**EulerProblem solution = new Problem3() {};
             *  System.out.println(solution.getSolution()); 
             *  @Problem 3: LargestPrimeFactor
             */

             /**EulerProblem solution = new Problem4() {};
             *  System.out.println(solution.getSolution()); 
             *  @Problem 4: LargestPalindromeProduct
             */

             /**EulerProblem solution = new Problem5(20) {};
             *  System.out.println(solution.getSolution()); 
             *  @Problem 5: SmallestMultiple
             */
              
              
            //  SumSquareDifference();
            //  GetPrimeAt(10001);
            //  LargestProductSeries();
            //  SpecialPythagoreanTripley();
            //  SummationOfPrimes(2000000);
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
              boolean prime;
              primeList.add(2);
              primeList.add(3);
              double maxRoot;
              int increase = 2;

              for (int temp = 5; temp < limit;) {
                  temp += increase;
                  if (increase == 2)
                      increase = 4;
                  else if (increase == 4)
                      increase = 2;
                  prime = true;
                  maxRoot = Math.sqrt(primeList.get(primeList.size()-1));
                  for (int j = 1; j < primeList.size(); j++) {
                      if (temp%primeList.get(j) == 0){
                          prime = false;
                          break;
                      }
                      if (maxRoot < primeList.get(j))
                          break;
                  }

                  if (prime){
                      primeList.add(temp);
                  }
              }
              
              long sum = 0;
              for (Integer j:primeList)
                 sum = sum + j;
              
              System.out.println(sum);
          }
}	

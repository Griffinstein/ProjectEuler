/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author Ed
 */
public class Problem4 implements EulerProblem{

    @Override
    public String getSolution() {
        return "" + LargestPalindromeProduct();
    }

    private int LargestPalindromeProduct(){
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

      return palindromic;
    }

    private boolean TestPalindrome(int i){
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
    
    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

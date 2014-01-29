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
public class Problem17 implements EulerProblem {

    @Override
    public String getSolution() {
        return "" + NumberLetterCounts();
    }
    
    private int NumberLetterCounts(){
        int answer = 0;
        String[] numbers = new String[1000];
        int numDigits, first, second, third;
        String temp, secondtemp;
        int lastTwo;
        secondtemp = "0";
        
        for (int i = 1; i<=1000; i++){
            temp = "" + i;
            numDigits = temp.length();
            
            
            if (temp.length() <= 2)
                secondtemp = temp;
            else
                secondtemp = temp.substring(1);

            lastTwo = Integer.parseInt(secondtemp);
            
            if (numDigits > 2){
                third = temp.charAt(temp.length()-3) - '0';
                numbers[i-1] = getWord(third) + " " + getWord(100);
                if (i%100 != 0)
                    numbers[i-1] = numbers[i-1] + " and ";
            }
            if (numDigits > 1){
                if (lastTwo >= 20){
                    second = (temp.charAt(temp.length()-2) - '0') * 10;
                    if (numbers[i-1] != null)
                        numbers[i-1] = numbers[i-1]+ getWord(second) + " ";
                    else
                        numbers[i-1] = getWord(second) + " ";
                }
                else{
                    second = lastTwo;
                    if (numbers[i-1] != null)
                        numbers[i-1] = numbers[i-1] + getWord(second);
                    else
                        numbers[i-1] = getWord(second);
                }
            }
            if (numDigits > 0 && (secondtemp < 10 || secondtemp > 20)){
                first = temp.charAt(temp.length()-1) - '0';
                if (numbers[i-1] != null)
                    numbers[i-1] = numbers[i-1] + getWord(first);
                else
                    numbers[i-1] = getWord(first);
            }
            
        }
        
        return answer;
    }
    
    private String getWord(int x){
        String word = "";
        if (x==1)
            return "one";
        else if (x==2)
            return "two";
        else if (x==3)
            return "three";
        else if (x==4)
            return "four";
        else if (x==5)
            return "five";
        else if (x==6)
            return "six";
        else if (x==7)
            return "seven";
        else if (x==8)
            return "eight";
        else if (x==9)
            return "nine";
        else if (x==10)
            return "ten";
        else if (x==11)
            return "eleven";
        else if (x==12)
            return "twelve";
        else if (x==13)
            return "thirteen";
        else if (x==14)
            return "fourteen";
        else if (x==15)
            return "fifteen";
        else if (x==16)
            return "sixteen";
        else if (x==17)
            return "seventeen";
        else if (x==18)
            return "eighteen";
        else if (x==19)
            return "nineteen";
        else if (x==20)
            return "twenty";
        else if (x==30)
            return "thirty";
        else if (x==40)
            return "forty";
        else if (x==50)
            return "fifty";
        else if (x==60)
            return "sixty";
        else if (x==70)
            return "seventy";
        else if (x==80)
            return "eighty";
        else if (x==90)
            return "ninety";
        else if (x==100)
            return "hundred";
        else if (x==1000)
            return "thousand";           
        
                    
        return word;
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

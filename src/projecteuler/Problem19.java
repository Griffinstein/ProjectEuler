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
public class Problem19 implements EulerProblem {
    private int currentYear = 1900;
    private int currentMonth = 1;
    private int currentDay = 7;
    
    @Override
    public String getSolution() {
        return "" + CountingSundays();
    }
    
    private int CountingSundays(){
        int answer = 0;
        
        while (currentYear != 2001){
            currentDay = currentDay + 7;
            CheckMonth();
            if (currentDay == 1 && currentYear < 2001 && currentYear > 1900){
                answer++;
            }
        }
        
        return answer;
    }
    
    private void CheckMonth(){
        if (currentMonth == 1 || 
            currentMonth == 3 ||
            currentMonth == 5 ||
            currentMonth == 7 ||
            currentMonth == 8 ||
            currentMonth == 10||
            currentMonth == 12){
            if (currentDay > 31){
                if (currentMonth == 12){
                    currentMonth = 1;
                    currentYear++;
                    currentDay = currentDay - 31;}
                else{
                    currentMonth++;
                    currentDay = currentDay - 31;
                }
            }
        }
        else if (currentMonth == 4 || 
            currentMonth == 6 ||
            currentMonth == 9 ||
            currentMonth == 11){
            if (currentDay > 30){
                currentMonth++;
                currentDay = currentDay - 30;
            }
        }
        else {
            if (currentYear % 400 == 0){
                if (currentDay > 29){
                    currentMonth++;
                    currentDay = currentDay - 29; 
                    System.out.println(currentYear + " is a leap year");
                }
            }
            else if (currentYear % 100 == 0){
                if (currentDay > 28){
                    currentMonth++;
                    currentDay = currentDay - 28;   
                    System.out.println(currentYear + " is not a leap year");
                }
            }
            else if (currentYear % 4 == 0){
                if (currentDay > 29){
                    currentMonth++;
                    currentDay = currentDay - 29;
                    System.out.println(currentYear + " is a leap year");
                }
            }
            else{
                if (currentDay > 28){
                    currentMonth++;
                    currentDay = currentDay - 28;    
                    System.out.println(currentYear + " is not a leap year");
                }
            }
        }
    }

    @Override
    public String getAltSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

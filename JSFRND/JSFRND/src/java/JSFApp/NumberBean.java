/*
 * NumberBean.java
 *
 * Created on February 28, 2006, 12:47 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jsfApp;
public class NumberBean
{
    int firstNumber = 0;
    int secondNumber = 0;

    public NumberBean()
    {
        System.out.println("Creating model object");
    }
    public void setFirstNumber(int number)
    {
        firstNumber=number;
        System.out.println("Set firstNumber " + number);
    }
    public void setSecondNumber(int number)
    {
        secondNumber=number;
        System.out.println("Set secondNumber " + number);
    }
    public int getFirstNumber() 
    {
        System.out.println("get firstNumber " + firstNumber);
        return firstNumber;
    }

    public int getSecondNumber() 
    {
        System.out.println("get secondNumber " + secondNumber);
        return secondNumber;
    }
    public int getResult() 
    {
        System.out.println("get result " + (firstNumber + secondNumber));
        return firstNumber + secondNumber;
    }


}


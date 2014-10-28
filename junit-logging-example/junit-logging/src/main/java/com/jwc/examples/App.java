package com.jwc.examples;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator myCalc = new Calculator();
        int iTotal = myCalc.addInts(6,5);
        System.out.println("Call to addInts returned: " + iTotal);

        double dPower = myCalc.powerInts(10001, 2);

}
}

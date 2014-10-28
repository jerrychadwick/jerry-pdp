package com.jwc.examples;

import junit.framework.TestCase;

/**
 * Created by jchadwic on 10/28/14.
 */
public class CalculatorTest extends TestCase {

    public void testAddInts() throws Exception {
        Calculator myCalc = new Calculator();
        int testTotal = 13;
        int total = myCalc.addInts(7, 6);
        assertEquals(total, testTotal);
    }

    public void testSubInts() throws Exception {
        Calculator myCalc = new Calculator();
        int testTotal = 1;
        int total = myCalc.subInts(8, 6);
        assertEquals(total, testTotal);
    }

    public void testPowerInts() throws Exception {
        Calculator myCalc = new Calculator();
        double testTotal = 16;
        double total = myCalc.powerInts(2, 4);
        assertEquals(total, testTotal);
    }

}

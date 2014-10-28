package com.jwc.examples;


import org.apache.log4j.Logger;

/**
 * Created by jchadwic on 10/28/14.
 */
public class Calculator {

    private final Logger logger2 = Logger.getLogger(Calculator.class); // goes to the screen
    private final Logger logger = Logger.getLogger("foo"); // goes to the outfile

    public int addInts( int intOne, int intTwo ) {
        logger.info(String.format("Adding two ints. intOne=\"%d\" intTwo=\"%d\"", intOne, intTwo));
        return intOne + intTwo;
    }
    public int subInts( int intOne, int intTwo ) {
        logger.info("Subtracting two ints.");
        return intOne - intTwo;
    }

    public double powerInts( double intOne, double intTwo ) {
        logger.info("Raising one number to another power.");
        if (intOne > 10000l) {
            logger2.warn(String.format("Warning: intOne too big! intOne=\"%f\"", intOne));
        }
        return Math.pow(intOne, intTwo);
    }
}

package com.jerry.chadwick;
import java.lang.Math;

/**
 * Created by jchadwic on 9/12/14.
 * yay!
 */

// Fruits example of STATIC METHOD CALLS

class FruitIII {

    // Return int number of pieces of peel that
    // resulted from the peeling activity.
    public static int peel() {

        System.out.println("Peeling is appealing using a static method call.");
        return 1;
    }
}

class AppleIII {
    public int peel() {
        return FruitIII.peel();     // calling FruitIII's peel method statically.
    }
}

public class StaticMethodExample {

    public static void main(String[] args) {
        AppleIII apple = new AppleIII();
        int pieces = apple.peel();  // Apple's own peel() method.
    }

}

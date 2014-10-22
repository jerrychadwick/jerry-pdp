package com.jerry.chadwick;

/**
 * Created by jchadwic on 9/12/14.
 */

// Fruits example of COMPOSITION

class FruitII {

    // Return int number of pieces of peel that
    // resulted from the peeling activity.
    public int peel() {

        System.out.println("Peeling is appealing using composition.");
        return 1;
    }
}

// Apple is a composition of Fruit...
class  AppleII {

    // Apple holds a reference to a Fruit object...
    private FruitII fruit = new FruitII();

    // ... and defines its own peel() method which invokes the parent method.
    public int peel() {
        return fruit.peel();
    }
}

public class CompExample {

    public static void main(String[] args) {
        AppleII apple = new AppleII();
        int pieces = apple.peel();  // Apple's own peel() method.
    }
}
package com.jerry.chadwick;

// Fruits example of INHERITANCE

class  Fruit {

    // Return int number of pieces of peel that
    // resulted from the peeling activity.
    public int peel() {

        System.out.println("Peeling is appealing using inheritance.");
        return 1;
    }
}

// Apple is a sub-class of Fruit and can use the Fruit Class's peel() method directly.
class  Apple extends Fruit {
}

public class InheritanceExample {

    public static void main(String[] args) {
        Apple apple = new Apple();
        int pieces = apple.peel();  // Apple inherited Fruit's peel() method.
    }
}

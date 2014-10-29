package com.jerry.chadwick;

/**
 * Created by jchadwic on 9/12/14.
 * yay!
 */

// Fruits example of STATIC METHOD CALLS

class CalorieCalculatorII {

    public static int calculateCalories(int calPerSlice, int numSlices) {
        return calPerSlice * numSlices;
    }

}

// Orange is a composition of
class  OrangeIII {

    public int getNumSlices() {
        return 12;
    }

    public int caloriesPerSlice() {
        return 36;
    }

    public int getCalories() {
        return CalorieCalculatorII.calculateCalories(getNumSlices(), caloriesPerSlice());
    }
}

// Apple is a composition of
class  AppleIII  {

    public int getNumSlices() {
        return 2;
    }

    public int caloriesPerSlice() {
        return 25;
    }

    public int getCalories() {
        return CalorieCalculatorII.calculateCalories(getNumSlices(), caloriesPerSlice());
    }

}

public class StaticMethodExample {

    public static void main(String[] args) {
        AppleIII apple = new AppleIII();
        OrangeIII orange = new OrangeIII();

        System.out.println("An apple has " + apple.getCalories() + " calories ");
        System.out.println("An orange has " + orange.getCalories() + " calories ");
    }
}

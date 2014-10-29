package com.jerry.chadwick;

/**
 * Created by jchadwic on 9/12/14.
 *
 */

// Fruits example of COMPOSITION

interface FruitII {
    int getNumSlices ();
    int caloriesPerSlice ();
}

class CalorieCalculator {

    private FruitII fruit;

    public CalorieCalculator (FruitII fruit) {
        this.fruit = fruit;
    }

    public int calculateCalories() {
        return fruit.caloriesPerSlice() * fruit.getNumSlices();
    }

}

// Orange is a composition of
class  OrangeII implements FruitII {

    private CalorieCalculator calorieCalculator = new CalorieCalculator(this);

    @Override
    public int getNumSlices() {
        return 10;
    }

    @Override
    public int caloriesPerSlice() {
        return 35;
    }

    public int getCalories() {
        return calorieCalculator.calculateCalories();
    }
    //


}

// Apple is a composition of
class  AppleII implements FruitII {

    private CalorieCalculator calorieCalculator = new CalorieCalculator(this);

    @Override
    public int getNumSlices() {
        return 1;
    }

    @Override
    public int caloriesPerSlice() {
        return 20;
    }

    public int getCalories() {
        return calorieCalculator.calculateCalories();
    }

}

public class CompExample {

    public static void main(String[] args) {
        AppleII apple = new AppleII();
        OrangeII orange = new OrangeII();

        System.out.println("An apple has " + apple.getCalories() + " calories ");
        System.out.println("An orange has " + orange.getCalories() + " calories ");
    }
}
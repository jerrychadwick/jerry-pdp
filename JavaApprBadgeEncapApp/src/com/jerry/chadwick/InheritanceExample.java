package com.jerry.chadwick;

// Fruits example of INHERITANCE

// Fruits example of COMPOSITION

abstract class  FruitI {
    abstract int getNumSlices ();
    abstract int caloriesPerSlice ();

    public int getCalories() {
        return caloriesPerSlice() * getNumSlices();
    }

}


class  OrangeI extends FruitI {


    @Override
    public int getNumSlices() {
        return 7;
    }

    @Override
    public int caloriesPerSlice() {
        return 17;
    }

}

class  AppleI extends FruitI {


    @Override
    public int getNumSlices() {
        return 4;
    }

    @Override
    public int caloriesPerSlice() {
        return 14;
    }

}

public class InheritanceExample {

    public static void main(String[] args) {
        AppleI apple = new AppleI();
        OrangeI orange = new OrangeI();

        System.out.println("An apple has " + apple.getCalories() + " calories ");
        System.out.println("An orange has " + orange.getCalories() + " calories ");
    }
}


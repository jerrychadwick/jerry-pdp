package com.jerry.chadwick;

/**
 * Created by jchadwic on 9/12/14.
 *
 */

// Overload constructors example using constructor chaining.

class Animal {
    private String strName;
    private int iLegs;
    private boolean bHasTeeth;
    private String strBloodType;
    protected int location = 0;

    public Animal(String name)   {
        this.strName = name;
        System.out.println("I'm a " + name);
    }

    public Animal (String name, int legs) {
        this.strName = name;
        this.iLegs = legs;
        System.out.println("I'm a " + this.strName);
        System.out.println("I have " + this.iLegs + " legs.");
    }

    public Animal (int legs) {
        this.strName = "(unknown name)";
        this.iLegs = legs;
        System.out.println("I'm a " + this.strName);
        System.out.println("I have " + this.iLegs + " legs.");
    }

    public Animal (String name, int legs, boolean hasTeeth) {
        this.strName = name;
        this.iLegs = legs;
        this.bHasTeeth = hasTeeth;
        System.out.println("I'm a " + this.strName);
        System.out.println("I have " + legs + " legs.");
        System.out.println("I " + (this.bHasTeeth ? "DO " : "DO NOT ") + "have teeth." );
    }

    public Animal (String name, int legs, boolean hasTeeth, String bloodType) {
        this.strName = name;
        System.out.println("I'm a " + this.strName);
        this.iLegs = legs;
        System.out.println("I have " + this.iLegs + " legs.");
        this.bHasTeeth = hasTeeth;
        System.out.println("I " + (this.bHasTeeth ? "DO " : "DO NOT ") + "have teeth." );
        this.strBloodType = bloodType;
        System.out.println("I am " + this.strBloodType + " blooded." );
    }


    public int Walk (int iSteps) {
        location += iSteps;
        return location;
    }
}

class Bird extends Animal {

    public Bird(String name, int legs)   {
        super(name, legs);
    }

}

class Centipede extends Animal {
    public Centipede(int legs)   {
        super(legs);
    }

    public int Walk (int iSteps) {
        location += iSteps/100;
        return location/100;
    }

}

class Lion extends Animal {
    public Lion(String name, int legs, boolean hasTeeth)   {
        super(name, legs, hasTeeth);
    }
}
class Alligator extends Animal {
    public Alligator(String name, int legs, boolean hasTeeth, String bloodType)   {
        super(name, legs, hasTeeth, bloodType);
    }
}

public class OverloadConstructorsExample {

    public static void main(String[] args) {
        Bird bird = new Bird("Robin", 2);
        Lion lion = new Lion("African Lion", 4, true);
        Alligator alligator = new Alligator("Swamp Gator", 4, true, "cold");
        Centipede centipede = new Centipede(100);
        bird.Walk(1000);
        System.out.println("bird location = " + bird.location);
        centipede.Walk(1000);
        System.out.println("centipede location = " + centipede.location);
    }

}

package com.jerry.chadwick;

public class Main {

    public static class MyObject {
        int xCoord;
        int yCoord;

        public void MyObject() {
        }

    }
    public static void testMethod (int x, String inString, final MyObject myObj) {

        System.out.println("Inside testMethod()");
        System.out.println("x = " + x);
        System.out.println("inString = " + inString);
        System.out.println("myObj.xCoord = " + myObj.xCoord);
        System.out.println("myObj.yCoord = " + myObj.yCoord);
        System.out.println();

        x = 100;
        inString = "Changed by testMethod";
        myObj.xCoord = 100;
        myObj.yCoord = 200;

        System.out.println("Inside testMethod(), after changes");
        System.out.println("x = " + x);
        System.out.println("inString = " + inString);
        System.out.println("myObj.xCoord = " + myObj.xCoord);
        System.out.println("myObj.yCoord = " + myObj.yCoord);
        System.out.println();

        inString = new String("Created in new operation");  // create new instance of inString
        // myObj = new MyObject();  this line will not compile because you can't change myObj, only its state

    }

    public static void main(String[] args) {

        int myX = 0;
        String strInMain = "Original String";
        MyObject myObj1 = new MyObject();
        myObj1.xCoord = 1;
        myObj1.yCoord = 2;

        testMethod (myX, strInMain, myObj1);

        System.out.println("Inside main(), after calling testMethod()");
        System.out.println("myX = " + myX);
        System.out.println("strInMain = " + strInMain);
        System.out.println("myObj1.xCoord = " + myObj1.xCoord);
        System.out.println("myObj1.yCoord = " + myObj1.yCoord);


    }
}

package com.jwc;

import com.acme.ProtectedStringWriter;

public class Main {

    public static void main(String[] args) {

        // ----------------------------------------------------------------------------
	    // PRIVATE EXAMPLE...
        PrivateStringWriter myPrivateStringWriter = new PrivateStringWriter();

        // access private member using "setter"
        myPrivateStringWriter.setStrToWrite("This is a test");

        // access private member using "getter"
        System.out.println(myPrivateStringWriter.getStrToWrite());

        // the following line causes a compiler error:
        //System.out.println(myPrivateStringWriter.strToWrite);

        // PUBLIC EXAMPLE...
        PublicStringWriter myPublicStringWriter = new PublicStringWriter();

        // access public member directly
        myPublicStringWriter.strToWrite = "Mary had a little lamb.";
        System.out.println(myPublicStringWriter.strToWrite);

        // PROTECTED EXAMPLE...
        ProtectedStringWriter myProtectedStringWriter = new ProtectedStringWriter();

        // cannot access the setter directly...causes compiler error...
        //myProtectedStringWriter.setStrToWrite("Twas brillig and the slythy toves...");

        // access the getter() directly...
        System.out.println(myProtectedStringWriter.getStrToWrite());

        // ----------------------------------------------------------------------------
        // virtual method invocation example

        A myA = new B();
        System.out.println("Calling getClassName() in virtual method invocation example returns " + myA.getClassName());

        // ----------------------------------------------------------------------------
        // instanceof example using same classes
        B myB = new B();
        boolean bIsInstanceOf;
        String strInstanceOf;

        if (myB instanceof A) {
            bIsInstanceOf = true;
            strInstanceOf = "Yes";
        }
        else {
            bIsInstanceOf = false;
            strInstanceOf = "No";
        }

        System.out.println("Is class 'B' an instanceof class 'A'? " + strInstanceOf );

        // ----------------------------------------------------------------------------
        // CASTING example

        if (bIsInstanceOf) {
            A a = (A) myB;
            System.out.println("After casting myB as an A, a.getPrivateName() returns: " + a.getPrivateName());
        }

        if (myA instanceof B) {
            B myNewB = (B) myA;
            myNewB.setTime();
        }
    }

 }

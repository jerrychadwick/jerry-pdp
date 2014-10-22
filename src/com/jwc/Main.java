package com.jwc;

import com.acme.ProtectedStringWriter;

public class Main {

    public static void main(String[] args) {

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

    }

 }

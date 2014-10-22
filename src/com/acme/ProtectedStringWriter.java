package com.acme;

/**
 * Created by jchadwic on 10/22/14.
 *
 * Variables, methods and constructors which are declared protected in a superclass can be accessed only by the subclasses
 * in other package or any class within the package of the protected members' class.
 *
 * The protected access modifier cannot be applied to class and interfaces.
 *
 * Methods, fields can be declared protected, however methods and fields in a interface cannot be declared protected.
 *
 * Protected access gives the subclass a chance to use the helper method or variable, while preventing a
 * nonrelated class from trying to use it.
 *
 */
public class ProtectedStringWriter {
    private String strToWrite;

    public String getStrToWrite() {
        return strToWrite;
    }

    protected void setStrToWrite(String strToWrite) {
        this.strToWrite = strToWrite;
    }
}

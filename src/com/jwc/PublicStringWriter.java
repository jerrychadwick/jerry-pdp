package com.jwc;

/**
 * Created by jchadwic on 10/22/14.
 * A class, method, constructor, interface etc declared public can be accessed from any other class.
 * Therefore fields, methods, blocks declared inside a public class can be accessed from any class
 * belonging to the Java Universe.
 * However if the public class we are trying to access is in a different package,
 * then the public class still need to be imported.
 * Because of class inheritance, all public methods and variables of a class are inherited by its subclasses.
 */
public class PublicStringWriter {
    public String strToWrite;
}

package com.jwc;

/**
 * Created by jchadwic on 10/21/14.
 *
 * This class uses private access control
 * Private access modifier is the most restrictive access level.
 * Class and interfaces cannot be private.
 * Variables that are declared private can be accessed outside the class if public getter methods are present in the class.
 * Using the private modifier is the main way that an object encapsulates itself and hide data from the outside world.
 */

public class PrivateStringWriter {
    private String strToWrite;

    public String getStrToWrite() {
        return strToWrite;
    }

    public void setStrToWrite(String strToWrite) {
        this.strToWrite = strToWrite;
    }
}

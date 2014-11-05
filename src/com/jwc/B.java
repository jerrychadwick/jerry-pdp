package com.jwc;

/**
 * Created by jchadwic on 10/22/14.
 * Child class for virtual method invocation example
 */
public class B extends A {
    private String time;
    public String getClassName() {
        return "B";
    }
    public String getPrivateName() {
        return "B_Private_Name";
    }
    public void setTime() {time = "time waits for no man";}
}

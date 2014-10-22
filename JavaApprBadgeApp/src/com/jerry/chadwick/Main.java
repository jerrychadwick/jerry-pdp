package com.jerry.chadwick;


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {


    // Java Apprentice class task:
    // Write your own ENUM type...

    public enum Company {
        EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), APPLE(25);
        private int value;

        private Company(int value) {
            this.value = value;
        }
    }

    public static List<String> myList2;
    public static List<String> myBigStringList;
    public static long lMyCounter = 0;
//    public static final String A100CHARSTRING = "Lorem ipsum dolor si";
//    public static final String A100CHARSTRING = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida.";
    public static final String A100CHARSTRING = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida." +
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida." +
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida.";
    public static final int minMemForString = 8 * (int) ((((A100CHARSTRING.length()) * 2) + 45) / 8);


    // Java Apprentice class task:
    // Write code to show exception handling including examples of checked, unchecked, and Error exceptions...

    // BadCoException is a checked exception because it extends java.lang.Exception
    public static class BadCoException extends Exception {
        public BadCoException(String s) {
            super(s);
        }
    }

    // BadArgException is an un-checked exception because it extends java.lang.RuntimeException
    public static class BadArgException extends RuntimeException {
        public BadArgException(String s) {
            super(s);
        }
    }

    // method for checked exception...notice 'throws' statement
    private static void useEnumsChecked( Company coName ) throws BadCoException {
        if (isBadCompany(coName)) {
            throw new BadCoException("Bad company name: " + coName);
        }
        for (Company cName : Company.values()) {
            if (coName.toString() == cName.toString())
                System.out.println("This is our guy!");
            System.out.println("Company Value: " + cName.value + " - Company Name: " + cName);
        }
    }

    // method for checked exception...notice NO 'throws' statement
    private static void useEnumsUnchecked( String coName )  {
        if (isBadCompany(coName)) {
            throw new BadArgException("Bad company name: " + coName);
        }
        for (Company cName : Company.values()) {
            if (coName == cName.toString())
                System.out.println("This is our guy!");
            System.out.println("Company Value: " + cName.value + " - Company Name: " + cName);
        }
    }

    public static boolean isBadCompany (Company coName) {
        return isBadCompany(coName.toString());
    }

   public static boolean isBadCompany (String coName) {
        StringBuilder sbCompanies = new StringBuilder("EBAY, PAYPAL, GOOGLE, YAHOO, APPLE");
        if (sbCompanies.indexOf(coName)>=0 )
            return false;
        else
            return true;
    }

    public static void addStringsUntilNoMem() throws OutOfMemoryError
    {
        if (myBigStringList == null)
            myBigStringList = new ArrayList<String>();

        while (true) {
            myBigStringList.add(A100CHARSTRING);
            lMyCounter++;
            System.out.println("#chars approx = " + lMyCounter * minMemForString);
        }
    }

    private static void runGC () throws Exception
    {
        // It helps to call Runtime.gc()
        // using several method calls:
        for (int r = 0; r < 4; ++ r) _runGC ();
    }

    private static void _runGC () throws Exception
    {
        long usedMem1 = usedMemory (), usedMem2 = Long.MAX_VALUE;
        for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++ i)
        {
            s_runtime.runFinalization ();
            s_runtime.gc ();
            Thread.currentThread ().yield ();

            usedMem2 = usedMem1;
            usedMem1 = usedMemory ();
        }
    }

    private static long usedMemory ()
    {
        return s_runtime.totalMemory () - s_runtime.freeMemory ();
    }

    private static final Runtime s_runtime = Runtime.getRuntime ();

    public static int ReadTenThousand() {
        Charset charset = Charset.forName("US-ASCII");
        String file = "tenthousand.txt";
        try {
//            String  current = new java.io.File( "." ).getCanonicalPath();
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                myList2.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return myList2.size();
    }

    public static int WriteTenThousand() {
        Charset charset = Charset.forName("US-ASCII");
        String file = "tenthousandsorted.txt";
        int iCount = 0;

        try {
//            String  current = new java.io.File( "." ).getCanonicalPath();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

//            String line = null;
            if (myList2.size()>0) {
                for (String line : myList2) {
                    writer.write(line);
                    writer.newLine();
                    iCount++;
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return iCount;
    }

    public long getAvailableMemory() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory(); // current heap allocated to the VM process
        long freeMemory = runtime.freeMemory(); // out of the current heap, how much is free
        long maxMemory = runtime.maxMemory(); // Max heap VM can use e.g. Xmx setting
        long usedMemory = totalMemory - freeMemory; // how much of the current heap the VM is using
        long availableMemory = maxMemory - usedMemory; // available memory i.e. Maximum heap size minus the current amount used
        return availableMemory;
    }


// Main()

    public static void main(String[] args) {

        // Java Apprentice class task:
        // Write your own ENUM type...

        // Java Apprentice class task:
        // checked exception requires a TRY-CATCH block...
        try {
            useEnumsChecked(Company.YAHOO);
        } catch (BadCoException e) {
            System.out.println("Got a BADCOEXCEPTION in main...");
        }

        // unchecked exception doesn't require a TRY-CATCH block...
        // uncomment next line to see exception thrown...
        // useEnumsUnchecked("NOVELL");
        useEnumsUnchecked("APPLE");


        // Java Apprentice class task:
        // Add strings to list until OOM...

        try {
            addStringsUntilNoMem();
        } catch (OutOfMemoryError e) {
            System.out.println("Got out of memory exception -- JWC");
        }
/*
        if (false) {
            // -------------------------------
            // Warm up all classes/methods we will use
            runGC();
            usedMemory();
            // Array to keep strong references to allocated objects
            final int count = 100000;
            Object[] objects = new Object[count];

            long heap1 = 0;
            // Allocate count+1 objects, discard the first one
            for (int i = -1; i < count; ++i) {
                Object object = null;

                // Instantiate your data here and assign it to object

                //object = new Object ();
                //object = new Integer (i);
                //object = new Long (i);
                object = new String("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida.");
                //object = new byte [128][1]

                if (i >= 0)
                    objects[i] = object;
                else {
                    object = null; // Discard the warm up object
                    runGC();
                    heap1 = usedMemory(); // Take a before heap snapshot
                }
            }
            runGC();
            long heap2 = usedMemory(); // Take an after heap snapshot:

            final int size = Math.round(((float) (heap2 - heap1)) / count);
            System.out.println("'before' heap: " + heap1 +
                    ", 'after' heap: " + heap2);
            System.out.println("heap delta: " + (heap2 - heap1) +
                    ", {" + objects[0].getClass() + "} size = " + size + " bytes");
            for (int i = 0; i < count; ++i) objects[i] = null;
            objects = null;
        }

        // Java Apprentice class task: -----------------------------------------
        if (false) {
            long lAvailableMemory = instance.getAvailableMemory();
            int minMemForString = 8 * (int) ((((iStringSize) * 2) + 45) / 8);
            long lNumStrings = lAvailableMemory / minMemForString;

            if (myList2 == null) {
                myList2 = new ArrayList<String>();
                try {
                    while (true) {
                        myList2.add("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi commodo, ipsum sed pharetra gravida.");
                    }
                } catch (OutOfMemoryError e) {
                    lNumStrings = myList2.size();

                }
                long lNewAvailableMemory = instance.getAvailableMemory();
                long lUsedMemory = lAvailableMemory - lNewAvailableMemory;
                long lTest = lUsedMemory;
            }
        }


*/

        // Java Apprentice class task:
        //   Read in 10,000 line file, sort it, then write sorted file back out.

        if(false) {
            int iLinesRead = ReadTenThousand();
            java.util.Collections.sort(myList2);
            int iLinesWritten = WriteTenThousand();
        }
        // ...done. ------------------------------------------------------------

    }


}

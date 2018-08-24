package com.virtualassistance.baseclass.utilities;


import org.apache.log4j.Logger;


public class Logs {

    private static final String TAG = "MR_Logs";
    private static Logger Log = Logger.getLogger(Logs.class.getName());

    //private static final Logger logger = LogManager.getLogger(Logs.class);
    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite


        public static int startTestCase(String tag, String msg) {
        System.out.println("StartTestCase: " + tag + ": " + msg);
        return 0;
        }

        public static int endTestCase(String tag, String msg) {
        System.out.println("EndTestCase: " + tag + ": " + msg);
        return 0;
        }


        public static int debug(String tag, String msg) {
            System.out.println("DEBUG: " + tag + ": " + msg);
            return 0;
        }
        public static int info(String tag, String msg) {
            System.out.println("INFO: " + tag + ": " + msg);
            return 0;
        }
        public static int warn(String tag, String msg) {
            System.out.println("WARN: " + tag + ": " + msg);
            return 0;
        }
        public static int error (String tag, String msg) {
            System.out.println("ERROR: " + tag + ": " + msg);
            return 0;
        }


}

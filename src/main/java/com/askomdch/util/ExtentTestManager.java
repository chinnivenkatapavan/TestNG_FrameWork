package com.askomdch.util;


import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentTestManager() {}

    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void unload() {
        extentTest.remove();
    }
}


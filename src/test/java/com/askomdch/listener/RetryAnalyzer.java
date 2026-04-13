package com.askomdch.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int mAX_RETRY_COUNT = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(retryCount<mAX_RETRY_COUNT){
            retryCount++;
            return true;
        }
        return false;
    }
}

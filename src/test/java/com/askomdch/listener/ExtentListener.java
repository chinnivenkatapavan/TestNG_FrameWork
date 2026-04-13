package com.askomdch.listener;


import com.askomdch.baseTest.BaseTest;
import com.askomdch.util.ExtentManager;
import com.askomdch.util.ExtentTestManager;
import com.askomdch.util.ScreenShotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;


public class ExtentListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getReport();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentTestManager.getTest();
        test.fail(result.getThrowable());   // Assertion error logged

        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest baseTest) {

            String screenshotPath =
                    ScreenShotUtil.getScreenShot(
                            baseTest.getDriver(),
                            result.getMethod().getMethodName()
                    );

            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(
                        screenshotPath,
                        "Screenshot on Assertion Failure"
                );
            }
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}


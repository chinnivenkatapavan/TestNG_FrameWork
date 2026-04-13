package com.askomdch.util;


import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;


public class StepLogger {

    public static void step(String stepDescription,
                            WebDriver driver,
                            Runnable action,
                            ExtentTest test) {

        try {
            test.info(stepDescription);
            action.run();   // execute step
            test.pass(stepDescription + " ✅");

        } catch (Exception e) {

            String screenshot =
                    ScreenShotUtil.getScreenShot(driver, "STEP_FAILED");

            test.fail(stepDescription + " ❌")
                    .fail(e)
                    .addScreenCaptureFromPath(screenshot);

            throw e; // IMPORTANT: fail the test
        }
    }
}


package com.askomdch.listener;

import com.askomdch.base.BasePage;
import com.askomdch.baseTest.BaseTest;
import com.askomdch.util.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getDriver();
        String screenshotPath = ScreenShotUtil.getScreenShot(driver,result.getName());

        System.out.println("✅ Screenshot saved at:"+screenshotPath);
    }

}

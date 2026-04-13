package com.askomdch.tests;

import com.askomdch.baseTest.BaseTest;
import com.askomdch.pages.LoginPage;
import com.askomdch.testData.TestData;
import com.askomdch.util.ExtentTestManager;
import com.askomdch.util.StepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.askomdch.util.ScreenShotUtil.getScreenShot;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

//
//    public LoginTest(){
//        loginPage = new LoginPage(driver);
//    }

    @BeforeMethod
    public void setUpPage(){
        loginPage = new LoginPage(getDriver());
    }

    //@Test
    public void verifyLoginPage() throws InterruptedException {
        loginPage.oPenAccountTab();
        ExtentTestManager.getTest().info("Navigate into Account Page");
        Assert.assertEquals(loginPage.getHeaderText(),"Account");
        Assert.assertEquals(loginPage.getTitlepage(),"Account – AskOmDch");
        ExtentTestManager.getTest().info("Successfully verify all points");
        Thread.sleep(5000);
    }

    @Test
    public void verifyLoginPagewithAutoLogAndScreenShot(){
        StepLogger.step("Open Account Page",getDriver(),()->loginPage.oPenAccountTab(),ExtentTestManager.getTest());
        StepLogger.step("Verify HeaderText",getDriver(),()->Assert.assertEquals(loginPage.getHeaderText(),"Account"),ExtentTestManager.getTest());
        StepLogger.step("Verify Title of Page",getDriver(),()->Assert.assertEquals(loginPage.getTitlepage(),"Account – AskOmDch"),ExtentTestManager.getTest());
    }


    @Test(dataProvider = "loginCredentials", dataProviderClass = TestData.class)
    public void verfiyLoginCredentials(String userName, String passWord, String errorMessage) throws InterruptedException{
        loginPage.oPenAccountTab();
        ExtentTestManager.getTest().info("Navigate into Account Page");
        Assert.assertEquals(loginPage.getHeaderText(),"Account");
        Assert.assertEquals(loginPage.getTitlepage(),"Account – AskOmDch");
        loginPage.enterUserName(userName);
        loginPage.enterPassWord(passWord);
        loginPage.clickOnLoginButton();
        if (!errorMessage.isEmpty()){
            Assert.assertEquals(loginPage.getErrorMessage(),errorMessage);
        }
        else {
            Assert.assertEquals(loginPage.verifyUserNameInWelcomePage(),"beginner_Framework");
        }
        ExtentTestManager.getTest().info("Verify all credentials");
        //getScreenShot(driver,loginPage.getTitlepage());
        Thread.sleep(2000);
    }
}

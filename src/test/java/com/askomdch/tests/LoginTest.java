package com.askomdch.tests;

import com.askomdch.baseTest.BaseTest;
import com.askomdch.pages.LoginPage;
import com.askomdch.testData.TestData;
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

    @Test
    public void verifyLoginPage() throws InterruptedException {
        loginPage.oPenAccountTab();
        Assert.assertEquals(loginPage.getHeaderText(),"Account");
        Assert.assertEquals(loginPage.getTitlepage(),"Account – AskOmDc");
        Thread.sleep(5000);
    }


    @Test(dataProvider = "loginCredentials", dataProviderClass = TestData.class)
    public void verfiyLoginCredentials(String userName, String passWord, String errorMessage) throws InterruptedException{
        loginPage.oPenAccountTab();
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
        //getScreenShot(driver,loginPage.getTitlepage());
        Thread.sleep(2000);
    }
}

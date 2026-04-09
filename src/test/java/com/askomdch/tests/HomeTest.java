package com.askomdch.tests;

import com.askomdch.baseTest.BaseTest;
import com.askomdch.pages.HomePage;
import com.askomdch.pages.LoginPage;
import com.askomdch.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void verifyHomePage(){
        homePage.openHomePage();
        Assert.assertEquals(homePage.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        Assert.assertEquals(homePage.getTextTitle(),"AskOmDch");
        Assert.assertEquals(homePage.getTextCenter(),"Raining Offers for Hot Summer!");
    }

    @Test(dataProvider = "loginCredential" , dataProviderClass = TestData.class)
    public void verifyHomePageWithlogin(String userName , String passWord) throws InterruptedException{
        loginPage.oPenAccountTab();
        loginPage.enterUserName(userName);
        loginPage.enterPassWord(passWord);
        homePage.openHomePage();
        Thread.sleep(5000);
        Assert.assertEquals(homePage.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        Assert.assertEquals(homePage.getTextTitle(),"AskOmDch");
        Assert.assertEquals(homePage.getTextCenter(),"Raining Offers for Hot Summer!");
    }

}

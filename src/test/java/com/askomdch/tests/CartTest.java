package com.askomdch.tests;

import com.askomdch.baseTest.BaseTest;
import com.askomdch.pages.CartPage;
import com.askomdch.pages.HomePage;
import com.askomdch.pages.LoginPage;
import com.askomdch.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private CartPage cartPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        cartPage = new CartPage(getDriver());
    }

    @Test(dataProvider = "loginCredential", dataProviderClass = TestData.class)
    public void verifyCart(String userName, String passWord) throws InterruptedException{
        loginPage.oPenAccountTab();
        loginPage.enterUserName(userName);
        loginPage.enterPassWord(passWord);
        loginPage.clickOnLoginButton();
        cartPage.navigateToCart();
        Assert.assertEquals(cartPage.getSizeOfList(),7);
        cartPage.clickOnItem();
        String storeProductName = cartPage.getItemName();
        String storeProductPrice = cartPage.getItemPrice();
        cartPage.clickOnAddToCart();
        cartPage.clickOnCart();
        String verifyProductName = cartPage.verifyProductNameInCart();
        String verifyProductPrice = cartPage.verifyProductPriceInCart();
        Assert.assertEquals(storeProductName,verifyProductName);
        Assert.assertEquals(storeProductPrice,verifyProductPrice);
    }






}

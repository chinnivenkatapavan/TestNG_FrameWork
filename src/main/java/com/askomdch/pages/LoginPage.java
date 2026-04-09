package com.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final CommonActions commonActions;
    //private WebDriver driver;
    private final By headerText = By.xpath("//h1");
    private final By errorMessage = By.xpath("//ul[@role=\"alert\"]");
    private final By userName = By.xpath("(//strong)[1]");
    private final By loginButton = By.xpath("//button[text()=\"Log in\"]");


    public LoginPage(WebDriver driver){
        //this.driver = driver;
        commonActions = new CommonActions(driver);
    }


    public void oPenAccountTab(){
        commonActions.navigateTab("Account");
    }

    public String getHeaderText(){
        return commonActions.getText(headerText);
    }


    public String getTitlepage(){
        return commonActions.getTitlePage();
    }

    public void enterUserName(String userID){
        commonActions.send_Data_Into_Element("username",userID);
    }

    public void enterPassWord(String passWord){
        commonActions.send_Data_Into_Element("password",passWord);
    }

    public void clickOnLoginButton(){
        commonActions.clickOnButton(loginButton);
    }

    public String getErrorMessage(){
        return commonActions.getText(errorMessage);
    }

    public String verifyUserNameInWelcomePage(){
        return commonActions.getText(userName);
    }

}

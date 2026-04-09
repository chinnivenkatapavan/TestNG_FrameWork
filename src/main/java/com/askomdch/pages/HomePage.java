package com.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private CommonActions commonActions;
    private final By getTitleText = By.xpath("(//h1)[1]");
    private final By getCenterText = By.xpath("(//h1)[2]");

    public HomePage(WebDriver driver){
        commonActions = new CommonActions(driver);
    }

    public void openHomePage(){
        commonActions.navigateTab("Home");
    }

    public String getTextTitle(){
        return commonActions.getText(getTitleText);
    }

    public String getTextCenter(){
        return commonActions.getText(getCenterText);
    }

    public String getTitle(){
        return commonActions.getTitlePage();
    }



}

package com.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonActions {

    private WebDriver driver;



    public CommonActions(WebDriver driver){
        this.driver = driver;
    }


    //Common Navigate Page
    public void navigateTab(String tabName){
        driver.findElement(By.xpath("//a[@class=\"menu-link\" and text()='"+tabName+"']")).click();
    }

    //Verify HeaderText
    public String getText(By text){
        return driver.findElement(text).getText();
    }

    public String getTitlePage(){
        return driver.getTitle();
    }

    public void send_Data_Into_Element(String id, String textdata){
      if(!(driver.findElement(By.id(id)).getText().isEmpty())){
          driver.findElement(By.id(id)).clear();
      }
      driver.findElement(By.id(id)).sendKeys(textdata);
    }

    public void clickOnButton(By by){
        driver.findElement(by).click();
    }

    public List<WebElement> getListOfElements(By by){
        return driver.findElements(by);
    }




}

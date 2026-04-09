package com.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private CommonActions commonActions;
    private By listOfElements = By.xpath("//ul[contains(@class,\"products\")]//li");
    private By selectItemInList = By.xpath("(//ul[contains(@class,\"products\")]//li)[3]");
    private By getProductText = By.xpath("//h1");
    private By getProductPrice = By.xpath("//p[@class=\"price\"]//bdi");
    private By addToCartButton = By.name("add-to-cart");
    private By clickOnCartTab = By.xpath("(//a[@class=\"cart-container\"])[1]");
    private By prductNameInCart = By.xpath("//td[@class=\"product-name\"]//a");
    private By prductPriceInCart = By.xpath("//td[@class=\"product-price\"]//span//bdi");

    public CartPage(WebDriver driver){
        commonActions = new CommonActions(driver);
    }

    public void navigateToCart(){
        commonActions.navigateTab("Men");
    }

    public int getSizeOfList(){
        return commonActions.getListOfElements(listOfElements).size();
    }

    public void clickOnItem(){
       commonActions.clickOnButton(selectItemInList);
    }

    public String getItemName(){
        return commonActions.getText(getProductText);
    }

    public String getItemPrice(){
        return commonActions.getText(getProductPrice);
    }

    public void clickOnAddToCart(){
        commonActions.clickOnButton(addToCartButton);
    }

    public void clickOnCart(){
        commonActions.clickOnButton(clickOnCartTab);
    }

    public String verifyProductNameInCart(){
        return commonActions.getText(prductNameInCart);
    }

    public String verifyProductPriceInCart(){
        return commonActions.getText(prductPriceInCart);
    }

}

package com.askomdch.base;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePage {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private String browser;
    private String baseURL;

    //Passing browser and URL
    public void setDriver(String browser, String baseURL){
        this.browser = browser;
        this.baseURL = baseURL;
    }

    //Launching Browser
    public void launchBrowser(){
        WebDriver webDriver;
        switch(browser.toLowerCase()){
            case "chrome":
                webDriver = new ChromeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            default:
                throw new InvalidArgumentException("Unrecognized Driver");
        }
        driver.set(webDriver);
        getDriver().get(baseURL);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

    }

    //Killing driver
    public void driverKill(){
        if (getDriver()!=null){
            getDriver().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
}

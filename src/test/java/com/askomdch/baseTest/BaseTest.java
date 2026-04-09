package com.askomdch.baseTest;

import com.askomdch.base.BasePage;
import com.askomdch.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest extends BasePage {



    @BeforeClass
    public void initialBrowser(){
        System.out.println("Successfully InitialBrowser");
        setDriver("firefox","https://askomdch.com");
        launchBrowser();
    }
    @AfterClass
    public void closingBrowser(){
        System.out.println("Successfully Closed Browser");
        driverKill();
    }

}

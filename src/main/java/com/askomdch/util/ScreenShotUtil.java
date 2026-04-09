package com.askomdch.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {


    public static String getScreenShot(WebDriver driver, String screenshotName){

        try{
            //Taking screenShot
            File srcScreenShotFile = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);

            //Create a screenShot with timeStamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            //Creating path and rename screenshot
            String path = System.getProperty("user.dir")+"/screenshots/"+screenshotName+"_"+timestamp+".png";

            //Storing Screenshot into path
            FileUtils.copyFile(srcScreenShotFile,new File(path));
            return path;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}

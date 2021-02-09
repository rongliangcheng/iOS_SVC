package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class AboutPage {
    private AppiumDriver driver;


    public AboutPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public String getVersion(){
        Pause.stop(1);
        return driver.findElementByXPath("//*[contains(@name, '1.4.')]").getAttribute("value").substring(4);
    }

}

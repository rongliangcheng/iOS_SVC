package com.hexmeet.page;

import io.appium.java_client.AppiumDriver;

public class AccountPage {
    private AppiumDriver driver;

    public AccountPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public String get_display_name(String name){
        return driver.findElementByXPath("//*[contains(@name, '"+name+"')]").getAttribute("value");
    }
}

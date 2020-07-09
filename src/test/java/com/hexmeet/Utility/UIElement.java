package com.hexmeet.Utility;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static TestSpec.SystemTestSpec.LOGGER;

public class UIElement {

    public static boolean byElementIsExist(AppiumDriver appiumDriver, By by) {
        appiumDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            //LOGGER.info("Check element");
            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 1);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //LOGGER.info("Check complete");
            return true;
        } catch (Exception e) {
            //LOGGER.info("Element is not shown");
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }



}

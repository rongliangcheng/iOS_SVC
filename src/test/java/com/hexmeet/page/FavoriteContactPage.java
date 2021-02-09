package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class FavoriteContactPage {
    private AppiumDriver driver;

    private String favorite_contact_search_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeSearchField/XCUIElementTypeOther";
    private String ve210_xpath = "//XCUIElementTypeButton[@name=\"RongliangVE210\"]";
    private String contact_video_xpath = "//XCUIElementTypeStaticText[@name=\"视频\"]";

    public FavoriteContactPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void favorite_contact(String name){
        Pause.stop(1);
        driver.findElementByXPath("//*[contains(@name, '"+name+"')]").click();
        Pause.stop(1);
        driver.findElementByXPath(contact_video_xpath).click();
    }

    public void find_favorite_contact(String name){
        Pause.stop(1);
        driver.findElementByXPath(favorite_contact_search_xpath).click();
        Pause.stop(1);
        driver.findElementByXPath(favorite_contact_search_xpath).sendKeys(name);
        Pause.stop(1);
        driver.findElementByXPath(ve210_xpath).click();
        Pause.stop(1);
        driver.findElementByXPath(contact_video_xpath).click();
    }

}

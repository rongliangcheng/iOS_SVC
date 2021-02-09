package com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage;

import com.hexmeet.utility.Pause;
import com.hexmeet.utility.UIElement;
import com.hexmeet.page.PageObjectBase;
import com.hexmeet.page.startup.deploytype.privatedeploy.signin.SignInPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserPrivateMainPage implements PageObjectBase {
    AppiumDriver appiumDriver;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserPrivateMainPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
    }

    public WebElement findElementByXPath(String xpath){
        return appiumDriver.findElementByXPath(xpath);
    }

    @Override
    public WebElement findElementByAccessibilityId(String id) {
        return null;
    }

    public WebElement findElementByAccessibilityID(String accessibilityID){
        return appiumDriver.findElementByAccessibilityId(accessibilityID);
    }


    public void navigate(String serverAddr,String account,String password){
        SignInPage signInPage = new SignInPage(appiumDriver);
        signInPage.navigate();
        signInPage.submit(serverAddr,account,password);
        Pause.stop(0.5);

    }

    public void meeting(){
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeButton[@name=\"会议\"]").click();
    }

    public void joinAMeeting(){
        Pause.stop(0.5);
        findElementByAccessibilityID("加入会议").click();
    }

    public void contacts(){
        Pause.stop(0.5);
        findElementByAccessibilityID("通讯录").click();
    }

    public void aboutMe(){
        Pause.stop(0.5);
        findElementByAccessibilityID("我").click();
    }

}

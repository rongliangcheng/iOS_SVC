package com.hexmeet.page.startup.deploytype.privatedeploy.joinmeeting;

import com.hexmeet.utility.Pause;
import com.hexmeet.utility.UIElement;
import com.hexmeet.page.startup.deploytype.privatedeploy.PrivateDeployPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PrivateDirectJoinAMeetingPage {
    AppiumDriver appiumDriver;

    public PrivateDirectJoinAMeetingPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        PrivateDeployPage privateDeployPage = new PrivateDeployPage(appiumDriver);
        privateDeployPage.navigate();
        privateDeployPage.joinAMeeting();
    }

    public void muteUmuteCamera(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_camera").click();
    }

    public void muteUmuteMic(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_mic").click();
    }

    public void joinAMeeting(String serveraddr,String number,String username){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_server").sendKeys(serveraddr);
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_conf_id").sendKeys(number);
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_conf_name").sendKeys(username);
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_btn").click();


    }

    public boolean isOnGuestPage(){
        return UIElement.byElementIsExist(appiumDriver, By.id("com.hexmeet.hjt:id/login_title"));
    }
}

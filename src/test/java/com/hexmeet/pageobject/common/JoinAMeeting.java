package com.hexmeet.pageobject.common;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class JoinAMeeting {

    AppiumDriver appiumDriver;

    public JoinAMeeting(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void meetingNumber(String string){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/call_number").sendKeys(string);
    }

    public void muteCameraSwitch(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_camera_switch").click();
    }

    public void muteMicSwitch(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_mic_switch").click();
    }

    public void call(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/dial_btn").click();
    }
}

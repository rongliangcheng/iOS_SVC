package com.hexmeet.pageobject.startup.deploytype.privatedeploy;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class PrivateCloudPage {

    final private AppiumDriver appiumDriver;

    public PrivateCloudPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public  void joinMeetingRoom(){
        Pause.stop(1);

        //Choose join the meeting
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[1]").click();
    }

    public  void login(){
        Pause.stop(1);

        //Choose login
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[2]").click();
    }

    public  void setting(){
        Pause.stop(1);

        //Choose setting
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView").click();

    }
}

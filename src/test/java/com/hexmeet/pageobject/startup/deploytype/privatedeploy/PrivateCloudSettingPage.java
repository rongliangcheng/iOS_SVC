package com.hexmeet.pageobject.startup.deploytype.privatedeploy;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class PrivateCloudSettingPage {

    final private AppiumDriver appiumDriver;

    public PrivateCloudSettingPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){

    }

    public  void setting(){
        Pause.sleep(1);

        //Choose login
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[2]").click();
    }

    public  void about(){
        Pause.sleep(1);

        //Choose about
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]").click();
    }

}

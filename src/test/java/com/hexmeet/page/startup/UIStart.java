package com.hexmeet.page.startup;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class UIStart {
    final private AppiumDriver appiumDriver;

    public UIStart(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public  void startUp() {

        appiumDriver.findElementById("com.hexmeet.hjt:id/dialog_ok").click();

        Pause.stop(1);

        appiumDriver.findElementById("android:id/button1").click();
    }

}

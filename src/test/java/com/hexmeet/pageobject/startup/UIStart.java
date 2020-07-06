package com.hexmeet.pageobject.startup;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class UIStart {
    final private AppiumDriver appiumDriver;

    public UIStart(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public  void startUp() {
        appiumDriver.findElementById("com.hexmeet.hjt:id/dialog_ok").click();

        Pause.sleep(1);

        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();
    }

}

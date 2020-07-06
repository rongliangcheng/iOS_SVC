package com.hexmeet.pageobject;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class UICommon {


    public static void devicePermissionAllowance(final AppiumDriver appiumDriver) {
        Pause.sleep(1);
        //appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]\n").click();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();

        Pause.sleep(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();

        Pause.sleep(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();
    }

    //Used to check the wrong input password operation
    public boolean detectToast(final AppiumDriver appiumDriver){
        Pause.sleep(1);
        if(appiumDriver.findElementByXPath("/hierarchy/android.widget.Toast") != null)
            return true;

        return false;
    }

}

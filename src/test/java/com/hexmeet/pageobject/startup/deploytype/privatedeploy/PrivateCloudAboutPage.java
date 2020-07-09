package com.hexmeet.pageobject.startup.deploytype.privatedeploy;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class PrivateCloudAboutPage {

    final private AppiumDriver appiumDriver;

    public PrivateCloudAboutPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }


    public String getVersion(final AppiumDriver appiumDriver){
        Pause.stop(1);

        //Get verson info
        return appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]").getText();
    }

}

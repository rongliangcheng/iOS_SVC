package com.hexmeet.pageobject.startup.deploytype;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.startup.UIStart;
import io.appium.java_client.AppiumDriver;

public class DeploymentTypePage {

    final private AppiumDriver appiumDriver;

    public DeploymentTypePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        UIStart uiStart = new UIStart(appiumDriver);
        uiStart.startUp();
    }


    public void privateCloudDeployment() {
         Pause.sleep(1);

         //Choose private cloud deployment
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView[1]\n").click();
    }

    public void publicCloudUser(){
        Pause.sleep(1);

        //Choose public cloud deployment
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView[2]").click();
    }
}

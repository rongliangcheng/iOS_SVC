package com.hexmeet.pageobject.startup.deploytype.publicdeploy;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.startup.deploytype.DeploymentTypePage;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublicCloudPage {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    final AppiumDriver appiumDriver;

    public PublicCloudPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){

        DeploymentTypePage deploymentTypePage = new DeploymentTypePage(appiumDriver);
        deploymentTypePage.navigate();
        deploymentTypePage.publicCloudUser();
    }

    public void joinMeetingRoom(){
        Pause.sleep(1);

        //Choose join the meeting
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[1]").click();
    }

    public void login(){
        Pause.sleep(1);

        //Choose login
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[2]").click();
    }

    public void setting(final AppiumDriver appiumDriver){
        Pause.sleep(1);

        //Choose setting
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]").click();

    }
}

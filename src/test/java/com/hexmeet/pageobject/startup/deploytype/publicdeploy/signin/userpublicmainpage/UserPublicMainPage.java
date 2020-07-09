package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.PublicSignIn;
import io.appium.java_client.AppiumDriver;

public class UserPublicMainPage {

    final private AppiumDriver appiumDriver;

    public UserPublicMainPage(final AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(String account,String password){
        PublicSignIn publicSignIn = new PublicSignIn(appiumDriver);
        publicSignIn.navigate();
        publicSignIn.fillInAccount(account);
        publicSignIn.fillInPassword(password);
        publicSignIn.signIn();
    }

    public void meeting(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
                .click();
    }

    public void joinAConference(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
                .click();
    }

    public void contacts(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
                .click();
    }

    public void aboutMe(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[4]")
                .click();
    }
}
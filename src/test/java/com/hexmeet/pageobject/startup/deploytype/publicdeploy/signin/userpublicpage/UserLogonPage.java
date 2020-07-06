package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicpage;

import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.PublicSignIn;
import io.appium.java_client.AppiumDriver;

public class UserLogonPage {

    final private AppiumDriver appiumDriver;

    public UserLogonPage(final AppiumDriver appiumDriver){
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
        appiumDriver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
                .click();
    }

    public void joinAConference(){
        appiumDriver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
                .click();
    }

    public void contacts(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
                .click();
    }

    public void self(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[4]")
                .click();
    }
}
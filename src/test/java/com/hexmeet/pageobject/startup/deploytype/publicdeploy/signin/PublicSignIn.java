package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.UICommon;
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.PublicCloudPage;
import io.appium.java_client.AppiumDriver;

public class PublicSignIn {

    final private AppiumDriver appiumDriver;

    public PublicSignIn(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        PublicCloudPage publicCloudPage = new PublicCloudPage(appiumDriver);
        publicCloudPage.navigate();
        publicCloudPage.login();
    }

    public void fillInAccount(String account){
        Pause.stop(1);

        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[1]").clear();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[1]").sendKeys(account);

    }

    public void fillInPassword(String password){
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[2]").clear();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText[2]").sendKeys(password);
    }

    public void signIn(){
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button").click();

        Pause.stop(3);
        UICommon.devicePermissionAllowance(appiumDriver);
    }

    public void signInWithWrongUsernamePassword(){
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button").click();
    }

}

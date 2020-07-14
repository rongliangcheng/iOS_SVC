package com.hexmeet.pageobject.common;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

public class FindAContactInFavoritelist {
    AppiumDriver appiumDriver;

    public FindAContactInFavoritelist(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void searchContact(String string){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.EditText").sendKeys(string+"\n");
    }
}

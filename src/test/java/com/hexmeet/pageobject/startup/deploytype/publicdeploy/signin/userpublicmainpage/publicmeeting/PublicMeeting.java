package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.publicmeeting;

import com.hexmeet.Utility.Pause;
import com.hexmeet.Utility.UIElement;
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.PublicSignIn;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PublicMeeting {
    private AppiumDriver appiumDriver;

    public PublicMeeting(final AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(String account,String password){
        PublicSignIn publicSignIn = new PublicSignIn(appiumDriver);
        publicSignIn.navigate();
        publicSignIn.fillInAccount(account);
        publicSignIn.fillInPassword(password);
        publicSignIn.signIn();
    }

    public void publicMyMeetingRoom(){

        Pause.stop(0.5);

        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.ListView/android.view.View").click();
    }

    public void publicReservedMeeting(){
        Pause.stop(0.5);
        String xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ListView/android.view.View";
        if(UIElement.byElementIsExist(appiumDriver, By.xpath(xpath))) {
            appiumDriver.findElementByXPath(xpath).click();
        }else {
            appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]").click();
        }

    }
}

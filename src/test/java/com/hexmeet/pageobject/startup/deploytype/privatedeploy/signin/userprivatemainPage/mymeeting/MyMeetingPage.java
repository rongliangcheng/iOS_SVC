package com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting;

import com.hexmeet.Utility.Pause;
import com.hexmeet.Utility.UIElement;
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.UserPrivateMainPage;
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.publicmeeting.PublicMeeting;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyMeetingPage {

    AppiumDriver appiumDriver;

    public MyMeetingPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(String serveraddr,String accout,String password){
        UserPrivateMainPage userPrivateMainPage = new UserPrivateMainPage(appiumDriver);
        userPrivateMainPage.navigate(serveraddr,accout,password);
        userPrivateMainPage.meeting();
    }

    public void mymeetingpage(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.view.View[@content-desc=\"我的会议室\"]").click();
    }

    public void joinTheMeeting(String password){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.view.View[@content-desc=\"加入会议\"]\n").click();
        Pause.stop(4);
        if(UIElement.byElementIsExist(appiumDriver, By.id("com.hexmeet.hjt:id/input_password"))) {
            appiumDriver.findElementById("com.hexmeet.hjt:id/input_password").sendKeys("1111");
            appiumDriver.findElementById("com.hexmeet.hjt:id/positiveButton").click();
            Pause.stop(1.5);
            appiumDriver.findElementById("com.hexmeet.hjt:id/input_password").sendKeys(password);
            appiumDriver.findElementById("com.hexmeet.hjt:id/positiveButton").click();
        }
    }

    public void meetingSettings(String password, boolean muteWhenJoin,boolean allowAnonymousUser,boolean onlyHosterCanActivateMeeting,boolean allowOthersReserveMeeting,boolean groupSelectionBoolean){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.view.View[@content-desc=\"会议室设置\"]").click();

        Pause.stop(3);
        appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText").sendKeys(password);

        if(muteWhenJoin)
            appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View[2]").click();

        if(allowAnonymousUser)
            appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]").click();

        if(onlyHosterCanActivateMeeting)
            appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]").click();

        if(allowAnonymousUser)
            appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[4]/android.view.View[3]").click();

        if(groupSelectionBoolean)
            groupSelection();

        appiumDriver.findElementByXPath("//android.view.View[@content-desc=\"保存\"]").click();
    }

    private void groupSelection(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.widget.Button[@content-desc=\"选择群组\"]").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("(//android.view.View[@content-desc=\"zhangjs\"])[1]").click();

        Pause.stop(0.5);
        //remove the group selection
        appiumDriver.findElementByXPath("//android.view.View[@content-desc=\"×\"]").click();
    }

    public void muteUmuteCamera(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.CheckBox[1]").click();
    }

    public void muteUmuteAudio(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"会捷通\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.CheckBox[2]").click();
    }
}

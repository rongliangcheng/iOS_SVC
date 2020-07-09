package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.joinmeeting;

import io.appium.java_client.AppiumDriver;
import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.UserPublicMainPage;


public class PublicJoinMeeting {

    private AppiumDriver appiumDriver;

    public PublicJoinMeeting(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(String account,String password){

        UserPublicMainPage userPublicMainPage = new UserPublicMainPage(appiumDriver);
        userPublicMainPage.navigate("rongliang","rongliang");
        userPublicMainPage.joinAConference();
    }

    public void joinButton(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")
                .click();
    }

    public void cameraSwitch(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.Switch")
                .click();
    }

    public void micSwitch(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.Switch")
                .click();
    }

    public void dailNumber(int num){
        Pause.stop(1);
        if( num > 9 || num < 0){
            System.out.println("###"+num+"### wrong number is input");
        }

        if(num == 0)
            num = 11;

        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.Button["+num+"]")
                .click();
    }

    public void dailStar(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.Button[10]")
                .click();
    }

    public void backSpace(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
                .click();
    }

}

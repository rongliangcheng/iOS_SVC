package com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.joinmeeting.meetingoperations;

import com.hexmeet.Utility.Pause;
import io.appium.java_client.AppiumDriver;

/**
 * @author raleigh
 * @create 2020-06-22
 */
public class MeetingOperations {
    private AppiumDriver appiumDriver;

    public MeetingOperations(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void  touchScreen(){
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout").click();
    }



    public void switchCamera(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();

    }


    public void muteAudio(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();

    }

    public void muteCamera(){
        Pause.stop(1);

        String xpath = "\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();

    }

    public void conferenceManagement(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();
    }

    public void shareContent(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();
    }

    public void layoutModeSwitch(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[5]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();
    }

    public void moreItems(){
        Pause.stop(1);

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[6]";

        if( null == appiumDriver.findElementByXPath(xpath)){
            touchScreen();
        }

        appiumDriver.findElementByXPath(xpath).click();
    }

}

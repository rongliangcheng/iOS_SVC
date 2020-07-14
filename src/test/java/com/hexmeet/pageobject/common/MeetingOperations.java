package com.hexmeet.pageobject.common;

import com.hexmeet.Utility.Pause;
import com.hexmeet.Utility.UIElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MeetingOperations {

    private AppiumDriver appiumDriver;

    public MeetingOperations(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void hangupAndLeave(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.ImageView").click();
        Pause.stop(2);
        appiumDriver.findElementById("com.hexmeet.hjt:id/meeting_ok").click();
    }

    public void hangupAndTerminateCall(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.ImageView").click();
        Pause.stop(2);
        appiumDriver.findElementById("com.hexmeet.hjt:id/meeting_callend").click();
    }

    public void switchCamera(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView").click();
    }

    public void muteUmuteAudio(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView").click();
 }

    public void muteUmuteCamera(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ImageView").click();
    }

    public void meetingManagement(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.ImageView").click();
    }

    //ToDo
    //Add operatons in the meeting management

    public void shareContentAndCancel(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("android:id/button2").click();
    }

    public void shareContent(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("android:id/button1").click();
    }

    public void stopContent(){
        Pause.stop(0.5);
        Point point = new Point(100,160);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(point)).release().perform();
    }

    public void sendMessage(String string){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.ImageView").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText").sendKeys(string);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView").click();
    }

    public void switchLayout(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.ImageView").click();
    }

    public void showHideLocalPreview(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.ImageView").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/switch_localview").click();
    }

    public void switchToAudioOnly(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.ImageView").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/switch_vadio_mode").click();
    }

    public void switchBackToAVmode(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/audio_mode_btn").click();

    }

    public boolean isInMeetingPage(){
        Pause.stop(0.5);
        return UIElement.byElementIsExist(appiumDriver,xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.view.View[1]"));
    }


    private void touchScreenToShowButton(){
        String mainView="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.view.View[1]";
        if(!UIElement.byElementIsExist(appiumDriver,id("com.hexmeet.hjt:id/timer_chronometer"))){

            //LOGGER.info("Element not existing");
            appiumDriver.findElementByXPath(mainView).click();
        } else {
            //LOGGER.info("Element existing");
            appiumDriver.findElementByXPath(mainView).click();
            Pause.stop(1.5);
            appiumDriver.findElementByXPath(mainView).click();
        }
    }


}

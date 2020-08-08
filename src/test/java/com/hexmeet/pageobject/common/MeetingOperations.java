package com.hexmeet.pageobject.common;

import com.hexmeet.Utility.Pause;
import com.hexmeet.Utility.UIElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.springframework.cache.annotation.CachePut;

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
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_hangup").click();
        Pause.stop(2);
        appiumDriver.findElementById("com.hexmeet.hjt:id/meeting_callend").click();
    }

    public void hangupAndTerminateCall(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_hangup").click();
        Pause.stop(2);
        appiumDriver.findElementById("com.hexmeet.hjt:id/meeting_ok").click();
    }

    public void switchCamera(){
        tryAfterFailById("com.hexmeet.hjt:id/toolbar_switch_camera");
    }

    public void muteUmuteAudio(){
        tryAfterFailById("com.hexmeet.hjt:id/toolbar_local_mute");
    }

    public void muteUmuteCamera(){
        tryAfterFailById("com.hexmeet.hjt:id/toolbar_local_camera");
    }

    public void meetingManagement(){
        tryAfterFailById("com.hexmeet.hjt:id/toolbar_conference");
    }

    //ToDo
    //Add operatons in the meeting management

    public void shareContentAndCancel(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_layout_share").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("android:id/button2").click();
    }

    public void shareContent(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_layout_share").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("android:id/button1").click();
    }

    public void stopContent(){
        Pause.stop(0.5);
        Point point = new Point(100,160);
        Pause.stop(3);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(point)).release().perform();
        Pause.stop(3);
        touchAction.press(PointOption.point(point)).release().perform();
    }

    public void sendMessage(String string){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_layout_chat").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText").sendKeys(string);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button").click();

    }

    public void returnFromSendMessage(){
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView").click();
    }

    public void switchLayout(){
        tryAfterFailById("com.hexmeet.hjt:id/toolbar_layout_mode");
    }

    public void showHideLocalPreview(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_more").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/switch_localview").click();
    }

    public void switchToAudioOnly(){
        Pause.stop(0.5);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_more").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/switch_vadio_mode").click();
    }

    public void switchBackToAVmode(){
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/audio_mode_btn").click();
    }

    public void changeParticipantName(String participantName){
        Pause.stop(1);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_more").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/update_user_name").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/update_username").sendKeys(participantName);
        appiumDriver.findElementById("com.hexmeet.hjt:id/meeting_ok").click();
    }



    public String getDisplayName(){
        Pause.stop(1);
        return appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView").getText();
    }

    public void inviteParticipantInAMeeting(String username){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]").click();
        Pause.stop(2);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText").sendKeys(username);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText").click();
        appiumDriver.getKeyboard().sendKeys(Keys.RETURN);
        Pause.stop(2);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Image").click();
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public void muteAllInAMeeting(){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public void umuteAllInAMeeting(){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View[2]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public void lockTheMeeting(){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View[2]").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Button[1]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public void unlockTheMeeting(){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View[2]").click();
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Button[1]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public void postponeTheMeeting(){
        goIntoMeetingControl();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View[2]").click();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.Button[2]").click();
        Pause.stop(1);
        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.view.View[2]").click();
        Pause.stop(1);
        appiumDriver.findElementById("com.hexmeet.hjt:id/close_window").click();
    }

    public boolean isInMeetingPage(){
        Pause.stop(0.5);
        return UIElement.byElementIsExist(appiumDriver,xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.view.View[1]"));
    }

    public boolean hasTwoParticipants(){
        Pause.stop(0.5);
        return UIElement.byElementIsExist(appiumDriver,xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.ImageView"));
    }

    private void goIntoMeetingControl(){
        Pause.stop(1);
        touchScreenToShowButton();
        appiumDriver.findElementById("com.hexmeet.hjt:id/toolbar_conference").click();
    }


    private void touchScreenToShowButton(){
        String mainView="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.view.View[1]";
        if(!UIElement.byElementIsExist(appiumDriver,id("com.hexmeet.hjt:id/timer_chronometer"))){
            appiumDriver.findElementByXPath(mainView).click();
        } else {
            //LOGGER.info("Element existing");
            appiumDriver.findElementByXPath(mainView).click();
            Pause.stop(2);
            appiumDriver.findElementByXPath(mainView).click();
        }
    }

    private void tryAfterFailByXpath(String xpath){
        try{
            Pause.stop(2);
            touchScreenToShowButton();
            appiumDriver.findElementByXPath(xpath).click();
        } catch (Exception e){
            Pause.stop(2);
            touchScreenToShowButton();
            appiumDriver.findElementByXPath(xpath).click();
        }
    }

    private void tryAfterFailById(String Id){
        try{
            Pause.stop(2);
            touchScreenToShowButton();
            appiumDriver.findElementById(Id).click();
        } catch (Exception e){
            Pause.stop(2);
            touchScreenToShowButton();
            appiumDriver.findElementById(Id).click();
        }
    }

}

package com.hexmeet.page;

import com.hexmeet.sundae.mediaStatistics.CALLTYPE;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

import java.util.concurrent.TimeUnit;

public class ReservedMeetingInfoPage {
    private AppiumDriver driver;

    //bottom items xpath
    private String share_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[16]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]";
    private String cancel_share_xpath = "(//XCUIElementTypeStaticText[@name=\"取消\"])[1]";
    private String control_meeting_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[16]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
    private String terminate_meeting_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[16]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]";
    private String terminate_meeting_id = "结束";
    private String terminate_meeting_confirm_xpath = "//XCUIElementTypeStaticText[@name=\"确定\"]";
    private String join_reserved_meeting_xpath = "//XCUIElementTypeStaticText[@name=\"加入会议\"]";

    //call type combination
    private String video_call_xpath = "//XCUIElementTypeButton[@name=\"视频加入\"]";
    private String audio_call_xpath = "//XCUIElementTypeButton[@name=\"音频加入\"]";
    private String camera_switch_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[1]";
    private String mic_switch_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[2]";

    // Unstarted meeting
    private String delete_unstarted_meeting_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[16]/XCUIElementTypeOther[3]";
    private String delete_meeting_confirm_xpath = "//XCUIElementTypeStaticText[@name=\"确定\"]";

    public ReservedMeetingInfoPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void share_meeting_info(){
        Pause.stop(1);
        driver.findElementByXPath(share_xpath).click();
        Pause.stop(1);
        driver.findElementByXPath(cancel_share_xpath).click();
    }

    public void terminate_reservered_ongoing_meeting(){
        Pause.stop(1);
        //driver.findElementByXPath(terminate_meeting_xpath).click();
        driver.findElementByAccessibilityId(terminate_meeting_id).click();
        Pause.stop(1);
        driver.findElementByXPath(terminate_meeting_confirm_xpath).click();
    }

    public void join_reserved_meeting(CALLTYPE callType, Boolean camera_mute, Boolean mic_mute){
        Pause.stop(1);
        driver.findElementByXPath(join_reserved_meeting_xpath).click();
        Pause.stop(1);

        if( camera_mute && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("0")){
            driver.findElementByXPath(camera_switch_xpath).click();
        }else if( !camera_mute && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("1")){
            driver.findElementByXPath(camera_switch_xpath).click();
        }

        if( mic_mute && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("0")){
            driver.findElementByXPath(mic_switch_xpath).click();
        }else if( !camera_mute && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("1")){
            driver.findElementByXPath(mic_switch_xpath).click();
        }

        if (callType == CALLTYPE.Video){
            driver.findElementByXPath(video_call_xpath).click();
        }else if( callType == CALLTYPE.Audio ){
            driver.findElementByXPath(audio_call_xpath).click();
        }
    }

    public void delete_unstarted_meeting(){
        Pause.stop(1);
        driver.findElementByXPath(delete_unstarted_meeting_xpath).click();
        Pause.stop(1);
        driver.findElementByXPath(delete_meeting_confirm_xpath).click();
    }

    public boolean isOnGoingMeeting(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try{
            driver.findElementByXPath(join_reserved_meeting_xpath);
        } catch (Exception e){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return true;
    }

    public boolean isUnstartedMeeting(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try{
            driver.findElementByXPath(delete_unstarted_meeting_xpath);
        } catch (Exception e){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return true;
    }

}

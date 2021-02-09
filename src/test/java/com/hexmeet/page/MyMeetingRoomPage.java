package com.hexmeet.page;

import com.hexmeet.sundae.mediaStatistics.CALLTYPE;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMeetingRoomPage {

    AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String join_meeting_button_xpath = "//XCUIElementTypeStaticText[@name=\"加入会议\"]";
    private String camera_switch_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[1]";
    private String mic_switch_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch[2]";
    private String video_call_xpath = "//XCUIElementTypeButton[@name=\"视频加入\"]";
    private String audio_call_xpath = "//XCUIElementTypeButton[@name=\"音频加入\"]";

    public MyMeetingRoomPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void click_join_my_meeting(){
        log.info("Enter join my meeting");
        Pause.stop(1);
        driver.findElementByXPath(join_meeting_button_xpath).click();
    }

    public void video_call(){
        driver.findElementByXPath(video_call_xpath).click();
    }

    public void audio_call(){
        driver.findElementByXPath(audio_call_xpath).click();
    }

    public void camera_mute(boolean bflag){
        log.info(driver.findElementByXPath(camera_switch_xpath).getAttribute("value"));
        if( bflag && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("0")){
            log.info("true");
            driver.findElementByXPath(camera_switch_xpath).click();
        }else if( !bflag && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("1")){
            log.info("false");
            driver.findElementByXPath(camera_switch_xpath).click();
        }
    }

    public void mic_mute(boolean bflag){
        log.info(driver.findElementByXPath(mic_switch_xpath).getAttribute("value"));
        if( bflag && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("0")){
            log.info("mic true");
            driver.findElementByXPath(mic_switch_xpath).click();
        }else if( !bflag && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("1")){
            log.info("mic false");
            driver.findElementByXPath(mic_switch_xpath).click();
        }
    }

//    public void join_my_meeting(CALLTYPE callType, Boolean camera_mute, Boolean mic_mute){
//        log.info("Enter join my meeting");
//        Pause.stop(1);
//        driver.findElementByXPath(join_meeting_button_xpath).click();
//        Pause.stop(1);
//
//        log.info(driver.findElementByXPath(camera_switch_xpath).getAttribute("value"));
//        if( camera_mute && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("0")){
//            log.info("true");
//            driver.findElementByXPath(camera_switch_xpath).click();
//        }else if( !camera_mute && driver.findElementByXPath(camera_switch_xpath).getAttribute("value").equals("1")){
//            log.info("false");
//            driver.findElementByXPath(camera_switch_xpath).click();
//        }
//
//        log.info(driver.findElementByXPath(mic_switch_xpath).getAttribute("value"));
//        if( mic_mute && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("0")){
//            log.info("mic true");
//            driver.findElementByXPath(mic_switch_xpath).click();
//        }else if( !mic_mute && driver.findElementByXPath(mic_switch_xpath).getAttribute("value").equals("1")){
//            log.info("mic false");
//            driver.findElementByXPath(mic_switch_xpath).click();
//        }
//
//        if (callType == CALLTYPE.Video){
//            log.info("Video");
//            driver.findElementByXPath(video_call_xpath).click();
//        }else if( callType == CALLTYPE.Audio ){
//            log.info("Audio");
//            driver.findElementByXPath(audio_call_xpath).click();
//        }
//    }


}

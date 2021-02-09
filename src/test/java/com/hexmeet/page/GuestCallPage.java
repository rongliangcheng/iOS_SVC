package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestCallPage {
    private AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String server_address_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]";
    private String conferenceNumber_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]";
    private String display_name_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]";

    private String video_call_xpath = "//XCUIElementTypeStaticText[@name=\"视频加入\"]";
    private String audio_call_xpath = "//XCUIElementTypeStaticText[@name=\"音频加入\"]";

    private String camera_mute_xpath = "//XCUIElementTypeButton[@name=\"关闭摄像头\"]";
    private String mic_mute_xpath = "//XCUIElementTypeButton[@name=\"关闭麦克风\"]";

    private String meeting_password_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";
    private String join_commit_xpath = "//XCUIElementTypeButton[@name=\"加入\"]";
    private String join_cancel_xpath = "//XCUIElementTypeButton[@name=\"取消\"]";

    private String keyboard_done_xpath = "//XCUIElementTypeButton[@name=\"完成\"]";

    public GuestCallPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    private void fill_in_item(String xpath, String fill_in_string){
        driver.findElementByXPath(xpath).click();
        driver.findElementByXPath(xpath).clear();
        driver.findElementByXPath(xpath).sendKeys(fill_in_string);
        driver.findElementByXPath(keyboard_done_xpath).click();
    }

    public void fill_in_server_address(String server_address){
        Pause.stop(2);
        fill_in_item(server_address_xpath,server_address);
    }

    public void fill_conference_number(String conferenceNumber){
        fill_in_item(conferenceNumber_xpath,conferenceNumber);
    }

    public void fill_in_display_name(String display_name){
        fill_in_item(display_name_xpath,display_name);
    }

    public void video_call(){
        driver.findElementByXPath(video_call_xpath).click();
    }

    public void audio_call(){
        driver.findElementByXPath(audio_call_xpath).click();
    }


    public void fill_in_meeting_password(String password, boolean submit){
        driver.findElementByXPath(meeting_password_xpath).sendKeys(password);
        if( submit) {
            driver.findElementByXPath(join_commit_xpath).click();
        } else {
            driver.findElementByXPath(join_cancel_xpath).click();
        }
    }

    public void camera_mute(boolean bflag){
        log.info(String.valueOf(bflag));
        if( bflag && driver.findElementByXPath(camera_mute_xpath).getAttribute("value") == null ){
            log.info("camera true");
            driver.findElementByXPath(camera_mute_xpath).click();
        }else if( !bflag && driver.findElementByXPath(camera_mute_xpath).getAttribute("value") != null ){
            log.info("camera false");
            driver.findElementByXPath(camera_mute_xpath).click();
        }
    }

    public void mic_mute(boolean bflag){
        log.info(String.valueOf(bflag));
        if( bflag && driver.findElementByXPath(mic_mute_xpath).getAttribute("value") == null){
            log.info("mic true");
            driver.findElementByXPath(mic_mute_xpath).click();
        }else if( !bflag && driver.findElementByXPath(mic_mute_xpath).getAttribute("value") != null ){
            log.info("mic false");
            driver.findElementByXPath(mic_mute_xpath).click();
        }
    }

}

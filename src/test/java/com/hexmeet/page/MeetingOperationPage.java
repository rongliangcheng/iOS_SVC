package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MeetingOperationPage {
    private AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String main_windows_id = "横幅";
    private String hangup_xpath = "//XCUIElementTypeButton[@name=\"icon hang up \"]";
    private String hangup_confirm_xpath = "//XCUIElementTypeButton[@name=\"确定\"]";
    private String hangup_cancel_xpath = "//XCUIElementTypeButton[@name=\"取消\"]";
    private String switch_xpath = "//XCUIElementTypeButton[@name=\"icon switch camera \"]";
    private String mediaStatistics_xpath = "//XCUIElementTypeButton[@name=\"image 5\"]";
    private String audio_mute_xpath = "//XCUIElementTypeStaticText[@name=\"静音\"]";
    private String video_mute_xpath = "//XCUIElementTypeStaticText[@name=\"停止视频\"]";
    private String meeting_control_xpath = "//XCUIElementTypeStaticText[@name=\"会议管理\"]";
    private String share_content_xpath = "//XCUIElementTypeStaticText[@name=\"共享\"]";
    private String chat_xpath = "//XCUIElementTypeStaticText[@name=\"聊天\"]";
    private String lecture_switch_xpath = "//XCUIElementTypeStaticText[@name=\"分屏切换\"]";
    private String more_xpath = "//XCUIElementTypeStaticText[@name=\"更多\"]";

    private String switch_to_video_xpath = "//XCUIElementTypeButton[@name=\"切到视频模式\"]";

    private String hangup_id = "icon hang up ";
    private String hangup_confirm_id = "确定";
    private String hangup_cancel_id = "取消";
    private String switch_camera_id = "icon switch camera ";
    private String mediaStatistics_id = "image 5";
    private String mediaStatistics_hide_id = "btn back";
    //private String audio_mute_id = "icon mute";
    private String audio_mute_id = "icon unmute";
    private String audio_umute_id = "icon mute ";
    private String video_mute_pic_id = "icon unmute camera";
    private String video_mute_id = "icon unmute camera";
    private String video_umute_id = "icon mute camera ";
    private String meeting_control_id = "会议管理";
    private String share_content_id = "icon share ";
    private String strart_content_id = "开始直播";
    private String stop_content_id = "停止直播";
    private String stop_share_content_id = "icon stopshare ";
    private String stop_share_content_confirm_id = "好";
    private String back_to_app_from_coantent_share = "//XCUIElementTypeStaticText[@name=\"会捷通\"]";
    private String chat_id = "icon chat";
    private String chat_input_text_reserve_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextView";
    private String chat_input_text_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextView";
    private String chat_emtion_id = "icon keyboard face nor";
    private String chat_send_id = "Send";
    private String chat_return = "//XCUIElementTypeNavigationBar[@name=\"消息\"]/XCUIElementTypeButton";
    private String lecture_switch_id = "icon lecture ";
    private String galerry_switch_id = "icon gallery ";
    private String more_id = "icon more ";
    //private String close_local_video_xpath = "//XCUIElementTypeButton[@name=\"关闭本地视频\"]";
    private String close_local_video_xpath = "//XCUIElementTypeStaticText[@name=\"关闭本地视频\"]";
    //private String turn_on_local_video_xpath = "//XCUIElementTypeButton[@name=\"开启本地视频\"]";
    private String turn_on_local_video_xpath = "//XCUIElementTypeStaticText[@name=\"开启本地视频\"]";
    private String apply_speak_token_xpath = "//XCUIElementTypeStaticText[@name=\"申请发言\"]";
    //private String switch_to_audio_only_xpath = "//XCUIElementTypeButton[@name=\"切到语音模式\"]";
    private String switch_to_audio_only_xpath = "//XCUIElementTypeStaticText[@name=\"切到语音模式\"]";
    // private String change_display_name_xpath = "//XCUIElementTypeButton[@name=\"更改名称\"]";
    private String change_display_name_xpath = "//XCUIElementTypeStaticText[@name=\"更改名称\"]";
    private String display_name_textfield_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
    private String dispaly_name_textfield2_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
    private String change_display_name_confirm_id = "确定";
    private String vote_xpath = "//XCUIElementTypeButton[@name=\"参与投票\"]";


    public MeetingOperationPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void touchScreen(){
        Pause.stop(5);
        PointOption pointOption =  PointOption.point(80,195);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(pointOption).perform().release();
    }


    public void showMediaStatistics(){
        touchScreen();
        driver.findElementByAccessibilityId(mediaStatistics_id).click();
    }

    public void hideMediaStatistics(){
        driver.findElementByAccessibilityId(mediaStatistics_hide_id).click();
    }

    public void mute_audio(){
        touchScreen();
        driver.findElementByAccessibilityId(audio_mute_id).click();
    }

    public void unmute_audio(){
        touchScreen();
        driver.findElementByAccessibilityId(audio_umute_id).click();
    }

    public void mute_camera(){
        touchScreen();
        driver.findElementByAccessibilityId(video_mute_id).click();
    }

    public void umute_camera(){
        touchScreen();
        driver.findElementByAccessibilityId(video_umute_id).click();
    }

    public void share_content() {
        touchScreen();
        try {
            driver.findElementByAccessibilityId(share_content_id).click();
        }catch (Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(share_content_id).click();
        }
        Pause.stop(1);
        driver.findElementByAccessibilityId(strart_content_id).click();
        Pause.stop(10);

    }

    public void stop_content(){
        driver.findElementByAccessibilityId(stop_content_id);
        Pause.stop(5);
        touchScreen();
//        touchScreen();
//        try {
//            driver.findElementByAccessibilityId(stop_share_content_id).click();
//        } catch (Exception e){
//            touchScreen();
//            driver.findElementByAccessibilityId(stop_share_content_id).click();
//        }
//        Pause.stop(3);
//
//        while (stop_content_confirm_prompt()) {
//            driver.findElementByAccessibilityId(stop_share_content_confirm_id).click();
//            Pause.stop(5);
//        }
    }

    public void chat(String string){
        touchScreen();
        try {
            driver.findElementByAccessibilityId(chat_id).click();
        } catch (Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(chat_id).click();
        }
        Pause.stop(1);
        driver.findElementByXPath(chat_input_text_xpath).sendKeys(string);
        Pause.stop(1);
        driver.findElementByAccessibilityId(chat_send_id).click();
        Pause.stop(1);
        driver.findElementByXPath(chat_return).click();
    }

    public void chat_reserve_meeting(String string){
        touchScreen();
        try {
            driver.findElementByAccessibilityId(chat_id).click();
        } catch (Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(chat_id).click();
        }
        Pause.stop(1);
        driver.findElementByXPath(chat_input_text_reserve_xpath).sendKeys(string);
        Pause.stop(1);
        driver.findElementByAccessibilityId(chat_send_id).click();
        Pause.stop(1);
        driver.findElementByXPath(chat_return).click();
    }


    public void switch_to_lecture_display_mode(){
        touchScreen();
        driver.findElementByAccessibilityId(lecture_switch_id).click();
    }

    public void switch_to_gallery_display_mode(){
        touchScreen();
        driver.findElementByAccessibilityId(galerry_switch_id).click();
    }

    public void close_local_video(){
        touchScreen();
        driver.findElementByAccessibilityId(more_id).click();
        Pause.stop(1);
        try {
            driver.findElementByXPath(close_local_video_xpath).click();
        } catch ( Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(more_id).click();
            Pause.stop(1);
            driver.findElementByXPath(close_local_video_xpath).click();
        }
        // driver.executeScript("mobile: startPerfRecord", args);
    }

    public void turn_on_local_video(){
        touchScreen();
        driver.findElementByAccessibilityId(more_id).click();
        Pause.stop(1);
        try {
            driver.findElementByXPath(turn_on_local_video_xpath).click();
        } catch (Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(more_id).click();
            Pause.stop(1);
            driver.findElementByXPath(turn_on_local_video_xpath).click();
        }
    }

    public void switch_to_audio_only(){
        touchScreen();
        driver.findElementByAccessibilityId(more_id).click();
        try {
            driver.findElementByXPath(switch_to_audio_only_xpath).click();
        } catch ( Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(more_id).click();
            driver.findElementByXPath(switch_to_audio_only_xpath).click();
        }
    }
    public void switch_to_video_from_audio(){
        driver.findElementByXPath(switch_to_video_xpath).click();
    }

    public void change_display_name(String name){
        touchScreen();
        driver.findElementByAccessibilityId(more_id).click();
        Pause.stop(1);
        try {
            driver.findElementByXPath(change_display_name_xpath).click();
        } catch (Exception e){
            touchScreen();
            driver.findElementByAccessibilityId(more_id).click();
            Pause.stop(1);
            driver.findElementByXPath(change_display_name_xpath).click();
        }
        Pause.stop(1);
        //driver.findElementByXPath(display_name_textfield_xpath).click();
        driver.findElementByXPath(display_name_textfield_xpath).clear();
        Pause.stop(2);
        driver.findElementByXPath(dispaly_name_textfield2_xpath).sendKeys(name);
        driver.findElementByAccessibilityId(change_display_name_confirm_id).click();
    }

    public boolean find_display_name(String name){
        try{
            driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\""+name+"\"])[1]");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void switch_camera(){
        touchScreen();
        driver.findElementByAccessibilityId(switch_camera_id).click();
    }

    public void hangup(){
        touchScreen();
        driver.findElementByAccessibilityId(hangup_id).click();
        Pause.stop(3);
        driver.findElementByAccessibilityId(hangup_confirm_id).click();
    }

    public boolean stop_content_confirm_prompt(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try{
            driver.findElementByAccessibilityId(stop_share_content_confirm_id);
        } catch (Exception e){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return true;
    }
}

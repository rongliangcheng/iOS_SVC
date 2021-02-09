package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMeetingRoomSettingPage {

    AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String password_input_field_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeTextField";
    private String mute_on_join_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[6]/XCUIElementTypeSwitch";
    private String anonymous_on_join_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[8]/XCUIElementTypeSwitch";
    private String only_admin_activate_meeting_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[10]/XCUIElementTypeSwitch";
    private String allow_others_reserve_this_meeting_room_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[12]/XCUIElementTypeSwitch";
    private String allow_others_reserve_this_meeting_room_with_selectgroup_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[13]/XCUIElementTypeSwitch";
    private String select_group_xpath = "//XCUIElementTypeButton[@name=\"选择群组\"]";
    private String select_group_input_field_xpath = "//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeSearchField/XCUIElementTypeOthe";
    private String unselect_group_xpath = "//XCUIElementTypeStaticText[@name=\"×\"]";
    private String group_xpath = "//XCUIElementTypeButton[@name=\"例会群组 huatuo\"]";
    private String save_setting_xpath = "//XCUIElementTypeStaticText[@name=\"保存\"]";
    private String keyboard_done_xpath = "//XCUIElementTypeButton[@name=\"完成\"]";

    public MyMeetingRoomSettingPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void input_password(String password){
        driver.findElementByXPath(password_input_field_xpath).click();
        driver.findElementByXPath(password_input_field_xpath).clear();
        driver.findElementByXPath(password_input_field_xpath).sendKeys(password);
        driver.findElementByXPath(keyboard_done_xpath).click();
    }

    private void switch_on_call(String xpath, boolean bflag){
        //log.info(xpath);
        //log.info(driver.findElementByXPath(xpath).getAttribute("value"));
//        if( bflag && driver.findElementByXPath(xpath).getAttribute("value").equals("0") ){
//            log.info("true");
//            driver.findElementByXPath(xpath).click();
//        } else if (!bflag && driver.findElementByXPath(xpath).getAttribute("value").equals("1")){
//            log.info("false");
//            driver.findElementByXPath(xpath).click();
//        }

        driver.findElementByXPath(xpath).click();
        Pause.stop(3);
    }

    public void mute_on_join(boolean bflag){
        switch_on_call(mute_on_join_xpath,bflag);
    }

    public void anonymous_on_call(boolean bflag){
        switch_on_call(anonymous_on_join_xpath,bflag);
    }

    public void only_admin_can_activate_meeting(boolean bflag){
        switch_on_call(only_admin_activate_meeting_xpath,bflag);
    }

    public void allow_others_reserve_this_meeting_room(boolean bflag){
        switch_on_call(allow_others_reserve_this_meeting_room_xpath,bflag);
    }

    public void allow_others_reserve_this_meeting_room_with_selectgroup(boolean bflag){
        switch_on_call(allow_others_reserve_this_meeting_room_with_selectgroup_xpath,bflag);
    }


    public void select_group(boolean bflag){
        if( bflag) {
            driver.findElementByXPath(select_group_xpath).click();
            Pause.stop(1);
            //driver.findElementByXPath()
            driver.findElementByXPath(group_xpath).click();
        } else {
            driver.findElementByXPath(unselect_group_xpath).click();
        }

    }

    public void save_setting(){
        driver.findElementByXPath(save_setting_xpath).click();
    }
}

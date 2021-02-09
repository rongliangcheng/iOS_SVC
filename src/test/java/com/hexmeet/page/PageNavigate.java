package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;


public class PageNavigate {
    AppiumDriver driver;

    private String my_meetingroom_xpath = "//XCUIElementTypeStaticText[@name=\"我的会议室\"]";
    private String reserver_meeting_xpath = "//XCUIElementTypeStaticText[@name=\"预约会议\"]";

    //bottom items xpath
    private String meeting_xpath = "//XCUIElementTypeButton[@name=\"会议\"]";
    private String join_meeting_xpath = "//XCUIElementTypeButton[@name=\"加入会议\"]";
    private String contact_xpath = "//XCUIElementTypeButton[@name=\"通讯录\"]";
    private String account_xpath = "//XCUIElementTypeButton[@name=\"我\"]";

    //Account page
    //private String change_image_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]";
    //private String change_displayname_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";
    private String account_info_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton";
    private String return_to_account_xpath = "//XCUIElementTypeNavigationBar[@name=\"个人信息\"]/XCUIElementTypeButton";
    private String account_exit_xpath = "//XCUIElementTypeStaticText[@name=\"退出登录\"]";
    private String confirm_exit_xpath = "//XCUIElementTypeButton[@name=\"确定\"]";
    private String setting_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]";
    private String about_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]";

    // login page
    private String private_deploy_xpath = "//XCUIElementTypeImage[@name=\"icon_company\"]";
    private String private_deploy_login_xpath = "//XCUIElementTypeStaticText[@name=\"登录\"]";
    private String private_deploy_login_advanced_setting_xpath = "//XCUIElementTypeStaticText[@name=\"高级设置\"]";

    private String btn_back_id = "btn back";

    //guest call page
    private String guest_call_xpath = "//XCUIElementTypeButton[@name=\"加入会议\"]";

    // organization contact page
    private String organization_xpath = "//XCUIElementTypeButton[@name=\"组织结构\"]";

    // my meeting room page
    private String my_meeting_room_setting_xpath = "//XCUIElementTypeStaticText[@name=\"会议室设置\"]";

    public PageNavigate(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    // meeting page
    public void navigate_to_my_meetingroom(){
        Pause.stop(1);
        driver.findElementByXPath(my_meetingroom_xpath).click();
    }

    public void return_fronm_my_meeting_room(){

    }

    public void navigate_to_my_meeting_setting(){
        Pause.stop(1);
        driver.findElementByXPath(my_meeting_room_setting_xpath).click();
    }

    // bottom item on first page
    public void navigate_to_meeting(){
        Pause.stop(1);
        driver.findElementByXPath(meeting_xpath).click();
    }

    public void navigate_to_join_meeting(){
        Pause.stop(1);
        driver.findElementByXPath(join_meeting_xpath).click();
    }

    public void navigate_to_contact(){
        Pause.stop(1);
        driver.findElementByXPath(contact_xpath).click();
    }

    public void navigate_to_organization(){
        Pause.stop(1);
        driver.findElementByXPath(organization_xpath).click();
    }

    public void navigate_to_account(){
        Pause.stop(1);
        driver.findElementByXPath(account_xpath).click();
    }

    //account page

    public void navigate_to_account_info(){
        Pause.stop(1);
        driver.findElementByXPath(account_info_xpath).click();
    }

    public void return_from_account_info(){
        Pause.stop(1);
        driver.findElementByXPath(return_to_account_xpath).click();
    }


    public void navigate_to_exit(){
        Pause.stop(1);
        driver.findElementByXPath(account_exit_xpath).click();
        driver.findElementByXPath(confirm_exit_xpath).click();
    }

    public void navigate_to_setting(){
        Pause.stop(1);
        driver.findElementByXPath(setting_xpath).click();
    }

    public void navigate_to_about(){
        Pause.stop(1);
        driver.findElementByXPath(about_xpath).click();
    }

    //login
    public void navigate_to_private_deploy(){
        Pause.stop(1);
        driver.findElementByXPath(private_deploy_xpath).click();
    }

    public void navigate_to_private_deploy_login(){
        Pause.stop(1);
        driver.findElementByXPath(private_deploy_login_xpath).click();
    }

    public void navigate_private_deploy_from_private_deploy_login(){
        driver.findElementByAccessibilityId(btn_back_id).click();
    }

    public void navigate_to_private_deploy_login_advanced_setting(){
        Pause.stop(1);
        driver.findElementByXPath(private_deploy_login_advanced_setting_xpath).click();
    }

    //guest call
    public void navigate_to_guest_call(){
        driver.findElementByXPath(guest_call_xpath).click();
    }

}

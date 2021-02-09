package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import java.util.Calendar;


public class AccountInfoPage {
    AppiumDriver appiumDriver;
    private String image_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]";
    private String display_name_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";
    // picture
    private String select_from_photo_album_xpath = "//XCUIElementTypeButton[@name=\"从相册选择\"]";
    private String all_photos_xpath = "//XCUIElementTypeCell[@name=\"所有照片\"]";
    private String pic1_xpath = "//XCUIElementTypeImage[@name=\"照片, 1月18日, 下午2:16\"]";
    private String pic2_xpath = "//XCUIElementTypeImage[@name=\"照片, 1月18日, 下午2:17\"]";
    private String pic_select_confirm_xpath = "//XCUIElementTypeStaticText[@name=\"完成\"]";
    //displayname
    private String display_name_text_xpath = "//XCUIElementTypeAlert[@name=\"改名\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther";
    private String display_name_submit_xpath = "//XCUIElementTypeButton[@name=\"确定\"]";
    private String display_name_cancel_xpath = "//XCUIElementTypeButton[@name=\"取消\"]";
    private String select_all_chars_xpath = "//XCUIElementTypeMenuItem[@name=\"全选\"]";
    private String cut_chars_xpath = "//XCUIElementTypeMenuItem[@name=\"剪切\"]";


    public AccountInfoPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void change_image(){
        Pause.stop(1);
        appiumDriver.findElementByXPath(image_xpath).click();
        appiumDriver.findElementByXPath(select_from_photo_album_xpath).click();
        // appiumDriver.findElementByXPath(all_photos_xpath).click();
        Calendar cas = Calendar.getInstance();
        int day=cas.get(Calendar.DATE);//获取日
        if( day % 2 == 0 ){
            appiumDriver.findElementByXPath(pic1_xpath).click();
        }else{
            appiumDriver.findElementByXPath(pic2_xpath).click();
        }

        appiumDriver.findElementByXPath(pic_select_confirm_xpath).click();
    }

    public void change_display_name(String displayName){
        Pause.stop(1);
        appiumDriver.findElementByXPath(display_name_xpath).click();
//        TouchActions action = new TouchActions(appiumDriver);
//        action.doubleTap(appiumDriver.findElementByXPath(display_name_text_xpath));
//        action.perform();
        appiumDriver.findElementByXPath(display_name_text_xpath).click();
        appiumDriver.findElementByXPath(select_all_chars_xpath).click();
        appiumDriver.findElementByXPath(cut_chars_xpath).click();
        appiumDriver.findElementByXPath(display_name_text_xpath).sendKeys(displayName);

    }

    public void change_special_display_name(String displayName){
        Pause.stop(1);
        appiumDriver.findElementByXPath(display_name_xpath).click();
        appiumDriver.findElementByXPath(display_name_text_xpath).sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        appiumDriver.findElementByXPath(display_name_text_xpath).sendKeys(displayName);

    }

    public void cancel_change_display_name(){
        appiumDriver.findElementByXPath(display_name_cancel_xpath).click();
    }

    public void submit_change_dispaly_name(){
        appiumDriver.findElementByXPath(display_name_submit_xpath).click();
    }
}

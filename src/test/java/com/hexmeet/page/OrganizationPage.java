package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
// TODO:
// 目前Appium还没有找到支持页面操作的方法
// 而从页面上，能找到用户但是没有办法发起呼叫

public class OrganizationPage {
    private AppiumDriver driver;

    public OrganizationPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

//    public void find_contact_in_organization(String name){
//        Pause.stop(1);
//        driver
//    }
}

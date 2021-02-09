package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class PrivateDeployLoginAdvancedSettingPage {
    AppiumDriver driver;

    private String port_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
    private String https_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch";
    private String save_setting_xpath = "//XCUIElementTypeStaticText[@name=\"保存\"]";
    public PrivateDeployLoginAdvancedSettingPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void set_port(String port){
        Pause.stop(1);
        driver.findElementByXPath(port_xpath).clear();
        driver.findElementByXPath(port_xpath).sendKeys(port);
    }

    public void enable_https(Boolean bflag){
        Pause.stop(1);
        if ( bflag && driver.findElementByXPath(https_xpath).getAttribute("value").equals("0")){
            driver.findElementByXPath(https_xpath).click();
        }

        if ( !bflag && driver.findElementByXPath(https_xpath).getAttribute("value").equals("1")){
            driver.findElementByXPath(https_xpath).click();
        }
    }

    public void save_setting(){
        driver.findElementByXPath(save_setting_xpath).click();
    }
}

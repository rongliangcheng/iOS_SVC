package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class SettingPage {
    AppiumDriver driver;

    private String autoAnswer_xpath = "//XCUIElementTypeSwitch[@name=\"自动应答\"]";
    private String _1080_xpath = "//XCUIElementTypeSwitch[@name=\"1080P\"]";
    private String high_framerate_xpath = "//XCUIElementTypeSwitch[@name=\"启用高帧率视频\"]";
    private String close_prompt_xpath = "//XCUIElementTypeSwitch[@name=\"关闭提示\"]";

    public SettingPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void auto_answer(Boolean bflag){
        Pause.stop(1);
        if( bflag && driver.findElementByXPath(autoAnswer_xpath).getAttribute("value") == "0"){
            driver.findElementByXPath(autoAnswer_xpath).click();
        } else if (!bflag && driver.findElementByXPath(autoAnswer_xpath).getAttribute("value") == "1"){
            driver.findElementByXPath(autoAnswer_xpath).click();
        }
    }

    public void switch_to_1080P(Boolean bflag){
        Pause.stop(1);
        if( bflag && driver.findElementByXPath(_1080_xpath).getAttribute("value") == "0"){
            driver.findElementByXPath(_1080_xpath).click();
        } else if (!bflag && driver.findElementByXPath(_1080_xpath).getAttribute("value") == "1"){
            driver.findElementByXPath(_1080_xpath).click();
        }
    }

    public void high_framerate(Boolean bflag){
        Pause.stop(1);
        if( bflag && driver.findElementByXPath(high_framerate_xpath).getAttribute("value") == "0"){
            driver.findElementByXPath(high_framerate_xpath).click();
        } else if (!bflag && driver.findElementByXPath(high_framerate_xpath).getAttribute("value") == "1"){
            driver.findElementByXPath(high_framerate_xpath).click();
        }
    }

    public void close_prompt(Boolean bflag){
        Pause.stop(1);
        if( bflag && driver.findElementByXPath(close_prompt_xpath).getAttribute("value") == "0"){
            driver.findElementByXPath(close_prompt_xpath).click();
        } else if (!bflag && driver.findElementByXPath(close_prompt_xpath).getAttribute("value") == "1"){
            driver.findElementByXPath(close_prompt_xpath).click();
        }
    }
}

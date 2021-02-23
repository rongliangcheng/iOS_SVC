package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class PrivateDeployLoginPage {
    private String privateDeployLoginPage_id = "私有部署登录";
    private String server_addr_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]";
    private String account_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]";
    private String password_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";
    private String login_submit_xpath = "//XCUIElementTypeStaticText[@name=\"登录\"]";
    private String keyboard_done_xpath = "(//XCUIElementTypeButton[@name=\"Done\"])[1]";

    private AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    public PrivateDeployLoginPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void fill_in_server_address(String server_address){
        Pause.stop(1);
        driver.findElementByXPath(server_addr_xpath).clear();
        driver.findElementByXPath(server_addr_xpath).sendKeys(server_address);
    }

    public void fill_in_account(String account){
        Pause.stop(1);
        driver.findElementByXPath(account_xpath).clear();
        driver.findElementByXPath(account_xpath).sendKeys(account);
    }

    public void fill_in_password(String password){
        Pause.stop(1);
        driver.findElementByXPath(password_xpath).clear();
        driver.findElementByXPath(password_xpath).sendKeys(password);
    }

    public void hide_keyboard(){
        driver.findElementByXPath(keyboard_done_xpath).click();
    }

    public void login_submit(){
        Pause.stop(1);
        driver.findElementByXPath(login_submit_xpath).click();
    }

    public boolean isOnPrivateDeployLoginPage(){
        log.info(" Check whether it is on private deploy login page");
        //return driver.findElementByAccessibilityId(privateDeployLoginPage_id).isDisplayed();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try{
            driver.findElementByAccessibilityId(privateDeployLoginPage_id);
        } catch (Exception e){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return true;
    }
}

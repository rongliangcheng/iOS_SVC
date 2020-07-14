package com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.common.UICommon;
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.PrivateDeployPage;
import io.appium.java_client.AppiumDriver;

import java.util.logging.Logger;

import static TestSpec.SystemTestSpec.LOGGER;

public class SignInPage {

    private AppiumDriver appiumDriver;

    public SignInPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        LOGGER.info("Sign in page");
        PrivateDeployPage privateDeployPage = new PrivateDeployPage(appiumDriver);
        privateDeployPage.navigate();
        privateDeployPage.signIn();
    }

    public void submit(String serveraddr,String accout,String password){
        LOGGER.info("Sign in page Sumbit");
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_server").sendKeys(serveraddr);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_name").sendKeys(accout);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_password").sendKeys(password);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_btn").click();

        Pause.stop(0.5);
        //UICommon.devicePermissionAllowance(appiumDriver);
    }

    public void submit(String serveraddr,String accout,String password,String port,Boolean useHttps){
        LOGGER.info("Sign in page Submit");
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/text_advance_setting").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_port").sendKeys(port);
        if(useHttps)
            appiumDriver.findElementById("com.hexmeet.hjt:id/https_switch").click();
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/save_btn").click();

        Pause.stop(0.5);
        submit(serveraddr,accout,password);
    }


}

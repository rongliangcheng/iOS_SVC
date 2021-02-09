package com.hexmeet.page.startup.deploytype.privatedeploy;

import com.hexmeet.utility.Pause;
import com.hexmeet.page.startup.deploytype.DeploymentTypePage;
import io.appium.java_client.AppiumDriver;

import java.util.logging.Logger;


public class PrivateDeployPage {
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private AppiumDriver appiumDriver;

    public PrivateDeployPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        logger.info("Private Deploy Page");
        DeploymentTypePage deploymentTypePage = new DeploymentTypePage(appiumDriver);

        deploymentTypePage.navigate();
        deploymentTypePage.privateCloudDeployment();
    }

    public void signIn(){
        logger.info("Sign in mode");
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name=\"登录\"]").click();
    }

    public void joinAMeeting(){
        logger.info("Join a meeting directly");
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//XCUIElementTypeButton[@name=\"加入会议\"]").click();
    }

    public void setup(){
        logger.info("Setting");
        Pause.stop(0.5);
        appiumDriver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"设置\"]").click();

    }

}

package com.hexmeet.pageobject.startup.deploytype.privatedeploy;

import com.hexmeet.Utility.Pause;
import com.hexmeet.pageobject.startup.deploytype.DeploymentTypePage;
import io.appium.java_client.AppiumDriver;

import static TestSpec.SystemTestSpec.LOGGER;

public class PrivateDeployPage {

    private AppiumDriver appiumDriver;

    public PrivateDeployPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        LOGGER.info("Private Deploy Page");
        DeploymentTypePage deploymentTypePage = new DeploymentTypePage(appiumDriver);

        deploymentTypePage.navigate();
        deploymentTypePage.privateCloudDeployment();
    }

    public void signIn(){
        LOGGER.info("Sign in mode");
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_btn").click();
    }

    public void joinAMeeting(){
        LOGGER.info("Join a meeting directly");
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/login_join_meeting").click();
    }

    public void setting(){
        LOGGER.info("Setting");
        Pause.stop(0.5);
        appiumDriver.findElementById("com.hexmeet.hjt:id/app_setup").click();

    }

}

package com.hexmeet.page.startup.deploytype;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeploymentTypePage {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    final private AppiumDriver appiumDriver;

    public DeploymentTypePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
    }


    public void privateCloudDeployment() {
        logger.info("Private cloud deployment");
         Pause.stop(1);

         //Choose private cloud deployment
        appiumDriver.findElementByAccessibilityId("icon_company").click();
    }

    public void publicCloudUser(){
        logger.info("Public cloud user");
        Pause.stop(1);

        //Choose public cloud deployment
        appiumDriver.findElementByAccessibilityId("icon_cloud").click();
    }
}

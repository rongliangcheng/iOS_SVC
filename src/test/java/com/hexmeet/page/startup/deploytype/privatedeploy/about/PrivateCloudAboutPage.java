package com.hexmeet.page.startup.deploytype.privatedeploy.about;

import com.hexmeet.utility.Pause;
import com.hexmeet.page.startup.deploytype.privatedeploy.PrivateDeployPage;
import io.appium.java_client.AppiumDriver;

public class PrivateCloudAboutPage {

    final private AppiumDriver appiumDriver;

    public PrivateCloudAboutPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
        PrivateDeployPage privateDeployPage = new PrivateDeployPage(appiumDriver);
        privateDeployPage.navigate();
        privateDeployPage.setup();
    }


    public String getVersion(){
        Pause.stop(2);

        appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.TextView").click();

        Pause.stop(2);
        //Get verson info
        return appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]").getText();
    }

}

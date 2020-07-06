package com.hexmeet.autotestcases.login

import com.hexmeet.base.SystemTestSpec
import com.hexmeet.Utility.Pause
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Shared

class Reinstall extends SystemTestSpec{
    @Shared
    DesiredCapabilities capabilities = new DesiredCapabilities()

    @Shared
    AppiumDriver appiumDriver = new AppiumDriver();
    def setupSpec(){
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","564b35554c573398");
        capabilities.setCapability("platformVersion", "10.0.0");
        capabilities.setCapability("appPackage", "com.hexmeet.hjt");
        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"),capabilities);
    }


    def "Install App"(){
        when:
            appiumDriver.installApp("/Users/apple/IdeaProjects/Sundae/app/HexMeetHJT-1.4.11-release.apk")
            Pause.sleep(60)
            appiumDriver.launchApp();

        then:
            assert true
    }
}

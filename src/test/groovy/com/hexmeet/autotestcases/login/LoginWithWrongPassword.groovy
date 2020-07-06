package com.hexmeet.autotestcases.login

import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.base.EndpointSystemTestSpec
import com.hexmeet.pageobject.UICommon
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class LoginWithWrongPassword extends EndpointSystemTestSpec{

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    def setupSpec(){

        androidEndpoint.initialAppiumEndpoint("Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    def cleanupSpec(){
//        if(androidEndpoint.getAppiumEndpointDriver() != null){
//                androidEndpoint.getAppiumEndpointDriver().quit();
//        }
    }

    def "Login the hjt System"(){

        AppiumDriver driver = androidEndpoint.getAppiumEndpointDriver();

        when:

        log.info("Start up hjt application\n")
        UICommon.startUp(driver);

        log.info("Login Cloud System\n")
        UICommon.userLoginCloud(driver,"rongliang","ronglia")

        log.info("A toast will appear when input the wrong password")
        boolean result = UICommon.detectToast(driver);

        then:
            assert result

    }
}

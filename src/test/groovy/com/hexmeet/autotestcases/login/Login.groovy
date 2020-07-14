package com.hexmeet.autotestcases.login

import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import TestSpec.EndpointSystemTestSpec
import com.hexmeet.pageobject.common.UICommon
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.PublicSignIn
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import spock.lang.Shared

import java.util.concurrent.TimeUnit

class Login extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver driver

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint()

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    def setupSpec(){



    }

    def cleanupSpec(){
//        if(androidEndpoint.getAppiumEndpointDriver() != null){
//                androidEndpoint.getAppiumEndpointDriver().quit();
//        }
    }

    def setup(){

    }

    def cleanup(){

    }

//    def "Login hjt System"(){
//
//
//        when:"Sign in the public cloud with correct password"
//
//        PublicSignIn publicSignIn = new PublicSignIn(driver);
//        publicSignIn.navigate()
//        publicSignIn.fillInAccount("rongliang")
//        publicSignIn.fillInPassword("rongliang")
//        publicSignIn.signIn()
//
//        then:"sign in successfully"
//           assert true
//
//    }

    def "Login hjt with wrong account"(){
        when: "Sign in with wrong account is not permitted"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
        driver = androidEndpoint.getAppiumEndpointDriver()
        PublicSignIn publicSignIn = new PublicSignIn(driver);
        publicSignIn.navigate()
        3.times {
            LOGGER.info("Fill in wrong account and password ")
            publicSignIn.fillInAccount("ronglian")
            publicSignIn.fillInPassword("rongl")
            publicSignIn.signInWithWrongUsernamePassword()
            UICommon.detectToast(driver)
            showPicInReportortrait(driver,"Toast")
            Pause.stop(1)
        }

        then:"quit"
        assert true
    }

//    def "Login hjt with wrong password"(){
//
//        when: "Sign in with wrong password 5 times, it will lock the user for 5 minutes"
//        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
//        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
//        driver = androidEndpoint.getAppiumEndpointDriver()
//        PublicSignIn publicSignIn = new PublicSignIn(driver);
//        publicSignIn.navigate()
//        5.times {
//            LOGGER.info("Fill in wrong password")
//            publicSignIn.fillInAccount("rongliang")
//            publicSignIn.fillInPassword("rongl")
//            publicSignIn.signInWithWrongUsernamePassword()
//            UICommon.detectToast(driver)
//            showPicInReportortrait(driver,"Toast")
//            Pause.stop(1.5)
//        }
//
//        Pause.stop(5)
//
//        then:"quit"
//        assert true
//    }
//
//    def "Login hjt System successfully after 5 minutes"(){
//
//
//        when:"Sign in the public cloud with correct password"
//        LOGGER.info("Sleep 5 minutes")
//        Pause.stop(300)
//        LOGGER.info("5 minutes over")
//        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
//        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
//        driver = androidEndpoint.getAppiumEndpointDriver()
//        PublicSignIn publicSignIn = new PublicSignIn(driver);
//        publicSignIn.navigate()
//        publicSignIn.fillInAccount("rongliang")
//        publicSignIn.fillInPassword("rongliang")
//        publicSignIn.signIn()
//        showPicInReportortrait(driver,"Sign in")
//
//        then:"sign in successfully"
//        assert true
//
//    }

}

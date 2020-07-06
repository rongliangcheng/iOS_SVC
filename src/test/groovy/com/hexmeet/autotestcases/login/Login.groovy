package com.hexmeet.autotestcases.login

import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.base.EndpointSystemTestSpec
import com.hexmeet.pageobject.UICommon
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

        androidEndpoint.initialAppiumEndpoint("Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        driver = androidEndpoint.getAppiumEndpointDriver()
        androidEndpoint.initialAppiumEndpoint("Android_1")

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

    def "Login the hjt System"(){


        when:

        PublicSignIn publicSignIn = new PublicSignIn(driver);
        publicSignIn.navigate()
        publicSignIn.fillInAccount("rongliang")
        publicSignIn.fillInPassword("rongliang")
        publicSignIn.signIn()

        then:
            true

    }
}

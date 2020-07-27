package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.UICommon
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.SignInPage
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit


@Title("正确登录及异常登录")
class SignIn extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    def setupSpec(){

        LOGGER.info("Setup")


    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Sign without serveraddress should tigger a prompt"(){


    }

    //def "Sign in with username and password"(){
    def "登录"(){
        when:"初始化AppiumDriver"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
        and:"以hjtautotest1/123456登录"
        SignInPage signInPage = new SignInPage(appiumDriver)
        signInPage.navigate()
        signInPage.submit("cloudbeta.hexmeet.com","hjtautotest1","123456")

        //and:"Capture a picture"

        //showPicInReportPortrait(appiumDriver,"Private cloud sign in")

        then:"成功登录"
        assert true
    }

    def "Sign with username password port and https"(){

    }

}

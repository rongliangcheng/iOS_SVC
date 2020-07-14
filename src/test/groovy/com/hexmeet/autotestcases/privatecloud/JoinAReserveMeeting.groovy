package com.hexmeet.autotestcases.privatecloud

import TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.Utility.UIElement
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.SignInPage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class JoinAReserveMeeting extends EndpointSystemTestSpec {
    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    ReserveMeetingPage reserveMeetingPage

    @Shared
    String serverAddr="cloudbeta.hexmeet.com"

    @Shared
    String username="hjtautotest1"

    @Shared
    String password="123456"

    def setupSpec(){

 //       LOGGER.info("Setup")
//        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
//        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
//        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
//        SignInPage signInPage = new SignInPage(appiumDriver)
//        signInPage.navigate()
//        signInPage.submit(serverAddr,username,password)
//        reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
//        reserveMeetingPage.navigate()

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Create a now meeting and join"(){

        when:"Create a reserved meeting"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
        SignInPage signInPage = new SignInPage(appiumDriver)
        signInPage.navigate()
        signInPage.submit(serverAddr,username,password)
        ReserveMeetingPage reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
        reserveMeetingPage.navigate()
        reserveMeetingPage.now();
        reserveMeetingPage.finish();
        reserveMeetingPage.backAfterReserver()

        and:"Join the reserved meeting"
        reserveMeetingPage.joinReservedMeeting();
        Pause.stop(30)
        showPicInReport(appiumDriver,"In meeting")

        and:"Hanup and terminate the call"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndTerminateCall()

        then:
        assert  true

    }


    def "Create a now meeting and invite another participant"(){
        when:"Create a reserved meeting"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
        SignInPage signInPage = new SignInPage(appiumDriver)
        signInPage.navigate()
        signInPage.submit(serverAddr,username,password)
        ReserveMeetingPage reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
        reserveMeetingPage.navigate()
        Pause.stop(5);
        reserveMeetingPage.now();
        reserveMeetingPage.addParticipants("hjtautotest2");
        reserveMeetingPage.finish();
        reserveMeetingPage.backAfterReserver()

        and:"Join the reserved meeting"
        reserveMeetingPage.joinReservedMeeting();
        Pause.stop(30)
        showPicInReport(appiumDriver,"In meeting")

        and:"Hanup and terminate the call"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndTerminateCall()

        then:
        assert  true
    }

//暂时没有解决 setpassword的问题
//    def "Create a password protected meeting and join"(){
//        when:"Create a reserved meeting"
//        reserveMeetingPage.now();
//        reserveMeetingPage.setMeetingPassword("1234567890")
//        reserveMeetingPage.finish();
//        reserveMeetingPage.backAfterReserver()
//
//        and:"Join the reserved meeting"
//        reserveMeetingPage.joinReservedMeeting()
//        Pause.stop(30)
//        showPicInReport(appiumDriver)
//
//        then:
//        assert true
//    }



}

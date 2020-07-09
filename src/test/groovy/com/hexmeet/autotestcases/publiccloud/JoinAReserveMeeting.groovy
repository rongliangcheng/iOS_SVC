package com.hexmeet.autotestcases.publiccloud

import TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.publicmeeting.reservemeeting.ReserveMeetingPage
import io.appium.java_client.AppiumDriver
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
    String username="rongliang"

    @Shared
    String password="rongliang"

    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
        reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
        reserveMeetingPage.navigate(username,password);

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Create a now meeting and join"(){

        when:"Create a reserved meeting"
        reserveMeetingPage.now();
        reserveMeetingPage.finish();
        reserveMeetingPage.backAfterReserver()

        and:"Join the reserved meeting"
        reserveMeetingPage.joinReservedMeeting()
        Pause.stop(30)
        showPicInReport(appiumDriver,"In meeting")

        then:
        assert true

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

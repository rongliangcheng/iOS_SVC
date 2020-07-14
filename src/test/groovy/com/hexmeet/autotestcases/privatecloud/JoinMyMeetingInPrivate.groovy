package com.hexmeet.autotestcases.privatecloud

import TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.SignInPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting.MyMeetingPage
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class JoinMyMeetingInPrivate extends EndpointSystemTestSpec{
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

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Change meeting password and join my meeting"(){

        when:"Create a reserved meeting"
        String newPassword="12345"
        MyMeetingPage myMeetingPage = new MyMeetingPage(appiumDriver);
        myMeetingPage.navigate(serverAddr,username,password);
        myMeetingPage.mymeetingpage()
        myMeetingPage.muteUmuteCamera()
        myMeetingPage.muteUmuteAudio()
        myMeetingPage.muteUmuteCamera()
        myMeetingPage.muteUmuteAudio()
        myMeetingPage.meetingSettings(newPassword,false,false,false,false,true)
        myMeetingPage.joinTheMeeting(newPassword)

        Pause.stop(5)
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        Boolean isInAmeeting = meetingOperations.isInMeetingPage();

        and:"hangup the call "
        Pause.stop(30)
        meetingOperations.hangupAndTerminateCall()

        then:
        assert isInAmeeting

    }
}
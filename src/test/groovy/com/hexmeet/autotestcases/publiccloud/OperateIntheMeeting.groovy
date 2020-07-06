package com.hexmeet.autotestcases.publiccloud

import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.base.EndpointSystemTestSpec
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicpage.joinmeeting.PublicJoinMeeting
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicpage.joinmeeting.meetingoperations.MeetingOperations
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

/**
 @author raleigh
 @create 2020-06-22
 */
class OperateIntheMeeting extends EndpointSystemTestSpec{
    @Shared
    AppiumDriver driver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    MeetingOperations meetingOperations;

    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpoint("Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        driver = androidEndpoint.getAppiumEndpointDriver()
        androidEndpoint.initialAppiumEndpoint("Android_1")
        meetingOperations = new MeetingOperations(driver);

        PublicJoinMeeting publicJoinMeeting = new PublicJoinMeeting(driver);
        publicJoinMeeting.navigate("rongliang","rongliang");

        publicJoinMeeting.dailNumber(1)
        publicJoinMeeting.dailNumber(3)
        publicJoinMeeting.dailNumber(9)
        publicJoinMeeting.dailNumber(1)
        publicJoinMeeting.dailNumber(0)
        publicJoinMeeting.dailNumber(0)
        publicJoinMeeting.dailNumber(0)
        publicJoinMeeting.backSpace()
        publicJoinMeeting.dailNumber(0)
        publicJoinMeeting.dailNumber(1)
        publicJoinMeeting.dailNumber(0)
        publicJoinMeeting.dailNumber(2)
        publicJoinMeeting.dailNumber(2)

        publicJoinMeeting.joinButton()

        Pause.sleep(10)
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "mute the audio"(){
        when:"mute the audio"
        meetingOperations.muteAudio()

        showPicInReport(driver)

        then:
        assert true
    }

    def "mute the local camera"(){
        when:"mute the local camera"
        meetingOperations.muteCamera()

        showPicInReport(driver)

        then:
        assert true
    }


    def "Layout mode Switch"(){
        when:"mute the local camera"
        meetingOperations.layoutModeSwitch()

        showPicInReport(driver)

        then:
        assert true
    }



}

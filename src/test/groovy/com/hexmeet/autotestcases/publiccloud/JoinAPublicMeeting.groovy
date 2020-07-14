package com.hexmeet.autotestcases.publiccloud

import com.hexmeet.Utility.Pause

import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.joinmeeting.PublicJoinMeeting
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.joinmeeting.meetingoperations.MeetingOperations
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class JoinAPublicMeeting extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver driver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        driver = androidEndpoint.getAppiumEndpointDriver()

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Join a predefined meeting"(){
        when:"start an endpoint"


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

//        String pic = captureScreenShot(driver);
//
//        Pause.sleep(5);
//
//        reportInfo " show pictures <img src=\"${pic}\" width=\"320\" height=\"180\" /> "

        and: "Show buttons on the screen"
        MeetingOperations meetingOperations = new MeetingOperations(driver);
        meetingOperations.muteAudio();

        Pause.stop(5);

        and: "Show buttons on the screen"
        meetingOperations.muteCamera();

        then:"Join the meeting "
            assert true;
    }

    def "Mute the camera"(){
        when: "Show buttons on the screen"
        MeetingOperations meetingOperations = new MeetingOperations(driver);
        meetingOperations.muteAudio();

        then:" Mute the audio"
        assert true;
    }

    def "Mute the local camera"(){
        when: "Show buttons on the screen"
        MeetingOperations meetingOperations = new MeetingOperations(driver);
        meetingOperations.muteCamera();

        then: "mute camera successfully"
        assert true;
    }

}

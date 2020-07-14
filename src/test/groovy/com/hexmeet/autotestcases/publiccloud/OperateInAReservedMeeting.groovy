package com.hexmeet.autotestcases.publiccloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.startup.deploytype.publicdeploy.signin.userpublicmainpage.publicmeeting.PublicMeeting
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class OperateInAReservedMeeting extends EndpointSystemTestSpec {

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    ReserveMeetingPage reserveMeetingPage

    @Shared
    MeetingOperations meetingOperations
    @Shared
    String username="rongliang"

    @Shared
    String password="rongliang"

    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

        PublicMeeting publicMeeting = new PublicMeeting(appiumDriver);
        publicMeeting.navigate(username,password);
        Pause.stop(5);
        publicMeeting.publicReservedMeeting();

        reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
        //reserveMeetingPage.navigate(username,password);
        reserveMeetingPage.now();
        reserveMeetingPage.finish();
        reserveMeetingPage.backAfterReserver()
        reserveMeetingPage.joinReservedMeeting()

        Pause.stop(20)

        meetingOperations = new MeetingOperations(appiumDriver)
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Mute umute Audio"(){
        when:" Do audio operation for the first time"
        LOGGER.info("Mute audio")
        meetingOperations.muteUmuteAudio()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Mute Audio")

        and: "do audio operation for the second time"
        LOGGER.info("Umute audio")
        meetingOperations.muteUmuteAudio()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Umute Audio")

        then:
        assert true
    }


    def "Mute umute Camera"(){
        when: "Do camera operation for the first time"
        LOGGER.info("Mute camera")
        meetingOperations.muteUmuteCamera()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Mute camera")

        and: "Do camera operation for the second time"
        LOGGER.info("Umute camera")
        meetingOperations.muteUmuteCamera()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Umute camera")

        then:
        assert true
    }

    def "Switch camera"(){
        when:"Do camera switch for the first time"
        LOGGER.info("Switch camera")
        meetingOperations.switchCamera()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Switch camera")

        and:"Do camera switch for the second time"
        LOGGER.info("Switch camera back")
        meetingOperations.switchCamera()
        Pause.stop(2)
        showPicInReport(appiumDriver,"switch camera")

        then:
        assert true
    }

    def "Share content and then cancel"(){
        when:"Begin to share content"
        LOGGER.info("Share content and cancel")
        meetingOperations.shareContentAndCancel()

        then:
        assert true
    }

    def "Share content and stop content"(){

        when: "Begin to share content"
        LOGGER.info("Share content")
        meetingOperations.shareContent()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Share content")

        and: "Stop content"
        LOGGER.info("Stop content")
        meetingOperations.stopContent()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Stop Content")

        then:
        assert  true
    }

    def "Chat"(){
        when: "Send message to all"
        LOGGER.info("Send message to all")
        meetingOperations.sendMessage("Hell, how are you")
        Pause.stop(2)
        showPicInReport(appiumDriver,"Chat")

        then:
        assert true
    }

    def "switch layout"(){
        when:"Do switch layout for the first time"
        LOGGER.info("Switch Layout")
        meetingOperations.switchLayout()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Layout 1")

        and:"Do switch layout for the second time"
        LOGGER.info("Switch layout back")
        meetingOperations.switchLayout()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Layout back")

        then:
        assert true
    }

    def "Mute umute Local preview"(){
        when:"Do show hide local preview for the first time"
        LOGGER.info("Mute local preview")
        meetingOperations.showHideLocalPreview()
        Pause.stop(2)
        showPicInReport(appiumDriver,"Hide local preview")

        and:"Do show hide local preview for the second time"
        LOGGER.info("Umute local preview")
        meetingOperations.showHideLocalPreview()
        Pause.stop(2)
        showPicInReport(appiumDriver,"show local preview")

        then:
        assert  true
    }

    def "Audio Video Escalation"(){
        when:"Switch to audio only mode"
        LOGGER.info("Downgrade to audio")
        meetingOperations.switchToAudioOnly()
        Pause.stop(5)
        showPicInReport(appiumDriver,"Audio Only")

        and:"Switch back to video mode"
        LOGGER.info("Upgrade to video")
        meetingOperations.switchBackToAVmode()
        Pause.stop(5)
        showPicInReport(appiumDriver,"Normal")

        then:
        assert true
    }

    def "Hangup and terminate the call"(){
        when:"Hangup and terminate the call"
        LOGGER.info("Hangup and terminate the call")
        meetingOperations.hangupAndTerminateCall()
        Pause.stop(5)

        and:"Capture the screen"
        showPicInReport(appiumDriver,"Terminated")

        then:
        assert true
    }


}

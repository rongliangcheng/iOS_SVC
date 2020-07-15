package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.joinmeeting.PrivateDirectJoinAMeetingPage
import io.appium.java_client.AppiumDriver

import spock.lang.Shared

import java.util.concurrent.TimeUnit

class GuestCall extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    String serverAddress="cloudbeta.hexmeet.com"

    @Shared
    String conferenceNumber="13910000200"

    @Shared
    String username="hjtautotest1"

    @Shared
    PrivateDirectJoinAMeetingPage privateDirectJoinAMeetingPage


    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

        privateDirectJoinAMeetingPage  = new PrivateDirectJoinAMeetingPage(appiumDriver)
        privateDirectJoinAMeetingPage.navigate()

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "Join without username"(){

        when:" Join with username"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,conferenceNumber,"")
        Pause.stop(20)
        showPicInReport(appiumDriver,"No name join")

        and: "Hangup and leave"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndLeave()

        Pause.stop(5)

        then:
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "Join with username"(){

        when:" Join with username"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,conferenceNumber,username)
        Pause.stop(20)
        showPicInReport(appiumDriver,username)

        and: "Hangup and leave"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndLeave()

        Pause.stop(5)

        then:
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "Join with not existed meeting room"(){

        when:" Join with username"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,"1239","hjtautotest1")
        showPicInReportPortrait(appiumDriver,"No name join")

        Pause.stop(5)

        then:
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "Join with wrong server id"(){

        when:" Join with username"
        privateDirectJoinAMeetingPage.joinAMeeting("serverAddress","13910000200","hjtautotest1")
        showPicInReportPortrait()(appiumDriver,"No name join")

        Pause.stop(5)

        then:
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


}

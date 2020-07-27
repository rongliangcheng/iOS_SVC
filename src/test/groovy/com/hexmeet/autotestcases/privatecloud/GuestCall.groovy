package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.joinmeeting.PrivateDirectJoinAMeetingPage
import io.appium.java_client.AppiumDriver

import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("非注册用户呼叫")
class GuestCall extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    String serverAddress="cloudbeta.hexmeet.com"

    @Shared
    String conferenceNumber="13910001001*12345"

    @Shared
    String username="hjtautotest1"

    @Shared
    PrivateDirectJoinAMeetingPage privateDirectJoinAMeetingPage


    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
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

    def "匿名呼入"(){

        when:"不填用户名"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,conferenceNumber,"")
        Pause.stop(20)
        showPicInReport(appiumDriver,"No name join")

        and: "挂断并离开会议"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndLeave()

        Pause.stop(5)

        then:"成功挂断"
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "带用户名呼入"(){

        when:"填写用户名"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,conferenceNumber,username)
        Pause.stop(20)
        showPicInReport(appiumDriver,username)

        and: "挂断并离开"
        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
        meetingOperations.hangupAndLeave()

        Pause.stop(5)

        then:"成功挂断"
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
        privateDirectJoinAMeetingPage.joinAMeeting("serverAddress",conferenceNumber,"hjtautotest1")
        showPicInReportPortrait(appiumDriver,"No name join")

        Pause.stop(5)

        then:
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


}

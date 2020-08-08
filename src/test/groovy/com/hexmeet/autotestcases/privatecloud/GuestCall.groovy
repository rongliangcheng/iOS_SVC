package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.MeetingOperations
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.joinmeeting.PrivateDirectJoinAMeetingPage
import io.appium.java_client.AppiumDriver
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("非注册用户呼叫")
@Narrative("测试非注册用户的各种呼叫场景")
@Retry(delay=10000)
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
        meetingOperations.persistentCallHangupAndLeave()

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
        meetingOperations.persistentCallHangupAndLeave()

        Pause.stop(5)

        then:"成功挂断"
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "呼叫不存在的会议号"(){

        when:"呼叫不存在的会议号1239"
        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,"1239","hjtautotest1")
        showPicInReportPortrait(appiumDriver,"No name join")

        Pause.stop(5)

        then:"呼叫不能建立，并提示"
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


    def "呼叫错误的服务器地址"(){

        when:"呼叫不存在的服务器地址"
        privateDirectJoinAMeetingPage.joinAMeeting("serverAddress",conferenceNumber,"hjtautotest1")
        showPicInReportPortrait(appiumDriver,"No name join")

        Pause.stop(5)

        then:"呼叫不能建立，并且停留在呼叫界面"
        assert privateDirectJoinAMeetingPage.isOnGuestPage()

    }


}

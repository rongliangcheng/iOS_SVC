package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MediaStatisticsPage
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.MeetingPage
import com.hexmeet.page.PrivateDeployLoginPage
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.page.startup.deploytype.privatedeploy.joinmeeting.PrivateDirectJoinAMeetingPage
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.GuestCallOperations
import pageActions.PageNavigateOperations
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title
import spock.lang.Unroll

import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Title("非注册用户呼叫")
@Narrative("测试非注册用户的各种呼叫场景")
// @Retry(delay=10000)
class GuestCall extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint iosEndpoint = new IOSAppiumEndpoint();

    @Shared
    String serverAddress="cloudbeta.hexmeet.com"

    @Shared
    String conferenceNumber="115359"

    @Shared
    String password="12345"

    @Shared
    String conferenceNumWithPassword = "115359*12345"

    @Shared
    String username="hjtautotest3"

    @Shared
    PrivateDirectJoinAMeetingPage privateDirectJoinAMeetingPage

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass());

    def setupSpec(){

        LOGGER.info("Setup")

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    @Unroll()
    def "匿名呼入组合"(){

        when:"初始化"
        iosEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and: "到达非登陆呼叫界面"
        PrivateDeployLoginPage privateDeployLoginPage = new PrivateDeployLoginPage(appiumDriver)
        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)

        Pause.stop(10)
        if(privateDeployLoginPage.isOnPrivateDeployLoginPage()){
            pageNavigateOperations.navigate_to_guest_call_from_private_deploy_login()
        }else if( meetingPage.isOnMeetingPage()){
            pageNavigateOperations.navigate_to_guest_call_from_logined_page()
        }

        GuestCallOperations guestCallOperations = new GuestCallOperations(appiumDriver);
        guestCallOperations.guest_call(serverAddress,conferenceNumWithPassword, display_name, calltype,camera_mute,mic_mute)

        and: "挂断并离开会议"
        Pause.stop(20)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.hangup()

        then:"成功挂断"
        assert true

        where:
        display_name | calltype | camera_mute | mic_mute
        "hjtautotest3" | CALLTYPE.Video | true | true
        "hjtautotest3" | CALLTYPE.Video | true | false
        "hjtautotest3" | CALLTYPE.Video | false | true
        "hjtautotest3" | CALLTYPE.Video | false | false
        "hjtautotest3" | CALLTYPE.Audio | true | true
        "hjtautotest3" | CALLTYPE.Audio | true | false
        "hjtautotest3" | CALLTYPE.Audio | false | true
        "hjtautotest3" | CALLTYPE.Audio | false | false
        "" | CALLTYPE.Video | false | false
        "" | CALLTYPE.Audio | false | false
    }


    @Unroll()
    def "匿名呼入并输入密码"() {

        when: "初始化"
        iosEndpoint.initialAppiumEndpointfromJson("config.json", "iOS_1")
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and: "到达非登陆呼叫界面"
        PrivateDeployLoginPage privateDeployLoginPage = new PrivateDeployLoginPage(appiumDriver)
        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)

        Pause.stop(10)
        if (privateDeployLoginPage.isOnPrivateDeployLoginPage()) {
            pageNavigateOperations.navigate_to_guest_call_from_private_deploy_login()
        } else if (meetingPage.isOnMeetingPage()) {
            pageNavigateOperations.navigate_to_guest_call_from_logined_page()
        }

        GuestCallOperations guestCallOperations = new GuestCallOperations(appiumDriver);
        guestCallOperations.guest_call(serverAddress, conferenceNumber, display_name, calltype, camera_mute, mic_mute)
        Pause.stop(1)


        long val = System.currentTimeMillis()/2000;
        log.info(String.valueOf(val))
        if ( val % 2) {
            log.info("True")
            guestCallOperations.guest_call_with_password(password, true)
            and: "挂断并离开会议"
            Pause.stop(20)
            MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
            meetingOperationPage.hangup()
        } else {
            log.info("false")
            guestCallOperations.guest_call_with_password(password, false)
            Pause.stop(20)
         }


        then:"成功挂断"
        assert true

        where:
        display_name | calltype | camera_mute | mic_mute
        "hjtautotest3" | CALLTYPE.Video | true | true
        "hjtautotest3" | CALLTYPE.Video | true | false
        "hjtautotest3" | CALLTYPE.Video | false | true
        "hjtautotest3" | CALLTYPE.Video | false | false
        "hjtautotest3" | CALLTYPE.Audio | true | true
        "hjtautotest3" | CALLTYPE.Audio | true | false
        "hjtautotest3" | CALLTYPE.Audio | false | true
        "hjtautotest3" | CALLTYPE.Audio | false | false
    }


//    def "带用户名呼入"(){
//
//        when:"填写用户名"
//        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,conferenceNumber,username)
//        Pause.stop(20)
//        showPicInReport(appiumDriver,username)
//
//        and: "挂断并离开"
//        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
//        meetingOperations.persistentCallHangupAndLeave()
//
//        Pause.stop(5)
//
//        then:"成功挂断"
//        assert privateDirectJoinAMeetingPage.isOnGuestPage()
//
//    }
//
//
//    def "呼叫不存在的会议号"(){
//
//        when:"呼叫不存在的会议号1239"
//        privateDirectJoinAMeetingPage.joinAMeeting(serverAddress,"1239","hjtautotest1")
//        showPicInReportPortrait(appiumDriver,"No name join")
//
//        Pause.stop(5)
//
//        then:"呼叫不能建立，并提示"
//        assert privateDirectJoinAMeetingPage.isOnGuestPage()
//
//    }
//
//
//    def "呼叫错误的服务器地址"(){
//
//        when:"呼叫不存在的服务器地址"
//        privateDirectJoinAMeetingPage.joinAMeeting("serverAddress",conferenceNumber,"hjtautotest1")
//        showPicInReportPortrait(appiumDriver,"No name join")
//
//        Pause.stop(5)
//
//        then:"呼叫不能建立，并且停留在呼叫界面"
//        assert privateDirectJoinAMeetingPage.isOnGuestPage()
//
//    }


}

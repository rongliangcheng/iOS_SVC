package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.MeetingPage
import com.hexmeet.page.MyMeetingRoomPage
import com.hexmeet.page.MyMeetingRoomSettingPage
import com.hexmeet.page.PageNavigate
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause

//import com.hexmeet.utility.Pause
//import com.hexmeet.page.common.MeetingOperations
//import com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting.MyMeetingPage
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.MyMeetingRoomOperations
import pageActions.MyMeetingRoomSettingOperations
import pageActions.PageNavigateOperations
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("加入私有部署我的会议")
@Narrative("呼叫私有部署中我的会议室，修改麦克，摄像头设置，并修改会议密码")
//@Retry(delay=10000)

class JoinMyMeetingInPrivate extends EndpointSystemTestSpec{
    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint iOSAppiumEndPoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    String serverAddr="cloudbeta.hexmeet.com"

    @Shared
    String username="hjtautotest3"

    @Shared
    String password="123456"

    def setupSpec(){

        LOGGER.info("Setup")
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "修改会议密码并加入会议"() {

        when: "初始化"
        iOSAppiumEndPoint.initialAppiumEndpointfromJson("config.json", "iOS_1")
        iOSAppiumEndPoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iOSAppiumEndPoint.getAppiumEndpointDriver()

        and: "修改会议设置"

        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.clear_reserved_meeting(username)
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_my_meeting_setting()
        MyMeetingRoomSettingOperations myMeetingRoomSettingOperations = new MyMeetingRoomSettingOperations(appiumDriver)
        myMeetingRoomSettingOperations.change_my_meeting_room_setting("12345", true, true, true, true)

        //TODO
        //Will add guest call to verify
        and: "进入会议"
        MyMeetingRoomOperations myMeetingRoomOperations = new MyMeetingRoomOperations(appiumDriver)
        myMeetingRoomOperations.join_my_meeting(CALLTYPE.Video, false, false)

        then: "入会成功"
        assert true
    }

    @Retry()
    def "修改后挂断会议"(){
        when:"挂断会议"
        Pause.stop(30)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.hangup()

        then:"操作成功"
        assert true

    }

//    def "去掉会议密码修改参数并加入会议"() {
//
//        when: "初始化"
//        iOSAppiumEndPoint.initialAppiumEndpointfromJson("config.json", "iOS_1")
//        iOSAppiumEndPoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
//        appiumDriver = iOSAppiumEndPoint.getAppiumEndpointDriver()
//
//        and: "修改会议设置"
//        MeetingPage meetingPage = new MeetingPage(appiumDriver)
//        meetingPage.clear_reserved_meeting(username)
//        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
//        pageNavigate.navigate_to_my_meetingroom()
//        // PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
//        // pageNavigateOperations.navigate_to_my_meeting_setting()
//        // MyMeetingRoomSettingOperations myMeetingRoomSettingOperations = new MyMeetingRoomSettingOperations(appiumDriver)
//        // myMeetingRoomSettingOperations.change_my_meeting_room_setting("", false, true, false, true)
//
//        and: "进入会议"
//        MyMeetingRoomPage myMeetingRoomPage = new MyMeetingRoomPage(appiumDriver)
//        myMeetingRoomPage.join_my_meeting(CALLTYPE.Video, true, true)
//
//        then:"入会成功"
//        assert true
//    }
//
//    @Retry()
//    def "恢复后参数后挂断"(){
//        when:"挂断会议"
//        Pause.stop(30)
//        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
//        meetingOperationPage.hangup()
//
//        then:"操作成功"
//        assert true
//
//    }
}

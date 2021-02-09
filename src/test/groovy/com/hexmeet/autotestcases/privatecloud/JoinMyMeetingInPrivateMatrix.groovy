package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MediaStatisticsPage
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.MeetingPage
import com.hexmeet.page.MyMeetingRoomPage
import com.hexmeet.page.PageNavigate
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause
import io.appium.java_client.AppiumDriver

//import com.hexmeet.utility.Pause
//import com.hexmeet.page.common.MeetingOperations
//import com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting.MyMeetingPage

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.MyMeetingRoomOperations
import pageActions.MyMeetingRoomSettingOperations
import pageActions.PageNavigateOperations
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

@Unroll
@Title("加入私有部署我的会议")
@Narrative("遍历音视频 关闭摄像头 关闭mic")
//@Retry(delay=10000)

class JoinMyMeetingInPrivateMatrix extends EndpointSystemTestSpec{
    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint iOSAppiumEndPoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    String username = "hjtautotest3"

    def setupSpec(){

        LOGGER.info("Setup")

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "我的会议室视频组合呼叫"() {

        when: "重新初始化"
        iOSAppiumEndPoint.initialAppiumEndpointfromJson("config.json", "iOS_1")
        iOSAppiumEndPoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iOSAppiumEndPoint.getAppiumEndpointDriver()

        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.clear_reserved_meeting(username)

        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.navigate_to_my_meetingroom()

        and: "呼叫参数 matrix"
        MyMeetingRoomOperations myMeetingRoomOperations = new MyMeetingRoomOperations(appiumDriver)
        myMeetingRoomOperations.join_my_meeting(calltype, camera_mute, mic_mute)

        then: "统计媒体信息"
        Pause.stop(20)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.showMediaStatistics()
        Pause.stop(10)
        MediaStatisticsPage mediaStatisticsPage = new MediaStatisticsPage(appiumDriver)
        int audioRate = mediaStatisticsPage.getAudioSendRate();
        int videoRate = mediaStatisticsPage.getVideoSendRate(3);

        and: "挂断"
        meetingOperationPage.hideMediaStatistics()
        meetingOperationPage.hangup()

        then: "入会成功"
        assert audioRate > audiolow && audioRate < audiohigh
        assert videoRate > videolow && videoRate < videohig

        where:
        calltype       | camera_mute | mic_mute | audiolow | audiohigh | videolow | videohig
        CALLTYPE.Video | true        | true     |   1       | 10       | 0        |   100
        CALLTYPE.Video | true        | false    |   10      | 40        | 0       |   100
        CALLTYPE.Video | false        | true    |   1       | 10        |  100    |  3000
        CALLTYPE.Video | false        | false   |  10       | 40        |  100    |  3000

    }


    @Unroll
    def "我的会议室音频组合呼叫"() {

        when: "重新初始化"
        iOSAppiumEndPoint.initialAppiumEndpointfromJson("config.json", "iOS_1")
        iOSAppiumEndPoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iOSAppiumEndPoint.getAppiumEndpointDriver()

        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.clear_reserved_meeting(username)

        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.navigate_to_my_meetingroom()

        and: "呼叫参数 matrix"
        MyMeetingRoomOperations myMeetingRoomOperations = new MyMeetingRoomOperations(appiumDriver)
        myMeetingRoomOperations.join_my_meeting(calltype, camera_mute, mic_mute)

        then: "统计媒体信息"
        Pause.stop(20)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.showMediaStatistics()
        Pause.stop(10)
        MediaStatisticsPage mediaStatisticsPage = new MediaStatisticsPage(appiumDriver)
        int audioRate = mediaStatisticsPage.getAudioSendRate()
        int videoRate = mediaStatisticsPage.getVideoSendRate(3)

        and: "挂断"
        meetingOperationPage.hideMediaStatistics()
        meetingOperationPage.hangup()

        then: "入会成功"
        assert audioRate > audiolow && audioRate < audiohigh
        assert videoRate == 0

        where:
        calltype       | camera_mute | mic_mute | audiolow | audiohigh
        CALLTYPE.Audio | true        | true     |   1       | 10
        CALLTYPE.Audio | true        | false    |   10      | 40
        CALLTYPE.Audio | false        | true    |   1       | 10
        CALLTYPE.Audio | false        | false   |   10       | 40

    }

}

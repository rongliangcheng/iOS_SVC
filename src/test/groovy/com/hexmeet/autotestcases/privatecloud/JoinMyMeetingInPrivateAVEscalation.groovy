package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.*
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger

//import com.hexmeet.utility.Pause
//import com.hexmeet.page.common.MeetingOperations
//import com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting.MyMeetingPage

import org.slf4j.LoggerFactory
import pageActions.MyMeetingRoomOperations
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Title
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

@Unroll
@Title("加入私有部署我的会议")
@Narrative("遍历音视频 关闭摄像头 关闭mic")
//@Retry(delay=10000)

class JoinMyMeetingInPrivateAVEscalation extends EndpointSystemTestSpec{
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

    def "我的会议室音频升视频"() {

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


        then: "audio升video"
        meetingOperationPage.hideMediaStatistics()
        Pause.stop(2)
        meetingOperationPage.switch_to_video_from_audio()
        Pause.stop(10)
        meetingOperationPage.showMediaStatistics()
        MediaStatisticsPage mediaStatisticsPage2 = new MediaStatisticsPage(appiumDriver)
        int videoRate2 = mediaStatisticsPage2.getVideoSendRate(3)

        and: "挂断"
        meetingOperationPage.hideMediaStatistics()
        meetingOperationPage.hangup()

        then: "升级成功"
        assert audioRate > audiolow && audioRate < audiohigh
        assert videoRate == 0
        assert videoRate2 > videolow && videoRate2 < videohigh

        where:
        calltype       | camera_mute | mic_mute | audiolow | audiohigh | videolow | videohigh
        CALLTYPE.Audio | false        | true    |   1       | 10        |  100    |  3000
        CALLTYPE.Audio | false        | false   |  10       | 80        |  100    |  3000
        CALLTYPE.Audio | true        | true    |   1       | 10        |  0    |  100
        CALLTYPE.Audio | true        | false   |  10       | 80       |  0    |  100
    }


}

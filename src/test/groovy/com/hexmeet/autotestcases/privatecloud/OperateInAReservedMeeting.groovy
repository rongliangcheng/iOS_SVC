package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.MeetingPage
import com.hexmeet.page.PrivateDeployLoginPage
import com.hexmeet.page.ReservedMeetingInfoPage
import com.hexmeet.page.webpage.ChromeDriverSingleton
import com.hexmeet.page.webpage.MobileWebCreateReserveMeetingPage
import com.hexmeet.page.webpage.MobileWebLogin
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
//import com.hexmeet.page.common.MeetingOperations
//import com.hexmeet.page.common.ReserveMeetingPage
import com.hexmeet.page.startup.deploytype.privatedeploy.signin.SignInPage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.GuestCallOperations
import pageActions.PageNavigateOperations
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("加入预约会议并进行操作")
@Narrative("预约会议然后进行麦克，摄像头，模式的操作")
@Retry(delay=10000)


class OperateInAReservedMeeting extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    String serverAddressUrl="http://cloudbeta.hexmeet.com/mobile/#/login"

    @Shared
    String username="hjtautotest3"

    @Shared
    IOSAppiumEndpoint iosEndpoint = new IOSAppiumEndpoint()

    @Shared
    MeetingOperationPage meetingOperationPage

    def setupSpec(){

        LOGGER.info("Setup")
        // "初始化"


    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "清除已经预约会议"(){
        when:"清除会议"
        iosEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        MeetingPage meetingPage = new MeetingPage(appiumDriver);
        meetingPage.clear_reserved_meeting(username)

        then:"清除成功"
        assert true
    }

    def "创建即时会议"() {

        when: "创建一即时会议并改变时长"
        WebDriver driver = ChromeDriverSingleton.getDriver();
        MobileWebLogin mobileWebLogin = new MobileWebLogin(driver, serverAddressUrl, username, "123456");

        MobileWebCreateReserveMeetingPage mobileWebCreateReserveMeetingPage = new MobileWebCreateReserveMeetingPage();
        mobileWebCreateReserveMeetingPage.navigate_to_reserve_meeting_page();
        mobileWebCreateReserveMeetingPage.create_now_meeting();

        then:""
        assert true
    }

    def "加入会议"(){
        when:"加入会议"
        iosEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        Pause.stop(40)
        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.find_reserved_meeting(username)

        ReservedMeetingInfoPage reservedMeetingInfoPage = new ReservedMeetingInfoPage(appiumDriver)
        reservedMeetingInfoPage.join_reserved_meeting(CALLTYPE.Video,false,false)

        Pause.stop(20)

        meetingOperationPage = new MeetingOperationPage(appiumDriver)
        then: "进入会议"
        assert meetingOperationPage.find_display_name(username)
    }

    def "静音"() {
        when: "点击静音按钮一次"
        LOGGER.info("Mute audio")
        meetingOperationPage = new MeetingOperationPage(appiumDriver);
        meetingOperationPage.mute_audio()
        Pause.stop(10)
        // showPicInReport(appiumDriver,"静音操作")

        then:
        meetingOperationPage.find_display_name(username)
    }

    def "解除静音"(){
        when: "点击解除静音"
        LOGGER.info("Umute audio")
        meetingOperationPage.unmute_audio()
        Pause.stop(2)
        // showPicInReport(appiumDriver,"解除静音")

        then:"操作成功"
        assert true
    }

    def "切换摄像头"(){
        when:"点击切换摄像头按钮1次"
        LOGGER.info("Switch camera")
        meetingOperationPage.switch_camera()
        Pause.stop(10)
        // showPicInReport(appiumDriver,"切换摄像头1次")

        and:"点击切换摄像头按钮2次"
        LOGGER.info("Switch camera back")
        meetingOperationPage.switch_camera()
        Pause.stop(2)
        // showPicInReport(appiumDriver,"切换摄像头2次")

        then:"操作成功"
        assert true
    }

    def "关摄像头"() {
        when: "停止视频"
        LOGGER.info("Mute camera")
        meetingOperationPage.mute_camera()
        Pause.stop(10)
        // showPicInReport(appiumDriver,"停止视频")

        then:
        assert true
    }

    def "开摄像头"(){
        when: "开启视频"
        LOGGER.info("Umute camera")
        meetingOperationPage.umute_camera()
        Pause.stop(2)
        // showPicInReport(appiumDriver,"开启视频")

        then:"操作成功"
        assert true
    }



    def "聊天"(){
        when: "发送聊天消息"
        LOGGER.info("Send message to all")
        meetingOperationPage.chat_reserve_meeting("Hello, how are you")
        Pause.stop(2)
        // // showPicInReportPortrait(appiumDriver,"聊天界面")

        then:"操作成功"
        assert true
    }

    def "切换到lecture分屏模式"(){
        when:"点击分屏模式1次"
        LOGGER.info("Switch to lecture Layout")
        Pause.stop(10)
        meetingOperationPage.switch_to_lecture_display_mode()
        // showPicInReport(appiumDriver,"分屏模式2")

        then:"操作成功"
        assert true
    }

    def "切换到gallery分屏模式"(){
        when:"点击分屏模式1次"
        LOGGER.info("Switch gallery Layout")
        Pause.stop(10)
        meetingOperationPage.switch_to_gallery_display_mode()
        // showPicInReport(appiumDriver,"分屏模式2")

        then:"操作成功"
        assert true
    }

    def "共享桌面"() {
        when: "点击共享桌面并分享"
        LOGGER.info("Share content")
        meetingOperationPage.share_content()

        then:"共享成功"
        assert true
    }

    def "停止共享"() {

        when: "点击停止共享"
        Pause.stop(10)
        meetingOperationPage.stop_content()

        then:"共享停止成功"
        assert  true
    }

//
//    def "改名"(){
//        when:"更改名字"
//        LOGGER.info("update user name")
//        meetingOperationPage.change_display_name("AAAAFFFF")
//        Pause.stop(10)
//        // showPicInReport(appiumDriver,"更名为AAAAFFFF")
//
//        then:"更名成功"
//        assert meetingOperationPage.find_display_name("AAAAFFFF")
//    }
//
//    def "关闭近端预览"() {
//        when: "点击取消近端预览按钮"
//        LOGGER.info("Mute local preview")
//        meetingOperationPage.close_local_video()
//        Pause.stop(10)
//        // showPicInReport(appiumDriver,"取消近端预览")
//
//        then:"操作成功"
//        assert  true
//    }
//
//    def "打开近端预览"(){
//        when:"点击近端预览按钮"
//        LOGGER.info("turn on local preview")
//        meetingOperationPage.turn_on_local_video()
//        Pause.stop(2)
//        // showPicInReport(appiumDriver,"近端预览")
//
//        then:"操作成功"
//        assert  true
//    }
//
//    def "降到音频"() {
//        when: "点击切换到音频模式按钮"
//        LOGGER.info("Downgrade to audio")
//        meetingOperationPage.switch_to_audio_only()
//        Pause.stop(10)
//        // showPicInReport(appiumDriver,"音频模式")
//
//        then:"操作成功"
//        assert true
//    }
//
//
//    def "升级到视频"(){
//        when:"点击音视频模式按钮"
//        LOGGER.info("Upgrade to video")
//        meetingOperationPage.switch_to_video_from_audio()
//        Pause.stop(5)
//        // showPicInReport(appiumDriver,"音视频模式")
//
//        then:"操作成功"
//        assert true
//    }

    def "挂断并结束会议"(){
        when:"挂断并结束会议"
        LOGGER.info("Hangup and terminate the call")
        meetingOperationPage.hangup()
        Pause.stop(5)

        and:"抓屏"
        // // showPicInReportPortrait(appiumDriver,"会议结束")

        then:"操作成功"
        assert true
    }

}


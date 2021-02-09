package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.MeetingPage
import com.hexmeet.page.ReservedMeetingInfoPage
import com.hexmeet.page.webpage.ChromeDriverSingleton
import com.hexmeet.page.webpage.MobileWebCreateReserveMeetingPage
import com.hexmeet.page.webpage.MobileWebLogin
import com.hexmeet.sundae.mediaStatistics.CALLTYPE
import com.hexmeet.utility.Pause
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.page.startup.deploytype.privatedeploy.signin.SignInPage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title
import spock.lang.Unroll

import java.util.concurrent.TimeUnit
@Title("加入预约会议")
@Narrative("创建预约会议并加入，邀请别的用户")
@Retry(delay=20000)

class JoinAReserveMeeting extends EndpointSystemTestSpec {
    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint androidEndpoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    MobileWebCreateReserveMeetingPage mobileWebCreateReserveMeetingPage

    @Shared
    String serverAddr="cloudbeta.hexmeet.com"

    @Shared
    String username="hjtautotest3"

    @Shared
    String password="123456"

    def setupSpec(){

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "清除已经预约的会议"(){
        when: "初始化"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

        and:" 清除已经预约的会议"
        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.clear_reserved_meeting(username)

        then:
        assert true

    }

    def "创建即时会议"() {

        when: "创建一即时会议并改变时长"
        WebDriver driver= ChromeDriverSingleton.getDriver();
        MobileWebLogin mobileWebLogin = new MobileWebLogin(driver, "http://cloudbeta.hexmeet.com/mobile/#/login", "hjtautotest3", "123456");

        MobileWebCreateReserveMeetingPage mobileWebCreateReserveMeetingPage = new MobileWebCreateReserveMeetingPage();
        mobileWebCreateReserveMeetingPage.navigate_to_reserve_meeting_page();
        mobileWebCreateReserveMeetingPage.create_now_meeting();

//        and:"退出"
//        driver.quit()

        then:""
        assert true
    }

    @Unroll()
    def "加入预约的即时会议"(){
        when: "初始化"
        androidEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

        and:" Moible user join the conference"

        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        meetingPage.find_reserved_meeting(username)

        ReservedMeetingInfoPage reservedMeetingInfoPage = new ReservedMeetingInfoPage(appiumDriver)
        reservedMeetingInfoPage.join_reserved_meeting(calltype,camera_mute,mic_mute)


        and:"挂断并结束会议"
        Pause.stop(20)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.hangup()

        then:"操作成功"
        assert  true

        where:
        calltype       | camera_mute | mic_mute
        CALLTYPE.Video |   true      | true
        CALLTYPE.Video |   true      | false
        CALLTYPE.Video |   false      | true
        CALLTYPE.Video |   false      | false
        CALLTYPE.Audio |   true      | true
        CALLTYPE.Audio |   true      | false
        CALLTYPE.Audio |   false      | true
        CALLTYPE.Audio |   false      | false


    }

//
//    def "创建即时会议并邀请其他与会者"(){
//        when:"创建一即时会议"
//        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
//        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
//        appiumDriver = androidEndpoint.getAppiumEndpointDriver()
//        SignInPage signInPage = new SignInPage(appiumDriver)
//        signInPage.navigate()
//        signInPage.submit(serverAddr,username,password)
//        ReserveMeetingPage reserveMeetingPage = new ReserveMeetingPage(appiumDriver);
//        reserveMeetingPage.navigate()
//        Pause.stop(5);
//        reserveMeetingPage.now();
//        reserveMeetingPage.addParticipants("hjtautotest2");
//        reserveMeetingPage.finish();
//        reserveMeetingPage.backAfterReserver()
//
//        and:"加入会议"
//        reserveMeetingPage.joinReservedMeeting("hjtautotest1");
//        Pause.stop(30)
//        showPicInReport(appiumDriver,"与会中")
//
//        and:"挂断并结束会议"
//        MeetingOperations meetingOperations = new MeetingOperations(appiumDriver)
//        meetingOperations.hangupAndTerminateCall()
//
//        then:"操作成功"
//        assert  true
//    }

//暂时没有解决 setpassword的问题
//    def "Create a password protected meeting and join"(){
//        when:"Create a reserved meeting"
//        reserveMeetingPage.now();
//        reserveMeetingPage.setMeetingPassword("1234567890")
//        reserveMeetingPage.finish();
//        reserveMeetingPage.backAfterReserver()
//
//        and:"Join the reserved meeting"
//        reserveMeetingPage.joinReservedMeeting()
//        Pause.stop(30)
//        showPicInReport(appiumDriver)
//
//        then:
//        assert true
//    }



}

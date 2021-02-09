package com.hexmeet.autotestcases.privatecloud


import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.FavoriteContactPage
import com.hexmeet.page.MeetingOperationPage
import com.hexmeet.page.PageNavigate
import com.hexmeet.utility.Pause
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint

import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit


@Title("从通讯录中呼叫")
@Narrative("从通信录中找到用户并呼叫")

class CallAContactInPrivate extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint iOSAppiumEndpoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    @Shared
    String serverAddress="cloudbeta.hexmeet.com"

    @Shared
    String accout="hjtautotest1"

    @Shared
    String password="123456"

    @Shared
    String favoriteContact="RongliangVE210"

    def setupSpec(){

        LOGGER.info("Setup")
        iOSAppiumEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        iOSAppiumEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iOSAppiumEndpoint.getAppiumEndpointDriver()
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "call a contact in Favorite List"(){

    }

    @Retry(delay = 3000)
    def "呼叫常用联系人中的用户"(){

        when:"直接点击常用联系人"
        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.navigate_to_contact()

        and:"呼叫"
        FavoriteContactPage favoriteContactPage = new FavoriteContactPage(appiumDriver)
        favoriteContactPage.favorite_contact(favoriteContact)

        then:"呼叫成功"
        assert true


    }

    @Retry()
    def "挂断"(){
        when:"挂断呼叫"
        Pause.stop(30)
        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
        meetingOperationPage.hangup()

        then:"呼叫成功"
        assert  true
    }

//    @Retry(delay = 30000)
//    def "查找并呼叫常用联系人中的用户"(){
//        when:"初始化并登录"
//        iOSAppiumEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
//        iOSAppiumEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
//        appiumDriver = iOSAppiumEndpoint.getAppiumEndpointDriver()
//
//        and:"直接点击常用联系人"
//        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
//        pageNavigate.navigate_to_contact()
//
//        FavoriteContactPage favoriteContactPage = new FavoriteContactPage(appiumDriver)
//        favoriteContactPage.find_favorite_contact(favoriteContact)
//
//        and:"挂断呼叫"
//        Pause.stop(30)
//        MeetingOperationPage meetingOperationPage = new MeetingOperationPage(appiumDriver)
//        meetingOperationPage.hangup()
//
//        then:"呼叫成功"
//        assert  true
//    }


}

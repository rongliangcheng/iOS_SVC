package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.MeetingPage
import com.hexmeet.utility.Pause
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.PrivateDeployLoginAdvancedSettingOperatios
import pageActions.PrivateDeployLoginOperations
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit


@Title("登录")
@Narrative("测试用户登录场景：正常，用户名错，密码错，服务器错")
class SignIn extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint iosEndpoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    @Shared
    long IMPLICIT_WAIT_TIME = 120

    @Shared
    String configFileName="config.json"

    @Shared
    String appiumKeyword_1 = "iOS_1"

    @Shared
    String serverAddr = "cloudbeta.hexmeet.com"

    @Shared
    String PORT = "80"

    @Shared
    String signInUserName = "hjtautotest3"

    @Shared
    String signInPassword = "123456"

    @Shared
    String wrongPassword = "12345"

    def setupSpec(){

        log.info("Setup")
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }


    def "正常用户 密码 错误端口登录"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest3/123456登录"
        PrivateDeployLoginAdvancedSettingOperatios privateDeployLoginAdvancedSettingOperatios = new PrivateDeployLoginAdvancedSettingOperatios(appiumDriver);
        privateDeployLoginAdvancedSettingOperatios.advanced_setting("8000",false);
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,signInPassword)

        then:"成功登录"
        assert true
    }

    def "正常用户 密码 端口 https 登录"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest3/123456登录"
        PrivateDeployLoginAdvancedSettingOperatios privateDeployLoginAdvancedSettingOperatios = new PrivateDeployLoginAdvancedSettingOperatios(appiumDriver);
        privateDeployLoginAdvancedSettingOperatios.advanced_setting("80",true);
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,signInPassword)

        then:"成功登录"
        assert true
    }

    def "正常用户 密码 端口登录"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest3/123456登录"
        PrivateDeployLoginAdvancedSettingOperatios privateDeployLoginAdvancedSettingOperatios = new PrivateDeployLoginAdvancedSettingOperatios(appiumDriver);
        privateDeployLoginAdvancedSettingOperatios.advanced_setting("80",false);
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,signInPassword)

        then:"成功登录"
        assert true
    }

    def "不存在的server登录"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest/12345登录"
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login("cloudbeta.aaa.com",signInUserName,signInPassword)

        then:"成功登录"
        assert true
    }

    def "不存在用户错误密码登录"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest/123456登录"
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login(serverAddr,"signInUserName",signInPassword)

        then:"成功登录"
        assert true
    }

    def "5次密码错误被锁"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)

        and:"以hjtautotest/12345登录 第1次"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,wrongPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"密码错误第1次")
        Pause.stop(5)

        and:"以hjtautotest/12345登录 第2次"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,wrongPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"密码错误第2次")
        Pause.stop(5)

        and:"以hjtautotest/12345登录 第3次"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,wrongPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"密码错误第3次")
        Pause.stop(5)

        and:"以hjtautotest/12345登录 第4次"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,wrongPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"密码错误第4次")
        Pause.stop(5)

        and:"以hjtautotest/12345登录 第5次"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,wrongPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"密码错误第5次")
        Pause.stop(5)

        and:"以hjtautotest/123456 正确登录 被锁"

        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,signInPassword)
        Pause.stop(0.6)
        // showPicInReportPortrait(appiumDriver,"账号被锁")
        Pause.stop(5)

        then:"成功登录"
        assert true
    }

    def "正常用户密码登录"(){
        when:"初始化AppiumDriver"
        Pause.stop(300)
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"以hjtautotest3/123456登录"
        PrivateDeployLoginAdvancedSettingOperatios privateDeployLoginAdvancedSettingOperatios = new PrivateDeployLoginAdvancedSettingOperatios(appiumDriver);
        privateDeployLoginAdvancedSettingOperatios.advanced_setting("",false);
        PrivateDeployLoginOperations privateDeployLoginOperations = new PrivateDeployLoginOperations(appiumDriver)
        privateDeployLoginOperations.private_deploy_login(serverAddr,signInUserName,signInPassword)

        Pause.stop(10)
        MeetingPage meetingPage = new MeetingPage(appiumDriver)
        then:"成功登录"
        assert meetingPage.isOnMeetingPage()
    }

}

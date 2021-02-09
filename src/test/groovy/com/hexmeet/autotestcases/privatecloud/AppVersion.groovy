package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.page.AboutPage
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.PrivateDeployLoginPage
import com.hexmeet.utility.Pause
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.PageNavigateOperations
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("版本信息")
@Narrative("获取App版本")

class AppVersion extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    IOSAppiumEndpoint iosEndpoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    def setupSpec(){

        LOGGER.info("Setup")

        iosEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        PrivateDeployLoginPage privateDeployLoginPage = new PrivateDeployLoginPage(appiumDriver);
        if( privateDeployLoginPage.onPrivateDeployLoginPage){
            privateDeployLoginPage.login_submit()
        }
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }


    def "获取版本"(){
        when:"到达about页面"
        Pause.stop(10)
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_about()

        and:"获取版本信息"
        AboutPage aboutPage = new AboutPage(appiumDriver)
        println(aboutPage.getVersion())

        then:"版本获取成功"
        assert true

    }

}

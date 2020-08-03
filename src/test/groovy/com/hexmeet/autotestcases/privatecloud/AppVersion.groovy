package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.Utility.Pause
import com.hexmeet.Utility.UIElement
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.pageobject.common.CallAContactInStructure
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.about.PrivateCloudAboutPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.UserPrivateMainPage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Narrative
import spock.lang.Retry
import spock.lang.Shared
import spock.lang.Title
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

@Title("App版本")
@Narrative("获取App版本")

class AppVersion extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    String version

    def setupSpec(){

        LOGGER.info("Setup")

        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }


    def "app版本"(){
        when:"版本版本"
        PrivateCloudAboutPage privateCloudAboutPage = new PrivateCloudAboutPage(appiumDriver)
        privateCloudAboutPage.navigate()
        version = privateCloudAboutPage.getVersion()
        log.info(version)
        showPicInReportPortrait(appiumDriver,"版本信息")

        def filePath="D:\\Dev\\workspace\\Jenkins\\workspace\\HJT_SVC_Android\\build\\version.txt"
        File file = new File(filePath)
        file.text=version

        then:"获得版本"
        assert true

    }


}

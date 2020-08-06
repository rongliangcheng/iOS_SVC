package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.Utility.Pause
import com.hexmeet.Utility.UIElement
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.pageobject.common.CallAContactInStructure
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.about.PrivateCloudAboutPage
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.UserPrivateMainPage
import com.hexmeet.sundae.build.AppBuild
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

@Title("版本升级")
@Narrative("获取App版本")

class AppVersion extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    PrivateCloudAboutPage privateCloudAboutPage;

    @Shared
    String version

    @Shared
    boolean versionMatch = true

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


    def "版本升级"(){
        when:"当前App版本信息"
        privateCloudAboutPage = new PrivateCloudAboutPage(appiumDriver)
        privateCloudAboutPage.navigate()
        version = privateCloudAboutPage.getVersion()
        log.info(version)
        showPicInReportPortrait(appiumDriver,"版本信息")


        AppBuild appBuild = new AppBuild();
        String buildVersion=appBuild.getVersion();
        reportInfo("Jenkins Build版本信息："+appBuild.buildName)

        and:"Jenkins build版本信息${buildVersion}"

        if(version != buildVersion){
            appBuild.downloadBuildFile();
            appiumDriver.installApp(appBuild.getOutputBuildPath());

            Pause.stop(30)

            androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
            androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
            appiumDriver = androidEndpoint.getAppiumEndpointDriver()
            privateCloudAboutPage = new PrivateCloudAboutPage(appiumDriver)
            privateCloudAboutPage.navigate()
            String newVersion = privateCloudAboutPage.getVersion()
            showPicInReportPortrait(appiumDriver,"新版本信息")
            versionMatch = newVersion == buildVersion
            version=newVersion;
        }

        def filePath="D:\\Dev\\workspace\\Jenkins\\workspace\\HJT_SVC_Android\\build\\version.txt"
        File file = new File(filePath)
        file.text=version

        then:"版本升级成功"
        assert versionMatch

    }




}

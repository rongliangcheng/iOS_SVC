package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.Utility.Pause
import com.hexmeet.Utility.UIElement
import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.pageobject.common.ReserveMeetingPage
import com.hexmeet.pageobject.common.CallAContactInStructure
import com.hexmeet.pageobject.startup.deploytype.privatedeploy.signin.userprivatemainPage.UserPrivateMainPage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared

import java.util.concurrent.TimeUnit

class CallAContactInPrivate extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint androidEndpoint = new AppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())

    @Shared
    ReserveMeetingPage reserveMeetingPage

    @Shared
    String serverAddress="cloudbeta.hexmeet.com"

    @Shared
    String accout="hjtautotest1"

    @Shared
    String password="123456"

    def setupSpec(){

        LOGGER.info("Setup")
        androidEndpoint.initialAppiumEndpointfromJson("config.json","Android_1")
        androidEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        appiumDriver = androidEndpoint.getAppiumEndpointDriver()

        UserPrivateMainPage userPrivateMainPage = new UserPrivateMainPage(appiumDriver)
        userPrivateMainPage.navigate(serverAddress,accout,password)
        userPrivateMainPage.contacts()
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }

    def "call a contact in Favorite List"(){

    }

    def "Call a contact in a structure"(){
        when:"Find a user in company structure and call"
        CallAContactInStructure callAContactInStructure = new CallAContactInStructure(appiumDriver)
        callAContactInStructure.findAContactInStructure("hjtautotest2")
        Pause.stop(3)
        showPicInReport(appiumDriver,"Find the contact:");

        and:"Call the contact"
        callAContactInStructure.callTheContact()
        Pause.stop(5)
        showPicInReport(appiumDriver,"Call to a contact");
        Pause.stop(30)

        then:
        assert  UIElement.byElementIsExist(appiumDriver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.view.View[1]"))

    }


}

//package com.hexmeet.autotestcases.login
//
//import com.hexmeet.utility.Pause
//import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
//import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
//import com.hexmeet.page.common.UICommon
//import com.hexmeet.page.startup.deploytype.publicdeploy.signin.PublicSignIn
//import io.appium.java_client.AppiumDriver
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//
//import spock.lang.Shared
//
//import java.util.concurrent.TimeUnit
//
//class Login extends EndpointSystemTestSpec{
//
//    @Shared
//    AppiumDriver driver
//
//    @Shared
//    IOSAppiumEndpoint iosEndpoint = new IOSAppiumEndpoint()
//
//    @Shared
//    Logger log = LoggerFactory.getLogger(this.getClass())
//
//
//
//    def setupSpec(){
//
//    }
//
//    def cleanupSpec(){
////        if(iosEndpoint.getAppiumEndpointDriver() != null){
////                iosEndpoint.getAppiumEndpointDriver().quit();
////        }
//    }
//
//    def setup(){
//
//    }
//
//    def cleanup(){
//
//    }
//
//    def "Login hjt with wrong account"(){
//        when: "Sign in with wrong account is not permitted"
//        iosEndpoint.initialAppiumEndpointfromJson("config.json","iOS_1")
//        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
//        driver = iosEndpoint.getAppiumEndpointDriver()
//        sleep(3000)
//
//        driver.findElementByAccessibilityId("预约会议").click()
//
//        Set<String> contextNames = driver.getContextHandles();
//
//        System.out.println(contextNames.toString());
//
//        for (String contextName : contextNames) {
//            if (contextName.contains("NATIVE_APP")) {
//                log.info("Reaching to Native App", true);
//                // print(driver.context(contextName));
//
//                print(driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView"))
//
//            }
//            else{
//                log.info("Not found", true);
//            }
//        }
//
////        Set<String> contextNames = driver.getContextHandles();
////        print(contextNames)
////        String setContext = contextNames.toArray()[1].toString();
////        print(driver.context(setContext));// set context to WEBVIEW_com.my.package
//
////        PublicSignIn publicSignIn = new PublicSignIn(driver);
////        publicSignIn.navigate()
////        3.times {
////            LOGGER.info("Fill in wrong account and password ")
////            publicSignIn.fillInAccount("ronglian")
////            publicSignIn.fillInPassword("rongl")
////            publicSignIn.signInWithWrongUsernamePassword()
////            UICommon.detectToast(driver)
////            // showPicInReportortrait(driver,"Toast")
////            Pause.stop(1)
////        }
//
//        then:"quit"
//        assert true
//    }
//
////    def "Login hjt with wrong password"(){
////
////        when: "Sign in with wrong password 5 times, it will lock the user for 5 minutes"
////        iosEndpoint.initialAppiumEndpointfromJson("config.json","Ios_1")
////        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
////        driver = iosEndpoint.getAppiumEndpointDriver()
////        PublicSignIn publicSignIn = new PublicSignIn(driver);
////        publicSignIn.navigate()
////        5.times {
////            LOGGER.info("Fill in wrong password")
////            publicSignIn.fillInAccount("rongliang")
////            publicSignIn.fillInPassword("rongl")
////            publicSignIn.signInWithWrongUsernamePassword()
////            UICommon.detectToast(driver)
////            showPicInReportortrait(driver,"Toast")
////            Pause.stop(1.5)
////        }
////
////        Pause.stop(5)
////
////        then:"quit"
////        assert true
////    }
////
////    def "Login hjt System successfully after 5 minutes"(){
////
////
////        when:"Sign in the public cloud with correct password"
////        LOGGER.info("Sleep 5 minutes")
////        Pause.stop(300)
////        LOGGER.info("5 minutes over")
////        iosEndpoint.initialAppiumEndpointfromJson("config.json","Ios_1")
////        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
////        driver = iosEndpoint.getAppiumEndpointDriver()
////        PublicSignIn publicSignIn = new PublicSignIn(driver);
////        publicSignIn.navigate()
////        publicSignIn.fillInAccount("rongliang")
////        publicSignIn.fillInPassword("rongliang")
////        publicSignIn.signIn()
////        showPicInReportortrait(driver,"Sign in")
////
////        then:"sign in successfully"
////        assert true
////
////    }
//
//}

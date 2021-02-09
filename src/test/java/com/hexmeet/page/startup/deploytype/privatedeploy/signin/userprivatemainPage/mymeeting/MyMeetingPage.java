package com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage.mymeeting;

import com.hexmeet.utility.Pause;
import com.hexmeet.utility.UIElement;
import com.hexmeet.page.PageObjectBase;
import com.hexmeet.page.startup.deploytype.privatedeploy.signin.userprivatemainPage.UserPrivateMainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMeetingPage implements PageObjectBase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    AppiumDriver appiumDriver;

    @Override
    public void navigate() {
        logger.info("Navigate");
        UserPrivateMainPage userPrivateMainPage = new UserPrivateMainPage(appiumDriver);
        userPrivateMainPage.navigate();
        userPrivateMainPage.meeting();
    }

    @Override
    public WebElement findElementByXPath(String xpath) {
        return appiumDriver.findElementByXPath(xpath);
    }

    @Override
    public WebElement findElementByAccessibilityId(String id) {
        return appiumDriver.findElementByAccessibilityId(id);
    }



    public MyMeetingPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(String serveraddr,String accout,String password){
        logger.info("Navigate with"+serveraddr);
        UserPrivateMainPage userPrivateMainPage = new UserPrivateMainPage(appiumDriver);
        userPrivateMainPage.navigate(serveraddr,accout,password);
        userPrivateMainPage.meeting();
    }

    public void mymeetingpage(){
        logger.info("mymeetingpage");
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeStaticText[@name=\"我的会议室\"]").click();
    }

    public void joinTheMeeting(String password){
        logger.info("join the meeting");
        Pause.stop(0.5);
        findElementByAccessibilityId("加入会议").click();
        Pause.stop(4);
        if(UIElement.byElementIsExist(appiumDriver, By.xpath("//XCUIElementTypeStaticText[@name=\"会议密码\"]"))) {
            findElementByXPath("//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").sendKeys("12345");
            findElementByXPath("//XCUIElementTypeStaticText[@name=\"加入\"]").click();
            Pause.stop(1.5);
        }
    }

    public void meetingSettings(String password, boolean muteWhenJoin,boolean allowAnonymousUser,boolean onlyHosterCanActivateMeeting,boolean allowOthersReserveMeeting,boolean groupSelectionBoolean){
        logger.info("Set meeting options");
        Pause.stop(0.5);
        findElementByAccessibilityId("会议室设置").click();

        //password
        Pause.stop(3);
        findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeTextField").clear();
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeTextField").sendKeys(password);
        findElementByAccessibilityId("完成").click();

        if(muteWhenJoin)
            findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[6]/XCUIElementTypeSwitch").click();

        if(allowAnonymousUser)
            findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[8]/XCUIElementTypeSwitch").click();

        if(onlyHosterCanActivateMeeting)
            findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[10]/XCUIElementTypeSwitch").click();

        if(allowAnonymousUser)
            findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[12]/XCUIElementTypeSwitch").click();

        if(groupSelectionBoolean)
            groupSelection();

        findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeOther[16]").click();
    }

    private void groupSelection(){
        logger.info("select group");
        Pause.stop(0.5);
        findElementByAccessibilityId("选择群组").click();
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeStaticText[@name=\"zhangjs的会议群组----\"]").click();

        Pause.stop(0.5);
        //remove the group selection
        findElementByXPath("(//XCUIElementTypeStaticText[@name=\"×\"])[1]").click();
    }

    public void muteUmuteCamera(){
        logger.info("");
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeSwitch[1]").click();
    }

    public void muteUmuteAudio(){
        logger.info("");
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeOther[@name=\"会捷通\"]/XCUIElementTypeSwitch[2]").click();
    }
}

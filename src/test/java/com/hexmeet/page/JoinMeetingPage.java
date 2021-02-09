package com.hexmeet.page;

import com.hexmeet.appiumendpoint.AppiumEndpoint;
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.concurrent.TimeUnit;

public class JoinMeetingPage {
    private AppiumDriver driver;

    //xpath
    private String input_meeting_number_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
    private String video_call_xpath = "//XCUIElementTypeButton[@name=\"视频加入\"]";
    private String audio_call_xpath = "//XCUIElementTypeButton[@name=\"音频加入\"]";

    private String camera_mute_oncall_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeSwitch";
    private String mic_mute_oncall_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch";

    private String password_of_meeting_xpath = "//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";
    private String join_button_after_password_xpath = "//XCUIElementTypeStaticText[@name=\"加入\"]";
    private String cancel_button_after_password_xpath = "//XCUIElementTypeStaticText[@name=\"取消\"]";



    public JoinMeetingPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    //
    public void input_meeting_number(String number){
        Pause.stop(2);
        driver.findElementByXPath(input_meeting_number_xpath).clear();
        driver.findElementByXPath(input_meeting_number_xpath).sendKeys(number);
    }

    public void mute_camera_oncall(Boolean flag){
        Pause.stop(1);
        driver.findElementByXPath(camera_mute_oncall_xpath).click();
    }

    public void mute_audio_oncall(Boolean flag){
        Pause.stop(1);
        driver.findElementByXPath(mic_mute_oncall_xpath).click();
    }

    public void video_call(){
        Pause.stop(1);
        driver.findElementByXPath(video_call_xpath).click();
    }

    public void audio_call(){
        Pause.stop(1);
        driver.findElementByXPath(audio_call_xpath).click();
    }

    public void input_password(String password){
        Pause.stop(2);
        driver.findElementByXPath(password_of_meeting_xpath).sendKeys(password);
    }

    public void join_with_password(){
        Pause.stop(1);
        driver.findElementByXPath(join_button_after_password_xpath).click();
    }

    public void cancel_input_password(){
        Pause.stop(1);
        driver.findElementByXPath(cancel_button_after_password_xpath).click();
    }


    public static void main(String[] args) {
        IOSAppiumEndpoint iosEndpoint = new IOSAppiumEndpoint();
        iosEndpoint.initialAppiumEndpointfromJson("config.json", "iOS_1");
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        IOSDriver driver = iosEndpoint.getAppiumEndpointDriver();

        PageNavigate pageNavigate = new PageNavigate(driver);
        pageNavigate.navigate_to_join_meeting();

        JoinMeetingPage joinMeetingPage = new JoinMeetingPage(driver);
        joinMeetingPage.input_meeting_number("13910001001");
        joinMeetingPage.video_call();
        joinMeetingPage.input_password("123456");
        joinMeetingPage.join_with_password();
    }

}

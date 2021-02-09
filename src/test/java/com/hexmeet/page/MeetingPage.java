package com.hexmeet.page;

import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MeetingPage {
    private AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String meeting_page_xpath = "//XCUIElementTypeStaticText[@name=\"会议\"]";

    public MeetingPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void find_reserved_meeting(String name){
        Pause.stop(1);
        driver.findElementByXPath("//*[contains(@name, '"+name+"')]").click();
    }

    public void clear_reserved_meeting(String name){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        while(driver.findElementsByXPath("//*[contains(@name, '"+name+"')]").size() != 0){
            driver.findElementByXPath("//*[contains(@name, '"+name+"')]").click();

            ReservedMeetingInfoPage reservedMeetingInfoPage = new ReservedMeetingInfoPage(driver);
            try{
                reservedMeetingInfoPage.terminate_reservered_ongoing_meeting();
            } catch (Exception e){
                reservedMeetingInfoPage.delete_unstarted_meeting();
            }
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    public boolean isOnMeetingPage() {
        log.info(" Check whether it is on meeting page");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            driver.findElementByXPath(meeting_page_xpath);
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return true;
    }
}

package com.hexmeet.page.webpage;

import com.hexmeet.utility.Pause;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileWebCreateReserveMeetingPage {
    private WebDriver driver;

    public MobileWebCreateReserveMeetingPage(){
        driver = ChromeDriverSingleton.getDriver();
    }
    public void navigate_to_reserve_meeting_page(){
        Pause.stop(3);
        if ( driver.findElements(By.cssSelector("div.meet-head-nav > a")).size() == 2)
            driver.findElement(By.cssSelector("div.meet-head-nav > a:nth-child(2)")).click();
        else
            driver.findElement(By.className("icon-meet-order")).click();

        Pause.stop(3);
    }

    public void choose_now(){
        Pause.stop(1);
        driver.findElement(By.cssSelector("label.yd-checkbox")).click();
        Pause.stop(1);
    }

    public void choose_duration(){
        Pause.stop(1);
        driver.findElement(By.cssSelector("div[class='yd-datetime-input']")).click();
        Pause.stop(3);
        driver.findElement(By.linkText("确定")).click();
    }

    public void commit(){
        Pause.stop(1);
        driver.findElement(By.cssSelector("i[class='icon right-btn']")).click();
        Pause.stop(1);
    }

    public void create_now_meeting(){
        choose_now();
        commit();
    }

    public void clear_reserved_meeting(String username){
        Pause.stop(3);
//        while ( driver.findElements(By.cssSelector("div.item-title")).size() != 0) {
//            driver.findElement(By.cssSelector("div.item-title")).click();
//            Pause.stop(3);
//            driver.findElement(By.cssSelector("i.icon-f-close")).click();
//            Pause.stop(2);
//            driver.findElement(By.linkText("确定")).click();
//            Pause.stop(3);
//        }
        System.out.println("Here *");
        while ( driver.findElements(By.xpath("//item-title[contains(text(),'hjtautotest3')]")).size() != 0){
            System.out.println("delete items");
            driver.findElement(By.xpath("//item-title[contains(text(),'"+username+"')]")).click();
        }
    }

    public static void main(String[] args) {
        WebDriver driver = ChromeDriverSingleton.getDriver();
        MobileWebLogin mobileWebLogin = new MobileWebLogin(driver,"http://cloudbeta.hexmeet.com/mobile/#/login","hjtautotest3","123456");

        MobileWebCreateReserveMeetingPage mobileWebCreateReserveMeetingPage = new MobileWebCreateReserveMeetingPage();
        // mobileWebCreateReserveMeetingPage.navigate_to_reserve_meeting_page();
        // mobileWebCreateReserveMeetingPage.create_now_meeting();
        Pause.stop(3);
        mobileWebCreateReserveMeetingPage.clear_reserved_meeting("hjtautotest3");
        driver.quit();
    }

}

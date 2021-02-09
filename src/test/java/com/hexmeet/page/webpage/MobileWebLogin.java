package com.hexmeet.page.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileWebLogin {

    public MobileWebLogin(WebDriver driver, String url, String userName, String password){
        driver.get(url);
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.className("login-btn")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = ChromeDriverSingleton.instance().getDriver();
        MobileWebLogin mobileWebLogin = new MobileWebLogin(driver,"http://cloudbeta.hexmeet.com/mobile/#/login","hjtautotest4","123456");
        WebDriver driver1 = ChromeDriverSingleton.getDriver();
        System.out.println(driver);
        System.out.println(driver1);
        //

    }
}

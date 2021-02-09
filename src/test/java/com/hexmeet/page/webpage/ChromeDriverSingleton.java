package com.hexmeet.page.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSingleton {
    private static ChromeDriverSingleton INSTANCE = new ChromeDriverSingleton();
    private static WebDriver driver;
    private ChromeDriverSingleton(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver=new ChromeDriver();
    }
    public static ChromeDriverSingleton instance(){
        return INSTANCE;
    }
    public static WebDriver getDriver(){
        if(instance().driver == null){
            INSTANCE = new ChromeDriverSingleton();
        }
        return instance().driver;
    }
}

package com.hexmeet.appiumendpoint;

import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumEndpoint {
    private AppiumDriver appiumDriver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    Logger log = LoggerFactory.getLogger(this.getClass());

    //Initial Appium Endpoint manually
    public void initialAppiumEndpoint(String platformName,String platformVersion,
                                      String deviceName, String appPackage,String appActivity) {
        StringBuilder stringBuilder = new StringBuilder("Initial Appium Endpoint for ")
                .append(platformName)
                .append(":")
                .append(deviceName)
                .append("\n");
        log.info(stringBuilder.toString());
        setAppiumCapabilities(platformName,platformVersion,deviceName,appPackage,appActivity);
        try {
            appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void initialAppiumEndpoint(String platformName,String platformVersion,
                                      String deviceName, String appPackage,String appActivity,String port) {
        StringBuilder stringBuilder = new StringBuilder("Initial Appium Endpoint for ")
                .append(platformName)
                .append(":")
                .append(deviceName)
                .append(" at port:")
                .append(port)
                .append("\n");
        log.info(stringBuilder.toString());
        setAppiumCapabilities(platformName,platformVersion,deviceName,appPackage,appActivity);
        try {
            appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    };

    //Initial Appium Endpoint from config.json file
    public void initialAppiumEndpoint(String keyword) {
        log.info("Initial Appium endpoint from config.json");
        File file=new File(AppiumEndpoint.class.getClassLoader().getResource("config.json").getPath());
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            log.info(content);
            JSONObject jsonObject = JSONObject.parseObject(content);
            initialAppiumEndpoint(jsonObject.getJSONObject(keyword).getString("platformName"),
                    jsonObject.getJSONObject(keyword).getString("platformVersion"),
                    jsonObject.getJSONObject(keyword).getString("deviceName"),
                    jsonObject.getJSONObject(keyword).getString("appPackage"),
                    jsonObject.getJSONObject(keyword).getString("appActivity"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initialAppiumEndpoint(String keyword,String port) {
        log.info("Initial Appium endpoint from config.json");
        File file=new File(AppiumEndpoint.class.getClassLoader().getResource("config.json").getPath());
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            log.info(content);
            JSONObject jsonObject = JSONObject.parseObject(content);
            initialAppiumEndpoint(jsonObject.getJSONObject(keyword).getString("platformName"),
                    jsonObject.getJSONObject(keyword).getString("platformVersion"),
                    jsonObject.getJSONObject(keyword).getString("deviceName"),
                    jsonObject.getJSONObject(keyword).getString("appPackage"),
                    jsonObject.getJSONObject(keyword).getString("appActivity"),port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private void setAppiumCapabilities(String platformName,String platformVersion,
                                 String deviceName, String appPackage,String appActivity){
        log.info("Set appium endpoint capabilities");
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
    }


    public AppiumDriver getAppiumEndpointDriver(){
        return appiumDriver;
    };

}

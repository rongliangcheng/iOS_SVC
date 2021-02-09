package com.hexmeet.appiumendpoint;

import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class IOSAppiumEndpoint implements AppiumEndpoint{
    private IOSDriver iosdriver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    Logger log = LoggerFactory.getLogger(this.getClass());

    //Initial Appium Endpoint manually

    public void initialAppiumEndpointfromJson(String fileName, String keyWord) {
        StringBuilder stringBuilder = new StringBuilder("Initial iOS Appium Endpoint ...");
        log.info(stringBuilder.toString());
        setAppiumCapabilities(fileName,keyWord);
        try {
            iosdriver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public void initialAppiumEndpoint(String fileName,String keyWord,String port) {
        StringBuilder stringBuilder = new StringBuilder("Initial iOS Appium Endpoint ");
        log.info(stringBuilder.toString());
        setAppiumCapabilities(fileName,keyWord);
        try {
            iosdriver = new IOSDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    };

    //Initial Appium Endpoint from config.json file

    public void setAppiumCapabilities(String fileName,String keyword){
        log.info("Initial iOS Appium endpoint from config.json");
        File file=new File(IOSAppiumEndpoint.class.getClassLoader().getResource(fileName).getPath());
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            log.info(content);
            JSONObject jsonObject = JSONObject.parseObject(content);

            Set<String> keySet = jsonObject.getJSONObject(keyword).keySet();

            for(String key: keySet){
                log.info("set capacity of "+key+":"+jsonObject.getJSONObject(keyword).getString(key));
                capabilities.setCapability(key,jsonObject.getJSONObject(keyword).getString(key));
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public IOSDriver getAppiumEndpointDriver(){
        return iosdriver;
    };

}

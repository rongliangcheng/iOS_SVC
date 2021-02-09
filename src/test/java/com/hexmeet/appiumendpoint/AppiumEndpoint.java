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
import java.util.Set;

public interface AppiumEndpoint {

    public void initialAppiumEndpointfromJson(String fileName, String keyWord) ;
    public void initialAppiumEndpoint(String fileName,String keyWord,String port);
    public void setAppiumCapabilities(String fileName,String keyword);
    public AppiumDriver getAppiumEndpointDriver();

}

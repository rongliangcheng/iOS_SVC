package com.hexmeet.performance;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

public class AppPerformanceCollector {

    private AppiumDriver driver;
    private File traceZip = new File("/Users/hexmeetqa/PerformanceResult/trace.zip");

    public AppPerformanceCollector(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void startPerRecord(){
        HashMap<String, Object> args = new HashMap<>();
        args.put("timeout", 60000);
        args.put("pid", "current");
        args.put("profileName", "Time Profiler");
        driver.executeScript("mobile: startPerfRecord", args);
    }

    public void stopPerRecord() throws IOException {
        HashMap<String, Object> args = new HashMap<>();
        args.put("profileName", "Time Profiler");
        String b64Zip = (String)driver.executeScript("mobile: stopPerfRecord", args);
        byte[] bytesZip = Base64.getMimeDecoder().decode(b64Zip);
        FileOutputStream stream = new FileOutputStream(traceZip);
        stream.write(bytesZip);
    }
}

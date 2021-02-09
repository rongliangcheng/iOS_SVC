package com.hexmeet.page;

import io.appium.java_client.AppiumDriver;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class MediaStatisticsPage {

    private AppiumDriver driver;
    private Document document;

    Logger log = LoggerFactory.getLogger(this.getClass());


    public MediaStatisticsPage(AppiumDriver appiumDriver){
        driver = appiumDriver;
        // log.info(driver.getPageSource());
         String page_source = driver.getPageSource();
        String fileName = "/tmp/pagesource.xml";
        try {
            File xmlfile = new File(fileName);
            PrintStream ps = new PrintStream(new FileOutputStream(xmlfile));
            ps.print(page_source);
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(fileName));
        } catch (Exception e){
        e.printStackTrace();
        }
    }

    public int getAudioSendRate(){
        String xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[3]/@name";
         List<Node> list = document.selectNodes(xpath);
         return Double.valueOf(list.toString().split("\"")[1]).intValue();
    }

    public int getVideoSendRate(int row){
        String xpath = "//XCUIElementTypeCell["+row+"]/XCUIElementTypeStaticText[3]/@name";
        List<Node> list = document.selectNodes(xpath);
        if(list.size() == 0)
            return 0;
        return Double.valueOf(list.toString().split("\"")[1]).intValue();
    }

    public String getVideoFrameRate(int row){
        String xpath = "//XCUIElementTypeCell["+row+"]/XCUIElementTypeStaticText[4]/@name";
        List<Node> list = document.selectNodes(xpath);
        if(list.size() == 0)
            return "0";
        return list.toString().split("\"")[1];
    }


    public static void main(String[] args) {
//        MediaStatisticsPage mediaStatisticsPage = new MediaStatisticsPage();
//        System.out.println(mediaStatisticsPage.getAudioSendRate());
//        System.out.println(mediaStatisticsPage.getVideoSendRate(3));
//        System.out.println(mediaStatisticsPage.getVideoFrameRate(3));
    }
}

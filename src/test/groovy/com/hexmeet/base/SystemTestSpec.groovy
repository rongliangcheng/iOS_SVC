package com.hexmeet.base

import com.hexmeet.Utility.LogUtils
import com.hexmeet.Utility.Pause
import com.hexmeet.appiumendpoint.AppiumEndpoint
import io.appium.java_client.AppiumDriver
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.IRunListener
import org.spockframework.runtime.model.ErrorInfo
import spock.lang.Specification

import java.text.SimpleDateFormat

class SystemTestSpec extends Specification{

    public static Logger LOGGER = LoggerFactory.getLogger(this.getClass())

    IRunListener onFailedListener

    def setup(){

        onFailedListener = new AbstractRunListener(){
            @Override
            void error(ErrorInfo error){
                try{
                    onFailed()
                } catch (Exception e) {
                    LOGGER.warn("Some exception happen on OnFailed",e)
                }

            }
        }

        this.specificationContext.currentSpec.addListener(onFailedListener)


    }


    def cleanup(){
        this.specificationContext.currentSpec.getListeners().remove(onFailedListener)
    }

    void onFailed(){

    }

    public void pauseTest(int second){
        LOGGER.info("Pause test "+second+"s")
        Thread.sleep(second*1000)
    }

    def String captureScreenShot(AppiumDriver appiumDriver) {

        File screenShot = appiumDriver.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String filePath = new String("./build/spock-reports/"+timestamp+".jpg");
        FileUtils.copyFile(screenShot,new File(filePath));

        return timestamp+".jpg"
        //LOGGER.info(LogUtils.imageHtml(filePath));
    }

    def showPicInReport(AppiumDriver appiumDriver){
        String pic = captureScreenShot(appiumDriver);
        Pause.sleep(3);
        reportInfo " show pictures <img src=\"${pic}\" width=\"320\" height=\"180\" /> "
    }

}

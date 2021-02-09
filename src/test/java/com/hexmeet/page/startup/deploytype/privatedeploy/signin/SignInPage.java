package com.hexmeet.page.startup.deploytype.privatedeploy.signin;

import com.hexmeet.utility.Pause;
import com.hexmeet.utility.UIElement;
import com.hexmeet.page.PageObjectBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class SignInPage implements PageObjectBase  {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private AppiumDriver appiumDriver;

    public SignInPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void navigate(){
//        logger.info("Sign in page");
//        PrivateDeployPage privateDeployPage = new PrivateDeployPage(appiumDriver);
//        privateDeployPage.navigate();
//        privateDeployPage.signIn();
    }

    @Override
    public  WebElement findElementByXPath(String xpath) {
        return appiumDriver.findElementByXPath(xpath);
    }

    @Override
    public WebElement findElementByAccessibilityId(String id) {
        return appiumDriver.findElementByAccessibilityId(id);
    }

    public void submit(String serveraddr, String accout, String password){
        logger.info("Sign in page Sumbit");
        Pause.stop(0.5);
        String serverXpath="//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]";
        findElementByXPath(serverXpath).clear();
        findElementByXPath(serverXpath).sendKeys(serveraddr);
        String usernameXpath="//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]";
        findElementByXPath(usernameXpath).clear();
        findElementByXPath(usernameXpath).sendKeys(accout);
        String passwordXpath="//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";
        findElementByXPath(passwordXpath).clear();
        findElementByXPath(passwordXpath).sendKeys(password);
        String keyboardXpath="(//XCUIElementTypeButton[@name=\"Done\"])[1]";
        findElementByXPath(keyboardXpath).click();
        findElementByXPath("//XCUIElementTypeButton[@name=\"登录\"]").click();

        Pause.stop(0.5);

//        if(UIElement.byElementIsExist(appiumDriver, By.id("android:id/button1")))
//            UICommon.devicePermissionAllowance(appiumDriver);
    }

    public void submit(String serveraddr,String accout,String password,String port,boolean useHttps){
        logger.info("Sign in page Submit");
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeStaticText[@name=\"高级设置\"]").click();
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys(port);
        if(useHttps)
            findElementByXPath("//XCUIElementTypeApplication[@name=\"会捷通\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch").click();
        Pause.stop(0.5);
        findElementByXPath("//XCUIElementTypeButton[@name=\"保存\"]").click();

        Pause.stop(0.5);

        submit(serveraddr,accout,password);

        Pause.stop(0.5);

        if(UIElement.byElementIsExist(appiumDriver, By.xpath("//XCUIElementTypeSheet[@name=\"您想在钥匙串中存储此密码以在App和网站中使用吗？\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]")))
            findElementByXPath("//XCUIElementTypeSheet[@name=\"您想在钥匙串中存储此密码以在App和网站中使用吗？\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]").click();
    }

    public boolean isOnSignInPage(){
        logger.info("Check Sign in page");
        return UIElement.byElementIsExist(appiumDriver,By.xpath("//XCUIElementTypeStaticText[@name=\"私有部署登录\"]"));
    }


}

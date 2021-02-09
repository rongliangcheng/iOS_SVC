package com.hexmeet.autotestcases.privatecloud

import com.hexmeet.appiumendpoint.AppiumEndpoint
import com.hexmeet.appiumendpoint.IOSAppiumEndpoint
import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec
import com.hexmeet.page.AccountInfoPage
import com.hexmeet.page.AccountPage
import com.hexmeet.page.PageNavigate
import com.hexmeet.utility.Pause
import io.appium.java_client.AppiumDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pageActions.PageNavigateOperations
import pageActions.PrivateDeployLoginAdvancedSettingOperatios
import pageActions.PrivateDeployLoginOperations
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("用户信息")
@Narrative("测试用户更换头像，更改用户名")
class AccountInfo extends EndpointSystemTestSpec{

    @Shared
    AppiumDriver appiumDriver;

    @Shared
    AppiumEndpoint iosEndpoint = new IOSAppiumEndpoint();

    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass())


    @Shared
    long IMPLICIT_WAIT_TIME = 30

    @Shared
    String configFileName="config.json"

    @Shared
    String appiumKeyword_1 = "iOS_1"

    @Shared
    String oldName = "hjtautotest3"

    @Shared
    String newName = "autotest"

    @Shared
    String newName1 = "1~!@#\$%^&*()_+||}{:?><"

    def setupSpec(){

        log.info("Setup")
    }

    def cleanupSpec(){

    }

    def setup(){

    }

    def cleanup(){

    }


    def "更换头像"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"根据日期当双号更换头像 双：蓝莓 单：石榴"
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_account_info()
        AccountInfoPage accountInfoPage = new AccountInfoPage(appiumDriver)
        accountInfoPage.change_image()

        then:"成功登录"
        assert true
    }

    def "更改用户名"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"更改用户名为 autotest 并取消更改"
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_account_info()
        AccountInfoPage accountInfoPage = new AccountInfoPage(appiumDriver)
        accountInfoPage.change_display_name(newName)
        accountInfoPage.cancel_change_display_name()

        and:"更改用户名为 autotest 并确认"
        accountInfoPage.change_display_name(newName)
        accountInfoPage.submit_change_dispaly_name()

        and:"确认更改成功"
        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.return_from_account_info()
        AccountPage accountPage = new AccountPage(appiumDriver)
        String displayName = accountPage.get_display_name(newName)

        then:"成功登录"
        assert displayName.contains(newName);
    }

    def "更改用户名包含特殊字符"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"更改用户名为 autotest 并取消更改"
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_account_info()
        AccountInfoPage accountInfoPage = new AccountInfoPage(appiumDriver)

        and:"更改用户名为 autotest 并确认"
        accountInfoPage.change_display_name(newName1)
        accountInfoPage.submit_change_dispaly_name()

        and:"确认更改成功"
        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.return_from_account_info()
        AccountPage accountPage = new AccountPage(appiumDriver)
        String displayName = accountPage.get_display_name(newName1)

        then:"成功登录"
        assert displayName.contains(newName1);
    }

    def "改回原始用户名"(){
        when:"初始化AppiumDriver"
        iosEndpoint.initialAppiumEndpointfromJson(configFileName,appiumKeyword_1)
        iosEndpoint.getAppiumEndpointDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
        appiumDriver = iosEndpoint.getAppiumEndpointDriver()

        and:"更改用户名为 autotest 并更改"
        PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(appiumDriver)
        pageNavigateOperations.navigate_to_account_info()
        AccountInfoPage accountInfoPage = new AccountInfoPage(appiumDriver)
        accountInfoPage.change_special_display_name(oldName)
        accountInfoPage.submit_change_dispaly_name()

        and:"确认更改成功"
        PageNavigate pageNavigate = new PageNavigate(appiumDriver)
        pageNavigate.return_from_account_info()
        AccountPage accountPage = new AccountPage(appiumDriver)
        String displayName = accountPage.get_display_name(oldName)

        then:"成功登录"
        assert displayName.contains(oldName);
    }


}

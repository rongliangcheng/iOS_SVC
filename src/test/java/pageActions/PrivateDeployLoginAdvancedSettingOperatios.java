package pageActions;

import com.hexmeet.page.MeetingPage;
import com.hexmeet.page.PageNavigate;
import com.hexmeet.page.PrivateDeployLoginAdvancedSettingPage;
import io.appium.java_client.AppiumDriver;

public class PrivateDeployLoginAdvancedSettingOperatios {
    private AppiumDriver driver;

    public PrivateDeployLoginAdvancedSettingOperatios(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void advanced_setting(String port, Boolean httpsEnable){
        MeetingPage meetingPage = new MeetingPage(driver);
        if ( meetingPage.isOnMeetingPage()){
            PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(driver);
            pageNavigateOperations.navigate_to_private_deploy_login_from_scratch();
        }
        PageNavigate pageNavigate = new PageNavigate(driver);
        pageNavigate.navigate_to_private_deploy_login_advanced_setting();
        PrivateDeployLoginAdvancedSettingPage privateDeployLoginAdvancedSettingPage = new PrivateDeployLoginAdvancedSettingPage(driver);
        privateDeployLoginAdvancedSettingPage.set_port(port);
        privateDeployLoginAdvancedSettingPage.enable_https(httpsEnable);
        privateDeployLoginAdvancedSettingPage.save_setting();
    }
}

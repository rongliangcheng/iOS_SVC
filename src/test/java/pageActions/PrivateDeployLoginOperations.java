package pageActions;

import com.hexmeet.page.MeetingPage;
import com.hexmeet.page.PrivateDeployLoginPage;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class PrivateDeployLoginOperations {
    private AppiumDriver driver;

    PrivateDeployLoginOperations(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void private_deploy_login(String server_address, String account, String password){

        MeetingPage meetingPage = new MeetingPage(driver);
        if ( meetingPage.isOnMeetingPage()){
            PageNavigateOperations pageNavigateOperations = new PageNavigateOperations(driver);
            pageNavigateOperations.navigate_to_private_deploy_login_from_scratch();
        }
        PrivateDeployLoginPage privateDeployLoginPage = new PrivateDeployLoginPage(driver);
        privateDeployLoginPage.fill_in_server_address(server_address);
        privateDeployLoginPage.fill_in_account(account);
        privateDeployLoginPage.fill_in_password(password);
        privateDeployLoginPage.hide_keyboard();
        Pause.stop(2);
        privateDeployLoginPage.login_submit();
        Pause.stop(2);
        TouchAction touchAction = new TouchAction(driver);
        PointOption point=  PointOption.point(190,40);
        touchAction.tap(point);
        Pause.stop(1);
    }
}

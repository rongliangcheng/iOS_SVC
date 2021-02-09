package pageActions;

import com.hexmeet.page.PageNavigate;
import io.appium.java_client.AppiumDriver;

public class PageNavigateOperations {
    private AppiumDriver driver;
    private PageNavigate pageNavigate;
    public PageNavigateOperations(AppiumDriver appiumDriver){
        driver = appiumDriver;
        pageNavigate = new PageNavigate(driver);
    }

    public void navigate_to_private_deploy_login_from_scratch(){
        pageNavigate.navigate_to_account();
        pageNavigate.navigate_to_account_info();
        pageNavigate.navigate_to_exit();
        pageNavigate.navigate_to_private_deploy();
        pageNavigate.navigate_to_private_deploy_login();
    }

    // to guest call
    public void navigate_to_guest_call_from_private_deploy_login(){
        pageNavigate.navigate_private_deploy_from_private_deploy_login();
        pageNavigate.navigate_to_guest_call();
    }

    public void navigate_to_guest_call_from_logined_page(){
        pageNavigate.navigate_to_account();
        pageNavigate.navigate_to_account_info();
        pageNavigate.navigate_to_exit();
        pageNavigate.navigate_to_private_deploy();
        pageNavigate.navigate_to_guest_call();
    }
    public void navigate_to_my_meeting_setting(){
        pageNavigate.navigate_to_my_meetingroom();
        pageNavigate.navigate_to_my_meeting_setting();
    }

    public void navigate_to_account_info(){
        pageNavigate.navigate_to_account();
        pageNavigate.navigate_to_account_info();
    }

    public void navigate_to_about(){
        pageNavigate.navigate_to_account();
        pageNavigate.navigate_to_about();
    }
}

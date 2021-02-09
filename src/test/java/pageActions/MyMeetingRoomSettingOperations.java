package pageActions;

import com.hexmeet.page.MyMeetingRoomPage;
import com.hexmeet.page.MyMeetingRoomSettingPage;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class MyMeetingRoomSettingOperations {

    AppiumDriver driver;

    public MyMeetingRoomSettingOperations(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void change_my_meeting_room_setting(String password,boolean mute_on_call, boolean anonymous,
                                               boolean only_admin_activate, boolean allow_others_reserve){
        MyMeetingRoomSettingPage myMeetingRoomSettingPage = new MyMeetingRoomSettingPage(driver);
        myMeetingRoomSettingPage.input_password(password);
        Pause.stop(1);
        myMeetingRoomSettingPage.mute_on_join(mute_on_call);
        Pause.stop(1);
        myMeetingRoomSettingPage.anonymous_on_call(anonymous);
        Pause.stop(1);
        myMeetingRoomSettingPage.only_admin_can_activate_meeting(only_admin_activate);
        Pause.stop(1);
        myMeetingRoomSettingPage.allow_others_reserve_this_meeting_room(allow_others_reserve);
        Pause.stop(1);
//        if(select_group) {
//            myMeetingRoomSettingPage.allow_others_reserve_this_meeting_room(allow_others_reserve);
//        } else {
//            myMeetingRoomSettingPage.allow_others_reserve_this_meeting_room_with_selectgroup(allow_others_reserve);
//        }
//        myMeetingRoomSettingPage.select_group(select_group);
        myMeetingRoomSettingPage.save_setting();
    }

}

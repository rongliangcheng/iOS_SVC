package pageActions;

import com.hexmeet.page.MyMeetingRoomPage;
import com.hexmeet.sundae.mediaStatistics.CALLTYPE;
import com.hexmeet.utility.Pause;
import io.appium.java_client.AppiumDriver;

public class MyMeetingRoomOperations {

    private AppiumDriver driver;

    public MyMeetingRoomOperations(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void join_my_meeting(CALLTYPE callType, Boolean camera_mute, Boolean mic_mute){
        MyMeetingRoomPage myMeetingRoomPage = new MyMeetingRoomPage(driver);
        myMeetingRoomPage.click_join_my_meeting();
        myMeetingRoomPage.camera_mute(camera_mute);
        myMeetingRoomPage.mic_mute(mic_mute);

        if (callType == CALLTYPE.Video){
            myMeetingRoomPage.video_call();
        }else if( callType == CALLTYPE.Audio ){
            myMeetingRoomPage.audio_call();
        }
    }
}

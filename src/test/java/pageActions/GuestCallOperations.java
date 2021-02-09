package pageActions;


import com.hexmeet.page.GuestCallPage;
import com.hexmeet.sundae.mediaStatistics.CALLTYPE;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestCallOperations {
    private AppiumDriver driver;
    Logger log = LoggerFactory.getLogger(this.getClass());

    public GuestCallOperations(AppiumDriver appiumDriver){
        driver = appiumDriver;
    }

    public void guest_call_with_password(String password, boolean commit){
        log.info(String.valueOf(commit));
        GuestCallPage guestCallPage = new GuestCallPage(driver);
        guestCallPage.fill_in_meeting_password(password,commit);
    }

    public void guest_call(String server_address, String conferenceNumber, String displayName, CALLTYPE calltype,boolean camera_mute, boolean mic_mute){
        GuestCallPage guestCallPage = new GuestCallPage(driver);
        guestCallPage.fill_in_server_address(server_address);
        guestCallPage.fill_conference_number(conferenceNumber);
        guestCallPage.fill_in_display_name(displayName);
        guestCallPage.camera_mute(camera_mute);
        guestCallPage.mic_mute(mic_mute);

        if( calltype == CALLTYPE.Video){
            guestCallPage.video_call();
        } else if( calltype == CALLTYPE.Audio){
            guestCallPage.audio_call();
        }

    }
}

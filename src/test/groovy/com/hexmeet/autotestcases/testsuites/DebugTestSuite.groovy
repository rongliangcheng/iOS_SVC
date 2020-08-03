package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.privatecloud.AppVersion
import com.hexmeet.autotestcases.privatecloud.InviteParticipantInMeetingControl
import com.hexmeet.autotestcases.privatecloud.LockMeetingInMeetingControl
import com.hexmeet.autotestcases.privatecloud.PostponeMeetingInMeetingControl
import org.junit.runner.RunWith
import org.junit.runners.Suite



@RunWith(Suite.class)
@Suite.SuiteClasses([
//          SignIn
 //        GuestCall
//        OperateReserveMeeting
//        InviteParticipantInMeetingControl
//        PostponeMeetingInMeetingControl
//        LockMeetingInMeetingControl
        AppVersion
//          CallAContactInPrivate
//        JoinAReserveMeeting,
//        OperateInAReservedMeeting
])
class DebugTestSuite {
}


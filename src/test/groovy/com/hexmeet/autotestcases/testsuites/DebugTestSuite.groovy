package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.privatecloud.GuestCall
import com.hexmeet.autotestcases.privatecloud.LongCall
import com.hexmeet.autotestcases.privatecloud.OperateInAReservedMeeting
import com.hexmeet.autotestcases.privatecloud.AppVersion
import com.hexmeet.autotestcases.privatecloud.ShortCalls
import org.junit.runner.RunWith
import org.junit.runners.Suite



@RunWith(Suite.class)
@Suite.SuiteClasses([
//          SignIn
//         GuestCall
//        OperateReserveMeeting
//        InviteParticipantInMeetingControl
//        PostponeMeetingInMeetingControl
//        LockMeetingInMeetingControl
//LongCall
//          CallAContactInPrivate
//        JoinAReserveMeeting,
//        AppVersion,
        OperateInAReservedMeeting
//        ShortCalls
])
class DebugTestSuite {
}


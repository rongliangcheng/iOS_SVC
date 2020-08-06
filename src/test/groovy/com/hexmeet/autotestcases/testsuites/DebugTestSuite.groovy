package com.hexmeet.autotestcases.testsuites


import com.hexmeet.autotestcases.privatecloud.OperateInAReservedMeeting
import com.hexmeet.autotestcases.privatecloud.AppVersion
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

//          CallAContactInPrivate
//        JoinAReserveMeeting,
        AppVersion,
        OperateInAReservedMeeting
])
class DebugTestSuite {
}


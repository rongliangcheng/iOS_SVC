package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.privatecloud.AccountInfo
import com.hexmeet.autotestcases.privatecloud.AppVersion
import com.hexmeet.autotestcases.privatecloud.CallAContactInPrivate
import com.hexmeet.autotestcases.privatecloud.GuestCall
import com.hexmeet.autotestcases.privatecloud.JoinAReserveMeeting
import com.hexmeet.autotestcases.privatecloud.JoinMyMeetingInPrivate
import com.hexmeet.autotestcases.privatecloud.JoinMyMeetingInPrivateAVEscalation
import com.hexmeet.autotestcases.privatecloud.JoinMyMeetingInPrivateMatrix
import com.hexmeet.autotestcases.privatecloud.OperateInAGuestCall
import com.hexmeet.autotestcases.privatecloud.OperateInAReservedMeeting
import com.hexmeet.autotestcases.privatecloud.SignIn
import com.hexmeet.page.JoinMeetingPage

//import com.hexmeet.autotestcases.privatecloud.GuestCall
//import com.hexmeet.autotestcases.privatecloud.JoinAReserveMeeting
//import com.hexmeet.autotestcases.privatecloud.JoinMyMeetingInPrivate
//import com.hexmeet.autotestcases.privatecloud.LockMeetingInMeetingControl
//import com.hexmeet.autotestcases.privatecloud.OperateInAGuestCall

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([
//        OperateInAGuestCall,
//        GuestCall,
//        SignIn,
        AppVersion,
//        AccountInfo,
//        CallAContactInPrivate,
//        JoinMyMeetingInPrivate,
//        JoinMyMeetingInPrivateAVEscalation,
//        JoinMyMeetingInPrivateMatrix,
//        JoinAReserveMeeting,
//        OperateInAReservedMeeting
])

class PrivateCloudTestSuite {
}

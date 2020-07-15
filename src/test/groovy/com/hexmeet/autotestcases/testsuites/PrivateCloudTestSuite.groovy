package com.hexmeet.autotestcases.testsuites


import com.hexmeet.autotestcases.privatecloud.CallAContactInPrivate
import com.hexmeet.autotestcases.privatecloud.GuestCall
import com.hexmeet.autotestcases.privatecloud.JoinAReserveMeeting
import com.hexmeet.autotestcases.privatecloud.JoinMyMeetingInPrivate
import com.hexmeet.autotestcases.privatecloud.OperateInAGuestCall
import com.hexmeet.autotestcases.privatecloud.OperateInAServeredMeeting
import com.hexmeet.autotestcases.privatecloud.SignIn

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([
            SignIn,
            GuestCall,
            OperateInAGuestCall,
            CallAContactInPrivate,
            JoinAReserveMeeting,
            OperateInAServeredMeeting,
            JoinMyMeetingInPrivate
//        LoginWithWrongPassword,
//        LoginWithWrongUsername
])

class PrivateCloudTestSuite {
}

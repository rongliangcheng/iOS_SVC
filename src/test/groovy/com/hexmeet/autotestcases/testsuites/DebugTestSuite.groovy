package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.privatecloud.CallAContactInPrivate
import com.hexmeet.autotestcases.privatecloud.GuestCall
import com.hexmeet.autotestcases.privatecloud.SignIn
import org.junit.runner.RunWith
import org.junit.runners.Suite



@RunWith(Suite.class)
@Suite.SuiteClasses([
          SignIn,
//          GuestCall
//          CallAContactInPrivate
//        JoinAReserveMeeting,
//        OperateInAReservedMeeting
])
class DebugTestSuite {
}


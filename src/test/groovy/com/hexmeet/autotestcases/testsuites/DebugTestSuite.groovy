package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.login.Login
import com.hexmeet.autotestcases.privatecloud.JoinAReserveMeeting
import org.junit.runner.RunWith
import org.junit.runners.Suite



@RunWith(Suite.class)
@Suite.SuiteClasses([
        JoinAReserveMeeting
//        JoinAReserveMeeting,
//        OperateInAReservedMeeting
])
class DebugTestSuite {
}


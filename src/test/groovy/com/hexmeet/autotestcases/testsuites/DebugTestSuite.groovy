package com.hexmeet.autotestcases.testsuites


import com.hexmeet.autotestcases.privatecloud.SignIn
import org.junit.runner.RunWith
import org.junit.runners.Suite



@RunWith(Suite.class)
@Suite.SuiteClasses([
        SignIn
//        JoinAReserveMeeting,
//        OperateInAReservedMeeting
])
class DebugTestSuite {
}


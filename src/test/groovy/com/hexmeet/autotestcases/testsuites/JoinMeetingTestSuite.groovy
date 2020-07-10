package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.login.Login
import com.hexmeet.autotestcases.publiccloud.JoinAReserveMeeting
import com.hexmeet.autotestcases.publiccloud.OperateInAReservedMeeting
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite.class)
@Suite.SuiteClasses([
        Login,
        JoinAReserveMeeting,
        OperateInAReservedMeeting
])
class JoinMeetingTestSuite {
}

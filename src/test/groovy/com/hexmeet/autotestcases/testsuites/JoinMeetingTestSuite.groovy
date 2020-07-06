package com.hexmeet.autotestcases.testsuites


import com.hexmeet.autotestcases.publiccloud.JoinAPublicMeeting
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite.class)
@Suite.SuiteClasses([
        JoinAPublicMeeting
])
class JoinMeetingTestSuite {
}

package com.hexmeet.autotestcases.testsuites

import com.hexmeet.autotestcases.install.InstallApp
import com.hexmeet.autotestcases.login.*
import com.hexmeet.autotestcases.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([
          PreTest,
//        InstallApp,
        Login
//        LoginWithWrongPassword,
//        LoginWithWrongUsername
])

class LoginTestSuite {
}

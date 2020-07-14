package com.hexmeet.autotestcases;

import com.hexmeet.autotestcases.TestSpec.EndpointSystemTestSpec


public class PreTest extends EndpointSystemTestSpec {

    def "Test preparation"() {

        when:
            LOGGER.info("test");

        then:
            assert true
    }
}

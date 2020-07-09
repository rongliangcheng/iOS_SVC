package com.hexmeet.autotestcases;

import TestSpec.EndpointSystemTestSpec


public class PreTest extends EndpointSystemTestSpec {

    def "Test preparation"() {

        when:
            LOGGER.info("test");

        then:
            assert true
    }
}

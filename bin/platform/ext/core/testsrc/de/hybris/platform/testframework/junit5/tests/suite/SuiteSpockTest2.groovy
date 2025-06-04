/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests.suite

import de.hybris.bootstrap.annotations.ManualTest
import de.hybris.platform.servicelayer.ServicelayerBaseSpecification

@ManualTest
class SuiteSpockTest2 extends ServicelayerBaseSpecification {
    def "Test the addition functionality"() {
        expect:
        4 == 2 + 2
    }

    def "Test the string generation"() {
        given:
        String name = "Spock Testing"
        when:
        String result = "Testing with " + name
        then:
        result == "Testing with Spock Testing"
    }

    def "Test list size"() {
        given:
        List<Integer> myList = [1, 2, 3, 4, 5]
        expect:
        myList.size() == 5
    }

    def "Test the null value"() {
        given:
        String emptyString = null
        expect:
        emptyString == null
    }

    def "Test the not null value"() {
        given:
        String notEmptyString = "I'm a not empty string"
        expect:
        notEmptyString != null
    }
}

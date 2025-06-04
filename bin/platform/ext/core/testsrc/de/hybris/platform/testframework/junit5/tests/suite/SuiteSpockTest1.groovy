/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests.suite

import de.hybris.bootstrap.annotations.ManualTest
import de.hybris.platform.servicelayer.ServicelayerBaseSpecification

@ManualTest
class SuiteSpockTest1 extends ServicelayerBaseSpecification {
    def "Test multiplication functionality"() {
        expect:
        10 == 2 * 5
    }

    def "Test string concatenation"() {
        given:
        String str1 = "Hello"
        String str2 = " Spock!"
        when:
        String result = str1 + str2
        then:
        result == "Hello Spock!"
    }

    def "Test list contains"() {
        given:
        List<String> nameList = ["Spock", "Kirk", "McCoy"]
        expect:
        nameList.contains("Kirk")
    }

    def "Test HashMap get"() {
        given:
        Map<Integer, String> map = [1:"Spock", 2:"Kirk", 3:"McCoy"]
        expect:
        map.get(2) == "Kirk"
    }

    def "Test empty array"() {
        given:
        def array = [] as Object[]
        expect:
        array.size() == 0
    }
}

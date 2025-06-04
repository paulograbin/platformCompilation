/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.servicelayer.ServicelayerBaseSpecification
import de.hybris.platform.testframework.JUnit4OnlyTest
import org.junit.Assume
import org.junit.Test
import org.junit.jupiter.api.Assumptions
import org.opentest4j.TestAbortedException
import spock.lang.IgnoreIf

@JUnit4OnlyTest
@IntegrationTest
class SpockAssumptionsSpecificationJUnit4Only extends ServicelayerBaseSpecification {

    @Test
    def "Should #skip test because of the assumption - TestAbortedException"(String skip) {
        given:
        if ('ignore' == skip) {
            throw new TestAbortedException('Should be skipped')
        }
        when:
        def i = 1
        then:
        i == 1

        where:
        skip << ['ignore', 'execute']
    }

    @IgnoreIf({ skip == 'ignore' })
    @Test
    def "Should #skip test because of the assumption - IgnoreIf"(String skip) {
        when:
        def i = 1
        then:
        i == 1

        where:
        skip << ['ignore', 'execute']
    }

    @Test
    def "Should #skip test because of the assumption - Assume"(String skip) {
        given:
        Assume.assumeTrue('ignore' != skip)
        when:
        def i = 1
        then:
        i == 1

        where:
        skip << ['ignore', 'execute']
    }

    @Test
    def "Should #skip test because of the assumption - Assumptions"(String skip) {
        given:

        Assumptions.assumeTrue('ignore' != skip)
        when:
        def i = 1
        then:
        i == 1

        where:
        skip << ['ignore', 'execute']
    }
}

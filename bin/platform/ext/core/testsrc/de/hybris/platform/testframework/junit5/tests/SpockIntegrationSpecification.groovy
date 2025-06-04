/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.jalo.security.JaloSecurityException
import de.hybris.platform.servicelayer.ServicelayerBaseSpecification
import spock.lang.Unroll


@IntegrationTest
class SpockIntegrationSpecification extends ServicelayerBaseSpecification {


    @Override
    def setup() {
        println("setup")
    }

    @Override
    def cleanup() throws JaloSecurityException {
        println("cleanup")
    }

    @Unroll
    void "print #value1"() {
        when:
        println(value1)
        then:
        value1 != null
        where:
        value1 | value2
        1      | 2
        "a"    | "b"
    }
}

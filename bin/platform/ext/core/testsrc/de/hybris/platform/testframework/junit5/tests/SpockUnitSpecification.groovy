/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests


import de.hybris.bootstrap.annotations.UnitTest
import org.junit.Ignore
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

@UnitTest
@Ignore("how???")
class SpockUnitSpecification extends Specification {

    @Test
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

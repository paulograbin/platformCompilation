/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests.suite

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.testframework.junit5.annotation.AfterPlatformSuite
import de.hybris.platform.testframework.junit5.annotation.BeforePlatformSuite
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suite
@SelectClasses([SuiteSpockTest1.class, SuiteSpockTest2.class])
@IntegrationTest
class SpockSuiteJupiter {
    private final static Logger LOG = LoggerFactory.getLogger(SpockSuite)

    @BeforePlatformSuite
    public static void setUp()
    {
        LOG.info("SET UP JUPITER")
    }

    @AfterPlatformSuite
    public static void tearDown()
    {
        LOG.info("TEAR DOWN JUPITER")
    }
}

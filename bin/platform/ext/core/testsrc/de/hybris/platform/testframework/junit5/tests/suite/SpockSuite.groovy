/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework.junit5.tests.suite

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.testframework.JUnit4OnlyTest
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@JUnit4OnlyTest
@RunWith(Suite.class)
@Suite.SuiteClasses([SuiteSpockTest1.class, SuiteSpockTest2.class])
@IntegrationTest
class SpockSuite {
    private final static Logger LOG = LoggerFactory.getLogger(SpockSuite)

    @BeforeClass
    public static void setUp()
    {
        LOG.info("SET UP")
    }

    @Test
    public void dummyTest()
    {
        //nothing here
    }

    @AfterClass
    public static void tearDown()
    {
        LOG.info("TEAR DOWN")
    }
}

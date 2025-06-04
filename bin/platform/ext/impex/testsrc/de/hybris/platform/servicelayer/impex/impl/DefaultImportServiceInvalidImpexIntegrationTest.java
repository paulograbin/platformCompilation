/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.impex.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Initialization;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupException;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.system.TestInitLockDao;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.Utilities;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class DefaultImportServiceInvalidImpexIntegrationTest extends ServicelayerTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private UserService userService;

	private TestInitLockDao testInitLockDao;

	int testClusterId = 0;

	final PropertyConfigSwitcher failOnErrorProperty = new PropertyConfigSwitcher(
			SystemSetupContext.FAIL_ON_DATA_CREATION_ERROR_PROPERTY);
	final PropertyConfigSwitcher clusterIdProperty = new PropertyConfigSwitcher(Config.Params.CLUSTER_ID);


	@Before
	public void setUp()
	{
		// test requires active master tenant to get master data source
		Registry.activateMasterTenant();
		Utilities.setJUnitTenant();

		testInitLockDao = new TestInitLockDao();
	}


	@After
	public void tearDown()
	{
		failOnErrorProperty.switchBackToDefault();
		clusterIdProperty.switchBackToDefault();
		if (testInitLockDao.readLockInfo().getClusterNodeId() == testClusterId)
		{
			testInitLockDao.releaseRowForClusterId(testClusterId);
		}
	}

	@Test
	public void shouldFailWithInvalidImpexAndSingleThread()
	{
		runTheTest(1);
	}


	@Test
	public void shouldFailWithInvalidImpexAndMultipleThreads()
	{
		runTheTest(2);
	}

	@Test
	public void shouldFailWithInvalidImpexWhileInitializingTenantOnTheSameNode()
	{
		failOnErrorProperty.switchToValue("true");
		final ImportConfig config = new ImportConfig();
		config.setScript("INSERT_UPDATE BadTitle; code[unique=true]; name[lang=de]; name[lang=en]\n"
				+ ";TTT1;TTT1-de;TTT1-en;\n");
		config.setSynchronous(true);

		testInitLockDao.lockRow(Registry.getCurrentTenantNoFallback(),
				Initialization.SYSTEM_INITIALIZATION_OP_NAME); //means - intialization is in progress
		assertThat(Initialization.isCurrentTenantInitializing()).isTrue();

		final int clusterNodeIdHoldingInitLock = testInitLockDao.readLockInfo().getClusterNodeId();
		assertThat(clusterNodeIdHoldingInitLock).isEqualTo(testClusterId);

		try
		{
			importService.importData(config);
			fail("SystemSetupException was expected but not thrown");

		}
		catch (Exception exc)
		{
			assertThat(exc).isInstanceOf(SystemSetupException.class);
		}

	}

	@Test
	public void shouldNotFailWithInvalidImpexWhileInitializingTenantOnDifferentNode()
	{
		failOnErrorProperty.switchToValue("true");
		final ImportConfig config = new ImportConfig();
		config.setScript("INSERT_UPDATE BadTitle; code[unique=true]; name[lang=de]; name[lang=en]\n"
				+ ";TTT1;TTT1-de;TTT1-en;\n");
		config.setSynchronous(true);

		testClusterId = 1;

		testInitLockDao.lockRowForClusterId(Registry.getCurrentTenantNoFallback(), Initialization.SYSTEM_INITIALIZATION_OP_NAME,
				testClusterId);
		assertThat(Initialization.isCurrentTenantInitializing()).isTrue();

		final int clusterNodeIdHoldingInitLock = testInitLockDao.readLockInfo().getClusterNodeId();
		assertThat(clusterNodeIdHoldingInitLock).isEqualTo(testClusterId);

		try
		{
			assertThat(clusterNodeIdHoldingInitLock).isNotEqualTo(Registry.getClusterID());
			final ImportResult importResult = importService.importData(config);

			assertThat(importResult.isFinished()).isTrue();
			assertThat(importResult.isSuccessful()).isFalse();

		}
		catch (Exception exc)
		{
			fail("No Exception should be thrown here for not successful import result, but it happened ", exc);
		}

	}


	private void runTheTest(final int maxThreads)
	{
		getOrCreateLanguage("de");
		getOrCreateLanguage("en");

		final ImportConfig config = new ImportConfig();
		config.setScript(
				"INSERT_UPDATE Title; code[unique=true]; name[lang=de]; name[lang=en]\n"
						+ ";TTT1;TTT1-de;TTT1-en;\n"
						+ ";TTT2;\"T\"TT2-de\";TTT2-en;\n"
						+ ";TTT3;TTT3-de;TTT3-en;\n"
						+ ";TTT4;TTT4-de;TTT4-en;\n"
						+ ";TTT5;TTT5-de;TTT5-en;\n"
		);

		config.setMaxThreads(maxThreads);
		config.setSynchronous(true);

		final ImportResult importResult = importService.importData(config);

		assertThat(importResult.isFinished()).isTrue();
		assertThat(importResult.isSuccessful()).isFalse();

		for (final String code : List.of("TTT1", "TTT3", "TTT4", "TTT5"))
		{
			assertTitleImported(code, code + "-de", code + "-en");
		}
	}

	void assertTitleImported(final String code, final String nameDE, final String nameEN)
	{
		final TitleModel title = userService.getTitleForCode(code);

		assertThat(title).isNotNull();
		assertThat(modelService.isNew(title)).isFalse();
		assertThat(modelService.isUpToDate(title)).isTrue();

		assertThat(title).extracting(TitleModel::getCode, t -> t.getName(Locale.GERMAN), t -> t.getName(Locale.ENGLISH))
		                 .containsExactly(code, nameDE, nameEN);

	}

}

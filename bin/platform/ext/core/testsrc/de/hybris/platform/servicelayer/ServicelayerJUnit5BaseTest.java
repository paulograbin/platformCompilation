/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer;

import de.hybris.platform.testframework.PlatformJUnit5Test;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;

public class ServicelayerJUnit5BaseTest extends PlatformJUnit5Test
{
	private final ServicelayerBaseTestLogic servicelayerBaseTestLogic = new ServicelayerBaseTestLogic();

	@BeforeEach
	public void prepareApplicationContextAndSession() throws Exception
	{
		servicelayerBaseTestLogic.prepareApplicationContextAndSession(this);
	}

	protected void autowireProperties(final ApplicationContext applicationContext)
	{
		servicelayerBaseTestLogic.autowireProperties(applicationContext, this);
	}

	protected String getBeanName(final Resource resource, final Field field)
	{
		return servicelayerBaseTestLogic.getBeanName(resource, field);
	}

	protected ApplicationContext getApplicationContext()
	{
		return servicelayerBaseTestLogic.getApplicationContext();
	}

}

/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.testframework;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.persistence.framework.PersistencePool;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class ItemCreationLifecycleListenerTest extends ServicelayerBaseTest
{
	private ItemCreationLifecycleListener itemCreationLifecycleListener;

	@Before
	public void setUp() throws Exception
	{
		itemCreationLifecycleListener = new ItemCreationLifecycleListener();
		//we do not want to use this listener for other things than tests
		Registry.getCurrentTenant().getPersistencePool().unregisterPersistenceListener(itemCreationLifecycleListener);
	}

	@Test
	public void shouldRegisterListener()
	{
		final PK pk = PK.fromLong(1);
		final PersistencePool.PersistenceListener persistenceListener1 = mock(PersistencePool.PersistenceListener.class);

		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener1);
		itemCreationLifecycleListener.entityCreated(pk);

		verify(persistenceListener1, times(1)).entityCreated(pk);
	}

	@Test
	public void shouldUnregisterListener()
	{
		final PK pk = PK.fromLong(1);
		final PersistencePool.PersistenceListener persistenceListener1 = mock(PersistencePool.PersistenceListener.class);

		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener1);
		verifyNoMoreInteractions(persistenceListener1);

		itemCreationLifecycleListener.unregisterPersistenceListener(persistenceListener1);
		itemCreationLifecycleListener.entityCreated(pk);
	}

	@Test
	public void shouldRegisterSameListenerOnlyOnce()
	{
		final PK pk = PK.fromLong(1);
		final PersistencePool.PersistenceListener persistenceListener1 = mock(PersistencePool.PersistenceListener.class);

		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener1);
		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener1);
		itemCreationLifecycleListener.entityCreated(pk);

		verify(persistenceListener1, times(1)).entityCreated(pk);
	}

	@Test
	public void shouldPassPKToAllRegisteredListeners()
	{
		final PK pk = PK.fromLong(1);
		final PersistencePool.PersistenceListener persistenceListener1 = mock(PersistencePool.PersistenceListener.class);
		final PersistencePool.PersistenceListener persistenceListener2 = mock(PersistencePool.PersistenceListener.class);

		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener1);
		itemCreationLifecycleListener.registerPersistenceListener(persistenceListener2);
		itemCreationLifecycleListener.entityCreated(pk);

		verify(persistenceListener1, times(1)).entityCreated(pk);
		verify(persistenceListener2, times(1)).entityCreated(pk);
	}
}

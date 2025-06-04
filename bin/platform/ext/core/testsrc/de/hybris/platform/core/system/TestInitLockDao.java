/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.core.system;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.core.system.impl.DefaultInitLockDao;
import de.hybris.platform.core.system.query.QueryProvider;
import de.hybris.platform.core.system.query.impl.QueryProviderFactory;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;
import org.awaitility.Awaitility;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestInitLockDao extends DefaultInitLockDao
{

	private static final int SINGLE_ROW_COUNT = 1;

	private static final int NO_ROWS_COUNT = 0;

	private static final int UNDEFINED_ROW_COUNT = -1;

	private static final int MAX_WAIT_TIME = 10 * 1000;

	private static final int SLEEP_BETWEEN_RETRY = 200;

	private static final Logger LOG = Logger.getLogger(TestInitLockDao.class.getName());

	private static final Integer UNLOCK_VALUE = Integer.valueOf(0);

	private static final Integer LOCK_VALUE = Integer.valueOf(1);

	private static final String GLOBAL_ID = "globalID";

	private static final Long uniqueInstanceIdentifier = Long.valueOf(PK.createUUIDPK(0).getLongValue());

	private final QueryProvider queryProvider;

	public TestInitLockDao()
	{
		this(null);
	}

	public TestInitLockDao(final QueryProvider givenQueryProvider)
	{
		queryProvider = (givenQueryProvider == null ? new QueryProviderFactory(
				getInitializedMasterDataSource().getDatabaseName()).getQueryProviderInstance() : givenQueryProvider);
	}

	public boolean lockRowForClusterId(final Tenant forTenant, final String processName, final int clusterId)
	{
		final JdbcTemplate template = new JdbcTemplate(getInitializedMasterDataSource());

		final int updateCount = lockRowInternal(forTenant, processName, template, clusterId);

		if (updateCount == SINGLE_ROW_COUNT)
		{
			return true;
		}
		else if (updateCount == NO_ROWS_COUNT)
		{
			return false;
		}
		else
		{
			throw new IllegalStateException("unexpected update count " + updateCount);
		}
	}

	private int lockRowInternal(final Tenant forTenant, final String processName, final JdbcTemplate template,
	                            final int clusterId)
	{
		int updateCount = UNDEFINED_ROW_COUNT;

		final long maxTime = System.currentTimeMillis() + MAX_WAIT_TIME;
		do
		{
			try
			{
				updateCount = template.update(//
						queryProvider.getQueryForLock(), //
						LOCK_VALUE, //
						forTenant.getTenantID(), //
						String.valueOf(clusterId), //
						new Timestamp(System.currentTimeMillis()), //
						processName, //
						uniqueInstanceIdentifier, //
						GLOBAL_ID, //
						UNLOCK_VALUE);
			}
			catch (final ConcurrencyFailureException e)
			{
				LOG.warn(e);
			}
			finally
			{
				waitIfNotFetched(updateCount);
			}
		}
		while (updateCount == UNDEFINED_ROW_COUNT && System.currentTimeMillis() < maxTime);

		return updateCount;
	}

	public boolean releaseRowForClusterId(final int clusterId)
	{
		final JdbcTemplate template = new JdbcTemplate(getInitializedMasterDataSource());
		try
		{
			return template.update(//
					queryProvider.getQueryForUnlock(), UNLOCK_VALUE //
					, null //lock uid
					, LOCK_VALUE, //
					String.valueOf(clusterId)//
			) == 1;
		}
		catch (final DataAccessException e)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Can't update a row with query " + queryProvider.getQueryForUnlock() + " , " + e.getMessage(), e);
			}
			//most likely table doesn't exist
			return false;
		}
	}

	private void waitIfNotFetched(final int updateCount)
	{
		Awaitility.await()
		          .atMost(SLEEP_BETWEEN_RETRY, TimeUnit.MILLISECONDS)
		          .untilFalse(new AtomicBoolean(updateCount == UNDEFINED_ROW_COUNT));
	}


}

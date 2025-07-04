/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.jdbcwrapper;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import org.awaitility.Awaitility;

public class DBOutageSimulator
{
	private final ExecutorService executor;
	private final JUnitJDBCConnectionPool connectionPool;

	AtomicInteger outageCounter = new AtomicInteger(0);

	public DBOutageSimulator(final JUnitJDBCConnectionPool connectionPool)
	{
		this(Executors.newCachedThreadPool(), connectionPool);
	}

	public DBOutageSimulator(final ExecutorService executor,
	                         final JUnitJDBCConnectionPool connectionPool)
	{
		this.executor = executor;
		this.connectionPool = connectionPool;
	}

	private void enableOutage(final JUnitJDBCConnectionPool connectionPool)
	{
		if (outageCounter.incrementAndGet() > 0)
		{
			connectionPool.setAllConnectionsFail(true);
		}
	}

	private void disableOutage(final JUnitJDBCConnectionPool connectionPool)
	{
		if (outageCounter.decrementAndGet() == 0)
		{
			connectionPool.setAllConnectionsFail(false);
		}
	}

	public void enable(){
		enableOutage(connectionPool);
	}

	public void disable(){
		disableOutage(connectionPool);
	}

	public DBOutage simulateDBOutage(final Duration outageDuration)
	{
		return new DBOutage(executor.submit(() -> {
			try
			{
				enableOutage(connectionPool);
				Thread.sleep(outageDuration.toMillis());
			}
			catch (final InterruptedException e)
			{
				Thread.currentThread().interrupt();
				throw new IllegalStateException(e);
			}
			finally
			{
				disableOutage(connectionPool);
			}
		}, null));
	}

	public DBOutage simulateDBOutage(final Supplier<Boolean> until, final Duration timeout)
	{
		return new DBOutage(executor.submit(() -> {
			try
			{
				enableOutage(connectionPool);
				Awaitility.await().atMost(timeout).until(() -> until.get());
			}
			finally
			{
				disableOutage(connectionPool);
			}
		}, null));
	}

	public DBOutage simulateDBOutage(final Supplier<Boolean> until)
	{
		final Duration defaultAwaitingTimeout = Duration.ofMinutes(5);
		return simulateDBOutage(until, defaultAwaitingTimeout);
	}

	public static class DBOutage
	{
		private final Future<Void> outageTask;

		private DBOutage(final Future<Void> outageTask)
		{
			this.outageTask = Objects.requireNonNull(outageTask);
		}

		public void waitTillEnd(final Duration timeout) throws InterruptedException, ExecutionException, TimeoutException
		{
			waitTillEnd(timeout.toNanos(), TimeUnit.NANOSECONDS);
		}

		public void waitTillEnd(final long timeout, final TimeUnit unit)
				throws InterruptedException, ExecutionException, TimeoutException
		{
			outageTask.get(timeout, unit);
		}
	}

}

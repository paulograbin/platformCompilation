/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.jdbcwrapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;


/**
 * For testing error flag in connection itself.
 */
public class JUnitConnectionImpl extends ConnectionImpl
{
	public static enum CommitMode
	{
		NORMAL, COMMIT_AND_ERROR, NO_COMMIT_ERROR, ROLLBACK_ERROR, COMMIT_OR_ROLLBACK_ERROR_AND_CLOSE_CONNECTION;
	}

	public static final String PREPARE_ERROR_QUERY = "TEST:throw.error.on prepare";

	private volatile boolean forceHasError = false;
	private volatile CommitMode commitMode = CommitMode.NORMAL;

	private volatile boolean hasBeenDestroyed = false;

	private volatile boolean forceClosed = false;

	public JUnitConnectionImpl(final HybrisDataSource ds, final Connection conn)
	{
		super(ds, conn);
	}

	public void setError(final boolean hasError)
	{
		this.forceHasError = hasError;
	}

	public void setCommitMode(final CommitMode mode)
	{
		this.commitMode = mode;
	}

	@Override
	public void commit() throws SQLException
	{
		switch (commitMode)
		{
			case COMMIT_AND_ERROR:
				super.commit();
				throw new SQLTransactionRollbackException("Transaction rolled back as requested by test mode " + commitMode);
			case NO_COMMIT_ERROR:
				throw new SQLTransactionRollbackException("Transaction rolled back as requested by test mode " + commitMode);
			case ROLLBACK_ERROR:
				super.rollback();
				throw new SQLTransactionRollbackException("Transaction rolled back as requested by test mode " + commitMode);
			case COMMIT_OR_ROLLBACK_ERROR_AND_CLOSE_CONNECTION:
				super.commit();
				forceClosed = true;
				throw new SQLException("SQL Exception by test mode " + commitMode);
			case NORMAL: // fall through
			default:
				super.commit();
		}
	}
	@Override
	public void rollback() throws SQLException
	{
		switch (commitMode)
		{
			case COMMIT_OR_ROLLBACK_ERROR_AND_CLOSE_CONNECTION:
				super.rollback();
				forceClosed = true;
				throw new SQLException("SQL Exception by test mode " + commitMode);
			case NORMAL: // fall through
			default:
				super.rollback();
		}
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		if (forceClosed)
		{
			return true;
		}
		return super.isClosed();
	}


	@Override
	void destroy() throws SQLException
	{
		try
		{
			super.destroy();
		}
		finally
		{
			hasBeenDestroyed = true;
		}
	}

	public boolean hasBeenDestroyed()
	{
		return hasBeenDestroyed;
	}

	@Override
	public String parseQuery(String queryIn) throws SQLException
	{
		if (PREPARE_ERROR_QUERY.equalsIgnoreCase(queryIn))
			throw new SQLException("test error on preare - as requested");

		return queryIn;
	}

	@Override
	protected void autoRollbackOnUnsetTxBOund()
	{
		throw new IllegalStateException("JUnitConnectionImpl doesnt automatically rollback open transactions!");
	}

	@Override
	protected boolean gotError()
	{
		return forceHasError || super.gotError();
	}

	public void resetTestMode()
	{
		forceHasError = false;
		forceClosed = false;
		commitMode = CommitMode.NORMAL;
	}

}

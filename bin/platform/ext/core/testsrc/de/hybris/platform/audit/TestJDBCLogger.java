package de.hybris.platform.audit;

import de.hybris.platform.core.Tenant;
import de.hybris.platform.jdbcwrapper.logger.FormattedLogger;
import de.hybris.platform.jdbcwrapper.logger.LogData;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test logger for JDBC operations.
 * This logger modifies the system configuration.
 * It cannot be used in the parallel test execution.
 */
public class TestJDBCLogger extends FormattedLogger
{
	private static final Logger LOG = LoggerFactory.getLogger(TestJDBCLogger.class);
	final static Queue<LogData> logDataList = new LinkedBlockingQueue<>();
	private static final PropertyConfigSwitcher dbLoggerClassProperty = new PropertyConfigSwitcher("db.log.loggerclass");
	private static final PropertyConfigSwitcher dbLogActive = new PropertyConfigSwitcher("db.log.active");
	private static final PropertyConfigSwitcher dbLogTablesInclude = new PropertyConfigSwitcher("db.log.filter.includetables");
	private static final PropertyConfigSwitcher dbLogAppendStackTrace = new PropertyConfigSwitcher("db.log.appendStackTrace");

	public TestJDBCLogger(final Tenant system)
	{
		super();
	}

	@Override
	public void logException(final Exception exception)
	{
		//NO-OP
	}

	@Override
	public void logText(final String text)
	{
		final LogData logData = LogData.builder()
		                               .withText(text).build();
		logText(logData);
	}
	@Override
	public void logText(final LogData logData)
	{
		logDataList.add(logData);
		LOG.info("SQL: " + logData.getSql());
	}

	@Override
	public void logException(final LogData logData)
	{
		//NO-OP
	}
	@Override
	public void logSQL(final LogData logData)
	{
		logDataList.add(logData);
		LOG.info("SQL: " + logData.getSql());
	}

	public void logSQL(final long threadId, final String dataSourceID, final int connectionId, final String now,
	                   final long elapsed, final String category, final String prepared, final String sql)
	{
		final LogData logData = LogData.builder()
		                               .withThreadId(threadId)
		                               .withDataSourceID(dataSourceID)
		                               .withConnectionId(connectionId)
		                               .withNow(now)
		                               .withElapsed(elapsed)
		                               .withCategory(category)
		                               .withPrepared(prepared)
		                               .withSql(sql)
		                               .build();
		logSQL(logData);
	}

	public static void enable(final String ... listOfTables)
	{
		enable(null, listOfTables);
	}

	public static void enable(final Boolean appendStackTrace, final String... listOfTables)
	{
		clearLogs();
		dbLogActive.switchToValue("true");
		dbLoggerClassProperty.switchToValue("de.hybris.platform.audit.TestJDBCLogger");
		dbLogTablesInclude.switchToValue(String.join(",", listOfTables));
		if (appendStackTrace != null)
		{
			dbLogAppendStackTrace.switchToValue(Boolean.toString(appendStackTrace));
		}
	}

	public static void disable()
	{
		dbLogActive.switchBackToDefault();
		dbLoggerClassProperty.switchBackToDefault();
		dbLogTablesInclude.switchBackToDefault();
		dbLogAppendStackTrace.switchBackToDefault();
		clearLogs();
	}

	public static List<String> getAllLogDataAsSqlText()
	{
		return getAllLogData().stream().map(LogData::getSql).toList();
	}

	public static void clearLogs()
	{
		logDataList.clear();
	}

	public static List<LogData> getAllLogData()
	{
		return new LinkedList<>(logDataList);
	}

}

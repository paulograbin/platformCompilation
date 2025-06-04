package de.hybris.platform.jdbcwrapper.logger;


import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.config.ConfigUtil;
import de.hybris.bootstrap.config.PlatformConfig;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.util.config.ConfigIntf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class FileLoggerTest
{

	private FileLogger fileLogger;

	@Mock
	private Tenant tenant;

	@Mock
	private ConfigIntf config;

	@Mock
	private PrintStream printStream;

	private String platformHomePath;
	private String logDirPath;
	private String dataDirPath;
	private final static String LOG_FILE_NAME = "logFile";

	@Before
	public void setUp() throws FileNotFoundException
	{
		doReturn(config).when(tenant).getConfig();
		doReturn(true).when(config).getBoolean(eq("db.log.file.append"), anyBoolean());

		fileLogger = spy(new FileLogger(tenant));
		doReturn(printStream).when(fileLogger).createPrintStream(anyString());

		final PlatformConfig config = ConfigUtil.getPlatformConfig(fileLogger.getClass());
		platformHomePath = config.getPlatformHome().toPath().toAbsolutePath().toString();
		logDirPath = config.getSystemConfig().getLogDir().toPath().toAbsolutePath().toString();
		dataDirPath = config.getSystemConfig().getDataDir().toPath().toAbsolutePath().toString();


	}

	@Test
	public void shouldPermitChangingLogFileWhenAbsolutePathToPlatformHomeIncluded()
	{
		//given
		final String logFileName = platformHomePath + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotPermittedChangingLogFileWhenAbsolutePathToPlatformHomeAndAttemptToEscapeItIncluded()
	{
		//given
		final String logFileName = platformHomePath + File.separator + ".." + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}

	@Test
	public void shouldPermitChangingLogFileWhenRelativePathToPlatformHomeIncluded()
	{
		fileLogger.setLogfile(LOG_FILE_NAME);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotPermittedChangingLogFileWhenRelativePathToPlatformLogAndAttemptToEscapeItIncluded()
	{
		//given
		final String logFileName = ".." + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotPermittedChangingLogFileWhenAbsolutePathToNotPermittedRootDirectoryIncluded()
	{
		//given
		final String logFileName = dataDirPath + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}

	@Test
	public void shouldPermitChangingLogFileWhenAbsolutePathToLogDirIncluded()
	{
		//given
		final String logFileName = logDirPath + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotPermittedChangingLogFileWhenAbsolutePathToLogDirAndAttemptToEscapeItIncluded()
	{
		//given
		final String logFileName = logDirPath + File.separator + ".." + File.separator + LOG_FILE_NAME;

		//when
		fileLogger.setLogfile(logFileName);
	}


}

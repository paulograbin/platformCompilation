/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.audit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class is used to switch the logging level for a given set of classes for tests purpose
 * and restore it back to the original level.
 */
public class LogLevelSwitcher
{
	private final List<Pair<Logger, Level>> loggersWithLevelBefore;

	public LogLevelSwitcher(final Class<?>... classesToAdjustLoggingLevel)
	{
		this.loggersWithLevelBefore = new ArrayList<>();
		gatherLogLevels(Arrays.asList(classesToAdjustLoggingLevel));
	}

	private void gatherLogLevels(final List<Class<?>> classesToAdjustLoggingLevel)
	{
		classesToAdjustLoggingLevel.forEach(clazz -> {
			final Logger logger = Logger.getLogger(clazz);
			final Level levelBefore = logger.getLevel();
			loggersWithLevelBefore.add(Pair.of(logger, levelBefore));
		});
	}

	public void switchLevel(final Level level)
	{
		loggersWithLevelBefore.forEach(pair -> pair.getLeft().setLevel(level));
	}

	public void restoreDefaultLevel()
	{
		loggersWithLevelBefore.forEach(pair -> pair.getLeft().setLevel(pair.getRight()));
	}

}

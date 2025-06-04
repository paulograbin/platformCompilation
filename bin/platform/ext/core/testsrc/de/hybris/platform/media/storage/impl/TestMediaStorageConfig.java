/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.media.storage.impl;

import de.hybris.platform.media.storage.MediaStorageConfigService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Fixed, tenant unaware test implementation for MediaStorageConfig interface.
 */
public class TestMediaStorageConfig implements MediaStorageConfigService
{
	public static final String GLOBAL_S3_KEY = "s3.globalSettings";

	@Override
	public boolean isStorageStrategyConfigured(final String storageId)
	{
		return false;
	}

	@Override
	public Collection<String> getSecuredFolders()
	{
		return Collections.emptySet();
	}

	@Override
	public MediaFolderConfig getConfigForFolder(final String folderQualifier)
	{
		return null;
	}

	@Override
	public String getDefaultStrategyId()
	{
		return null;
	}

	@Override
	public Set<MediaFolderConfig> getFolderConfigsForStrategy(final String strategyId)
	{
		return null;
	}


	@Override
	public GlobalMediaStorageConfig getGlobalSettingsForStrategy(final String strategyId)
	{
		return null;
	}


	@Override
	public String getDefaultCacheFolderName()
	{
		return null;
	}
}

/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.paulograbin.core.constants.GrabinCoreConstants;
import com.paulograbin.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class GrabinCoreManager extends GeneratedGrabinCoreManager
{
	public static final GrabinCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (GrabinCoreManager) em.getExtension(GrabinCoreConstants.EXTENSIONNAME);
	}
}

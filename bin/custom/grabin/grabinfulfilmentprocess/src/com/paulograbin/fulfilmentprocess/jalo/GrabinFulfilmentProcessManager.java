/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.paulograbin.fulfilmentprocess.constants.GrabinFulfilmentProcessConstants;

public class GrabinFulfilmentProcessManager extends GeneratedGrabinFulfilmentProcessManager
{
	public static final GrabinFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (GrabinFulfilmentProcessManager) em.getExtension(GrabinFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}

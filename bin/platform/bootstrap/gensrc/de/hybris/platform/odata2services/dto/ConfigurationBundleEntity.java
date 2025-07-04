/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.dto;

import java.io.Serializable;
import de.hybris.platform.odata2services.dto.IntegrationObjectBundleEntity;
import java.util.Set;


import java.util.Objects;
/**
 * Configuration bundle.
 */
public  class ConfigurationBundleEntity  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** A set of integration object bundles.<br/><br/><i>Generated property</i> for <code>ConfigurationBundleEntity.integrationObjectBundles</code> property defined at extension <code>odata2services</code>. */
	
	private Set<IntegrationObjectBundleEntity> integrationObjectBundles;
	
	public ConfigurationBundleEntity()
	{
		// default constructor
	}
	
	public void setIntegrationObjectBundles(final Set<IntegrationObjectBundleEntity> integrationObjectBundles)
	{
		this.integrationObjectBundles = integrationObjectBundles;
	}

	public Set<IntegrationObjectBundleEntity> getIntegrationObjectBundles() 
	{
		return integrationObjectBundles;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smartedit.dto;

import java.io.Serializable;
import de.hybris.platform.smartedit.dto.ConfigurationData;
import java.util.Collection;


import java.util.Objects;
public  class ConfigurationDataListWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConfigurationDataListWsDto.configurations</code> property defined at extension <code>smartedit</code>. */
	
	private Collection<ConfigurationData> configurations;
	
	public ConfigurationDataListWsDto()
	{
		// default constructor
	}
	
	public void setConfigurations(final Collection<ConfigurationData> configurations)
	{
		this.configurations = configurations;
	}

	public Collection<ConfigurationData> getConfigurations() 
	{
		return configurations;
	}
	

}
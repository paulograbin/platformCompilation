/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.smarteditwebservices.data.ConfigurationData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * List of configurations
 */
@Schema(name="ConfigurationDataListWsDto", description="List of configurations")
public  class ConfigurationDataListWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The list of configuration data<br/><br/><i>Generated property</i> for <code>ConfigurationDataListWsDto.configurations</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="configurations", description="The list of configuration data", required=true) 	
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
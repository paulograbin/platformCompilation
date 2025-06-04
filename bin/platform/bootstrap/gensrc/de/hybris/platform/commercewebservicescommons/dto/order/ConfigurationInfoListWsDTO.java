/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.ConfigurationInfoWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Configuration Info List
 */
@Schema(name="ConfigurationInfoList", description="Representation of a Configuration Info List")
public  class ConfigurationInfoListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of configuration info<br/><br/><i>Generated property</i> for <code>ConfigurationInfoListWsDTO.configurationInfos</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="configurationInfos", description="List of configuration info") 	
	private List<ConfigurationInfoWsDTO> configurationInfos;
	
	public ConfigurationInfoListWsDTO()
	{
		// default constructor
	}
	
	public void setConfigurationInfos(final List<ConfigurationInfoWsDTO> configurationInfos)
	{
		this.configurationInfos = configurationInfos;
	}

	public List<ConfigurationInfoWsDTO> getConfigurationInfos() 
	{
		return configurationInfos;
	}
	

}
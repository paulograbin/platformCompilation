/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of an order entry with product configuration attached.
 */
@Schema(name="CCPOrderEntry", description="Representation of an order entry with product configuration attached.")
public  class ProductConfigOrderEntryWsDTO extends OrderEntryWsDTO 

{



	/** Configuration Identifier. A randomly generated UUID owned by the product configurator.<br/><br/><i>Generated property</i> for <code>ProductConfigOrderEntryWsDTO.configId</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="configId", description="Configuration Identifier. A randomly generated UUID owned by the product configurator.", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String configId;
	
	public ProductConfigOrderEntryWsDTO()
	{
		// default constructor
	}
	
	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}

	public String getConfigId() 
	{
		return configId;
	}
	

}
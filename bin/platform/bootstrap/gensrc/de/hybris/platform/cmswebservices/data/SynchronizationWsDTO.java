/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available synchronization items.
 */
@Schema(name="SynchronizationWsDTO", description="Specifies a list of available synchronization items.")
public  class SynchronizationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SynchronizationWsDTO.items</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="items") 	
	private List<ItemSynchronizationWsDTO> items;
	
	public SynchronizationWsDTO()
	{
		// default constructor
	}
	
	public void setItems(final List<ItemSynchronizationWsDTO> items)
	{
		this.items = items;
	}

	public List<ItemSynchronizationWsDTO> getItems() 
	{
		return items;
	}
	

}
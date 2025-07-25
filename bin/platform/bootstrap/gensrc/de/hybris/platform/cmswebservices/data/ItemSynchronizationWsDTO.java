/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the item synchronization.
 */
@Schema(name="ItemSynchronizationWsDTO", description="Specifies properties of the item synchronization.")
public  class ItemSynchronizationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ItemSynchronizationWsDTO.itemId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemId") 	
	private String itemId;

	/** <i>Generated property</i> for <code>ItemSynchronizationWsDTO.itemType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemType", example="ContentSlot") 	
	private String itemType;
	
	public ItemSynchronizationWsDTO()
	{
		// default constructor
	}
	
	public void setItemId(final String itemId)
	{
		this.itemId = itemId;
	}

	public String getItemId() 
	{
		return itemId;
	}
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public String getItemType() 
	{
		return itemType;
	}
	

}
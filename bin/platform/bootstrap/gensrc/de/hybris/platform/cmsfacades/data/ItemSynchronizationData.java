/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:26 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class ItemSynchronizationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ItemSynchronizationData.itemId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String itemId;

	/** <i>Generated property</i> for <code>ItemSynchronizationData.itemType</code> property defined at extension <code>cmsfacades</code>. */
	
	private String itemType;
	
	public ItemSynchronizationData()
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
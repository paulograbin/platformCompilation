/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the navigation entry.
 */
@Schema(name="NavigationEntryData", description="Specifies properties of the navigation entry.")
public  class NavigationEntryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationEntryData.name</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="name", example="My Account") 	
	private String name;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemId", example="DigitalCompactsCategoryLink") 	
	private String itemId;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemType", example="CMSNavigationNode") 	
	private String itemType;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemSuperType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemSuperType", example="AbstractCMSComponent") 	
	private String itemSuperType;
	
	public NavigationEntryData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
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
	
	public void setItemSuperType(final String itemSuperType)
	{
		this.itemSuperType = itemSuperType;
	}

	public String getItemSuperType() 
	{
		return itemSuperType;
	}
	

}
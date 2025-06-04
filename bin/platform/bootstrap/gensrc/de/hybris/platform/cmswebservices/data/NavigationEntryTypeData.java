/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the navigation entry type.
 *
 * @deprecated no longer needed
 */
@Schema(name="NavigationEntryTypeData", description="Specifies properties of the navigation entry type.")
@Deprecated(since = "1811", forRemoval = true)
public  class NavigationEntryTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationEntryTypeData.itemType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="itemType", example="CMSParagraphComponent") 	
	private String itemType;
	
	public NavigationEntryTypeData()
	{
		// default constructor
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
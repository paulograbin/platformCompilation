/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import de.hybris.platform.cmswebservices.data.ComposedTypeData;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies property of the page type.
 */
@Schema(name="PageTypeData", description="Specifies property of the page type.")
public  class PageTypeData extends ComposedTypeData 

{



	/** <i>Generated property</i> for <code>PageTypeData.type</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="type", example="ContentPage") 	
	private String type;
	
	public PageTypeData()
	{
		// default constructor
	}
	
	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1811", forRemoval = true)
	public void setType(final String type)
	{
		this.type = type;
	}

	/**
	 * @deprecated no longer needed
	 */
	@Deprecated(since = "1811", forRemoval = true)
	public String getType() 
	{
		return type;
	}
	

}
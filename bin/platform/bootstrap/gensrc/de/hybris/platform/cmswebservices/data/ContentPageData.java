/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the content page.
 *
 * @deprecated no longer needed
 */
@Schema(name="ContentPageData", description="Specifies properties of the content page.")
@Deprecated(since = "6.6", forRemoval = true)
public  class ContentPageData extends AbstractPageData 

{



	/** <i>Generated property</i> for <code>ContentPageData.label</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="label") 	
	private String label;

	/** <i>Generated property</i> for <code>ContentPageData.path</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="path") 	
	private String path;
	
	public ContentPageData()
	{
		// default constructor
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setPath(final String path)
	{
		this.path = path;
	}

	public String getPath() 
	{
		return path;
	}
	

}
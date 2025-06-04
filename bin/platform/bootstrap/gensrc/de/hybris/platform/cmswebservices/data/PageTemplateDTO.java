/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of the page template for a given page.
 */
@Schema(name="PageTemplateDTO", description="Specifies properties of the page template for a given page.")
public  class PageTemplateDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateDTO.pageTypeCode</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageTypeCode", example="ContentPage") 	
	private String pageTypeCode;

	/** <i>Generated property</i> for <code>PageTemplateDTO.active</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="active", example="true") 	
	private Boolean active;
	
	public PageTemplateDTO()
	{
		// default constructor
	}
	
	public void setPageTypeCode(final String pageTypeCode)
	{
		this.pageTypeCode = pageTypeCode;
	}

	public String getPageTypeCode() 
	{
		return pageTypeCode;
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	

}
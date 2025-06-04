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


import java.util.Objects;
/**
 * Specifies a restriction type that can be applied to a given page type.
 */
@Schema(name="PageTypeRestrictionTypeData", description="Specifies a restriction type that can be applied to a given page type.")
public  class PageTypeRestrictionTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTypeRestrictionTypeData.pageType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageType", example="ContentPage") 	
	private String pageType;

	/** <i>Generated property</i> for <code>PageTypeRestrictionTypeData.restrictionType</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="restrictionType", example="CMSUserGroupRestriction") 	
	private String restrictionType;
	
	public PageTypeRestrictionTypeData()
	{
		// default constructor
	}
	
	public void setPageType(final String pageType)
	{
		this.pageType = pageType;
	}

	public String getPageType() 
	{
		return pageType;
	}
	
	public void setRestrictionType(final String restrictionType)
	{
		this.restrictionType = restrictionType;
	}

	public String getRestrictionType() 
	{
		return restrictionType;
	}
	

}
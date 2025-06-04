/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of valid component types for a given content slot.
 */
@Schema(name="ContentSlotTypeRestrictionsWsDTO", description="Specifies a list of valid component types for a given content slot.")
public  class ContentSlotTypeRestrictionsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ContentSlotTypeRestrictionsWsDTO.contentSlotUid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="contentSlotUid", example="Section1Slot-Homepage") 	
	private String contentSlotUid;

	/** <i>Generated property</i> for <code>ContentSlotTypeRestrictionsWsDTO.validComponentTypes</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="validComponentTypes", example="[\"ProductFeatureComponent\", \"CategoryFeatureComponent\"]") 	
	private List<String> validComponentTypes;
	
	public ContentSlotTypeRestrictionsWsDTO()
	{
		// default constructor
	}
	
	public void setContentSlotUid(final String contentSlotUid)
	{
		this.contentSlotUid = contentSlotUid;
	}

	public String getContentSlotUid() 
	{
		return contentSlotUid;
	}
	
	public void setValidComponentTypes(final List<String> validComponentTypes)
	{
		this.validComponentTypes = validComponentTypes;
	}

	public List<String> getValidComponentTypes() 
	{
		return validComponentTypes;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.dto.ContentSlotTypeRestrictionsWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available content slot type restrictions.
 */
@Schema(name="ContentSlotTypeRestrictionsListWsDTO", description="Specifies a list of available content slot type restrictions.")
public  class ContentSlotTypeRestrictionsListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ContentSlotTypeRestrictionsListWsDTO.typeRestrictionsList</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="typeRestrictionsList") 	
	private List<ContentSlotTypeRestrictionsWsDTO> typeRestrictionsList;
	
	public ContentSlotTypeRestrictionsListWsDTO()
	{
		// default constructor
	}
	
	public void setTypeRestrictionsList(final List<ContentSlotTypeRestrictionsWsDTO> typeRestrictionsList)
	{
		this.typeRestrictionsList = typeRestrictionsList;
	}

	public List<ContentSlotTypeRestrictionsWsDTO> getTypeRestrictionsList() 
	{
		return typeRestrictionsList;
	}
	

}
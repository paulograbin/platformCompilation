/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
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
 * Specifies a list of slot ids.
 */
@Schema(name="CMSContentSlotIdListWsDTO", description="Specifies a list of slot ids.")
public  class CMSContentSlotIdListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSContentSlotIdListWsDTO.slotIds</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="slotIds", example="[\"Section1Slot-Homepage\", \"Section2Footer-Homepage\"]") 	
	private List<String> slotIds;
	
	public CMSContentSlotIdListWsDTO()
	{
		// default constructor
	}
	
	public void setSlotIds(final List<String> slotIds)
	{
		this.slotIds = slotIds;
	}

	public List<String> getSlotIds() 
	{
		return slotIds;
	}
	

}
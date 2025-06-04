/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.basesite;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.basesite.BaseSiteWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Base Site List
 */
@Schema(name="BaseSiteList", description="Representation of a Base Site List")
public  class BaseSiteListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of basesites<br/><br/><i>Generated property</i> for <code>BaseSiteListWsDTO.baseSites</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="baseSites", description="List of basesites") 	
	private List<BaseSiteWsDTO> baseSites;
	
	public BaseSiteListWsDTO()
	{
		// default constructor
	}
	
	public void setBaseSites(final List<BaseSiteWsDTO> baseSites)
	{
		this.baseSites = baseSites;
	}

	public List<BaseSiteWsDTO> getBaseSites() 
	{
		return baseSites;
	}
	

}
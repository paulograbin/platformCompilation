/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomizationData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of customizations
 */
@Schema(name="CustomizationList", description="List of customizations")
public  class CustomizationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Pagination details<br/><br/><i>Generated property</i> for <code>CustomizationListWsDTO.pagination</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="pagination", description="Pagination details") 	
	private PaginationWsDTO pagination;

	/** List of customizations<br/><br/><i>Generated property</i> for <code>CustomizationListWsDTO.customizations</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="customizations", description="List of customizations") 	
	private List<CustomizationData> customizations;
	
	public CustomizationListWsDTO()
	{
		// default constructor
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setCustomizations(final List<CustomizationData> customizations)
	{
		this.customizations = customizations;
	}

	public List<CustomizationData> getCustomizations() 
	{
		return customizations;
	}
	

}
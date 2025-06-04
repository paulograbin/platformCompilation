/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.dto.PageContentSlotContainerWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available content slot containers.
 */
@Schema(name="PageContentSlotContainerListWsDTO", description="Specifies a list of available content slot containers.")
public  class PageContentSlotContainerListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotContainerListWsDTO.pageContentSlotContainerList</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pageContentSlotContainerList") 	
	private List<PageContentSlotContainerWsDTO> pageContentSlotContainerList;
	
	public PageContentSlotContainerListWsDTO()
	{
		// default constructor
	}
	
	public void setPageContentSlotContainerList(final List<PageContentSlotContainerWsDTO> pageContentSlotContainerList)
	{
		this.pageContentSlotContainerList = pageContentSlotContainerList;
	}

	public List<PageContentSlotContainerWsDTO> getPageContentSlotContainerList() 
	{
		return pageContentSlotContainerList;
	}
	

}
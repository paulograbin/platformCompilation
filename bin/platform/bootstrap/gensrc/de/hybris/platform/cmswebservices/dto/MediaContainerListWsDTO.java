/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available media containers.
 */
@Schema(name="MediaContainerListWsDTO", description="Specifies a list of available media containers.")
public  class MediaContainerListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaContainerListWsDTO.mediaContainers</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="mediaContainers") 	
	private List<MediaContainerWsDTO> mediaContainers;

	/** <i>Generated property</i> for <code>MediaContainerListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public MediaContainerListWsDTO()
	{
		// default constructor
	}
	
	public void setMediaContainers(final List<MediaContainerWsDTO> mediaContainers)
	{
		this.mediaContainers = mediaContainers;
	}

	public List<MediaContainerWsDTO> getMediaContainers() 
	{
		return mediaContainers;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}
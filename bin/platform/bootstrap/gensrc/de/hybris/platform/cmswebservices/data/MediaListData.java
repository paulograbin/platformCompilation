/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.MediaData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available media.
 */
@Schema(name="MediaListData", description="Specifies a list of available media.")
public  class MediaListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaListData.media</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="media") 	
	private List<MediaData> media;

	/** <i>Generated property</i> for <code>MediaListData.pagination</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public MediaListData()
	{
		// default constructor
	}
	
	public void setMedia(final List<MediaData> media)
	{
		this.media = media;
	}

	public List<MediaData> getMedia() 
	{
		return media;
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
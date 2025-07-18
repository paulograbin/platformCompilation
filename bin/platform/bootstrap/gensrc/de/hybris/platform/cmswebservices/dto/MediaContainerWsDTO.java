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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the media container.
 */
@Schema(name="MediaContainerWsDTO", description="Specifies properties of the media container.")
public  class MediaContainerWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaContainerWsDTO.qualifier</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="qualifier", example="summer-sales-media-container") 	
	private String qualifier;

	/** <i>Generated property</i> for <code>MediaContainerWsDTO.mediaContainerUuid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="mediaContainerUuid", example="encoded-media-container-identifier") 	
	private String mediaContainerUuid;

	/** <i>Generated property</i> for <code>MediaContainerWsDTO.medias</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="medias") 	
	private Map<String, String> medias;

	/** <i>Generated property</i> for <code>MediaContainerWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogVersion", example="Online") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>MediaContainerWsDTO.thumbnailUrl</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="thumbnailUrl", example="/images/summer-sales.jpeg") 	
	private String thumbnailUrl;
	
	public MediaContainerWsDTO()
	{
		// default constructor
	}
	
	public void setQualifier(final String qualifier)
	{
		this.qualifier = qualifier;
	}

	public String getQualifier() 
	{
		return qualifier;
	}
	
	public void setMediaContainerUuid(final String mediaContainerUuid)
	{
		this.mediaContainerUuid = mediaContainerUuid;
	}

	public String getMediaContainerUuid() 
	{
		return mediaContainerUuid;
	}
	
	public void setMedias(final Map<String, String> medias)
	{
		this.medias = medias;
	}

	public Map<String, String> getMedias() 
	{
		return medias;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setThumbnailUrl(final String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl() 
	{
		return thumbnailUrl;
	}
	

}
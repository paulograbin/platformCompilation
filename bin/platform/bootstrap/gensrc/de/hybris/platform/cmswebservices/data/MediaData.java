/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Specifies properties of a specific media.
 */
@Schema(name="MediaData", description="Specifies properties of a specific media.")
public  class MediaData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaData.uuid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>MediaData.code</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="code", example="PreviewData") 	
	private String code;

	/** <i>Generated property</i> for <code>MediaData.catalogId</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>MediaData.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="catalogVersion", example="Online") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>MediaData.mime</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="mime", example="image/png") 	
	private String mime;

	/** <i>Generated property</i> for <code>MediaData.altText</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="altText", example="Text to display if media can't be loaded.") 	
	private String altText;

	/** <i>Generated property</i> for <code>MediaData.description</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="description", example="Text that describes a media.") 	
	private String description;

	/** <i>Generated property</i> for <code>MediaData.url</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="url") 	
	private String url;

	/** <i>Generated property</i> for <code>MediaData.downloadUrl</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="downloadUrl") 	
	private String downloadUrl;
	
	public MediaData()
	{
		// default constructor
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setMime(final String mime)
	{
		this.mime = mime;
	}

	public String getMime() 
	{
		return mime;
	}
	
	public void setAltText(final String altText)
	{
		this.altText = altText;
	}

	public String getAltText() 
	{
		return altText;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setDownloadUrl(final String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadUrl() 
	{
		return downloadUrl;
	}
	

}
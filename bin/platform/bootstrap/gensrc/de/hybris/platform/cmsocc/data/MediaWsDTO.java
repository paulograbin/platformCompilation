/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;


import java.util.Objects;
@XmlRootElement
            @XmlAccessorType(XmlAccessType.FIELD)
public  class MediaWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaWsDTO.code</code> property defined at extension <code>cmsocc</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>MediaWsDTO.catalogId</code> property defined at extension <code>cmsocc</code>. */
	
	private String catalogId;

	/** <i>Generated property</i> for <code>MediaWsDTO.catalogVersion</code> property defined at extension <code>cmsocc</code>. */
	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>MediaWsDTO.mime</code> property defined at extension <code>cmsocc</code>. */
	
	private String mime;

	/** <i>Generated property</i> for <code>MediaWsDTO.altText</code> property defined at extension <code>cmsocc</code>. */
	
	private String altText;

	/** <i>Generated property</i> for <code>MediaWsDTO.description</code> property defined at extension <code>cmsocc</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>MediaWsDTO.url</code> property defined at extension <code>cmsocc</code>. */
	
	private String url;

	/** <i>Generated property</i> for <code>MediaWsDTO.downloadUrl</code> property defined at extension <code>cmsocc</code>. */
	
	private String downloadUrl;
	
	public MediaWsDTO()
	{
		// default constructor
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
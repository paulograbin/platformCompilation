/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto.image;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a profile picture.
 */
@Schema(name="UserAvatar", description="Representation of a profile picture.")
public  class UserAvatarWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** URL of customer profile image in media server. It's optional.<br/><br/><i>Generated property</i> for <code>UserAvatarWsDTO.url</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="url", description="URL of customer profile image in media server. It's optional.", example="/medias/?context=bWFzdGVyfHJvb3R8NTMyMDB8aW1hZ2UvanBlZ3xhRGM1TDJneFl5ODROemszTlRNd016a3dOVFU0TG1wd1p3fDViODZlNmFiZTkyNzFjZDFmM2I5ZWU3OGJhZWEzMjViZDBiZTQ2NjM3YzIyMTg") 	
	private String url;

	/** Image format. It's optional.<br/><br/><i>Generated property</i> for <code>UserAvatarWsDTO.format</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="format", description="Image format. It's optional.", example="jpg") 	
	private String format;
	
	public UserAvatarWsDTO()
	{
		// default constructor
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setFormat(final String format)
	{
		this.format = format;
	}

	public String getFormat() 
	{
		return format;
	}
	

}
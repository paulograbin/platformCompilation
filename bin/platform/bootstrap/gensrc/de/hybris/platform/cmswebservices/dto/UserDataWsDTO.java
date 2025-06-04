/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;


import java.util.Objects;
/**
 * Specifies properties of the user data.
 */
@Schema(name="UserDataWsDTO", description="Specifies properties of the user data.")
public  class UserDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserDataWsDTO.uid</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>UserDataWsDTO.readableLanguages</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="readableLanguages", example="[\"de\", \"hi\"]") 	
	private Set<String> readableLanguages;

	/** <i>Generated property</i> for <code>UserDataWsDTO.writeableLanguages</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="writeableLanguages", example="[\"de\", \"hi\"]") 	
	private Set<String> writeableLanguages;
	
	public UserDataWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setReadableLanguages(final Set<String> readableLanguages)
	{
		this.readableLanguages = readableLanguages;
	}

	public Set<String> getReadableLanguages() 
	{
		return readableLanguages;
	}
	
	public void setWriteableLanguages(final Set<String> writeableLanguages)
	{
		this.writeableLanguages = writeableLanguages;
	}

	public Set<String> getWriteableLanguages() 
	{
		return writeableLanguages;
	}
	

}
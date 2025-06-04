/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Language data
 */
@Schema(name="languageData", description="Language data")
public  class SmarteditLanguageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The name of the language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageData.name</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="name", description="The name of the language data", required=true, example="English") 	
	private String name;

	/** The iso code of the language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageData.isoCode</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="isoCode", description="The iso code of the language data", required=true, example="en") 	
	private String isoCode;
	
	public SmarteditLanguageData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setIsoCode(final String isoCode)
	{
		this.isoCode = isoCode;
	}

	public String getIsoCode() 
	{
		return isoCode;
	}
	

}
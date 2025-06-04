/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import de.hybris.platform.smarteditwebservices.data.SmarteditLanguageData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of languages
 */
@Schema(name="SmarteditLanguageListData", description="List of languages")
public  class SmarteditLanguageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The list of language data<br/><br/><i>Generated property</i> for <code>SmarteditLanguageListData.languages</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="languages", description="The list of language data", required=true) 	
	private List<SmarteditLanguageData> languages;
	
	public SmarteditLanguageListData()
	{
		// default constructor
	}
	
	public void setLanguages(final List<SmarteditLanguageData> languages)
	{
		this.languages = languages;
	}

	public List<SmarteditLanguageData> getLanguages() 
	{
		return languages;
	}
	

}
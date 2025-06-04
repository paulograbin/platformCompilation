/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available languages.
 */
@Schema(name="LanguageListData", description="Specifies a list of available languages.")
public  class LanguageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LanguageListData.languages</code> property defined at extension <code>cmswebservices</code>. */
@Schema(name="languages") 	
	private List<LanguageData> languages;
	
	public LanguageListData()
	{
		// default constructor
	}
	
	public void setLanguages(final List<LanguageData> languages)
	{
		this.languages = languages;
	}

	public List<LanguageData> getLanguages() 
	{
		return languages;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.smarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.smarteditwebservices.data.Theme;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * List of theme that active for smartedit
 */
@Schema(name="ThemeListWsDto", description="List of theme that active for smartedit")
public  class ThemeListWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The list of theme<br/><br/><i>Generated property</i> for <code>ThemeListWsDto.themes</code> property defined at extension <code>smarteditwebservices</code>. */
@Schema(name="themes", description="The list of theme", required=true) 	
	private Collection<Theme> themes;
	
	public ThemeListWsDto()
	{
		// default constructor
	}
	
	public void setThemes(final Collection<Theme> themes)
	{
		this.themes = themes;
	}

	public Collection<Theme> getThemes() 
	{
		return themes;
	}
	

}
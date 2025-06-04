/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.TitleWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Title List
 */
@Schema(name="TitleList", description="Representation of a Title List")
public  class TitleListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of titles<br/><br/><i>Generated property</i> for <code>TitleListWsDTO.titles</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="titles", description="List of titles") 	
	private List<TitleWsDTO> titles;
	
	public TitleListWsDTO()
	{
		// default constructor
	}
	
	public void setTitles(final List<TitleWsDTO> titles)
	{
		this.titles = titles;
	}

	public List<TitleWsDTO> getTitles() 
	{
		return titles;
	}
	

}
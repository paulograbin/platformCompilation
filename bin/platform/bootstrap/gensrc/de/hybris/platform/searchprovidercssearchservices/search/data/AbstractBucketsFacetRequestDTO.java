/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractFacetRequestDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.FacetFilterModeDTO;


import java.util.Objects;
public abstract  class AbstractBucketsFacetRequestDTO extends AbstractFacetRequestDTO 

{



	/** <i>Generated property</i> for <code>AbstractBucketsFacetRequestDTO.filterMode</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private FacetFilterModeDTO filterMode;
	
	public AbstractBucketsFacetRequestDTO()
	{
		// default constructor
	}
	
	public void setFilterMode(final FacetFilterModeDTO filterMode)
	{
		this.filterMode = filterMode;
	}

	public FacetFilterModeDTO getFilterMode() 
	{
		return filterMode;
	}
	

}
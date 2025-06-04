/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractExpressionAndValuesQueryDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.MatchTypeDTO;


import java.util.Objects;
public  class MatchTermsQueryDTO extends AbstractExpressionAndValuesQueryDTO 

{



	/** <i>Generated property</i> for <code>MatchTermsQueryDTO.matchType</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private MatchTypeDTO matchType;
	
	public MatchTermsQueryDTO()
	{
		// default constructor
	}
	
	public void setMatchType(final MatchTypeDTO matchType)
	{
		this.matchType = matchType;
	}

	public MatchTypeDTO getMatchType() 
	{
		return matchType;
	}
	

}
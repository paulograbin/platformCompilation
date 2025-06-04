/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.quote.QuoteWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Quote result list.
 */
@Schema(name="QuoteList", description="Representation of a Quote result list.")
public  class QuoteListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of quotes.<br/><br/><i>Generated property</i> for <code>QuoteListWsDTO.quotes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="quotes", description="List of quotes.") 	
	private List<QuoteWsDTO> quotes;

	/** Pagination of quotes list.<br/><br/><i>Generated property</i> for <code>QuoteListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Pagination of quotes list.") 	
	private PaginationWsDTO pagination;
	
	public QuoteListWsDTO()
	{
		// default constructor
	}
	
	public void setQuotes(final List<QuoteWsDTO> quotes)
	{
		this.quotes = quotes;
	}

	public List<QuoteWsDTO> getQuotes() 
	{
		return quotes;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}
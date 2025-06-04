/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto;

import java.io.Serializable;
import de.hybris.platform.notificationocc.dto.SiteMessageWsDTO;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Site message search result
 */
@Schema(name="siteMessageSearchResult", description="Site message search result")
public  class SiteMessageSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** site messages<br/><br/><i>Generated property</i> for <code>SiteMessageSearchResultWsDTO.messages</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="messages", description="site messages") 	
	private List<SiteMessageWsDTO> messages;

	/** sorting information<br/><br/><i>Generated property</i> for <code>SiteMessageSearchResultWsDTO.sorts</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="sorts", description="sorting information") 	
	private List<SortWsDTO> sorts;

	/** pagination information<br/><br/><i>Generated property</i> for <code>SiteMessageSearchResultWsDTO.pagination</code> property defined at extension <code>notificationocc</code>. */
@Schema(name="pagination", description="pagination information") 	
	private PaginationWsDTO pagination;
	
	public SiteMessageSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setMessages(final List<SiteMessageWsDTO> messages)
	{
		this.messages = messages;
	}

	public List<SiteMessageWsDTO> getMessages() 
	{
		return messages;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
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
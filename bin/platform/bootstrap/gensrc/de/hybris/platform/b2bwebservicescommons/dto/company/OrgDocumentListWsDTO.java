/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BOrgDocumentTypeWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BOrgDocumentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PaginationWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.SortWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a list of organizational documents for the organizational unit.
 */
@Schema(name="OrgDocumentList", description="Representation of a list of organizational documents for the organizational unit.")
public  class OrgDocumentListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of organizational documents.<br/><br/><i>Generated property</i> for <code>OrgDocumentListWsDTO.orgDocuments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgDocuments", description="List of organizational documents.", required=true) 	
	private List<B2BOrgDocumentWsDTO> orgDocuments;

	/** List of sort codes<br/><br/><i>Generated property</i> for <code>OrgDocumentListWsDTO.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sorts", description="List of sort codes") 	
	private List<SortWsDTO> sorts;

	/** List of organizational document types.<br/><br/><i>Generated property</i> for <code>OrgDocumentListWsDTO.orgDocumentTypes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgDocumentTypes", description="List of organizational document types.") 	
	private List<B2BOrgDocumentTypeWsDTO> orgDocumentTypes;

	/** Representation of search results pagination<br/><br/><i>Generated property</i> for <code>OrgDocumentListWsDTO.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="pagination", description="Representation of search results pagination", required=true) 	
	private PaginationWsDTO pagination;
	
	public OrgDocumentListWsDTO()
	{
		// default constructor
	}
	
	public void setOrgDocuments(final List<B2BOrgDocumentWsDTO> orgDocuments)
	{
		this.orgDocuments = orgDocuments;
	}

	public List<B2BOrgDocumentWsDTO> getOrgDocuments() 
	{
		return orgDocuments;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	
	public void setOrgDocumentTypes(final List<B2BOrgDocumentTypeWsDTO> orgDocumentTypes)
	{
		this.orgDocumentTypes = orgDocumentTypes;
	}

	public List<B2BOrgDocumentTypeWsDTO> getOrgDocumentTypes() 
	{
		return orgDocumentTypes;
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
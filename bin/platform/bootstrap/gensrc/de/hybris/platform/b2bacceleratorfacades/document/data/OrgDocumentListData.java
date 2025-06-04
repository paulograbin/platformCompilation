/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.document.data;

import de.hybris.platform.b2bacceleratorfacades.document.data.B2BDocumentTypeData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import java.util.List;


import java.util.Objects;
/**
 * POJO that includes all necessary data for creating proper result for Documents.
 */
public  class OrgDocumentListData<RESULT> extends SearchPageData<RESULT> 

{



	/** <i>Generated property</i> for <code>OrgDocumentListData<RESULT>.documentTypes</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private List<B2BDocumentTypeData> documentTypes;
	
	public OrgDocumentListData()
	{
		// default constructor
	}
	
	public void setDocumentTypes(final List<B2BDocumentTypeData> documentTypes)
	{
		this.documentTypes = documentTypes;
	}

	public List<B2BDocumentTypeData> getDocumentTypes() 
	{
		return documentTypes;
	}
	

}
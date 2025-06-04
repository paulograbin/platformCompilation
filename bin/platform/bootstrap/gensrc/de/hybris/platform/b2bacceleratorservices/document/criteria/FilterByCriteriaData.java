/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorservices.document.criteria;

import java.io.Serializable;


import java.util.Objects;
public  class FilterByCriteriaData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FilterByCriteriaData.startRange</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String startRange;

	/** <i>Generated property</i> for <code>FilterByCriteriaData.endRange</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String endRange;

	/** <i>Generated property</i> for <code>FilterByCriteriaData.documentTypeCode</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String documentTypeCode;

	/** <i>Generated property</i> for <code>FilterByCriteriaData.documentStatus</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String documentStatus;

	/** <i>Generated property</i> for <code>FilterByCriteriaData.filterByValue</code> property defined at extension <code>b2bacceleratorservices</code>. */
	
	private String filterByValue;
	
	public FilterByCriteriaData()
	{
		// default constructor
	}
	
	public void setStartRange(final String startRange)
	{
		this.startRange = startRange;
	}

	public String getStartRange() 
	{
		return startRange;
	}
	
	public void setEndRange(final String endRange)
	{
		this.endRange = endRange;
	}

	public String getEndRange() 
	{
		return endRange;
	}
	
	public void setDocumentTypeCode(final String documentTypeCode)
	{
		this.documentTypeCode = documentTypeCode;
	}

	public String getDocumentTypeCode() 
	{
		return documentTypeCode;
	}
	
	public void setDocumentStatus(final String documentStatus)
	{
		this.documentStatus = documentStatus;
	}

	public String getDocumentStatus() 
	{
		return documentStatus;
	}
	
	public void setFilterByValue(final String filterByValue)
	{
		this.filterByValue = filterByValue;
	}

	public String getFilterByValue() 
	{
		return filterByValue;
	}
	

}
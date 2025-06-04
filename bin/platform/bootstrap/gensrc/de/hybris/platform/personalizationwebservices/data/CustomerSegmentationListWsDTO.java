/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomerSegmentationData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * List of customer segmentations
 */
@Schema(name="CustomerSegmentationList", description="List of customer segmentations")
public  class CustomerSegmentationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Pagination details<br/><br/><i>Generated property</i> for <code>CustomerSegmentationListWsDTO.pagination</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="pagination", description="Pagination details") 	
	private PaginationWsDTO pagination;

	/** List of customer segmentations<br/><br/><i>Generated property</i> for <code>CustomerSegmentationListWsDTO.customerSegmentations</code> property defined at extension <code>personalizationwebservices</code>. */
@Schema(name="customerSegmentations", description="List of customer segmentations") 	
	private List<CustomerSegmentationData> customerSegmentations;
	
	public CustomerSegmentationListWsDTO()
	{
		// default constructor
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setCustomerSegmentations(final List<CustomerSegmentationData> customerSegmentations)
	{
		this.customerSegmentations = customerSegmentations;
	}

	public List<CustomerSegmentationData> getCustomerSegmentations() 
	{
		return customerSegmentations;
	}
	

}
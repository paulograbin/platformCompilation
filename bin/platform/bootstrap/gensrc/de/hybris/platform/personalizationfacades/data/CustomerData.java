/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomerSegmentationData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Customer details
 */
@Schema(name="customer", description="Customer details")
public  class CustomerData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** ID of the customer<br/><br/><i>Generated property</i> for <code>CustomerData.uid</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="uid", description="ID of the customer") 	
	private String uid;

	/** List of customer's segmentation details<br/><br/><i>Generated property</i> for <code>CustomerData.segmentLinks</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="segmentLinks", description="List of customer's segmentation details") 	
	private List<CustomerSegmentationData> segmentLinks;
	
	public CustomerData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setSegmentLinks(final List<CustomerSegmentationData> segmentLinks)
	{
		this.segmentLinks = segmentLinks;
	}

	public List<CustomerSegmentationData> getSegmentLinks() 
	{
		return segmentLinks;
	}
	

}
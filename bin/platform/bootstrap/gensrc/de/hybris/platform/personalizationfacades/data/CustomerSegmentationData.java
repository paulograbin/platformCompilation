/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomerData;
import de.hybris.platform.personalizationfacades.data.SegmentData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;


import java.util.Objects;
/**
 * Customer segmentation
 */
@Schema(name="customerSegmentation", description="Customer segmentation")
public  class CustomerSegmentationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer segmentation code<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.code</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="code", description="Customer segmentation code") 	
	private String code;

	/** Provider identifier<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.provider</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="provider", description="Provider identifier") 	
	private String provider;

	/** Basesite identifier<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.baseSite</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="baseSite", description="Basesite identifier") 	
	private String baseSite;

	/** Affinity of the customer to the segment<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.affinity</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="affinity", description="Affinity of the customer to the segment") 	
	private BigDecimal affinity;

	/** Details of the customer<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.customer</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="customer", description="Details of the customer") 	
	private CustomerData customer;

	/** Details of the segment<br/><br/><i>Generated property</i> for <code>CustomerSegmentationData.segment</code> property defined at extension <code>personalizationfacades</code>. */
@Schema(name="segment", description="Details of the segment") 	
	private SegmentData segment;
	
	public CustomerSegmentationData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setProvider(final String provider)
	{
		this.provider = provider;
	}

	public String getProvider() 
	{
		return provider;
	}
	
	public void setBaseSite(final String baseSite)
	{
		this.baseSite = baseSite;
	}

	public String getBaseSite() 
	{
		return baseSite;
	}
	
	public void setAffinity(final BigDecimal affinity)
	{
		this.affinity = affinity;
	}

	public BigDecimal getAffinity() 
	{
		return affinity;
	}
	
	public void setCustomer(final CustomerData customer)
	{
		this.customer = customer;
	}

	public CustomerData getCustomer() 
	{
		return customer;
	}
	
	public void setSegment(final SegmentData segment)
	{
		this.segment = segment;
	}

	public SegmentData getSegment() 
	{
		return segment;
	}
	

}
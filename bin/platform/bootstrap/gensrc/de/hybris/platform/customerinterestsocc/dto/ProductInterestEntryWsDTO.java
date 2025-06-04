/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerinterestsocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Product interest entry
 */
@Schema(name="productInterestEntry", description="Product interest entry")
public  class ProductInterestEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product interest type<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.interestType</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="interestType", description="Product interest type") 	
	private String interestType;

	/** Added date of product interest<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.dateAdded</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="dateAdded", description="Added date of product interest") 	
	private Date dateAdded;

	/** Expiration date of product interest<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.expirationDate</code> property defined at extension <code>customerinterestsocc</code>. */
@Schema(name="expirationDate", description="Expiration date of product interest") 	
	private Date expirationDate;
	
	public ProductInterestEntryWsDTO()
	{
		// default constructor
	}
	
	public void setInterestType(final String interestType)
	{
		this.interestType = interestType;
	}

	public String getInterestType() 
	{
		return interestType;
	}
	
	public void setDateAdded(final Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	public Date getDateAdded() 
	{
		return dateAdded;
	}
	
	public void setExpirationDate(final Date expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	public Date getExpirationDate() 
	{
		return expirationDate;
	}
	

}
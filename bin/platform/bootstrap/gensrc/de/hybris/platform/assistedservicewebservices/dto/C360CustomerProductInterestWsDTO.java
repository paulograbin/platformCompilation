/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.C360ProductWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Customer interest in product
 */
@Schema(name="C360CustomerProductInterest", description="Customer interest in product")
public  class C360CustomerProductInterestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Representation of a C360 Product.<br/><br/><i>Generated property</i> for <code>C360CustomerProductInterestWsDTO.product</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="product", description="Representation of a C360 Product.", required=true) 	
	private C360ProductWsDTO product;
	
	public C360CustomerProductInterestWsDTO()
	{
		// default constructor
	}
	
	public void setProduct(final C360ProductWsDTO product)
	{
		this.product = product;
	}

	public C360ProductWsDTO getProduct() 
	{
		return product;
	}
	

}
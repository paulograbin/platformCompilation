/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ReturnRequestStatusWsDTOType;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of modifications for a return request
 */
@Schema(name="ReturnRequestModification", description="Representation of modifications for a return request")
public  class ReturnRequestModificationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Status of the return request<br/><br/><i>Generated property</i> for <code>ReturnRequestModificationWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Status of the return request") 	
	private ReturnRequestStatusWsDTOType status;
	
	public ReturnRequestModificationWsDTO()
	{
		// default constructor
	}
	
	public void setStatus(final ReturnRequestStatusWsDTOType status)
	{
		this.status = status;
	}

	public ReturnRequestStatusWsDTOType getStatus() 
	{
		return status;
	}
	

}
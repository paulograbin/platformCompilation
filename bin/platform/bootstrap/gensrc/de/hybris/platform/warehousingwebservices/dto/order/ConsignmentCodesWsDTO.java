/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class ConsignmentCodesWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentCodesWsDTO.codes</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<String> codes;
	
	public ConsignmentCodesWsDTO()
	{
		// default constructor
	}
	
	public void setCodes(final List<String> codes)
	{
		this.codes = codes;
	}

	public List<String> getCodes() 
	{
		return codes;
	}
	

}
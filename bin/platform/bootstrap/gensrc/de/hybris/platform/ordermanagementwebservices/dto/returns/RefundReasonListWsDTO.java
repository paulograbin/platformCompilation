/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.returns;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class RefundReasonListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RefundReasonListWsDTO.refundReasons</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<String> refundReasons;
	
	public RefundReasonListWsDTO()
	{
		// default constructor
	}
	
	public void setRefundReasons(final List<String> refundReasons)
	{
		this.refundReasons = refundReasons;
	}

	public List<String> getRefundReasons() 
	{
		return refundReasons;
	}
	

}
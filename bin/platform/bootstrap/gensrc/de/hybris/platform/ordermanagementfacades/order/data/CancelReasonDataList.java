/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.CancelReason;
import java.util.List;


import java.util.Objects;
public  class CancelReasonDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CancelReasonDataList.reasons</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<CancelReason> reasons;
	
	public CancelReasonDataList()
	{
		// default constructor
	}
	
	public void setReasons(final List<CancelReason> reasons)
	{
		this.reasons = reasons;
	}

	public List<CancelReason> getReasons() 
	{
		return reasons;
	}
	

}
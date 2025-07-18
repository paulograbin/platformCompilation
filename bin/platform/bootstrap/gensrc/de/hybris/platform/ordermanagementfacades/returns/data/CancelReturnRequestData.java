/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.CancelReason;


import java.util.Objects;
public  class CancelReturnRequestData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CancelReturnRequestData.code</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>CancelReturnRequestData.cancelReason</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private CancelReason cancelReason;

	/** <i>Generated property</i> for <code>CancelReturnRequestData.notes</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private String notes;
	
	public CancelReturnRequestData()
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
	
	public void setCancelReason(final CancelReason cancelReason)
	{
		this.cancelReason = cancelReason;
	}

	public CancelReason getCancelReason() 
	{
		return cancelReason;
	}
	
	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

	public String getNotes() 
	{
		return notes;
	}
	

}
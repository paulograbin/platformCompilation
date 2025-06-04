/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.order;

import java.io.Serializable;


import java.util.Objects;
public  class OrderCancelRecordEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderCancelRecordEntryWsDTO.cancelResult</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String cancelResult;

	/** <i>Generated property</i> for <code>OrderCancelRecordEntryWsDTO.refusedMessage</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String refusedMessage;
	
	public OrderCancelRecordEntryWsDTO()
	{
		// default constructor
	}
	
	public void setCancelResult(final String cancelResult)
	{
		this.cancelResult = cancelResult;
	}

	public String getCancelResult() 
	{
		return cancelResult;
	}
	
	public void setRefusedMessage(final String refusedMessage)
	{
		this.refusedMessage = refusedMessage;
	}

	public String getRefusedMessage() 
	{
		return refusedMessage;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.PaymentModeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Payment Mode List
 */
@Schema(name="PaymentModeList", description="Representation of a Payment Mode List")
public  class PaymentModeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of payment modes<br/><br/><i>Generated property</i> for <code>PaymentModeListWsDTO.paymentModes</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="paymentModes", description="List of payment modes") 	
	private List<PaymentModeWsDTO> paymentModes;
	
	public PaymentModeListWsDTO()
	{
		// default constructor
	}
	
	public void setPaymentModes(final List<PaymentModeWsDTO> paymentModes)
	{
		this.paymentModes = paymentModes;
	}

	public List<PaymentModeWsDTO> getPaymentModes() 
	{
		return paymentModes;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import de.hybris.platform.commercewebservicescommons.dto.order.AbstractOrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.ConsignmentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a order. Note that sapBillingAddress is mutually exclusive with paymentInfo.billingAddress, which is used when the billing address is created concurrently with the paymentInfo.
        sapBillingAddress is used when there is a need to save the billing address, but the related paymentInfo has not been created yet.
 */
@Schema(name="Order", description="Representation of a order. Note that sapBillingAddress is mutually exclusive with paymentInfo.billingAddress, which is used when the billing address is created concurrently with the paymentInfo. sapBillingAddress is used when there is a need to save the billing address, but the related paymentInfo has not been created yet.")
public  class OrderWsDTO extends AbstractOrderWsDTO 

{



	/** Date of order creation<br/><br/><i>Generated property</i> for <code>OrderWsDTO.created</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="created", description="Date of order creation") 	
	private Date created;

	/** Status of order<br/><br/><i>Generated property</i> for <code>OrderWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Status of order") 	
	private String status;

	/** Status display<br/><br/><i>Generated property</i> for <code>OrderWsDTO.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusDisplay", description="Status display") 	
	private String statusDisplay;

	/** Flag showing if customer is Guest customer<br/><br/><i>Generated property</i> for <code>OrderWsDTO.guestCustomer</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="guestCustomer", description="Flag showing if customer is Guest customer") 	
	private Boolean guestCustomer;

	/** List of consignment<br/><br/><i>Generated property</i> for <code>OrderWsDTO.consignments</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="consignments", description="List of consignment") 	
	private List<ConsignmentWsDTO> consignments;

	/** Order delivery status<br/><br/><i>Generated property</i> for <code>OrderWsDTO.deliveryStatus</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryStatus", description="Order delivery status") 	
	private String deliveryStatus;

	/** Order delivery status display<br/><br/><i>Generated property</i> for <code>OrderWsDTO.deliveryStatusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryStatusDisplay", description="Order delivery status display") 	
	private String deliveryStatusDisplay;

	/** List of unconsigned order entries<br/><br/><i>Generated property</i> for <code>OrderWsDTO.unconsignedEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="unconsignedEntries", description="List of unconsigned order entries") 	
	private List<OrderEntryWsDTO> unconsignedEntries;

	/** Boolean flag showing if order is cancellable<br/><br/><i>Generated property</i> for <code>OrderWsDTO.cancellable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="cancellable", description="Boolean flag showing if order is cancellable", example="true") 	
	private Boolean cancellable;

	/** Boolean flag showing if order is returnable<br/><br/><i>Generated property</i> for <code>OrderWsDTO.returnable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="returnable", description="Boolean flag showing if order is returnable", example="true") 	
	private Boolean returnable;

	/** <i>Generated property</i> for <code>OrderWsDTO.paymentAddress</code> property defined at extension <code>ordermanagementwebservices</code>. */
@Schema(name="paymentAddress") 	
	private AddressWsDTO paymentAddress;
	
	public OrderWsDTO()
	{
		// default constructor
	}
	
	public void setCreated(final Date created)
	{
		this.created = created;
	}

	public Date getCreated() 
	{
		return created;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setGuestCustomer(final Boolean guestCustomer)
	{
		this.guestCustomer = guestCustomer;
	}

	public Boolean getGuestCustomer() 
	{
		return guestCustomer;
	}
	
	public void setConsignments(final List<ConsignmentWsDTO> consignments)
	{
		this.consignments = consignments;
	}

	public List<ConsignmentWsDTO> getConsignments() 
	{
		return consignments;
	}
	
	public void setDeliveryStatus(final String deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryStatus() 
	{
		return deliveryStatus;
	}
	
	public void setDeliveryStatusDisplay(final String deliveryStatusDisplay)
	{
		this.deliveryStatusDisplay = deliveryStatusDisplay;
	}

	public String getDeliveryStatusDisplay() 
	{
		return deliveryStatusDisplay;
	}
	
	public void setUnconsignedEntries(final List<OrderEntryWsDTO> unconsignedEntries)
	{
		this.unconsignedEntries = unconsignedEntries;
	}

	public List<OrderEntryWsDTO> getUnconsignedEntries() 
	{
		return unconsignedEntries;
	}
	
	public void setCancellable(final Boolean cancellable)
	{
		this.cancellable = cancellable;
	}

	public Boolean getCancellable() 
	{
		return cancellable;
	}
	
	public void setReturnable(final Boolean returnable)
	{
		this.returnable = returnable;
	}

	public Boolean getReturnable() 
	{
		return returnable;
	}
	
	public void setPaymentAddress(final AddressWsDTO paymentAddress)
	{
		this.paymentAddress = paymentAddress;
	}

	public AddressWsDTO getPaymentAddress() 
	{
		return paymentAddress;
	}
	

}
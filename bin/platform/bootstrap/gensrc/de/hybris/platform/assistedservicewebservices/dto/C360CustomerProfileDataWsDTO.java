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
import de.hybris.platform.assistedservicewebservices.dto.C360AddressWsDTO;
import de.hybris.platform.assistedservicewebservices.dto.C360PaymentDetailWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Customer Profile Data
 */
@Schema(name="C360CustomerProfileData", description="Representation of a Customer Profile Data")
public  class C360CustomerProfileDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The billing address of customer<br/><br/><i>Generated property</i> for <code>C360CustomerProfileDataWsDTO.billingAddress</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="billingAddress", description="The billing address of customer") 	
	private C360AddressWsDTO billingAddress;

	/** The delivery address of customer<br/><br/><i>Generated property</i> for <code>C360CustomerProfileDataWsDTO.deliveryAddress</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="deliveryAddress", description="The delivery address of customer") 	
	private C360AddressWsDTO deliveryAddress;

	/** The phone1 of customer<br/><br/><i>Generated property</i> for <code>C360CustomerProfileDataWsDTO.phone1</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="phone1", description="The phone1 of customer", example="090 0987 432") 	
	private String phone1;

	/** The phone2 of customer<br/><br/><i>Generated property</i> for <code>C360CustomerProfileDataWsDTO.phone2</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="phone2", description="The phone2 of customer", example="090 0987 653") 	
	private String phone2;

	/** The payment detail information list, returns up to 3 payment details<br/><br/><i>Generated property</i> for <code>C360CustomerProfileDataWsDTO.paymentDetails</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="paymentDetails", description="The payment detail information list, returns up to 3 payment details") 	
	private List<C360PaymentDetailWsDTO> paymentDetails;
	
	public C360CustomerProfileDataWsDTO()
	{
		// default constructor
	}
	
	public void setBillingAddress(final C360AddressWsDTO billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public C360AddressWsDTO getBillingAddress() 
	{
		return billingAddress;
	}
	
	public void setDeliveryAddress(final C360AddressWsDTO deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public C360AddressWsDTO getDeliveryAddress() 
	{
		return deliveryAddress;
	}
	
	public void setPhone1(final String phone1)
	{
		this.phone1 = phone1;
	}

	public String getPhone1() 
	{
		return phone1;
	}
	
	public void setPhone2(final String phone2)
	{
		this.phone2 = phone2;
	}

	public String getPhone2() 
	{
		return phone2;
	}
	
	public void setPaymentDetails(final List<C360PaymentDetailWsDTO> paymentDetails)
	{
		this.paymentDetails = paymentDetails;
	}

	public List<C360PaymentDetailWsDTO> getPaymentDetails() 
	{
		return paymentDetails;
	}
	

}
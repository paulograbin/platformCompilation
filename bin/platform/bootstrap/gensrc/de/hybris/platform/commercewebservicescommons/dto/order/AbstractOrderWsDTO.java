/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryModeWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.DeliveryOrderEntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.EntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.PaymentDetailsWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.PickupOrderEntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PromotionResultWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.voucher.VoucherWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Abstract Order
 */
@Schema(name="AbstractOrder", description="Representation of an Abstract Order")
public  class AbstractOrderWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code number of order<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code number of order") 	
	private String code;

	/** Flag stating iv value is net-value<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.net</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="net", description="Flag stating iv value is net-value") 	
	private Boolean net;

	/** Total price with tax<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.totalPriceWithTax</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalPriceWithTax", description="Total price with tax") 	
	private PriceWsDTO totalPriceWithTax;

	/** Total price value<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.totalPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalPrice", description="Total price value") 	
	private PriceWsDTO totalPrice;

	/** Total tax price<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.totalTax</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalTax", description="Total tax price") 	
	private PriceWsDTO totalTax;

	/** Subtotal price<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.subTotal</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="subTotal", description="Subtotal price") 	
	private PriceWsDTO subTotal;

	/** Delivery cost<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.deliveryCost</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryCost", description="Delivery cost") 	
	private PriceWsDTO deliveryCost;

	/** List of order entries<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entries", description="List of order entries") 	
	private List<OrderEntryWsDTO> entries;

	/** List of entry groups<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.entryGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entryGroups", description="List of entry groups") 	
	private List<EntryGroupWsDTO> entryGroups;

	/** <i>Generated property</i> for <code>AbstractOrderWsDTO.totalItems</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalItems") 	
	private Integer totalItems;

	/** Delivery mode information<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.deliveryMode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryMode", description="Delivery mode information") 	
	private DeliveryModeWsDTO deliveryMode;

	/** Delivery address<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.deliveryAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryAddress", description="Delivery address") 	
	private AddressWsDTO deliveryAddress;

	/** Payment information<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.paymentInfo</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="paymentInfo", description="Payment information") 	
	private PaymentDetailsWsDTO paymentInfo;

	/** List of applied order promotions<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.appliedOrderPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="appliedOrderPromotions", description="List of applied order promotions") 	
	private List<PromotionResultWsDTO> appliedOrderPromotions;

	/** List of applied product promotions<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.appliedProductPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="appliedProductPromotions", description="List of applied product promotions") 	
	private List<PromotionResultWsDTO> appliedProductPromotions;

	/** Product discounts<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.productDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="productDiscounts", description="Product discounts") 	
	private PriceWsDTO productDiscounts;

	/** Order discounts<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.orderDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="orderDiscounts", description="Order discounts") 	
	private PriceWsDTO orderDiscounts;

	/** Total discounts<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.totalDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalDiscounts", description="Total discounts") 	
	private PriceWsDTO totalDiscounts;

	/** Site<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.site</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="site", description="Site") 	
	private String site;

	/** Store<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.store</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="store", description="Store") 	
	private String store;

	/** Guest user id identifier<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.guid</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="guid", description="Guest user id identifier") 	
	private String guid;

	/** Flag showing if order is calculated<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.calculated</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="calculated", description="Flag showing if order is calculated") 	
	private Boolean calculated;

	/** List of applied vouchers<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.appliedVouchers</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="appliedVouchers", description="List of applied vouchers") 	
	private List<VoucherWsDTO> appliedVouchers;

	/** User information<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.user</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="user", description="User information") 	
	private PrincipalWsDTO user;

	/** List of pickup order entry group<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.pickupOrderGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pickupOrderGroups", description="List of pickup order entry group") 	
	private List<PickupOrderEntryGroupWsDTO> pickupOrderGroups;

	/** List of delivery order entries group<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.deliveryOrderGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryOrderGroups", description="List of delivery order entries group") 	
	private List<DeliveryOrderEntryGroupWsDTO> deliveryOrderGroups;

	/** Quantity of pickup items<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.pickupItemsQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="pickupItemsQuantity", description="Quantity of pickup items") 	
	private Long pickupItemsQuantity;

	/** Quantity of delivery items<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.deliveryItemsQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryItemsQuantity", description="Quantity of delivery items") 	
	private Long deliveryItemsQuantity;

	/** Customer requested date for order retrieval<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.requestedRetrievalAt</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="requestedRetrievalAt", description="Customer requested date for order retrieval") 	
	private String requestedRetrievalAt;

	/** Billing address, which is mutually exclusive with paymentInfo.billingAddress.<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.sapBillingAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapBillingAddress", description="Billing address, which is mutually exclusive with paymentInfo.billingAddress.") 	
	private AddressWsDTO sapBillingAddress;

	/** Email of customer.<br/><br/><i>Generated property</i> for <code>AbstractOrderWsDTO.sapCustomerEmail</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="sapCustomerEmail", description="Email of customer.", example="xxx.yy@zz.com") 	
	private String sapCustomerEmail;
	
	public AbstractOrderWsDTO()
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
	
	public void setNet(final Boolean net)
	{
		this.net = net;
	}

	public Boolean getNet() 
	{
		return net;
	}
	
	public void setTotalPriceWithTax(final PriceWsDTO totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public PriceWsDTO getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
	public void setTotalPrice(final PriceWsDTO totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public PriceWsDTO getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setTotalTax(final PriceWsDTO totalTax)
	{
		this.totalTax = totalTax;
	}

	public PriceWsDTO getTotalTax() 
	{
		return totalTax;
	}
	
	public void setSubTotal(final PriceWsDTO subTotal)
	{
		this.subTotal = subTotal;
	}

	public PriceWsDTO getSubTotal() 
	{
		return subTotal;
	}
	
	public void setDeliveryCost(final PriceWsDTO deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	public PriceWsDTO getDeliveryCost() 
	{
		return deliveryCost;
	}
	
	public void setEntries(final List<OrderEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<OrderEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setEntryGroups(final List<EntryGroupWsDTO> entryGroups)
	{
		this.entryGroups = entryGroups;
	}

	public List<EntryGroupWsDTO> getEntryGroups() 
	{
		return entryGroups;
	}
	
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}

	public Integer getTotalItems() 
	{
		return totalItems;
	}
	
	public void setDeliveryMode(final DeliveryModeWsDTO deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

	public DeliveryModeWsDTO getDeliveryMode() 
	{
		return deliveryMode;
	}
	
	public void setDeliveryAddress(final AddressWsDTO deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public AddressWsDTO getDeliveryAddress() 
	{
		return deliveryAddress;
	}
	
	public void setPaymentInfo(final PaymentDetailsWsDTO paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}

	public PaymentDetailsWsDTO getPaymentInfo() 
	{
		return paymentInfo;
	}
	
	public void setAppliedOrderPromotions(final List<PromotionResultWsDTO> appliedOrderPromotions)
	{
		this.appliedOrderPromotions = appliedOrderPromotions;
	}

	public List<PromotionResultWsDTO> getAppliedOrderPromotions() 
	{
		return appliedOrderPromotions;
	}
	
	public void setAppliedProductPromotions(final List<PromotionResultWsDTO> appliedProductPromotions)
	{
		this.appliedProductPromotions = appliedProductPromotions;
	}

	public List<PromotionResultWsDTO> getAppliedProductPromotions() 
	{
		return appliedProductPromotions;
	}
	
	public void setProductDiscounts(final PriceWsDTO productDiscounts)
	{
		this.productDiscounts = productDiscounts;
	}

	public PriceWsDTO getProductDiscounts() 
	{
		return productDiscounts;
	}
	
	public void setOrderDiscounts(final PriceWsDTO orderDiscounts)
	{
		this.orderDiscounts = orderDiscounts;
	}

	public PriceWsDTO getOrderDiscounts() 
	{
		return orderDiscounts;
	}
	
	public void setTotalDiscounts(final PriceWsDTO totalDiscounts)
	{
		this.totalDiscounts = totalDiscounts;
	}

	public PriceWsDTO getTotalDiscounts() 
	{
		return totalDiscounts;
	}
	
	public void setSite(final String site)
	{
		this.site = site;
	}

	public String getSite() 
	{
		return site;
	}
	
	public void setStore(final String store)
	{
		this.store = store;
	}

	public String getStore() 
	{
		return store;
	}
	
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}

	public String getGuid() 
	{
		return guid;
	}
	
	public void setCalculated(final Boolean calculated)
	{
		this.calculated = calculated;
	}

	public Boolean getCalculated() 
	{
		return calculated;
	}
	
	public void setAppliedVouchers(final List<VoucherWsDTO> appliedVouchers)
	{
		this.appliedVouchers = appliedVouchers;
	}

	public List<VoucherWsDTO> getAppliedVouchers() 
	{
		return appliedVouchers;
	}
	
	public void setUser(final PrincipalWsDTO user)
	{
		this.user = user;
	}

	public PrincipalWsDTO getUser() 
	{
		return user;
	}
	
	public void setPickupOrderGroups(final List<PickupOrderEntryGroupWsDTO> pickupOrderGroups)
	{
		this.pickupOrderGroups = pickupOrderGroups;
	}

	public List<PickupOrderEntryGroupWsDTO> getPickupOrderGroups() 
	{
		return pickupOrderGroups;
	}
	
	public void setDeliveryOrderGroups(final List<DeliveryOrderEntryGroupWsDTO> deliveryOrderGroups)
	{
		this.deliveryOrderGroups = deliveryOrderGroups;
	}

	public List<DeliveryOrderEntryGroupWsDTO> getDeliveryOrderGroups() 
	{
		return deliveryOrderGroups;
	}
	
	public void setPickupItemsQuantity(final Long pickupItemsQuantity)
	{
		this.pickupItemsQuantity = pickupItemsQuantity;
	}

	public Long getPickupItemsQuantity() 
	{
		return pickupItemsQuantity;
	}
	
	public void setDeliveryItemsQuantity(final Long deliveryItemsQuantity)
	{
		this.deliveryItemsQuantity = deliveryItemsQuantity;
	}

	public Long getDeliveryItemsQuantity() 
	{
		return deliveryItemsQuantity;
	}
	
	public void setRequestedRetrievalAt(final String requestedRetrievalAt)
	{
		this.requestedRetrievalAt = requestedRetrievalAt;
	}

	public String getRequestedRetrievalAt() 
	{
		return requestedRetrievalAt;
	}
	
	public void setSapBillingAddress(final AddressWsDTO sapBillingAddress)
	{
		this.sapBillingAddress = sapBillingAddress;
	}

	public AddressWsDTO getSapBillingAddress() 
	{
		return sapBillingAddress;
	}
	
	public void setSapCustomerEmail(final String sapCustomerEmail)
	{
		this.sapCustomerEmail = sapCustomerEmail;
	}

	public String getSapCustomerEmail() 
	{
		return sapCustomerEmail;
	}
	

}
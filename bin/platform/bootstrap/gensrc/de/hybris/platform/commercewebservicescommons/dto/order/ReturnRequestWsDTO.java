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
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.ReturnRequestEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a return request for an order
 */
@Schema(name="ReturnRequest", description="Representation of a return request for an order")
public  class ReturnRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Boolean flag for whether the return request is cancellable<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.cancellable</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="cancellable", description="Boolean flag for whether the return request is cancellable", example="true") 	
	private Boolean cancellable;

	/** Return request code<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Return request code", example="00000001") 	
	private String code;

	/** Date of the return request creation<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.creationTime</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="creationTime", description="Date of the return request creation", example="2020-12-31T09:00:00+0000") 	
	private Date creationTime;

	/** Delivery cost<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.deliveryCost</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deliveryCost", description="Delivery cost") 	
	private PriceWsDTO deliveryCost;

	/** Order related to the return request<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.order</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="order", description="Order related to the return request") 	
	private OrderWsDTO order;

	/** Boolean flag for whether there is a delivery cost for refund<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.refundDeliveryCost</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="refundDeliveryCost", description="Boolean flag for whether there is a delivery cost for refund", example="false") 	
	private Boolean refundDeliveryCost;

	/** Entries of the return request which contains information about the returned product<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.returnEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="returnEntries", description="Entries of the return request which contains information about the returned product") 	
	private List<ReturnRequestEntryWsDTO> returnEntries;

	/** URL of the return label<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.returnLabelDownloadUrl</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="returnLabelDownloadUrl", description="URL of the return label") 	
	private String returnLabelDownloadUrl;

	/** Return merchandise authorization number<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.rma</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="rma", description="Return merchandise authorization number", example="00000001") 	
	private String rma;

	/** Status of return request<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Status of return request") 	
	private String status;

	/** Subtotal price<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.subTotal</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="subTotal", description="Subtotal price") 	
	private PriceWsDTO subTotal;

	/** Total price<br/><br/><i>Generated property</i> for <code>ReturnRequestWsDTO.totalPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="totalPrice", description="Total price") 	
	private PriceWsDTO totalPrice;
	
	public ReturnRequestWsDTO()
	{
		// default constructor
	}
	
	public void setCancellable(final Boolean cancellable)
	{
		this.cancellable = cancellable;
	}

	public Boolean getCancellable() 
	{
		return cancellable;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	public void setDeliveryCost(final PriceWsDTO deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	public PriceWsDTO getDeliveryCost() 
	{
		return deliveryCost;
	}
	
	public void setOrder(final OrderWsDTO order)
	{
		this.order = order;
	}

	public OrderWsDTO getOrder() 
	{
		return order;
	}
	
	public void setRefundDeliveryCost(final Boolean refundDeliveryCost)
	{
		this.refundDeliveryCost = refundDeliveryCost;
	}

	public Boolean getRefundDeliveryCost() 
	{
		return refundDeliveryCost;
	}
	
	public void setReturnEntries(final List<ReturnRequestEntryWsDTO> returnEntries)
	{
		this.returnEntries = returnEntries;
	}

	public List<ReturnRequestEntryWsDTO> getReturnEntries() 
	{
		return returnEntries;
	}
	
	public void setReturnLabelDownloadUrl(final String returnLabelDownloadUrl)
	{
		this.returnLabelDownloadUrl = returnLabelDownloadUrl;
	}

	public String getReturnLabelDownloadUrl() 
	{
		return returnLabelDownloadUrl;
	}
	
	public void setRma(final String rma)
	{
		this.rma = rma;
	}

	public String getRma() 
	{
		return rma;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setSubTotal(final PriceWsDTO subTotal)
	{
		this.subTotal = subTotal;
	}

	public PriceWsDTO getSubTotal() 
	{
		return subTotal;
	}
	
	public void setTotalPrice(final PriceWsDTO totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public PriceWsDTO getTotalPrice() 
	{
		return totalPrice;
	}
	

}
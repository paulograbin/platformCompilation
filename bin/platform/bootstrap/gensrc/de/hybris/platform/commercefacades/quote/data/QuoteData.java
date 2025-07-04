/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:26 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.quote.data;

import de.hybris.platform.commercefacades.data.SAPAttachmentData;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.core.enums.QuoteState;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class QuoteData extends AbstractOrderData 

{



	/** <i>Generated property</i> for <code>QuoteData.version</code> property defined at extension <code>commercefacades</code>. */
	
	private Integer version;

	/** <i>Generated property</i> for <code>QuoteData.state</code> property defined at extension <code>commercefacades</code>. */
	
	private QuoteState state;

	/** <i>Generated property</i> for <code>QuoteData.creationTime</code> property defined at extension <code>commercefacades</code>. */
	
	private Date creationTime;

	/** <i>Generated property</i> for <code>QuoteData.updatedTime</code> property defined at extension <code>commercefacades</code>. */
	
	private Date updatedTime;

	/** <i>Generated property</i> for <code>QuoteData.hasCart</code> property defined at extension <code>commercefacades</code>. */
	
	private Boolean hasCart;

	/** <i>Generated property</i> for <code>QuoteData.orderCode</code> property defined at extension <code>commercefacades</code>. */
	
	private String orderCode;

	/** <i>Generated property</i> for <code>QuoteData.previousEstimatedTotal</code> property defined at extension <code>commercefacades</code>. */
	
	private PriceData previousEstimatedTotal;

	/** <i>Generated property</i> for <code>QuoteData.sapSubtotalExcludingOrderLevelDiscount</code> property defined at extension <code>commercefacades</code>. */
	
	private PriceData sapSubtotalExcludingOrderLevelDiscount;

	/** <i>Generated property</i> for <code>QuoteData.sapAttachments</code> property defined at extension <code>commercefacades</code>. */
	
	private List<SAPAttachmentData> sapAttachments;
	
	public QuoteData()
	{
		// default constructor
	}
	
	public void setVersion(final Integer version)
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	
	public void setState(final QuoteState state)
	{
		this.state = state;
	}

	public QuoteState getState() 
	{
		return state;
	}
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	public void setUpdatedTime(final Date updatedTime)
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() 
	{
		return updatedTime;
	}
	
	public void setHasCart(final Boolean hasCart)
	{
		this.hasCart = hasCart;
	}

	public Boolean getHasCart() 
	{
		return hasCart;
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	
	public void setPreviousEstimatedTotal(final PriceData previousEstimatedTotal)
	{
		this.previousEstimatedTotal = previousEstimatedTotal;
	}

	public PriceData getPreviousEstimatedTotal() 
	{
		return previousEstimatedTotal;
	}
	
	public void setSapSubtotalExcludingOrderLevelDiscount(final PriceData sapSubtotalExcludingOrderLevelDiscount)
	{
		this.sapSubtotalExcludingOrderLevelDiscount = sapSubtotalExcludingOrderLevelDiscount;
	}

	public PriceData getSapSubtotalExcludingOrderLevelDiscount() 
	{
		return sapSubtotalExcludingOrderLevelDiscount;
	}
	
	public void setSapAttachments(final List<SAPAttachmentData> sapAttachments)
	{
		this.sapAttachments = sapAttachments;
	}

	public List<SAPAttachmentData> getSapAttachments() 
	{
		return sapAttachments;
	}
	

}
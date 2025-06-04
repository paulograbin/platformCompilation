/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.comments.CommentWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.EntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.webservicescommons.dto.SAPAttachmentWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;


import java.util.Objects;
/**
 * Representation of the quote object.
 */
@Schema(name="Quote", description="Representation of the quote object.")
public  class QuoteWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Expiration time of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.expirationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="expirationTime", description="Expiration time of the quote.", required=true, example="yyyy-MM-ddTHH:mm:ss+0000") 	
	private Date expirationTime;

	/** Code of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="code", description="Code of the quote.", required=true, example="0003005") 	
	private String code;

	/** Name of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Name of the quote.", required=true, example="Quote 0003005") 	
	private String name;

	/** Current state of the quote. Possible state values - DRAFT, SUBMITTED, OFFER, CANCELLED, EXPIRED, etc.. The list of the states can be extended.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.state</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="state", description="Current state of the quote. Possible state values - DRAFT, SUBMITTED, OFFER, CANCELLED, EXPIRED, etc.. The list of the states can be extended.", required=true, example="CANCELLED") 	
	private String state;

	/** Description of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.description</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="description", description="Description of the quote.", required=false, example="Quote description") 	
	private String description;

	/** Current version of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.version</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="version", description="Current version of the quote.", required=true, example="1") 	
	private Integer version;

	/** Minimum subtotal value for the quote in the currency of the store.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.threshold</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="threshold", description="Minimum subtotal value for the quote in the currency of the store.", required=true, example="25000") 	
	private Double threshold;

	/** Id of the cart, which is linked to the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.cartId</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="cartId", description="Id of the cart, which is linked to the quote.", required=false, example="000350") 	
	private String cartId;

	/** Date of quote creation.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.creationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="creationTime", description="Date of quote creation.", required=true, example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationTime;

	/** Date of the last quote update.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.updatedTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="updatedTime", description="Date of the last quote update.", required=true, example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date updatedTime;

	/** Actions, which are allowed to perform with the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.allowedActions</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="allowedActions", description="Actions, which are allowed to perform with the quote.") 	
	private List<String> allowedActions;

	/** Previously estimated total price of the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.previousEstimatedTotal</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="previousEstimatedTotal", description="Previously estimated total price of the quote.") 	
	private PriceWsDTO previousEstimatedTotal;

	/** List of quote comments.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.comments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="comments", description="List of quote comments.") 	
	private List<CommentWsDTO> comments;

	/** Total price of the cart with taxes.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalPriceWithTax</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="totalPriceWithTax", description="Total price of the cart with taxes.") 	
	private PriceWsDTO totalPriceWithTax;

	/** Total price of the cart.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalPrice</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="totalPrice", description="Total price of the cart.") 	
	private PriceWsDTO totalPrice;

	/** Entries of the cart.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.entries</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="entries", description="Entries of the cart.") 	
	private List<OrderEntryWsDTO> entries;

	/** List of entry groups<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.entryGroups</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="entryGroups", description="List of entry groups") 	
	private List<EntryGroupWsDTO> entryGroups;

	/** Total number of the items in the quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.totalItems</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="totalItems", description="Total number of the items in the quote.", required=true, example="2") 	
	private Integer totalItems;

	/** Discounts available for the current quote.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.quoteDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="quoteDiscounts", description="Discounts available for the current quote.") 	
	private PriceWsDTO quoteDiscounts;

	/** Value of the discount<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.sapQuoteDiscountsRate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sapQuoteDiscountsRate", description="Value of the discount") 	
	private Double sapQuoteDiscountsRate;

	/** Type of the discount - PERCENT for discount by percentage, ABSOLUTE for discount by amount, TARGET for discount by adjustment of the total value<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.sapQuoteDiscountsType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sapQuoteDiscountsType", description="Type of the discount - PERCENT for discount by percentage, ABSOLUTE for discount by amount, TARGET for discount by adjustment of the total value") 	
	private String sapQuoteDiscountsType;

	/** Discounts available for the current order.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.orderDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orderDiscounts", description="Discounts available for the current order.") 	
	private PriceWsDTO orderDiscounts;

	/** Subtotal of the quote with applied discount.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.subTotalWithDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="subTotalWithDiscounts", description="Subtotal of the quote with applied discount.") 	
	private PriceWsDTO subTotalWithDiscounts;

	/** Discount applied to the product.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.productDiscounts</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="productDiscounts", description="Discount applied to the product.") 	
	private PriceWsDTO productDiscounts;

	/** Subtotal of the quote without applied order discount.<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.sapSubtotalExcludingOrderLevelDiscount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sapSubtotalExcludingOrderLevelDiscount", description="Subtotal of the quote without applied order discount.") 	
	private PriceWsDTO sapSubtotalExcludingOrderLevelDiscount;

	/** List of SAP attachments<br/><br/><i>Generated property</i> for <code>QuoteWsDTO.sapAttachments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="sapAttachments", description="List of SAP attachments") 	
	private List<SAPAttachmentWsDTO> sapAttachments;
	
	public QuoteWsDTO()
	{
		// default constructor
	}
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setState(final String state)
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setVersion(final Integer version)
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	
	public void setThreshold(final Double threshold)
	{
		this.threshold = threshold;
	}

	public Double getThreshold() 
	{
		return threshold;
	}
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
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
	
	public void setAllowedActions(final List<String> allowedActions)
	{
		this.allowedActions = allowedActions;
	}

	public List<String> getAllowedActions() 
	{
		return allowedActions;
	}
	
	public void setPreviousEstimatedTotal(final PriceWsDTO previousEstimatedTotal)
	{
		this.previousEstimatedTotal = previousEstimatedTotal;
	}

	public PriceWsDTO getPreviousEstimatedTotal() 
	{
		return previousEstimatedTotal;
	}
	
	public void setComments(final List<CommentWsDTO> comments)
	{
		this.comments = comments;
	}

	public List<CommentWsDTO> getComments() 
	{
		return comments;
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
	
	public void setQuoteDiscounts(final PriceWsDTO quoteDiscounts)
	{
		this.quoteDiscounts = quoteDiscounts;
	}

	public PriceWsDTO getQuoteDiscounts() 
	{
		return quoteDiscounts;
	}
	
	public void setSapQuoteDiscountsRate(final Double sapQuoteDiscountsRate)
	{
		this.sapQuoteDiscountsRate = sapQuoteDiscountsRate;
	}

	public Double getSapQuoteDiscountsRate() 
	{
		return sapQuoteDiscountsRate;
	}
	
	public void setSapQuoteDiscountsType(final String sapQuoteDiscountsType)
	{
		this.sapQuoteDiscountsType = sapQuoteDiscountsType;
	}

	public String getSapQuoteDiscountsType() 
	{
		return sapQuoteDiscountsType;
	}
	
	public void setOrderDiscounts(final PriceWsDTO orderDiscounts)
	{
		this.orderDiscounts = orderDiscounts;
	}

	public PriceWsDTO getOrderDiscounts() 
	{
		return orderDiscounts;
	}
	
	public void setSubTotalWithDiscounts(final PriceWsDTO subTotalWithDiscounts)
	{
		this.subTotalWithDiscounts = subTotalWithDiscounts;
	}

	public PriceWsDTO getSubTotalWithDiscounts() 
	{
		return subTotalWithDiscounts;
	}
	
	public void setProductDiscounts(final PriceWsDTO productDiscounts)
	{
		this.productDiscounts = productDiscounts;
	}

	public PriceWsDTO getProductDiscounts() 
	{
		return productDiscounts;
	}
	
	public void setSapSubtotalExcludingOrderLevelDiscount(final PriceWsDTO sapSubtotalExcludingOrderLevelDiscount)
	{
		this.sapSubtotalExcludingOrderLevelDiscount = sapSubtotalExcludingOrderLevelDiscount;
	}

	public PriceWsDTO getSapSubtotalExcludingOrderLevelDiscount() 
	{
		return sapSubtotalExcludingOrderLevelDiscount;
	}
	
	public void setSapAttachments(final List<SAPAttachmentWsDTO> sapAttachments)
	{
		this.sapAttachments = sapAttachments;
	}

	public List<SAPAttachmentWsDTO> getSapAttachments() 
	{
		return sapAttachments;
	}
	

}
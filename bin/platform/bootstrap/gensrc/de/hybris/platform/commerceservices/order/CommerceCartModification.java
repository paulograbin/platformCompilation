/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order;

import java.io.Serializable;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import java.util.Set;


import java.util.Objects;
/**
 * Represents the result of a modification to a cart entry.
 */
public  class CommerceCartModification  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CommerceCartModification.statusCode</code> property defined at extension <code>commerceservices</code>. */
	
	private String statusCode;

	/** <i>Generated property</i> for <code>CommerceCartModification.quantity</code> property defined at extension <code>commerceservices</code>. */
	
	private long quantity;

	/** <i>Generated property</i> for <code>CommerceCartModification.quantityAdded</code> property defined at extension <code>commerceservices</code>. */
	
	private long quantityAdded;

	/** <i>Generated property</i> for <code>CommerceCartModification.entry</code> property defined at extension <code>commerceservices</code>. */
	
	private AbstractOrderEntryModel entry;

	/** <i>Generated property</i> for <code>CommerceCartModification.product</code> property defined at extension <code>commerceservices</code>. */
	
	private ProductModel product;

	/** <i>Generated property</i> for <code>CommerceCartModification.deliveryModeChanged</code> property defined at extension <code>commerceservices</code>. */
	
	private Boolean deliveryModeChanged;

	/** <i>Generated property</i> for <code>CommerceCartModification.entryGroupNumbers</code> property defined at extension <code>commerceservices</code>. */
	
	private Set<Integer> entryGroupNumbers;
	
	public CommerceCartModification()
	{
		// default constructor
	}
	
	public void setStatusCode(final String statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getStatusCode() 
	{
		return statusCode;
	}
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

	public long getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantityAdded(final long quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}

	public long getQuantityAdded() 
	{
		return quantityAdded;
	}
	
	public void setEntry(final AbstractOrderEntryModel entry)
	{
		this.entry = entry;
	}

	public AbstractOrderEntryModel getEntry() 
	{
		return entry;
	}
	
	public void setProduct(final ProductModel product)
	{
		this.product = product;
	}

	public ProductModel getProduct() 
	{
		return product;
	}
	
	public void setDeliveryModeChanged(final Boolean deliveryModeChanged)
	{
		this.deliveryModeChanged = deliveryModeChanged;
	}

	public Boolean getDeliveryModeChanged() 
	{
		return deliveryModeChanged;
	}
	
	public void setEntryGroupNumbers(final Set<Integer> entryGroupNumbers)
	{
		this.entryGroupNumbers = entryGroupNumbers;
	}

	public Set<Integer> getEntryGroupNumbers() 
	{
		return entryGroupNumbers;
	}
	

}
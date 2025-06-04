/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.rao;

import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;


import java.util.Objects;
public  class FreeProductRAO extends AbstractRuleActionRAO 

{



	/** <i>Generated property</i> for <code>FreeProductRAO.addedOrderEntry</code> property defined at extension <code>ruleengineservices</code>. */
	
	private OrderEntryRAO addedOrderEntry;

	/** <i>Generated property</i> for <code>FreeProductRAO.quantityAdded</code> property defined at extension <code>ruleengineservices</code>. */
	
	private int quantityAdded;
	
	public FreeProductRAO()
	{
		// default constructor
	}
	
	public void setAddedOrderEntry(final OrderEntryRAO addedOrderEntry)
	{
		this.addedOrderEntry = addedOrderEntry;
	}

	public OrderEntryRAO getAddedOrderEntry() 
	{
		return addedOrderEntry;
	}
	
	public void setQuantityAdded(final int quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}

	public int getQuantityAdded() 
	{
		return quantityAdded;
	}
	

}
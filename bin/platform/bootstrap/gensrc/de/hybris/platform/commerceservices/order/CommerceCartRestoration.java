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
import de.hybris.platform.commerceservices.order.CommerceCartModification;
import java.util.List;


import java.util.Objects;
/**
 * Represents the result of the restoration of a cart to a customer's session.
 */
public  class CommerceCartRestoration  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CommerceCartRestoration.modifications</code> property defined at extension <code>commerceservices</code>. */
	
	private List<CommerceCartModification> modifications;
	
	public CommerceCartRestoration()
	{
		// default constructor
	}
	
	public void setModifications(final List<CommerceCartModification> modifications)
	{
		this.modifications = modifications;
	}

	public List<CommerceCartModification> getModifications() 
	{
		return modifications;
	}
	

}
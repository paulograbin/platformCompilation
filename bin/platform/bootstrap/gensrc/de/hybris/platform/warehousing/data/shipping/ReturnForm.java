/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.shipping;

import java.io.Serializable;
import de.hybris.platform.warehousing.data.shipping.ReturnFormEntry;
import java.util.List;


import java.util.Objects;
public  class ReturnForm  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnForm.formEntries</code> property defined at extension <code>warehousing</code>. */
	
	private List<ReturnFormEntry> formEntries;
	
	public ReturnForm()
	{
		// default constructor
	}
	
	public void setFormEntries(final List<ReturnFormEntry> formEntries)
	{
		this.formEntries = formEntries;
	}

	public List<ReturnFormEntry> getFormEntries() 
	{
		return formEntries;
	}
	

}
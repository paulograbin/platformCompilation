/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.ReturnAction;
import java.util.List;


import java.util.Objects;
public  class ReturnActionDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnActionDataList.returnActions</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<ReturnAction> returnActions;
	
	public ReturnActionDataList()
	{
		// default constructor
	}
	
	public void setReturnActions(final List<ReturnAction> returnActions)
	{
		this.returnActions = returnActions;
	}

	public List<ReturnAction> getReturnActions() 
	{
		return returnActions;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicefacades.customer360;

import java.io.Serializable;
import de.hybris.platform.assistedservicefacades.customer360.GeneralActivityData;
import java.util.List;


import java.util.Objects;
public  class GeneralActivityDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>GeneralActivityDataList.generalActivities</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private List<GeneralActivityData> generalActivities;
	
	public GeneralActivityDataList()
	{
		// default constructor
	}
	
	public void setGeneralActivities(final List<GeneralActivityData> generalActivities)
	{
		this.generalActivities = generalActivities;
	}

	public List<GeneralActivityData> getGeneralActivities() 
	{
		return generalActivities;
	}
	

}
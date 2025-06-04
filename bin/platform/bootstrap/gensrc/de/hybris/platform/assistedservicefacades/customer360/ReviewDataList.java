/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicefacades.customer360;

import java.io.Serializable;
import de.hybris.platform.assistedservicefacades.customer360.ReviewData;
import java.util.List;


import java.util.Objects;
public  class ReviewDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReviewDataList.reviews</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private List<ReviewData> reviews;
	
	public ReviewDataList()
	{
		// default constructor
	}
	
	public void setReviews(final List<ReviewData> reviews)
	{
		this.reviews = reviews;
	}

	public List<ReviewData> getReviews() 
	{
		return reviews;
	}
	

}
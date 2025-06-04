/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:26 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ReviewWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Review List
 */
@Schema(name="ReviewList", description="Representation of a Review List")
public  class ReviewListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of reviews<br/><br/><i>Generated property</i> for <code>ReviewListWsDTO.reviews</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="reviews", description="List of reviews") 	
	private List<ReviewWsDTO> reviews;
	
	public ReviewListWsDTO()
	{
		// default constructor
	}
	
	public void setReviews(final List<ReviewWsDTO> reviews)
	{
		this.reviews = reviews;
	}

	public List<ReviewWsDTO> getReviews() 
	{
		return reviews;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;


import java.util.Objects;
public  class ReviewData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReviewData.id</code> property defined at extension <code>commercefacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>ReviewData.headline</code> property defined at extension <code>commercefacades</code>. */
	
	private String headline;

	/** <i>Generated property</i> for <code>ReviewData.comment</code> property defined at extension <code>commercefacades</code>. */
	
	private String comment;

	/** <i>Generated property</i> for <code>ReviewData.rating</code> property defined at extension <code>commercefacades</code>. */
	
	private Double rating;

	/** <i>Generated property</i> for <code>ReviewData.date</code> property defined at extension <code>commercefacades</code>. */
	
	private Date date;

	/** <i>Generated property</i> for <code>ReviewData.alias</code> property defined at extension <code>commercefacades</code>. */
	
	private String alias;

	/** <i>Generated property</i> for <code>ReviewData.principal</code> property defined at extension <code>commercefacades</code>. */
	
	private PrincipalData principal;
	
	public ReviewData()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setHeadline(final String headline)
	{
		this.headline = headline;
	}

	public String getHeadline() 
	{
		return headline;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	
	public void setRating(final Double rating)
	{
		this.rating = rating;
	}

	public Double getRating() 
	{
		return rating;
	}
	
	public void setDate(final Date date)
	{
		this.date = date;
	}

	public Date getDate() 
	{
		return date;
	}
	
	public void setAlias(final String alias)
	{
		this.alias = alias;
	}

	public String getAlias() 
	{
		return alias;
	}
	
	public void setPrincipal(final PrincipalData principal)
	{
		this.principal = principal;
	}

	public PrincipalData getPrincipal() 
	{
		return principal;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;


import java.util.Objects;
public  class CommerceCartMetadata  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The name of the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadata.name</code> property defined at extension <code>commercefacades</code>. */
	
	private Optional<String> name;

	/** The description of the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadata.description</code> property defined at extension <code>commercefacades</code>. */
	
	private Optional<String> description;

	/** The expiration time to be stored in the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadata.expirationTime</code> property defined at extension <code>commercefacades</code>. */
	
	private Optional<Date> expirationTime;

	/** Indicates if the expiration time stored in the Cart should be removed. It has precedence over
				expirationTime
				attribute which will be ignored when this attribute will be set to true.
			<br/><br/><i>Generated property</i> for <code>CommerceCartMetadata.removeExpirationTime</code> property defined at extension <code>commercefacades</code>. */
	
	private boolean removeExpirationTime;
	
	public CommerceCartMetadata()
	{
		// default constructor
	}
	
	public void setName(final Optional<String> name)
	{
		this.name = name;
	}

	public Optional<String> getName() 
	{
		return name;
	}
	
	public void setDescription(final Optional<String> description)
	{
		this.description = description;
	}

	public Optional<String> getDescription() 
	{
		return description;
	}
	
	public void setExpirationTime(final Optional<Date> expirationTime)
	{
		this.expirationTime = expirationTime;
	}

	public Optional<Date> getExpirationTime() 
	{
		return expirationTime;
	}
	
	public void setRemoveExpirationTime(final boolean removeExpirationTime)
	{
		this.removeExpirationTime = removeExpirationTime;
	}

	public boolean isRemoveExpirationTime() 
	{
		return removeExpirationTime;
	}
	

}
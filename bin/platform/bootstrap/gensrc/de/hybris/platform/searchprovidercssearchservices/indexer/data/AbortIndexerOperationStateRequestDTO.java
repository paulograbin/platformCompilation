/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.indexer.data;

import de.hybris.platform.searchprovidercssearchservices.indexer.data.AbstractIndexerOperationStateRequestDTO;


import java.util.Objects;
public  class AbortIndexerOperationStateRequestDTO extends AbstractIndexerOperationStateRequestDTO 

{



	/** <i>Generated property</i> for <code>AbortIndexerOperationStateRequestDTO.message</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String message;
	
	public AbortIndexerOperationStateRequestDTO()
	{
		// default constructor
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbortIndexerOperationStateRequestDTO other = (AbortIndexerOperationStateRequestDTO) o;
		return Objects.equals(getMessage(), other.getMessage());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = message;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}
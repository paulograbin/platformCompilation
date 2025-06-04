/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.indexer.data;

import de.hybris.platform.searchprovidercssearchservices.indexer.data.AbstractIndexerOperationStateRequestDTO;


import java.util.Objects;
public  class FailIndexerOperationStateRequestDTO extends AbstractIndexerOperationStateRequestDTO 

{



	/** <i>Generated property</i> for <code>FailIndexerOperationStateRequestDTO.message</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String message;
	
	public FailIndexerOperationStateRequestDTO()
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

		final FailIndexerOperationStateRequestDTO other = (FailIndexerOperationStateRequestDTO) o;
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
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.webservicescommons.dto.error.ErrorListWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an Address Validation
 */
@Schema(name="AddressValidation", description="Representation of an Address Validation")
public  class AddressValidationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of errors<br/><br/><i>Generated property</i> for <code>AddressValidationWsDTO.errors</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="errors", description="List of errors") 	
	private ErrorListWsDTO errors;

	/** Decision<br/><br/><i>Generated property</i> for <code>AddressValidationWsDTO.decision</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="decision", description="Decision") 	
	private String decision;

	/** List of suggested addresses<br/><br/><i>Generated property</i> for <code>AddressValidationWsDTO.suggestedAddresses</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="suggestedAddresses", description="List of suggested addresses") 	
	private List<AddressWsDTO> suggestedAddresses;
	
	public AddressValidationWsDTO()
	{
		// default constructor
	}
	
	public void setErrors(final ErrorListWsDTO errors)
	{
		this.errors = errors;
	}

	public ErrorListWsDTO getErrors() 
	{
		return errors;
	}
	
	public void setDecision(final String decision)
	{
		this.decision = decision;
	}

	public String getDecision() 
	{
		return decision;
	}
	
	public void setSuggestedAddresses(final List<AddressWsDTO> suggestedAddresses)
	{
		this.suggestedAddresses = suggestedAddresses;
	}

	public List<AddressWsDTO> getSuggestedAddresses() 
	{
		return suggestedAddresses;
	}
	

}
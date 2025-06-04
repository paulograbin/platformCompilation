/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.consent;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.consent.ConsentTemplateWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Consent Template List
 */
@Schema(name="ConsentTemplateList", description="Representation of a Consent Template List")
public  class ConsentTemplateListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of consent templates<br/><br/><i>Generated property</i> for <code>ConsentTemplateListWsDTO.consentTemplates</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="consentTemplates", description="List of consent templates") 	
	private List<ConsentTemplateWsDTO> consentTemplates;
	
	public ConsentTemplateListWsDTO()
	{
		// default constructor
	}
	
	public void setConsentTemplates(final List<ConsentTemplateWsDTO> consentTemplates)
	{
		this.consentTemplates = consentTemplates;
	}

	public List<ConsentTemplateWsDTO> getConsentTemplates() 
	{
		return consentTemplates;
	}
	

}
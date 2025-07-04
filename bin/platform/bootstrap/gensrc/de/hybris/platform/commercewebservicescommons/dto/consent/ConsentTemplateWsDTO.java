/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.consent;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.consent.ConsentWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Consent Template
 */
@Schema(name="ConsentTemplate", description="Representation of a Consent Template")
public  class ConsentTemplateWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Consent template identifier<br/><br/><i>Generated property</i> for <code>ConsentTemplateWsDTO.id</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="id", description="Consent template identifier") 	
	private String id;

	/** Consent template name<br/><br/><i>Generated property</i> for <code>ConsentTemplateWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Consent template name") 	
	private String name;

	/** Consent template description<br/><br/><i>Generated property</i> for <code>ConsentTemplateWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Consent template description") 	
	private String description;

	/** Consent template version<br/><br/><i>Generated property</i> for <code>ConsentTemplateWsDTO.version</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="version", description="Consent template version") 	
	private Integer version;

	/** Current consent<br/><br/><i>Generated property</i> for <code>ConsentTemplateWsDTO.currentConsent</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currentConsent", description="Current consent") 	
	private ConsentWsDTO currentConsent;
	
	public ConsentTemplateWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setVersion(final Integer version)
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	
	public void setCurrentConsent(final ConsentWsDTO currentConsent)
	{
		this.currentConsent = currentConsent;
	}

	public ConsentWsDTO getCurrentConsent() 
	{
		return currentConsent;
	}
	

}
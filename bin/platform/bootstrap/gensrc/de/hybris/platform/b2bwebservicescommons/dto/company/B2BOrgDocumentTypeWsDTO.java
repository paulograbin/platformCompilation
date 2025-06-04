/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of an organizational document type.
 */
@Schema(name="OrgDocumentType", description="Representation of an organizational document type.")
public  class B2BOrgDocumentTypeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Organizational document type code.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentTypeWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="code", description="Organizational document type code.", required=true, example="PURCHASE_ORDER") 	
	private String code;

	/** Organizational document type name.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentTypeWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="name", description="Organizational document type name.", example="Purchase Order") 	
	private String name;
	
	public B2BOrgDocumentTypeWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}
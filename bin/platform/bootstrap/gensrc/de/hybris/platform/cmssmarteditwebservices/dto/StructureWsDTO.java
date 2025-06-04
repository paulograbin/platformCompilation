/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.StructureAttributeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * @deprecated no longer needed
 */
@Schema(name="structure")
@Deprecated(since = "1811", forRemoval = true)
public  class StructureWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureWsDTO.code</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>StructureWsDTO.category</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="category") 	
	private String category;

	/** <i>Generated property</i> for <code>StructureWsDTO.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>StructureWsDTO.i18nKey</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="i18nKey") 	
	private String i18nKey;

	/** <i>Generated property</i> for <code>StructureWsDTO.type</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="type") 	
	private String type;

	/** <i>Generated property</i> for <code>StructureWsDTO.attributes</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="attributes") 	
	private List<StructureAttributeWsDTO> attributes;
	
	public StructureWsDTO()
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
	
	public void setCategory(final String category)
	{
		this.category = category;
	}

	public String getCategory() 
	{
		return category;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setI18nKey(final String i18nKey)
	{
		this.i18nKey = i18nKey;
	}

	public String getI18nKey() 
	{
		return i18nKey;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setAttributes(final List<StructureAttributeWsDTO> attributes)
	{
		this.attributes = attributes;
	}

	public List<StructureAttributeWsDTO> getAttributes() 
	{
		return attributes;
	}
	

}
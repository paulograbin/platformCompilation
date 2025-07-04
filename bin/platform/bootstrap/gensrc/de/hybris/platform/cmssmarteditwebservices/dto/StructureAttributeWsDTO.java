/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.OptionData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;


import java.util.Objects;
/**
 * @deprecated no longer needed
 */
@Schema(name="structureAttribute")
@Deprecated(since = "1811", forRemoval = true)
public  class StructureAttributeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.qualifier</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="qualifier") 	
	private String qualifier;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.required</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="required") 	
	private boolean required;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.localized</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="localized") 	
	private Boolean localized;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.cmsStructureType</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="cmsStructureType") 	
	private String cmsStructureType;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.cmsStructureEnumType</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="cmsStructureEnumType") 	
	private String cmsStructureEnumType;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.i18nKey</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="i18nKey") 	
	private String i18nKey;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.dependsOn</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="dependsOn") 	
	private String dependsOn;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.options</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="options") 	
	private List<OptionData> options;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.mode</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="mode") 	
	private String mode;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.editable</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="editable") 	
	private boolean editable;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.paged</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="paged") 	
	private boolean paged;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.collection</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="collection") 	
	private boolean collection;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.uri</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="uri") 	
	private String uri;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.idAttribute</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="idAttribute") 	
	private String idAttribute;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.labelAttributes</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="labelAttributes") 	
	private List<String> labelAttributes;

	/** <i>Generated property</i> for <code>StructureAttributeWsDTO.params</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="params") 	
	private Map<String,String> params;
	
	public StructureAttributeWsDTO()
	{
		// default constructor
	}
	
	public void setQualifier(final String qualifier)
	{
		this.qualifier = qualifier;
	}

	public String getQualifier() 
	{
		return qualifier;
	}
	
	public void setRequired(final boolean required)
	{
		this.required = required;
	}

	public boolean isRequired() 
	{
		return required;
	}
	
	public void setLocalized(final Boolean localized)
	{
		this.localized = localized;
	}

	public Boolean getLocalized() 
	{
		return localized;
	}
	
	public void setCmsStructureType(final String cmsStructureType)
	{
		this.cmsStructureType = cmsStructureType;
	}

	public String getCmsStructureType() 
	{
		return cmsStructureType;
	}
	
	public void setCmsStructureEnumType(final String cmsStructureEnumType)
	{
		this.cmsStructureEnumType = cmsStructureEnumType;
	}

	public String getCmsStructureEnumType() 
	{
		return cmsStructureEnumType;
	}
	
	public void setI18nKey(final String i18nKey)
	{
		this.i18nKey = i18nKey;
	}

	public String getI18nKey() 
	{
		return i18nKey;
	}
	
	public void setDependsOn(final String dependsOn)
	{
		this.dependsOn = dependsOn;
	}

	public String getDependsOn() 
	{
		return dependsOn;
	}
	
	public void setOptions(final List<OptionData> options)
	{
		this.options = options;
	}

	public List<OptionData> getOptions() 
	{
		return options;
	}
	
	public void setMode(final String mode)
	{
		this.mode = mode;
	}

	public String getMode() 
	{
		return mode;
	}
	
	public void setEditable(final boolean editable)
	{
		this.editable = editable;
	}

	public boolean isEditable() 
	{
		return editable;
	}
	
	public void setPaged(final boolean paged)
	{
		this.paged = paged;
	}

	public boolean isPaged() 
	{
		return paged;
	}
	
	public void setCollection(final boolean collection)
	{
		this.collection = collection;
	}

	public boolean isCollection() 
	{
		return collection;
	}
	
	public void setUri(final String uri)
	{
		this.uri = uri;
	}

	public String getUri() 
	{
		return uri;
	}
	
	public void setIdAttribute(final String idAttribute)
	{
		this.idAttribute = idAttribute;
	}

	public String getIdAttribute() 
	{
		return idAttribute;
	}
	
	public void setLabelAttributes(final List<String> labelAttributes)
	{
		this.labelAttributes = labelAttributes;
	}

	public List<String> getLabelAttributes() 
	{
		return labelAttributes;
	}
	
	public void setParams(final Map<String,String> params)
	{
		this.params = params;
	}

	public Map<String,String> getParams() 
	{
		return params;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import de.hybris.platform.sap.productconfig.facades.UiType;
import de.hybris.platform.sap.productconfig.facades.UiValidationType;
import de.hybris.platform.sap.productconfig.occ.ConflictWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticValueWsDTO;
import de.hybris.platform.sap.productconfig.occ.ProductConfigMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * An attribute of a complex product.
 */
@Schema(name="CCPAttribute", description="An attribute of a complex product.")
public  class CsticWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Language-independent attribute key.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.key</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="key", description="Language-independent attribute key.", example="1-CONF_LAPTOP.HARDWARE-SCREEN_SIZE") 	
	private String key;

	/** Language-independent attribute name as assigned in the modeling environment.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.name</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="name", description="Language-independent attribute name as assigned in the modeling environment.", example="SCREEN_SIZE") 	
	private String name;

	/** Language-dependent attribute description.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.langDepName</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="langDepName", description="Language-dependent attribute description.", example="Screen Size") 	
	private String langDepName;

	/** Attribute value, if the attribute is single-valued.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.value</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="value", description="Attribute value, if the attribute is single-valued.", example="17'") 	
	private String value;

	/** Formatted attribute value, relevant for numeric attributes. This formatting takes the session locale into account.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.formattedValue</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="formattedValue", description="Formatted attribute value, relevant for numeric attributes. This formatting takes the session locale into account.", example="24,87") 	
	private String formattedValue;

	/** Language-dependent attribute long description.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.longText</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="longText", description="Language-dependent attribute long description.", example="Screen size in inches") 	
	private String longText;

	/** Attribute is visible.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.visible</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="visible", description="Attribute is visible.", example="true") 	
	private boolean visible;

	/** It is required to specify this attribute in order to complete the configuration.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.required</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="required", description="It is required to specify this attribute in order to complete the configuration.", example="false") 	
	private boolean required;

	/** Attribute type. Specifies how the attribute should be rendered ideally.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.type</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="type", description="Attribute type. Specifies how the attribute should be rendered ideally.", example="CHECK_BOX_LIST") 	
	private UiType type;

	/** Attribute validation type. Specifies how an attribute should be validated in case it's free input.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.validationType</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="validationType", description="Attribute validation type. Specifies how an attribute should be validated in case it's free input.", example="NUMERIC") 	
	private UiValidationType validationType;

	/** The list of attribute domain values contain an interval. Only relevant if the attribute is of numeric type.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.intervalInDomain</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="intervalInDomain", description="The list of attribute domain values contain an interval. Only relevant if the attribute is of numeric type.", example="false") 	
	private boolean intervalInDomain;

	/** Maximum length of attribute value names for all domain values.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.maxlength</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="maxlength", description="Maximum length of attribute value names for all domain values.", example="5") 	
	private int maxlength;

	/** Maximum number of decimal places. Only relevant if the attribute is of numeric type.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.typeLength</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="typeLength", description="Maximum number of decimal places. Only relevant if the attribute is of numeric type.", example="10") 	
	private int typeLength;

	/** Number of decimal places. Only relevant if the attribute is of numeric type.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.numberScale</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="numberScale", description="Number of decimal places. Only relevant if the attribute is of numeric type.", example="2") 	
	private int numberScale;

	/** Are negative values allowed? Only relevant if the attribute is of numeric type.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.negativeAllowed</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="negativeAllowed", description="Are negative values allowed? Only relevant if the attribute is of numeric type.", example="false") 	
	private boolean negativeAllowed;

	/** Has a retract been triggered for all values of this attribute?<br/><br/><i>Generated property</i> for <code>CsticWsDTO.retractTriggered</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="retractTriggered", description="Has a retract been triggered for all values of this attribute?", example="true") 	
	private boolean retractTriggered;

	/** Retract must never happen for this attribute because the configuration engine forbids it.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.retractBlocked</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="retractBlocked", description="Retract must never happen for this attribute because the configuration engine forbids it.", example="true") 	
	private boolean retractBlocked;

	/** List of domain values.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.domainValues</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="domainValues", description="List of domain values.") 	
	private List<CsticValueWsDTO> domainValues;

	/** List of conflicts.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.conflicts</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="conflicts", description="List of conflicts.") 	
	private List<ConflictWsDTO> conflicts;

	/** Image list.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.images</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="images", description="Image list.") 	
	private List<ImageWsDTO> images;

	/** Message list.<br/><br/><i>Generated property</i> for <code>CsticWsDTO.messages</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="messages", description="Message list.") 	
	private List<ProductConfigMessageWsDTO> messages;
	
	public CsticWsDTO()
	{
		// default constructor
	}
	
	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setLangDepName(final String langDepName)
	{
		this.langDepName = langDepName;
	}

	public String getLangDepName() 
	{
		return langDepName;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setFormattedValue(final String formattedValue)
	{
		this.formattedValue = formattedValue;
	}

	public String getFormattedValue() 
	{
		return formattedValue;
	}
	
	public void setLongText(final String longText)
	{
		this.longText = longText;
	}

	public String getLongText() 
	{
		return longText;
	}
	
	public void setVisible(final boolean visible)
	{
		this.visible = visible;
	}

	public boolean isVisible() 
	{
		return visible;
	}
	
	public void setRequired(final boolean required)
	{
		this.required = required;
	}

	public boolean isRequired() 
	{
		return required;
	}
	
	public void setType(final UiType type)
	{
		this.type = type;
	}

	public UiType getType() 
	{
		return type;
	}
	
	public void setValidationType(final UiValidationType validationType)
	{
		this.validationType = validationType;
	}

	public UiValidationType getValidationType() 
	{
		return validationType;
	}
	
	public void setIntervalInDomain(final boolean intervalInDomain)
	{
		this.intervalInDomain = intervalInDomain;
	}

	public boolean isIntervalInDomain() 
	{
		return intervalInDomain;
	}
	
	public void setMaxlength(final int maxlength)
	{
		this.maxlength = maxlength;
	}

	public int getMaxlength() 
	{
		return maxlength;
	}
	
	public void setTypeLength(final int typeLength)
	{
		this.typeLength = typeLength;
	}

	public int getTypeLength() 
	{
		return typeLength;
	}
	
	public void setNumberScale(final int numberScale)
	{
		this.numberScale = numberScale;
	}

	public int getNumberScale() 
	{
		return numberScale;
	}
	
	public void setNegativeAllowed(final boolean negativeAllowed)
	{
		this.negativeAllowed = negativeAllowed;
	}

	public boolean isNegativeAllowed() 
	{
		return negativeAllowed;
	}
	
	public void setRetractTriggered(final boolean retractTriggered)
	{
		this.retractTriggered = retractTriggered;
	}

	public boolean isRetractTriggered() 
	{
		return retractTriggered;
	}
	
	public void setRetractBlocked(final boolean retractBlocked)
	{
		this.retractBlocked = retractBlocked;
	}

	public boolean isRetractBlocked() 
	{
		return retractBlocked;
	}
	
	public void setDomainValues(final List<CsticValueWsDTO> domainValues)
	{
		this.domainValues = domainValues;
	}

	public List<CsticValueWsDTO> getDomainValues() 
	{
		return domainValues;
	}
	
	public void setConflicts(final List<ConflictWsDTO> conflicts)
	{
		this.conflicts = conflicts;
	}

	public List<ConflictWsDTO> getConflicts() 
	{
		return conflicts;
	}
	
	public void setImages(final List<ImageWsDTO> images)
	{
		this.images = images;
	}

	public List<ImageWsDTO> getImages() 
	{
		return images;
	}
	
	public void setMessages(final List<ProductConfigMessageWsDTO> messages)
	{
		this.messages = messages;
	}

	public List<ProductConfigMessageWsDTO> getMessages() 
	{
		return messages;
	}
	

}
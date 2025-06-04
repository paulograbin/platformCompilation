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
import de.hybris.platform.sap.productconfig.occ.ProductConfigMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an attribute value.
 */
@Schema(name="CCPAttributeValue", description="Representation of an attribute value.")
public  class CsticValueWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value key.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.key</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="key", description="Value key.", example="MET_BLUE") 	
	private String key;

	/** Language-independent value name.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.name</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="name", description="Language-independent value name.", example="MET_BLUE") 	
	private String name;

	/** Language-dependent value description.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.langDepName</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="langDepName", description="Language-dependent value description.", example="Metallic Blue") 	
	private String langDepName;

	/** Indicates if value is selected.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.selected</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="selected", description="Indicates if value is selected.", example="false") 	
	private boolean selected;

	/** Indicates if value is read-only.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.readonly</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="readonly", description="Indicates if value is read-only.", example="false") 	
	private boolean readonly;

	/** Language dependent value description.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.longText</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="longText", description="Language dependent value description.", example="Screen size in inches") 	
	private String longText;

	/** List of images.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.images</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="images", description="List of images.") 	
	private List<ImageWsDTO> images;

	/** Message list.<br/><br/><i>Generated property</i> for <code>CsticValueWsDTO.messages</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="messages", description="Message list.") 	
	private List<ProductConfigMessageWsDTO> messages;
	
	public CsticValueWsDTO()
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
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	
	public void setReadonly(final boolean readonly)
	{
		this.readonly = readonly;
	}

	public boolean isReadonly() 
	{
		return readonly;
	}
	
	public void setLongText(final String longText)
	{
		this.longText = longText;
	}

	public String getLongText() 
	{
		return longText;
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
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.sap.productconfig.occ.ProductConfigMessageWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an attribute value in the context of the configuration overview.
 */
@Schema(name="CCPAttributeValueOverview", description="Representation of an attribute value in the context of the configuration overview.")
public  class OverviewCsticValueWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Language-dependent attribute name.<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.characteristic</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="characteristic", description="Language-dependent attribute name.", example="Accessories") 	
	private String characteristic;

	/** Attribute ID<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.characteristicId</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="characteristicId", description="Attribute ID", example="ACCESSORIES") 	
	private String characteristicId;

	/** Language-dependent value name.<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.value</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="value", description="Language-dependent value name.", example="Extra Audio Package") 	
	private String value;

	/** Value identifier.<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.valueId</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="valueId", description="Value identifier.", example="EXTRA_AUDIO_PACKAGE") 	
	private String valueId;

	/** Price of attribute value.<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.price</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="price", description="Price of attribute value.") 	
	private PriceWsDTO price;

	/** Obsolete price that has been reduced as discounts have been applied.<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.obsoletePrice</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="obsoletePrice", description="Obsolete price that has been reduced as discounts have been applied.") 	
	private PriceWsDTO obsoletePrice;

	/** Message list<br/><br/><i>Generated property</i> for <code>OverviewCsticValueWsDTO.messages</code> property defined at extension <code>sapproductconfigocc</code>. */
@Schema(name="messages", description="Message list") 	
	private List<ProductConfigMessageWsDTO> messages;
	
	public OverviewCsticValueWsDTO()
	{
		// default constructor
	}
	
	public void setCharacteristic(final String characteristic)
	{
		this.characteristic = characteristic;
	}

	public String getCharacteristic() 
	{
		return characteristic;
	}
	
	public void setCharacteristicId(final String characteristicId)
	{
		this.characteristicId = characteristicId;
	}

	public String getCharacteristicId() 
	{
		return characteristicId;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setValueId(final String valueId)
	{
		this.valueId = valueId;
	}

	public String getValueId() 
	{
		return valueId;
	}
	
	public void setPrice(final PriceWsDTO price)
	{
		this.price = price;
	}

	public PriceWsDTO getPrice() 
	{
		return price;
	}
	
	public void setObsoletePrice(final PriceWsDTO obsoletePrice)
	{
		this.obsoletePrice = obsoletePrice;
	}

	public PriceWsDTO getObsoletePrice() 
	{
		return obsoletePrice;
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
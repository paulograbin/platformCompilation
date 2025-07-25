/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.facades.overview;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.sap.productconfig.facades.overview.CharacteristicValueMessage;
import de.hybris.platform.sap.productconfig.facades.overview.ValuePositionTypeEnum;
import java.util.List;


import java.util.Objects;
public  class CharacteristicValue  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CharacteristicValue.message</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String message;

	/** <i>Generated property</i> for <code>CharacteristicValue.characteristic</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String characteristic;

	/** <i>Generated property</i> for <code>CharacteristicValue.characteristicId</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String characteristicId;

	/** <i>Generated property</i> for <code>CharacteristicValue.value</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String value;

	/** <i>Generated property</i> for <code>CharacteristicValue.valueId</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String valueId;

	/** <i>Generated property</i> for <code>CharacteristicValue.price</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private PriceData price;

	/** <i>Generated property</i> for <code>CharacteristicValue.priceDescription</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String priceDescription;

	/** <i>Generated property</i> for <code>CharacteristicValue.obsoletePrice</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private PriceData obsoletePrice;

	/** <i>Generated property</i> for <code>CharacteristicValue.obsoletePriceDescription</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private String obsoletePriceDescription;

	/** <i>Generated property</i> for <code>CharacteristicValue.valuePositionType</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private ValuePositionTypeEnum valuePositionType;

	/** <i>Generated property</i> for <code>CharacteristicValue.messages</code> property defined at extension <code>sapproductconfigfacades</code>. */
	
	private List<CharacteristicValueMessage> messages;
	
	public CharacteristicValue()
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
	
	public void setPrice(final PriceData price)
	{
		this.price = price;
	}

	public PriceData getPrice() 
	{
		return price;
	}
	
	public void setPriceDescription(final String priceDescription)
	{
		this.priceDescription = priceDescription;
	}

	public String getPriceDescription() 
	{
		return priceDescription;
	}
	
	public void setObsoletePrice(final PriceData obsoletePrice)
	{
		this.obsoletePrice = obsoletePrice;
	}

	public PriceData getObsoletePrice() 
	{
		return obsoletePrice;
	}
	
	public void setObsoletePriceDescription(final String obsoletePriceDescription)
	{
		this.obsoletePriceDescription = obsoletePriceDescription;
	}

	public String getObsoletePriceDescription() 
	{
		return obsoletePriceDescription;
	}
	
	public void setValuePositionType(final ValuePositionTypeEnum valuePositionType)
	{
		this.valuePositionType = valuePositionType;
	}

	public ValuePositionTypeEnum getValuePositionType() 
	{
		return valuePositionType;
	}
	
	public void setMessages(final List<CharacteristicValueMessage> messages)
	{
		this.messages = messages;
	}

	public List<CharacteristicValueMessage> getMessages() 
	{
		return messages;
	}
	

}
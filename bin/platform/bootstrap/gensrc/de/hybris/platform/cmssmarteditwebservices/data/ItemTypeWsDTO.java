/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.data;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
@Schema(name="itemType")
public  class ItemTypeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ItemTypeWsDTO.itemType</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="itemType") 	
	private String itemType;

	/** <i>Generated property</i> for <code>ItemTypeWsDTO.i18nKey</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@Schema(name="i18nKey") 	
	private String i18nKey;
	
	public ItemTypeWsDTO()
	{
		// default constructor
	}
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public String getItemType() 
	{
		return itemType;
	}
	
	public void setI18nKey(final String i18nKey)
	{
		this.i18nKey = i18nKey;
	}

	public String getI18nKey() 
	{
		return i18nKey;
	}
	

}
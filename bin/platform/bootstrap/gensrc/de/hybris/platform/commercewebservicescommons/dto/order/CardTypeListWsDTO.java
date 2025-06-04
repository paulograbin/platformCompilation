/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.CardTypeWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Card Type List
 */
@Schema(name="CardTypeList", description="Representation of a Card Type List")
public  class CardTypeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of card types<br/><br/><i>Generated property</i> for <code>CardTypeListWsDTO.cardTypes</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="cardTypes", description="List of card types") 	
	private List<CardTypeWsDTO> cardTypes;
	
	public CardTypeListWsDTO()
	{
		// default constructor
	}
	
	public void setCardTypes(final List<CardTypeWsDTO> cardTypes)
	{
		this.cardTypes = cardTypes;
	}

	public List<CardTypeWsDTO> getCardTypes() 
	{
		return cardTypes;
	}
	

}
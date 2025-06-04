/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * data type of delivery timeslot
 */
@Schema(name="DeliveryTimeSlot", description="data type of delivery timeslot")
public  class DeliveryTimeSlotWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** delivery timeslot code<br/><br/><i>Generated property</i> for <code>DeliveryTimeSlotWsDTO.code</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="code", description="delivery timeslot code") 	
	private String code;

	/** delivery timeslot name<br/><br/><i>Generated property</i> for <code>DeliveryTimeSlotWsDTO.name</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@Schema(name="name", description="delivery timeslot name") 	
	private String name;
	
	public DeliveryTimeSlotWsDTO()
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
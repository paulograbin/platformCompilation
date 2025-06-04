/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import de.hybris.platform.b2bwebservicescommons.dto.order.TriggerWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.CartWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Replenishment Order data.
 */
@Schema(name="ReplenishmentOrder", description="Request body fields required and optional to operate on Replenishment Order data.")
public  class ReplenishmentOrderWsDTO extends CartWsDTO 

{



	/** Is the Replenishment Order active<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="active", description="Is the Replenishment Order active", example="Boolean.FALSE") 	
	private Boolean active;

	/** Trigger for the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.trigger</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="trigger", description="Trigger for the replenishment order") 	
	private TriggerWsDTO trigger;

	/** First date of the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.firstDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="firstDate", description="First date of the replenishment order", example="2020-12-31T09:00:00+0000") 	
	private Date firstDate;

	/** Unique code for the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.replenishmentOrderCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="replenishmentOrderCode", description="Unique code for the replenishment order", required=true, example="502BJ") 	
	private String replenishmentOrderCode;
	
	public ReplenishmentOrderWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setTrigger(final TriggerWsDTO trigger)
	{
		this.trigger = trigger;
	}

	public TriggerWsDTO getTrigger() 
	{
		return trigger;
	}
	
	public void setFirstDate(final Date firstDate)
	{
		this.firstDate = firstDate;
	}

	public Date getFirstDate() 
	{
		return firstDate;
	}
	
	public void setReplenishmentOrderCode(final String replenishmentOrderCode)
	{
		this.replenishmentOrderCode = replenishmentOrderCode;
	}

	public String getReplenishmentOrderCode() 
	{
		return replenishmentOrderCode;
	}
	

}
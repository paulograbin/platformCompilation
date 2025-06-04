/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Maximum and minimum limits of the day range.
 */
@Schema(name="DayRange", description="Maximum and minimum limits of the day range.")
public  class DayRangeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Minimum day range.<br/><br/><i>Generated property</i> for <code>DayRangeWsDTO.minBoundary</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="minBoundary", description="Minimum day range.", required=true, example="31") 	
	private Integer minBoundary;

	/** Maximum day range. The value null  is used for infinite ranges. For example, a minBoundary of 91 and a maxBoundary of null represents a 91+ day range.<br/><br/><i>Generated property</i> for <code>DayRangeWsDTO.maxBoundary</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="maxBoundary", description="Maximum day range. The value null is used for infinite ranges. For example, a minBoundary of 91 and a maxBoundary of null represents a 91+ day range.", example="60") 	
	private Integer maxBoundary;
	
	public DayRangeWsDTO()
	{
		// default constructor
	}
	
	public void setMinBoundary(final Integer minBoundary)
	{
		this.minBoundary = minBoundary;
	}

	public Integer getMinBoundary() 
	{
		return minBoundary;
	}
	
	public void setMaxBoundary(final Integer maxBoundary)
	{
		this.maxBoundary = maxBoundary;
	}

	public Integer getMaxBoundary() 
	{
		return maxBoundary;
	}
	

}
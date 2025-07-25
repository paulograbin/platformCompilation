/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.sourcing;

import java.io.Serializable;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import java.util.Map;


import java.util.Objects;
public  class SourcingLocation  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SourcingLocation.warehouse</code> property defined at extension <code>warehousing</code>. */
	
	private WarehouseModel warehouse;

	/** <i>Generated property</i> for <code>SourcingLocation.availability</code> property defined at extension <code>warehousing</code>. */
	
	private Map<ProductModel, Long> availability;

	/** <i>Generated property</i> for <code>SourcingLocation.distance</code> property defined at extension <code>warehousing</code>. */
	
	private Double distance;

	/** <i>Generated property</i> for <code>SourcingLocation.context</code> property defined at extension <code>warehousing</code>. */
	
	private SourcingContext context;

	/** <i>Generated property</i> for <code>SourcingLocation.priority</code> property defined at extension <code>warehousing</code>. */
	
	private Integer priority;
	
	public SourcingLocation()
	{
		// default constructor
	}
	
	public void setWarehouse(final WarehouseModel warehouse)
	{
		this.warehouse = warehouse;
	}

	public WarehouseModel getWarehouse() 
	{
		return warehouse;
	}
	
	public void setAvailability(final Map<ProductModel, Long> availability)
	{
		this.availability = availability;
	}

	public Map<ProductModel, Long> getAvailability() 
	{
		return availability;
	}
	
	public void setDistance(final Double distance)
	{
		this.distance = distance;
	}

	public Double getDistance() 
	{
		return distance;
	}
	
	public void setContext(final SourcingContext context)
	{
		this.context = context;
	}

	public SourcingContext getContext() 
	{
		return context;
	}
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

	public Integer getPriority() 
	{
		return priority;
	}
	

}
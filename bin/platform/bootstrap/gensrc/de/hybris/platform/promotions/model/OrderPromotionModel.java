/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.promotions.model;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.AbstractPromotionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OrderPromotion first defined at extension promotions.
 */
@SuppressWarnings("all")
public class OrderPromotionModel extends AbstractPromotionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OrderPromotion";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OrderPromotionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OrderPromotionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderPromotionModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OrderPromotionModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
}

/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.promotions.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.AbstractPromotionActionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type PromotionOrderAdjustTotalAction first defined at extension promotions.
 */
@SuppressWarnings("all")
public class PromotionOrderAdjustTotalActionModel extends AbstractPromotionActionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PromotionOrderAdjustTotalAction";
	
	/** <i>Generated constant</i> - Attribute key of <code>PromotionOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotions</code>. */
	public static final String AMOUNT = "amount";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PromotionOrderAdjustTotalActionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PromotionOrderAdjustTotalActionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PromotionOrderAdjustTotalActionModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PromotionOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotions</code>. 
	 * @return the amount - The amount to adjust the cart total by.
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.GETTER)
	public Double getAmount()
	{
		return getPersistenceContext().getPropertyValue(AMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PromotionOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotions</code>. 
	 *  
	 * @param value the amount - The amount to adjust the cart total by.
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.SETTER)
	public void setAmount(final Double value)
	{
		getPersistenceContext().setPropertyValue(AMOUNT, value);
	}
	
}

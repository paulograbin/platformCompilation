/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.promotionengineservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotionengineservices.model.AbstractRuleBasedPromotionActionModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;

/**
 * Generated model class for type RuleBasedOrderAdjustTotalAction first defined at extension promotionengineservices.
 */
@SuppressWarnings("all")
public class RuleBasedOrderAdjustTotalActionModel extends AbstractRuleBasedPromotionActionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "RuleBasedOrderAdjustTotalAction";
	
	/** <i>Generated constant</i> - Attribute key of <code>RuleBasedOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotionengineservices</code>. */
	public static final String AMOUNT = "amount";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public RuleBasedOrderAdjustTotalActionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public RuleBasedOrderAdjustTotalActionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public RuleBasedOrderAdjustTotalActionModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RuleBasedOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotionengineservices</code>. 
	 * @return the amount - The amount to adjust the cart total by.
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.GETTER)
	public BigDecimal getAmount()
	{
		return getPersistenceContext().getPropertyValue(AMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>RuleBasedOrderAdjustTotalAction.amount</code> attribute defined at extension <code>promotionengineservices</code>. 
	 *  
	 * @param value the amount - The amount to adjust the cart total by.
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.SETTER)
	public void setAmount(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(AMOUNT, value);
	}
	
}

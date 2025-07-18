/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.promotionengineservices.model;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.ruleengineservices.model.SourceRuleTemplateModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type PromotionSourceRuleTemplate first defined at extension promotionengineservices.
 */
@SuppressWarnings("all")
public class PromotionSourceRuleTemplateModel extends SourceRuleTemplateModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PromotionSourceRuleTemplate";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PromotionSourceRuleTemplateModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PromotionSourceRuleTemplateModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractRuleTemplate</code> at extension <code>ruleengineservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PromotionSourceRuleTemplateModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractRuleTemplate</code> at extension <code>ruleengineservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PromotionSourceRuleTemplateModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
}

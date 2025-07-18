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
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.promotions.model.AbstractPromotionActionModel;
import de.hybris.platform.promotions.model.CachedPromotionOrderEntryConsumedModel;
import de.hybris.platform.promotions.model.PromotionResultModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;

/**
 * Generated model class for type CachedPromotionResult first defined at extension promotions.
 */
@SuppressWarnings("all")
public class CachedPromotionResultModel extends PromotionResultModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CachedPromotionResult";
	
	/** <i>Generated constant</i> - Attribute key of <code>CachedPromotionResult.cachedActions</code> attribute defined at extension <code>promotions</code>. */
	public static final String CACHEDACTIONS = "cachedActions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CachedPromotionResult.cachedConsumedEntries</code> attribute defined at extension <code>promotions</code>. */
	public static final String CACHEDCONSUMEDENTRIES = "cachedConsumedEntries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CachedPromotionResultModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CachedPromotionResultModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _order initial attribute declared by type <code>PromotionResult</code> at extension <code>promotions</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CachedPromotionResultModel(final AbstractOrderModel _order)
	{
		super();
		setOrder(_order);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _order initial attribute declared by type <code>PromotionResult</code> at extension <code>promotions</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CachedPromotionResultModel(final AbstractOrderModel _order, final ItemModel _owner)
	{
		super();
		setOrder(_order);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CachedPromotionResult.cachedActions</code> attribute defined at extension <code>promotions</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the cachedActions - Cached list of actions
	 */
	@Accessor(qualifier = "cachedActions", type = Accessor.Type.GETTER)
	public Collection<AbstractPromotionActionModel> getCachedActions()
	{
		return getPersistenceContext().getPropertyValue(CACHEDACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CachedPromotionResult.cachedConsumedEntries</code> attribute defined at extension <code>promotions</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the cachedConsumedEntries - Cached list of consumed entries
	 */
	@Accessor(qualifier = "cachedConsumedEntries", type = Accessor.Type.GETTER)
	public Collection<CachedPromotionOrderEntryConsumedModel> getCachedConsumedEntries()
	{
		return getPersistenceContext().getPropertyValue(CACHEDCONSUMEDENTRIES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CachedPromotionResult.cachedActions</code> attribute defined at extension <code>promotions</code>. 
	 *  
	 * @param value the cachedActions - Cached list of actions
	 */
	@Accessor(qualifier = "cachedActions", type = Accessor.Type.SETTER)
	public void setCachedActions(final Collection<AbstractPromotionActionModel> value)
	{
		getPersistenceContext().setPropertyValue(CACHEDACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CachedPromotionResult.cachedConsumedEntries</code> attribute defined at extension <code>promotions</code>. 
	 *  
	 * @param value the cachedConsumedEntries - Cached list of consumed entries
	 */
	@Accessor(qualifier = "cachedConsumedEntries", type = Accessor.Type.SETTER)
	public void setCachedConsumedEntries(final Collection<CachedPromotionOrderEntryConsumedModel> value)
	{
		getPersistenceContext().setPropertyValue(CACHEDCONSUMEDENTRIES, value);
	}
	
}

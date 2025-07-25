/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.configurablebundleservices.model.AbstractBundleRuleModel;
import de.hybris.platform.configurablebundleservices.model.BundleTemplateModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;

/**
 * Generated model class for type ChangeProductPriceBundleRule first defined at extension configurablebundleservices.
 */
@SuppressWarnings("all")
public class ChangeProductPriceBundleRuleModel extends AbstractBundleRuleModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ChangeProductPriceBundleRule";
	
	/**<i>Generated relation code constant for relation <code>BundleTemplatePriceRulesRelation</code> defining source attribute <code>bundleTemplate</code> in extension <code>configurablebundleservices</code>.</i>*/
	public static final String _BUNDLETEMPLATEPRICERULESRELATION = "BundleTemplatePriceRulesRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChangeProductPriceBundleRule.price</code> attribute defined at extension <code>configurablebundleservices</code>. */
	public static final String PRICE = "price";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChangeProductPriceBundleRule.currency</code> attribute defined at extension <code>configurablebundleservices</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>ChangeProductPriceBundleRule.bundleTemplate</code> attribute defined at extension <code>configurablebundleservices</code>. */
	public static final String BUNDLETEMPLATE = "bundleTemplate";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ChangeProductPriceBundleRuleModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ChangeProductPriceBundleRuleModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractBundleRule</code> at extension <code>configurablebundleservices</code>
	 * @param _currency initial attribute declared by type <code>ChangeProductPriceBundleRule</code> at extension <code>configurablebundleservices</code>
	 * @param _price initial attribute declared by type <code>ChangeProductPriceBundleRule</code> at extension <code>configurablebundleservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ChangeProductPriceBundleRuleModel(final CatalogVersionModel _catalogVersion, final CurrencyModel _currency, final BigDecimal _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCurrency(_currency);
		setPrice(_price);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractBundleRule</code> at extension <code>configurablebundleservices</code>
	 * @param _currency initial attribute declared by type <code>ChangeProductPriceBundleRule</code> at extension <code>configurablebundleservices</code>
	 * @param _id initial attribute declared by type <code>AbstractBundleRule</code> at extension <code>configurablebundleservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _price initial attribute declared by type <code>ChangeProductPriceBundleRule</code> at extension <code>configurablebundleservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ChangeProductPriceBundleRuleModel(final CatalogVersionModel _catalogVersion, final CurrencyModel _currency, final String _id, final ItemModel _owner, final BigDecimal _price)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCurrency(_currency);
		setId(_id);
		setOwner(_owner);
		setPrice(_price);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChangeProductPriceBundleRule.bundleTemplate</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 * @return the bundleTemplate
	 */
	@Accessor(qualifier = "bundleTemplate", type = Accessor.Type.GETTER)
	public BundleTemplateModel getBundleTemplate()
	{
		return getPersistenceContext().getPropertyValue(BUNDLETEMPLATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChangeProductPriceBundleRule.currency</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 * @return the currency - Currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChangeProductPriceBundleRule.price</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 * @return the price - price set by bundle rule
	 */
	@Accessor(qualifier = "price", type = Accessor.Type.GETTER)
	public BigDecimal getPrice()
	{
		return getPersistenceContext().getPropertyValue(PRICE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ChangeProductPriceBundleRule.bundleTemplate</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 *  
	 * @param value the bundleTemplate
	 */
	@Accessor(qualifier = "bundleTemplate", type = Accessor.Type.SETTER)
	public void setBundleTemplate(final BundleTemplateModel value)
	{
		getPersistenceContext().setPropertyValue(BUNDLETEMPLATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ChangeProductPriceBundleRule.currency</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 *  
	 * @param value the currency - Currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ChangeProductPriceBundleRule.price</code> attribute defined at extension <code>configurablebundleservices</code>. 
	 *  
	 * @param value the price - price set by bundle rule
	 */
	@Accessor(qualifier = "price", type = Accessor.Type.SETTER)
	public void setPrice(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(PRICE, value);
	}
	
}

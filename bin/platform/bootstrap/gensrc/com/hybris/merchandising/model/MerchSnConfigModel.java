/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 */
package com.hybris.merchandising.model;

import com.hybris.merchandising.model.MerchSnFieldModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.searchservices.model.SnIndexTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type MerchSnConfig first defined at extension merchandisingservices.
 * <p>
 * Merchandising Configuration.
 */
@SuppressWarnings("all")
public class MerchSnConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MerchSnConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.snIndexType</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String SNINDEXTYPE = "snIndexType";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.enabled</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String ENABLED = "enabled";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.baseSite</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String BASESITE = "baseSite";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.defaultLanguage</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String DEFAULTLANGUAGE = "defaultLanguage";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.currency</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.baseImageUrl</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String BASEIMAGEURL = "baseImageUrl";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.baseCatalogPageUrl</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String BASECATALOGPAGEURL = "baseCatalogPageUrl";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.rollUpStrategy</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String ROLLUPSTRATEGY = "rollUpStrategy";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.rollUpStrategyField</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String ROLLUPSTRATEGYFIELD = "rollUpStrategyField";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.cdsIdentifier</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String CDSIDENTIFIER = "cdsIdentifier";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.displayName</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String DISPLAYNAME = "displayName";
	
	/** <i>Generated constant</i> - Attribute key of <code>MerchSnConfig.merchSnFields</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHSNFIELDS = "merchSnFields";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MerchSnConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MerchSnConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSite initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _currency initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _defaultLanguage initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _displayName initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _rollUpStrategyField initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _snIndexType initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSnConfigModel(final BaseSiteModel _baseSite, final CurrencyModel _currency, final LanguageModel _defaultLanguage, final String _displayName, final String _rollUpStrategyField, final SnIndexTypeModel _snIndexType)
	{
		super();
		setBaseSite(_baseSite);
		setCurrency(_currency);
		setDefaultLanguage(_defaultLanguage);
		setDisplayName(_displayName);
		setRollUpStrategyField(_rollUpStrategyField);
		setSnIndexType(_snIndexType);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _baseSite initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _currency initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _defaultLanguage initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _displayName initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _rollUpStrategyField initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 * @param _snIndexType initial attribute declared by type <code>MerchSnConfig</code> at extension <code>merchandisingservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MerchSnConfigModel(final BaseSiteModel _baseSite, final CurrencyModel _currency, final LanguageModel _defaultLanguage, final String _displayName, final ItemModel _owner, final String _rollUpStrategyField, final SnIndexTypeModel _snIndexType)
	{
		super();
		setBaseSite(_baseSite);
		setCurrency(_currency);
		setDefaultLanguage(_defaultLanguage);
		setDisplayName(_displayName);
		setOwner(_owner);
		setRollUpStrategyField(_rollUpStrategyField);
		setSnIndexType(_snIndexType);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.baseCatalogPageUrl</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the baseCatalogPageUrl - Domain used for links to products and categories
	 */
	@Accessor(qualifier = "baseCatalogPageUrl", type = Accessor.Type.GETTER)
	public String getBaseCatalogPageUrl()
	{
		return getPersistenceContext().getPropertyValue(BASECATALOGPAGEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.baseImageUrl</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the baseImageUrl - Domain from which product images are served
	 */
	@Accessor(qualifier = "baseImageUrl", type = Accessor.Type.GETTER)
	public String getBaseImageUrl()
	{
		return getPersistenceContext().getPropertyValue(BASEIMAGEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.baseSite</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the baseSite - Base site for which configuration is defined
	 */
	@Accessor(qualifier = "baseSite", type = Accessor.Type.GETTER)
	public BaseSiteModel getBaseSite()
	{
		return getPersistenceContext().getPropertyValue(BASESITE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.cdsIdentifier</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the cdsIdentifier - Product directory identifier
	 */
	@Accessor(qualifier = "cdsIdentifier", type = Accessor.Type.GETTER)
	public String getCdsIdentifier()
	{
		return getPersistenceContext().getPropertyValue(CDSIDENTIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.currency</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the currency - Default currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.defaultLanguage</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the defaultLanguage - Default language
	 */
	@Accessor(qualifier = "defaultLanguage", type = Accessor.Type.GETTER)
	public LanguageModel getDefaultLanguage()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTLANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.displayName</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the displayName - Display name
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.GETTER)
	public String getDisplayName()
	{
		return getPersistenceContext().getPropertyValue(DISPLAYNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.merchSnFields</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the merchSnFields
	 */
	@Accessor(qualifier = "merchSnFields", type = Accessor.Type.GETTER)
	public List<MerchSnFieldModel> getMerchSnFields()
	{
		return getPersistenceContext().getPropertyValue(MERCHSNFIELDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.rollUpStrategy</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the rollUpStrategy - Roll Up Strategy
	 */
	@Accessor(qualifier = "rollUpStrategy", type = Accessor.Type.GETTER)
	public String getRollUpStrategy()
	{
		return getPersistenceContext().getPropertyValue(ROLLUPSTRATEGY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.rollUpStrategyField</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the rollUpStrategyField - Roll Up Strategy Field
	 */
	@Accessor(qualifier = "rollUpStrategyField", type = Accessor.Type.GETTER)
	public String getRollUpStrategyField()
	{
		return getPersistenceContext().getPropertyValue(ROLLUPSTRATEGYFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.snIndexType</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the snIndexType - Indexed type
	 */
	@Accessor(qualifier = "snIndexType", type = Accessor.Type.GETTER)
	public SnIndexTypeModel getSnIndexType()
	{
		return getPersistenceContext().getPropertyValue(SNINDEXTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MerchSnConfig.enabled</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the enabled - Flag indicating if configuration is enabled
	 */
	@Accessor(qualifier = "enabled", type = Accessor.Type.GETTER)
	public boolean isEnabled()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ENABLED));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.baseCatalogPageUrl</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the baseCatalogPageUrl - Domain used for links to products and categories
	 */
	@Accessor(qualifier = "baseCatalogPageUrl", type = Accessor.Type.SETTER)
	public void setBaseCatalogPageUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(BASECATALOGPAGEURL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.baseImageUrl</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the baseImageUrl - Domain from which product images are served
	 */
	@Accessor(qualifier = "baseImageUrl", type = Accessor.Type.SETTER)
	public void setBaseImageUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(BASEIMAGEURL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.baseSite</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the baseSite - Base site for which configuration is defined
	 */
	@Accessor(qualifier = "baseSite", type = Accessor.Type.SETTER)
	public void setBaseSite(final BaseSiteModel value)
	{
		getPersistenceContext().setPropertyValue(BASESITE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.cdsIdentifier</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the cdsIdentifier - Product directory identifier
	 */
	@Accessor(qualifier = "cdsIdentifier", type = Accessor.Type.SETTER)
	public void setCdsIdentifier(final String value)
	{
		getPersistenceContext().setPropertyValue(CDSIDENTIFIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.currency</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the currency - Default currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.defaultLanguage</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the defaultLanguage - Default language
	 */
	@Accessor(qualifier = "defaultLanguage", type = Accessor.Type.SETTER)
	public void setDefaultLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTLANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.displayName</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the displayName - Display name
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.SETTER)
	public void setDisplayName(final String value)
	{
		getPersistenceContext().setPropertyValue(DISPLAYNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.enabled</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the enabled - Flag indicating if configuration is enabled
	 */
	@Accessor(qualifier = "enabled", type = Accessor.Type.SETTER)
	public void setEnabled(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ENABLED, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.merchSnFields</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the merchSnFields
	 */
	@Accessor(qualifier = "merchSnFields", type = Accessor.Type.SETTER)
	public void setMerchSnFields(final List<MerchSnFieldModel> value)
	{
		getPersistenceContext().setPropertyValue(MERCHSNFIELDS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.rollUpStrategy</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the rollUpStrategy - Roll Up Strategy
	 */
	@Accessor(qualifier = "rollUpStrategy", type = Accessor.Type.SETTER)
	public void setRollUpStrategy(final String value)
	{
		getPersistenceContext().setPropertyValue(ROLLUPSTRATEGY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MerchSnConfig.rollUpStrategyField</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the rollUpStrategyField - Roll Up Strategy Field
	 */
	@Accessor(qualifier = "rollUpStrategyField", type = Accessor.Type.SETTER)
	public void setRollUpStrategyField(final String value)
	{
		getPersistenceContext().setPropertyValue(ROLLUPSTRATEGYFIELD, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>MerchSnConfig.snIndexType</code> attribute defined at extension <code>merchandisingservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the snIndexType - Indexed type
	 */
	@Accessor(qualifier = "snIndexType", type = Accessor.Type.SETTER)
	public void setSnIndexType(final SnIndexTypeModel value)
	{
		getPersistenceContext().setPropertyValue(SNINDEXTYPE, value);
	}
	
}

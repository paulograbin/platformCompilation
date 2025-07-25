/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.basecommerce.model.site;

import com.hybris.merchandising.model.MerchProductDirectoryConfigModel;
import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.acceleratorservices.model.CartRemovalCronJobModel;
import de.hybris.platform.acceleratorservices.model.UncollectedOrdersCronJobModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.commerceservices.enums.SiteTheme;
import de.hybris.platform.commerceservices.model.user.SiteEmployeeGroupModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.personalizationservices.model.config.CxConfigModel;
import de.hybris.platform.promotions.model.PromotionGroupModel;
import de.hybris.platform.searchservices.model.SnIndexTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;
import de.hybris.platform.store.BaseStoreModel;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Generated model class for type BaseSite first defined at extension basecommerce.
 */
@SuppressWarnings("all")
public class BaseSiteModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BaseSite";
	
	/**<i>Generated relation code constant for relation <code>SiteEmpGrp2BaseSiteRel</code> defining source attribute <code>siteEmployeeGroups</code> in extension <code>commerceservices</code>.</i>*/
	public static final String _SITEEMPGRP2BASESITEREL = "SiteEmpGrp2BaseSiteRel";
	
	/**<i>Generated relation code constant for relation <code>MerchProductDir2BaseSite</code> defining source attribute <code>merchProductDirectoryConfig</code> in extension <code>merchandisingservices</code>.</i>*/
	public static final String _MERCHPRODUCTDIR2BASESITE = "MerchProductDir2BaseSite";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.uid</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String UID = "uid";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.name</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.stores</code> attribute defined at extension <code>basecommerce</code>. */
	public static final String STORES = "stores";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.requiresAuthentication</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String REQUIRESAUTHENTICATION = "requiresAuthentication";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.theme</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String THEME = "theme";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.defaultLanguage</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DEFAULTLANGUAGE = "defaultLanguage";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.locale</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String LOCALE = "locale";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.channel</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String CHANNEL = "channel";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.defaultPromotionGroup</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DEFAULTPROMOTIONGROUP = "defaultPromotionGroup";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.solrFacetSearchConfiguration</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String SOLRFACETSEARCHCONFIGURATION = "solrFacetSearchConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.defaultStockLevelThreshold</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DEFAULTSTOCKLEVELTHRESHOLD = "defaultStockLevelThreshold";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.dataIsolationEnabled</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String DATAISOLATIONENABLED = "dataIsolationEnabled";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.siteEmployeeGroups</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String SITEEMPLOYEEGROUPS = "siteEmployeeGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.productIndexType</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String PRODUCTINDEXTYPE = "productIndexType";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.enableRegistration</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ENABLEREGISTRATION = "enableRegistration";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.merchProductDirectoryConfigPOS</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHPRODUCTDIRECTORYCONFIGPOS = "merchProductDirectoryConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.merchProductDirectoryConfig</code> attribute defined at extension <code>merchandisingservices</code>. */
	public static final String MERCHPRODUCTDIRECTORYCONFIG = "merchProductDirectoryConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CXCONFIG = "cxConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.cartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String CARTREMOVALAGE = "cartRemovalAge";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.anonymousCartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String ANONYMOUSCARTREMOVALAGE = "anonymousCartRemovalAge";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.cartRemovalCronJob</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String CARTREMOVALCRONJOB = "cartRemovalCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>BaseSite.uncollectedOrdersCronJob</code> attribute defined at extension <code>acceleratorservices</code>. */
	public static final String UNCOLLECTEDORDERSCRONJOB = "uncollectedOrdersCronJob";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BaseSiteModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BaseSiteModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>BaseSite</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BaseSiteModel(final String _uid)
	{
		super();
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _dataIsolationEnabled initial attribute declared by type <code>BaseSite</code> at extension <code>commerceservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>BaseSite</code> at extension <code>basecommerce</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BaseSiteModel(final Boolean _dataIsolationEnabled, final ItemModel _owner, final String _uid)
	{
		super();
		setDataIsolationEnabled(_dataIsolationEnabled);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.anonymousCartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the anonymousCartRemovalAge - After specified number of seconds carts will be cleaned up. Default is 14 days.
	 */
	@Accessor(qualifier = "anonymousCartRemovalAge", type = Accessor.Type.GETTER)
	public Integer getAnonymousCartRemovalAge()
	{
		return getPersistenceContext().getPropertyValue(ANONYMOUSCARTREMOVALAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.cartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the cartRemovalAge - After specified number of seconds carts will be cleaned up. Default is 28 days.
	 */
	@Accessor(qualifier = "cartRemovalAge", type = Accessor.Type.GETTER)
	public Integer getCartRemovalAge()
	{
		return getPersistenceContext().getPropertyValue(CARTREMOVALAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.cartRemovalCronJob</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the cartRemovalCronJob
	 */
	@Accessor(qualifier = "cartRemovalCronJob", type = Accessor.Type.GETTER)
	public CartRemovalCronJobModel getCartRemovalCronJob()
	{
		return getPersistenceContext().getPropertyValue(CARTREMOVALCRONJOB);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.channel</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the channel - The channel for this site.
	 */
	@Accessor(qualifier = "channel", type = Accessor.Type.GETTER)
	public SiteChannel getChannel()
	{
		return getPersistenceContext().getPropertyValue(CHANNEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the cxConfig
	 */
	@Accessor(qualifier = "cxConfig", type = Accessor.Type.GETTER)
	public CxConfigModel getCxConfig()
	{
		return getPersistenceContext().getPropertyValue(CXCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.dataIsolationEnabled</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the dataIsolationEnabled - Indicates whether customer data isolation is enabled for this site.
	 */
	@Accessor(qualifier = "dataIsolationEnabled", type = Accessor.Type.GETTER)
	public Boolean getDataIsolationEnabled()
	{
		final Boolean value = getPersistenceContext().getPropertyValue(DATAISOLATIONENABLED);
		return value != null ? value : Boolean.valueOf(false);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.defaultLanguage</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the defaultLanguage - The default language for the site.
	 */
	@Accessor(qualifier = "defaultLanguage", type = Accessor.Type.GETTER)
	public LanguageModel getDefaultLanguage()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTLANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.defaultPromotionGroup</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the defaultPromotionGroup - The default promotion group for the site.
	 */
	@Accessor(qualifier = "defaultPromotionGroup", type = Accessor.Type.GETTER)
	public PromotionGroupModel getDefaultPromotionGroup()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTPROMOTIONGROUP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.defaultStockLevelThreshold</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the defaultStockLevelThreshold - Indicates the threshold default value.
	 */
	@Accessor(qualifier = "defaultStockLevelThreshold", type = Accessor.Type.GETTER)
	public Integer getDefaultStockLevelThreshold()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTSTOCKLEVELTHRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.locale</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the locale - The locale to use for each language.
	 */
	@Accessor(qualifier = "locale", type = Accessor.Type.GETTER)
	public String getLocale()
	{
		return getLocale(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.locale</code> attribute defined at extension <code>commerceservices</code>. 
	 * @param loc the value localization key 
	 * @return the locale - The locale to use for each language.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "locale", type = Accessor.Type.GETTER)
	public String getLocale(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(LOCALE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.merchProductDirectoryConfig</code> attribute defined at extension <code>merchandisingservices</code>. 
	 * @return the merchProductDirectoryConfig
	 */
	@Accessor(qualifier = "merchProductDirectoryConfig", type = Accessor.Type.GETTER)
	public MerchProductDirectoryConfigModel getMerchProductDirectoryConfig()
	{
		return getPersistenceContext().getPropertyValue(MERCHPRODUCTDIRECTORYCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.name</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.name</code> attribute defined at extension <code>basecommerce</code>. 
	 * @param loc the value localization key 
	 * @return the name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.productIndexType</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the productIndexType
	 */
	@Accessor(qualifier = "productIndexType", type = Accessor.Type.GETTER)
	public SnIndexTypeModel getProductIndexType()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTINDEXTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.siteEmployeeGroups</code> attribute defined at extension <code>commerceservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the siteEmployeeGroups
	 */
	@Accessor(qualifier = "siteEmployeeGroups", type = Accessor.Type.GETTER)
	public Set<SiteEmployeeGroupModel> getSiteEmployeeGroups()
	{
		return getPersistenceContext().getPropertyValue(SITEEMPLOYEEGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.solrFacetSearchConfiguration</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the solrFacetSearchConfiguration - Solr search configuration for this site.
	 */
	@Accessor(qualifier = "solrFacetSearchConfiguration", type = Accessor.Type.GETTER)
	public SolrFacetSearchConfigModel getSolrFacetSearchConfiguration()
	{
		return getPersistenceContext().getPropertyValue(SOLRFACETSEARCHCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.stores</code> attribute defined at extension <code>basecommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the stores
	 */
	@Accessor(qualifier = "stores", type = Accessor.Type.GETTER)
	public List<BaseStoreModel> getStores()
	{
		return getPersistenceContext().getPropertyValue(STORES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.theme</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the theme - The site theme that is used in this site.
	 */
	@Accessor(qualifier = "theme", type = Accessor.Type.GETTER)
	public SiteTheme getTheme()
	{
		return getPersistenceContext().getPropertyValue(THEME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.uid</code> attribute defined at extension <code>basecommerce</code>. 
	 * @return the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.GETTER)
	public String getUid()
	{
		return getPersistenceContext().getPropertyValue(UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.uncollectedOrdersCronJob</code> attribute defined at extension <code>acceleratorservices</code>. 
	 * @return the uncollectedOrdersCronJob
	 */
	@Accessor(qualifier = "uncollectedOrdersCronJob", type = Accessor.Type.GETTER)
	public UncollectedOrdersCronJobModel getUncollectedOrdersCronJob()
	{
		return getPersistenceContext().getPropertyValue(UNCOLLECTEDORDERSCRONJOB);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.enableRegistration</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the enableRegistration - Indicates if the website supports registration request.
	 */
	@Accessor(qualifier = "enableRegistration", type = Accessor.Type.GETTER)
	public boolean isEnableRegistration()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ENABLEREGISTRATION));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.requiresAuthentication</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the requiresAuthentication - Indicates if the website requires authentication or not.
	 */
	@Accessor(qualifier = "requiresAuthentication", type = Accessor.Type.GETTER)
	public boolean isRequiresAuthentication()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(REQUIRESAUTHENTICATION));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.anonymousCartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the anonymousCartRemovalAge - After specified number of seconds carts will be cleaned up. Default is 14 days.
	 */
	@Accessor(qualifier = "anonymousCartRemovalAge", type = Accessor.Type.SETTER)
	public void setAnonymousCartRemovalAge(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ANONYMOUSCARTREMOVALAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.cartRemovalAge</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the cartRemovalAge - After specified number of seconds carts will be cleaned up. Default is 28 days.
	 */
	@Accessor(qualifier = "cartRemovalAge", type = Accessor.Type.SETTER)
	public void setCartRemovalAge(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CARTREMOVALAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.cartRemovalCronJob</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the cartRemovalCronJob
	 */
	@Accessor(qualifier = "cartRemovalCronJob", type = Accessor.Type.SETTER)
	public void setCartRemovalCronJob(final CartRemovalCronJobModel value)
	{
		getPersistenceContext().setPropertyValue(CARTREMOVALCRONJOB, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.channel</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the channel - The channel for this site.
	 */
	@Accessor(qualifier = "channel", type = Accessor.Type.SETTER)
	public void setChannel(final SiteChannel value)
	{
		getPersistenceContext().setPropertyValue(CHANNEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.cxConfig</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the cxConfig
	 */
	@Accessor(qualifier = "cxConfig", type = Accessor.Type.SETTER)
	public void setCxConfig(final CxConfigModel value)
	{
		getPersistenceContext().setPropertyValue(CXCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>BaseSite.dataIsolationEnabled</code> attribute defined at extension <code>commerceservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the dataIsolationEnabled - Indicates whether customer data isolation is enabled for this site.
	 */
	@Accessor(qualifier = "dataIsolationEnabled", type = Accessor.Type.SETTER)
	public void setDataIsolationEnabled(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(DATAISOLATIONENABLED, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.defaultLanguage</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the defaultLanguage - The default language for the site.
	 */
	@Accessor(qualifier = "defaultLanguage", type = Accessor.Type.SETTER)
	public void setDefaultLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTLANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.defaultPromotionGroup</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the defaultPromotionGroup - The default promotion group for the site.
	 */
	@Accessor(qualifier = "defaultPromotionGroup", type = Accessor.Type.SETTER)
	public void setDefaultPromotionGroup(final PromotionGroupModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTPROMOTIONGROUP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.defaultStockLevelThreshold</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the defaultStockLevelThreshold - Indicates the threshold default value.
	 */
	@Accessor(qualifier = "defaultStockLevelThreshold", type = Accessor.Type.SETTER)
	public void setDefaultStockLevelThreshold(final Integer value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTSTOCKLEVELTHRESHOLD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.enableRegistration</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the enableRegistration - Indicates if the website supports registration request.
	 */
	@Accessor(qualifier = "enableRegistration", type = Accessor.Type.SETTER)
	public void setEnableRegistration(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ENABLEREGISTRATION, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.locale</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the locale - The locale to use for each language.
	 */
	@Accessor(qualifier = "locale", type = Accessor.Type.SETTER)
	public void setLocale(final String value)
	{
		setLocale(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.locale</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the locale - The locale to use for each language.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "locale", type = Accessor.Type.SETTER)
	public void setLocale(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(LOCALE, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.merchProductDirectoryConfig</code> attribute defined at extension <code>merchandisingservices</code>. 
	 *  
	 * @param value the merchProductDirectoryConfig
	 */
	@Accessor(qualifier = "merchProductDirectoryConfig", type = Accessor.Type.SETTER)
	public void setMerchProductDirectoryConfig(final MerchProductDirectoryConfigModel value)
	{
		getPersistenceContext().setPropertyValue(MERCHPRODUCTDIRECTORYCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.name</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.name</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.productIndexType</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the productIndexType
	 */
	@Accessor(qualifier = "productIndexType", type = Accessor.Type.SETTER)
	public void setProductIndexType(final SnIndexTypeModel value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTINDEXTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.requiresAuthentication</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the requiresAuthentication - Indicates if the website requires authentication or not.
	 */
	@Accessor(qualifier = "requiresAuthentication", type = Accessor.Type.SETTER)
	public void setRequiresAuthentication(final boolean value)
	{
		getPersistenceContext().setPropertyValue(REQUIRESAUTHENTICATION, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.siteEmployeeGroups</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the siteEmployeeGroups
	 */
	@Accessor(qualifier = "siteEmployeeGroups", type = Accessor.Type.SETTER)
	public void setSiteEmployeeGroups(final Set<SiteEmployeeGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(SITEEMPLOYEEGROUPS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.solrFacetSearchConfiguration</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the solrFacetSearchConfiguration - Solr search configuration for this site.
	 */
	@Accessor(qualifier = "solrFacetSearchConfiguration", type = Accessor.Type.SETTER)
	public void setSolrFacetSearchConfiguration(final SolrFacetSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRFACETSEARCHCONFIGURATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.stores</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the stores
	 */
	@Accessor(qualifier = "stores", type = Accessor.Type.SETTER)
	public void setStores(final List<BaseStoreModel> value)
	{
		getPersistenceContext().setPropertyValue(STORES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.theme</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the theme - The site theme that is used in this site.
	 */
	@Accessor(qualifier = "theme", type = Accessor.Type.SETTER)
	public void setTheme(final SiteTheme value)
	{
		getPersistenceContext().setPropertyValue(THEME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.uid</code> attribute defined at extension <code>basecommerce</code>. 
	 *  
	 * @param value the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.SETTER)
	public void setUid(final String value)
	{
		getPersistenceContext().setPropertyValue(UID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BaseSite.uncollectedOrdersCronJob</code> attribute defined at extension <code>acceleratorservices</code>. 
	 *  
	 * @param value the uncollectedOrdersCronJob
	 */
	@Accessor(qualifier = "uncollectedOrdersCronJob", type = Accessor.Type.SETTER)
	public void setUncollectedOrdersCronJob(final UncollectedOrdersCronJobModel value)
	{
		getPersistenceContext().setPropertyValue(UNCOLLECTEDORDERSCRONJOB, value);
	}
	
}

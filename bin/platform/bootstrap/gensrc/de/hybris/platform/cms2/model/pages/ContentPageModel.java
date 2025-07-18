/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.model.pages;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.acceleratorcms.model.components.SimpleBannerComponentModel;
import de.hybris.platform.acceleratorcms.model.components.SimpleResponsiveBannerComponentModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.contents.components.CMSLinkComponentModel;
import de.hybris.platform.cms2.model.contents.components.VideoComponentModel;
import de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.PageTemplateModel;
import de.hybris.platform.cms2lib.model.components.BannerComponentModel;
import de.hybris.platform.cms2lib.model.components.FlashComponentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type ContentPage first defined at extension cms2.
 */
@SuppressWarnings("all")
public class ContentPageModel extends AbstractPageModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ContentPage";
	
	/**<i>Generated relation code constant for relation <code>BannersForContentPage</code> defining source attribute <code>bannerComponets</code> in extension <code>cms2lib</code>.</i>*/
	public static final String _BANNERSFORCONTENTPAGE = "BannersForContentPage";
	
	/**<i>Generated relation code constant for relation <code>FlashComponentsForContentPage</code> defining source attribute <code>flashComponents</code> in extension <code>cms2lib</code>.</i>*/
	public static final String _FLASHCOMPONENTSFORCONTENTPAGE = "FlashComponentsForContentPage";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.label</code> attribute defined at extension <code>cms2</code>. */
	public static final String LABEL = "label";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.homepage</code> attribute defined at extension <code>cms2</code>. */
	public static final String HOMEPAGE = "homepage";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.labelOrId</code> attribute defined at extension <code>cms2</code>. */
	public static final String LABELORID = "labelOrId";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.navigationNodes</code> attribute defined at extension <code>cms2</code>. */
	public static final String NAVIGATIONNODES = "navigationNodes";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.linkComponents</code> attribute defined at extension <code>cms2</code>. */
	public static final String LINKCOMPONENTS = "linkComponents";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.videoComponents</code> attribute defined at extension <code>cms2</code>. */
	public static final String VIDEOCOMPONENTS = "videoComponents";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.bannerComponets</code> attribute defined at extension <code>cms2lib</code>. */
	public static final String BANNERCOMPONETS = "bannerComponets";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.flashComponents</code> attribute defined at extension <code>cms2lib</code>. */
	public static final String FLASHCOMPONENTS = "flashComponents";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.keywords</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String KEYWORDS = "keywords";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.simpleBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String SIMPLEBANNERCOMPONENTS = "simpleBannerComponents";
	
	/** <i>Generated constant</i> - Attribute key of <code>ContentPage.simpleResponsiveBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. */
	public static final String SIMPLERESPONSIVEBANNERCOMPONENTS = "simpleResponsiveBannerComponents";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ContentPageModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ContentPageModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _masterTemplate initial attribute declared by type <code>AbstractPage</code> at extension <code>cms2</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ContentPageModel(final CatalogVersionModel _catalogVersion, final PageTemplateModel _masterTemplate, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setMasterTemplate(_masterTemplate);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _masterTemplate initial attribute declared by type <code>AbstractPage</code> at extension <code>cms2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ContentPageModel(final CatalogVersionModel _catalogVersion, final PageTemplateModel _masterTemplate, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setMasterTemplate(_masterTemplate);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.bannerComponets</code> attribute defined at extension <code>cms2lib</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the bannerComponets
	 */
	@Accessor(qualifier = "bannerComponets", type = Accessor.Type.GETTER)
	public List<BannerComponentModel> getBannerComponets()
	{
		return getPersistenceContext().getPropertyValue(BANNERCOMPONETS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.flashComponents</code> attribute defined at extension <code>cms2lib</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the flashComponents
	 */
	@Accessor(qualifier = "flashComponents", type = Accessor.Type.GETTER)
	public List<FlashComponentModel> getFlashComponents()
	{
		return getPersistenceContext().getPropertyValue(FLASHCOMPONENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.keywords</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @return the keywords - Localized content page keywords.
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.GETTER)
	public String getKeywords()
	{
		return getKeywords(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.keywords</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * @param loc the value localization key 
	 * @return the keywords - Localized content page keywords.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.GETTER)
	public String getKeywords(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(KEYWORDS, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.label</code> attribute defined at extension <code>cms2</code>. 
	 * @return the label
	 */
	@Accessor(qualifier = "label", type = Accessor.Type.GETTER)
	public String getLabel()
	{
		return getPersistenceContext().getPropertyValue(LABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.labelOrId</code> attribute defined at extension <code>cms2</code>. 
	 * @return the labelOrId
	 * @deprecated since 4.3
	 */
	@Deprecated(since = "4.3", forRemoval = true)
	@Accessor(qualifier = "labelOrId", type = Accessor.Type.GETTER)
	public String getLabelOrId()
	{
		return getPersistenceContext().getPropertyValue(LABELORID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.linkComponents</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the linkComponents
	 */
	@Accessor(qualifier = "linkComponents", type = Accessor.Type.GETTER)
	public List<CMSLinkComponentModel> getLinkComponents()
	{
		return getPersistenceContext().getPropertyValue(LINKCOMPONENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.navigationNodes</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the navigationNodes
	 * @deprecated since 4.4
	 */
	@Deprecated(since = "4.4", forRemoval = true)
	@Accessor(qualifier = "navigationNodes", type = Accessor.Type.GETTER)
	public List<CMSNavigationNodeModel> getNavigationNodes()
	{
		return getPersistenceContext().getPropertyValue(NAVIGATIONNODES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.simpleBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the simpleBannerComponents
	 */
	@Accessor(qualifier = "simpleBannerComponents", type = Accessor.Type.GETTER)
	public List<SimpleBannerComponentModel> getSimpleBannerComponents()
	{
		return getPersistenceContext().getPropertyValue(SIMPLEBANNERCOMPONENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.simpleResponsiveBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the simpleResponsiveBannerComponents
	 */
	@Accessor(qualifier = "simpleResponsiveBannerComponents", type = Accessor.Type.GETTER)
	public List<SimpleResponsiveBannerComponentModel> getSimpleResponsiveBannerComponents()
	{
		return getPersistenceContext().getPropertyValue(SIMPLERESPONSIVEBANNERCOMPONENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.videoComponents</code> attribute defined at extension <code>cms2</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the videoComponents
	 */
	@Accessor(qualifier = "videoComponents", type = Accessor.Type.GETTER)
	public List<VideoComponentModel> getVideoComponents()
	{
		return getPersistenceContext().getPropertyValue(VIDEOCOMPONENTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContentPage.homepage</code> attribute defined at extension <code>cms2</code>. 
	 * @return the homepage
	 */
	@Accessor(qualifier = "homepage", type = Accessor.Type.GETTER)
	public boolean isHomepage()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(HOMEPAGE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.bannerComponets</code> attribute defined at extension <code>cms2lib</code>. 
	 *  
	 * @param value the bannerComponets
	 */
	@Accessor(qualifier = "bannerComponets", type = Accessor.Type.SETTER)
	public void setBannerComponets(final List<BannerComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(BANNERCOMPONETS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.flashComponents</code> attribute defined at extension <code>cms2lib</code>. 
	 *  
	 * @param value the flashComponents
	 */
	@Accessor(qualifier = "flashComponents", type = Accessor.Type.SETTER)
	public void setFlashComponents(final List<FlashComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(FLASHCOMPONENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.homepage</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the homepage
	 */
	@Accessor(qualifier = "homepage", type = Accessor.Type.SETTER)
	public void setHomepage(final boolean value)
	{
		getPersistenceContext().setPropertyValue(HOMEPAGE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.keywords</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the keywords - Localized content page keywords.
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.SETTER)
	public void setKeywords(final String value)
	{
		setKeywords(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.keywords</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the keywords - Localized content page keywords.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "keywords", type = Accessor.Type.SETTER)
	public void setKeywords(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(KEYWORDS, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.label</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the label
	 */
	@Accessor(qualifier = "label", type = Accessor.Type.SETTER)
	public void setLabel(final String value)
	{
		getPersistenceContext().setPropertyValue(LABEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.linkComponents</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the linkComponents
	 */
	@Accessor(qualifier = "linkComponents", type = Accessor.Type.SETTER)
	public void setLinkComponents(final List<CMSLinkComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(LINKCOMPONENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.navigationNodes</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the navigationNodes
	 * @deprecated since 4.4
	 */
	@Deprecated(since = "4.4", forRemoval = true)
	@Accessor(qualifier = "navigationNodes", type = Accessor.Type.SETTER)
	public void setNavigationNodes(final List<CMSNavigationNodeModel> value)
	{
		getPersistenceContext().setPropertyValue(NAVIGATIONNODES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.simpleBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the simpleBannerComponents
	 */
	@Accessor(qualifier = "simpleBannerComponents", type = Accessor.Type.SETTER)
	public void setSimpleBannerComponents(final List<SimpleBannerComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(SIMPLEBANNERCOMPONENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.simpleResponsiveBannerComponents</code> attribute defined at extension <code>acceleratorcms</code>. 
	 *  
	 * @param value the simpleResponsiveBannerComponents
	 */
	@Accessor(qualifier = "simpleResponsiveBannerComponents", type = Accessor.Type.SETTER)
	public void setSimpleResponsiveBannerComponents(final List<SimpleResponsiveBannerComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(SIMPLERESPONSIVEBANNERCOMPONENTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ContentPage.videoComponents</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the videoComponents
	 */
	@Accessor(qualifier = "videoComponents", type = Accessor.Type.SETTER)
	public void setVideoComponents(final List<VideoComponentModel> value)
	{
		getPersistenceContext().setPropertyValue(VIDEOCOMPONENTS, value);
	}
	
}

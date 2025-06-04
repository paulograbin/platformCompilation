/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:27:36 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.model.user;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type SiteEmployeeGroup first defined at extension commerceservices.
 * <p>
 * Group of Employees working in a particular base site.
 */
@SuppressWarnings("all")
public class SiteEmployeeGroupModel extends UserGroupModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SiteEmployeeGroup";
	
	/** <i>Generated constant</i> - Attribute key of <code>SiteEmployeeGroup.visibleSite</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String VISIBLESITE = "visibleSite";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SiteEmployeeGroupModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SiteEmployeeGroupModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 * @param _visibleSite initial attribute declared by type <code>SiteEmployeeGroup</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SiteEmployeeGroupModel(final String _uid, final BaseSiteModel _visibleSite)
	{
		super();
		setUid(_uid);
		setVisibleSite(_visibleSite);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 * @param _visibleSite initial attribute declared by type <code>SiteEmployeeGroup</code> at extension <code>commerceservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SiteEmployeeGroupModel(final ItemModel _owner, final String _uid, final BaseSiteModel _visibleSite)
	{
		super();
		setOwner(_owner);
		setUid(_uid);
		setVisibleSite(_visibleSite);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SiteEmployeeGroup.visibleSite</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the visibleSite
	 */
	@Accessor(qualifier = "visibleSite", type = Accessor.Type.GETTER)
	public BaseSiteModel getVisibleSite()
	{
		return getPersistenceContext().getPropertyValue(VISIBLESITE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SiteEmployeeGroup.visibleSite</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the visibleSite
	 */
	@Accessor(qualifier = "visibleSite", type = Accessor.Type.SETTER)
	public void setVisibleSite(final BaseSiteModel value)
	{
		getPersistenceContext().setPropertyValue(VISIBLESITE, value);
	}
	
}

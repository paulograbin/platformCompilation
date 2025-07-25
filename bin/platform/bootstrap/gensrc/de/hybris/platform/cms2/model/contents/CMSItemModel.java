/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.model.contents;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CMSItem first defined at extension cms2.
 */
@SuppressWarnings("all")
public class CMSItemModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CMSItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItem.uid</code> attribute defined at extension <code>cms2</code>. */
	public static final String UID = "uid";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItem.name</code> attribute defined at extension <code>cms2</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItem.catalogVersion</code> attribute defined at extension <code>cms2</code>. */
	public static final String CATALOGVERSION = "catalogVersion";
	
	/** <i>Generated constant</i> - Attribute key of <code>CMSItem.synchronizationBlocked</code> attribute defined at extension <code>cms2</code>. */
	public static final String SYNCHRONIZATIONBLOCKED = "synchronizationBlocked";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CMSItemModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CMSItemModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CMSItemModel(final CatalogVersionModel _catalogVersion, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>CMSItem</code> at extension <code>cms2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public CMSItemModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItem.catalogVersion</code> attribute defined at extension <code>cms2</code>. 
	 * @return the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.GETTER)
	public CatalogVersionModel getCatalogVersion()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItem.name</code> attribute defined at extension <code>cms2</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItem.uid</code> attribute defined at extension <code>cms2</code>. 
	 * @return the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.GETTER)
	public String getUid()
	{
		return getPersistenceContext().getPropertyValue(UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSItem.synchronizationBlocked</code> attribute defined at extension <code>cms2</code>. 
	 * @return the synchronizationBlocked
	 */
	@Accessor(qualifier = "synchronizationBlocked", type = Accessor.Type.GETTER)
	public boolean isSynchronizationBlocked()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(SYNCHRONIZATIONBLOCKED));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItem.catalogVersion</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the catalogVersion
	 */
	@Accessor(qualifier = "catalogVersion", type = Accessor.Type.SETTER)
	public void setCatalogVersion(final CatalogVersionModel value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItem.name</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItem.synchronizationBlocked</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the synchronizationBlocked
	 */
	@Accessor(qualifier = "synchronizationBlocked", type = Accessor.Type.SETTER)
	public void setSynchronizationBlocked(final boolean value)
	{
		getPersistenceContext().setPropertyValue(SYNCHRONIZATIONBLOCKED, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CMSItem.uid</code> attribute defined at extension <code>cms2</code>. 
	 *  
	 * @param value the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.SETTER)
	public void setUid(final String value)
	{
		getPersistenceContext().setPropertyValue(UID, value);
	}
	
}

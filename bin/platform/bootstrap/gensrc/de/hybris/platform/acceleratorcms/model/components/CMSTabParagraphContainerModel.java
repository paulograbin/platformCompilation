/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorcms.model.components;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.contents.containers.AbstractCMSComponentContainerModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type CMSTabParagraphContainer first defined at extension acceleratorcms.
 * <p>
 * This is container used to group tab paragraph components.
 */
@SuppressWarnings("all")
public class CMSTabParagraphContainerModel extends AbstractCMSComponentContainerModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CMSTabParagraphContainer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CMSTabParagraphContainerModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CMSTabParagraphContainerModel(final ItemModelContext ctx)
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
	public CMSTabParagraphContainerModel(final CatalogVersionModel _catalogVersion, final String _uid)
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
	public CMSTabParagraphContainerModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
}

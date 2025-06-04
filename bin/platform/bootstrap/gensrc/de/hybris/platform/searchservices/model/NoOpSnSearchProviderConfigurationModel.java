/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.model;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.searchservices.model.AbstractSnSearchProviderConfigurationModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type NoOpSnSearchProviderConfiguration first defined at extension searchservices.
 */
@SuppressWarnings("all")
public class NoOpSnSearchProviderConfigurationModel extends AbstractSnSearchProviderConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "NoOpSnSearchProviderConfiguration";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public NoOpSnSearchProviderConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public NoOpSnSearchProviderConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>AbstractSnSearchProviderConfiguration</code> at extension <code>searchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public NoOpSnSearchProviderConfigurationModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>AbstractSnSearchProviderConfiguration</code> at extension <code>searchservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public NoOpSnSearchProviderConfigurationModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
}

/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.adaptivesearch.model.AbstractAsConfigurableSearchConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AsSimpleSearchProfileModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AsSimpleSearchConfiguration first defined at extension adaptivesearch.
 */
@SuppressWarnings("all")
public class AsSimpleSearchConfigurationModel extends AbstractAsConfigurableSearchConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AsSimpleSearchConfiguration";
	
	/**<i>Generated relation code constant for relation <code>AsSimpleSearchProfile2SimpleSearchConfiguration</code> defining source attribute <code>searchProfile</code> in extension <code>adaptivesearch</code>.</i>*/
	public static final String _ASSIMPLESEARCHPROFILE2SIMPLESEARCHCONFIGURATION = "AsSimpleSearchProfile2SimpleSearchConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSimpleSearchConfiguration.searchProfile</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String SEARCHPROFILE = "searchProfile";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AsSimpleSearchConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AsSimpleSearchConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _searchProfile initial attribute declared by type <code>AsSimpleSearchConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AsSimpleSearchConfigurationModel(final AsSimpleSearchProfileModel _searchProfile, final String _uid)
	{
		super();
		setSearchProfile(_searchProfile);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _searchProfile initial attribute declared by type <code>AsSimpleSearchConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AsSimpleSearchConfigurationModel(final CatalogVersionModel _catalogVersion, final ItemModel _owner, final AsSimpleSearchProfileModel _searchProfile, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setOwner(_owner);
		setSearchProfile(_searchProfile);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsSimpleSearchConfiguration.searchProfile</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the searchProfile
	 */
	@Accessor(qualifier = "searchProfile", type = Accessor.Type.GETTER)
	public AsSimpleSearchProfileModel getSearchProfile()
	{
		return getPersistenceContext().getPropertyValue(SEARCHPROFILE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsConfiguration.corrupted</code> dynamic attribute defined at extension <code>adaptivesearch</code> and redeclared at extension <code>adaptivesearch</code>. 
	 * @return the corrupted
	 */
	@Override
	@Accessor(qualifier = "corrupted", type = Accessor.Type.GETTER)
	public boolean isCorrupted()
	{
		return (boolean) super.isCorrupted();
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AsSimpleSearchConfiguration.searchProfile</code> attribute defined at extension <code>adaptivesearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the searchProfile
	 */
	@Accessor(qualifier = "searchProfile", type = Accessor.Type.SETTER)
	public void setSearchProfile(final AsSimpleSearchProfileModel value)
	{
		getPersistenceContext().setPropertyValue(SEARCHPROFILE, value);
	}
	
}

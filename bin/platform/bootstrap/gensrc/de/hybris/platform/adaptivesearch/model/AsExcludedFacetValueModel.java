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
import de.hybris.platform.adaptivesearch.model.AbstractAsFacetConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AbstractAsFacetValueConfigurationModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AsExcludedFacetValue first defined at extension adaptivesearch.
 */
@SuppressWarnings("all")
public class AsExcludedFacetValueModel extends AbstractAsFacetValueConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AsExcludedFacetValue";
	
	/**<i>Generated relation code constant for relation <code>AbstractAsFacetConfiguration2ExcludedFacetValueRelation</code> defining source attribute <code>facetConfiguration</code> in extension <code>adaptivesearch</code>.</i>*/
	public static final String _ABSTRACTASFACETCONFIGURATION2EXCLUDEDFACETVALUERELATION = "AbstractAsFacetConfiguration2ExcludedFacetValueRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsExcludedFacetValue.facetConfigurationPOS</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String FACETCONFIGURATIONPOS = "facetConfigurationPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsExcludedFacetValue.facetConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String FACETCONFIGURATION = "facetConfiguration";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AsExcludedFacetValueModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AsExcludedFacetValueModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _facetConfiguration initial attribute declared by type <code>AsExcludedFacetValue</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _value initial attribute declared by type <code>AbstractAsFacetValueConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AsExcludedFacetValueModel(final AbstractAsFacetConfigurationModel _facetConfiguration, final String _uid, final String _value)
	{
		super();
		setFacetConfiguration(_facetConfiguration);
		setUid(_uid);
		setValue(_value);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _facetConfiguration initial attribute declared by type <code>AsExcludedFacetValue</code> at extension <code>adaptivesearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _value initial attribute declared by type <code>AbstractAsFacetValueConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AsExcludedFacetValueModel(final CatalogVersionModel _catalogVersion, final AbstractAsFacetConfigurationModel _facetConfiguration, final ItemModel _owner, final String _uid, final String _value)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setFacetConfiguration(_facetConfiguration);
		setOwner(_owner);
		setUid(_uid);
		setValue(_value);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsExcludedFacetValue.facetConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the facetConfiguration
	 */
	@Accessor(qualifier = "facetConfiguration", type = Accessor.Type.GETTER)
	public AbstractAsFacetConfigurationModel getFacetConfiguration()
	{
		return getPersistenceContext().getPropertyValue(FACETCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AsExcludedFacetValue.facetConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the facetConfiguration
	 */
	@Accessor(qualifier = "facetConfiguration", type = Accessor.Type.SETTER)
	public void setFacetConfiguration(final AbstractAsFacetConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(FACETCONFIGURATION, value);
	}
	
}

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
import de.hybris.platform.adaptivesearch.enums.AsFacetType;
import de.hybris.platform.adaptivesearch.model.AbstractAsItemConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AsExcludedFacetValueModel;
import de.hybris.platform.adaptivesearch.model.AsFacetRangeModel;
import de.hybris.platform.adaptivesearch.model.AsPromotedFacetValueModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type AbstractAsFacetConfiguration first defined at extension adaptivesearch.
 */
@SuppressWarnings("all")
public class AbstractAsFacetConfigurationModel extends AbstractAsItemConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractAsFacetConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.indexProperty</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String INDEXPROPERTY = "indexProperty";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.facetType</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String FACETTYPE = "facetType";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String PRIORITY = "priority";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.valuesSortProvider</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String VALUESSORTPROVIDER = "valuesSortProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.valuesDisplayNameProvider</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String VALUESDISPLAYNAMEPROVIDER = "valuesDisplayNameProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.topValuesProvider</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String TOPVALUESPROVIDER = "topValuesProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.topValuesSize</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String TOPVALUESSIZE = "topValuesSize";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.sort</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String SORT = "sort";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.ranged</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String RANGED = "ranged";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.rangeIncludeFrom</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String RANGEINCLUDEFROM = "rangeIncludeFrom";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.rangeIncludeTo</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String RANGEINCLUDETO = "rangeIncludeTo";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String UNIQUEIDX = "uniqueIdx";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.promotedValues</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String PROMOTEDVALUES = "promotedValues";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.ranges</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String RANGES = "ranges";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsFacetConfiguration.excludedValues</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String EXCLUDEDVALUES = "excludedValues";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractAsFacetConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractAsFacetConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _indexProperty initial attribute declared by type <code>AbstractAsFacetConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractAsFacetConfigurationModel(final String _indexProperty, final String _uid)
	{
		super();
		setIndexProperty(_indexProperty);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _indexProperty initial attribute declared by type <code>AbstractAsFacetConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractAsFacetConfigurationModel(final CatalogVersionModel _catalogVersion, final String _indexProperty, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setIndexProperty(_indexProperty);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.excludedValues</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the excludedValues
	 */
	@Accessor(qualifier = "excludedValues", type = Accessor.Type.GETTER)
	public List<AsExcludedFacetValueModel> getExcludedValues()
	{
		return getPersistenceContext().getPropertyValue(EXCLUDEDVALUES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.facetType</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the facetType
	 */
	@Accessor(qualifier = "facetType", type = Accessor.Type.GETTER)
	public AsFacetType getFacetType()
	{
		return getPersistenceContext().getPropertyValue(FACETTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.indexProperty</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the indexProperty
	 */
	@Accessor(qualifier = "indexProperty", type = Accessor.Type.GETTER)
	public String getIndexProperty()
	{
		return getPersistenceContext().getPropertyValue(INDEXPROPERTY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.GETTER)
	public Integer getPriority()
	{
		return getPersistenceContext().getPropertyValue(PRIORITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.promotedValues</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the promotedValues
	 */
	@Accessor(qualifier = "promotedValues", type = Accessor.Type.GETTER)
	public List<AsPromotedFacetValueModel> getPromotedValues()
	{
		return getPersistenceContext().getPropertyValue(PROMOTEDVALUES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.ranges</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ranges
	 */
	@Accessor(qualifier = "ranges", type = Accessor.Type.GETTER)
	public List<AsFacetRangeModel> getRanges()
	{
		return getPersistenceContext().getPropertyValue(RANGES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.sort</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the sort
	 */
	@Accessor(qualifier = "sort", type = Accessor.Type.GETTER)
	public String getSort()
	{
		return getPersistenceContext().getPropertyValue(SORT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.topValuesProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the topValuesProvider
	 */
	@Accessor(qualifier = "topValuesProvider", type = Accessor.Type.GETTER)
	public String getTopValuesProvider()
	{
		return getPersistenceContext().getPropertyValue(TOPVALUESPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.topValuesSize</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the topValuesSize
	 */
	@Accessor(qualifier = "topValuesSize", type = Accessor.Type.GETTER)
	public Integer getTopValuesSize()
	{
		return getPersistenceContext().getPropertyValue(TOPVALUESSIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.GETTER)
	public String getUniqueIdx()
	{
		return getPersistenceContext().getPropertyValue(UNIQUEIDX);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.valuesDisplayNameProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the valuesDisplayNameProvider
	 */
	@Accessor(qualifier = "valuesDisplayNameProvider", type = Accessor.Type.GETTER)
	public String getValuesDisplayNameProvider()
	{
		return getPersistenceContext().getPropertyValue(VALUESDISPLAYNAMEPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.valuesSortProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the valuesSortProvider
	 */
	@Accessor(qualifier = "valuesSortProvider", type = Accessor.Type.GETTER)
	public String getValuesSortProvider()
	{
		return getPersistenceContext().getPropertyValue(VALUESSORTPROVIDER);
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
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.ranged</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the ranged
	 */
	@Accessor(qualifier = "ranged", type = Accessor.Type.GETTER)
	public boolean isRanged()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(RANGED));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.rangeIncludeFrom</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the rangeIncludeFrom
	 */
	@Accessor(qualifier = "rangeIncludeFrom", type = Accessor.Type.GETTER)
	public boolean isRangeIncludeFrom()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(RANGEINCLUDEFROM));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsFacetConfiguration.rangeIncludeTo</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the rangeIncludeTo
	 */
	@Accessor(qualifier = "rangeIncludeTo", type = Accessor.Type.GETTER)
	public boolean isRangeIncludeTo()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(RANGEINCLUDETO));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.excludedValues</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the excludedValues
	 */
	@Accessor(qualifier = "excludedValues", type = Accessor.Type.SETTER)
	public void setExcludedValues(final List<AsExcludedFacetValueModel> value)
	{
		getPersistenceContext().setPropertyValue(EXCLUDEDVALUES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.facetType</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the facetType
	 */
	@Accessor(qualifier = "facetType", type = Accessor.Type.SETTER)
	public void setFacetType(final AsFacetType value)
	{
		getPersistenceContext().setPropertyValue(FACETTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AbstractAsFacetConfiguration.indexProperty</code> attribute defined at extension <code>adaptivesearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the indexProperty
	 */
	@Accessor(qualifier = "indexProperty", type = Accessor.Type.SETTER)
	public void setIndexProperty(final String value)
	{
		getPersistenceContext().setPropertyValue(INDEXPROPERTY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
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
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.SETTER)
	public void setPriority(final Integer value)
	{
		getPersistenceContext().setPropertyValue(PRIORITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.promotedValues</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the promotedValues
	 */
	@Accessor(qualifier = "promotedValues", type = Accessor.Type.SETTER)
	public void setPromotedValues(final List<AsPromotedFacetValueModel> value)
	{
		getPersistenceContext().setPropertyValue(PROMOTEDVALUES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.ranged</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the ranged
	 */
	@Accessor(qualifier = "ranged", type = Accessor.Type.SETTER)
	public void setRanged(final boolean value)
	{
		getPersistenceContext().setPropertyValue(RANGED, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.rangeIncludeFrom</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the rangeIncludeFrom
	 */
	@Accessor(qualifier = "rangeIncludeFrom", type = Accessor.Type.SETTER)
	public void setRangeIncludeFrom(final boolean value)
	{
		getPersistenceContext().setPropertyValue(RANGEINCLUDEFROM, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.rangeIncludeTo</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the rangeIncludeTo
	 */
	@Accessor(qualifier = "rangeIncludeTo", type = Accessor.Type.SETTER)
	public void setRangeIncludeTo(final boolean value)
	{
		getPersistenceContext().setPropertyValue(RANGEINCLUDETO, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.ranges</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the ranges
	 */
	@Accessor(qualifier = "ranges", type = Accessor.Type.SETTER)
	public void setRanges(final List<AsFacetRangeModel> value)
	{
		getPersistenceContext().setPropertyValue(RANGES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.sort</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the sort
	 */
	@Accessor(qualifier = "sort", type = Accessor.Type.SETTER)
	public void setSort(final String value)
	{
		getPersistenceContext().setPropertyValue(SORT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.topValuesProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the topValuesProvider
	 */
	@Accessor(qualifier = "topValuesProvider", type = Accessor.Type.SETTER)
	public void setTopValuesProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(TOPVALUESPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.topValuesSize</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the topValuesSize
	 */
	@Accessor(qualifier = "topValuesSize", type = Accessor.Type.SETTER)
	public void setTopValuesSize(final Integer value)
	{
		getPersistenceContext().setPropertyValue(TOPVALUESSIZE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.SETTER)
	public void setUniqueIdx(final String value)
	{
		getPersistenceContext().setPropertyValue(UNIQUEIDX, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.valuesDisplayNameProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the valuesDisplayNameProvider
	 */
	@Accessor(qualifier = "valuesDisplayNameProvider", type = Accessor.Type.SETTER)
	public void setValuesDisplayNameProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUESDISPLAYNAMEPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsFacetConfiguration.valuesSortProvider</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the valuesSortProvider
	 */
	@Accessor(qualifier = "valuesSortProvider", type = Accessor.Type.SETTER)
	public void setValuesSortProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUESSORTPROVIDER, value);
	}
	
}

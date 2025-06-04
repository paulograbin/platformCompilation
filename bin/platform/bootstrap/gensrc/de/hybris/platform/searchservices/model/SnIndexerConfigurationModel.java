/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.searchservices.model.SnIndexConfigurationModel;
import de.hybris.platform.searchservices.model.SnIndexTypeModel;
import de.hybris.platform.searchservices.model.SnRetryConfigurationModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type SnIndexerConfiguration first defined at extension searchservices.
 */
@SuppressWarnings("all")
public class SnIndexerConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SnIndexerConfiguration";
	
	/**<i>Generated relation code constant for relation <code>SnIndexConfiguration2IndexerConfiguration</code> defining source attribute <code>indexConfigurations</code> in extension <code>searchservices</code>.</i>*/
	public static final String _SNINDEXCONFIGURATION2INDEXERCONFIGURATION = "SnIndexConfiguration2IndexerConfiguration";
	
	/**<i>Generated relation code constant for relation <code>SnIndexType2IndexerConfiguration</code> defining source attribute <code>indexTypes</code> in extension <code>searchservices</code>.</i>*/
	public static final String _SNINDEXTYPE2INDEXERCONFIGURATION = "SnIndexType2IndexerConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.id</code> attribute defined at extension <code>searchservices</code>. */
	public static final String ID = "id";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.name</code> attribute defined at extension <code>searchservices</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.concurrency</code> attribute defined at extension <code>searchservices</code>. */
	public static final String CONCURRENCY = "concurrency";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.batchSize</code> attribute defined at extension <code>searchservices</code>. */
	public static final String BATCHSIZE = "batchSize";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.retryConfiguration</code> attribute defined at extension <code>searchservices</code>. */
	public static final String RETRYCONFIGURATION = "retryConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.indexConfigurations</code> attribute defined at extension <code>searchservices</code>. */
	public static final String INDEXCONFIGURATIONS = "indexConfigurations";
	
	/** <i>Generated constant</i> - Attribute key of <code>SnIndexerConfiguration.indexTypes</code> attribute defined at extension <code>searchservices</code>. */
	public static final String INDEXTYPES = "indexTypes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SnIndexerConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SnIndexerConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SnIndexerConfiguration</code> at extension <code>searchservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SnIndexerConfigurationModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>SnIndexerConfiguration</code> at extension <code>searchservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SnIndexerConfigurationModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.batchSize</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the batchSize
	 */
	@Accessor(qualifier = "batchSize", type = Accessor.Type.GETTER)
	public Integer getBatchSize()
	{
		return getPersistenceContext().getPropertyValue(BATCHSIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.concurrency</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the concurrency
	 */
	@Accessor(qualifier = "concurrency", type = Accessor.Type.GETTER)
	public Integer getConcurrency()
	{
		return getPersistenceContext().getPropertyValue(CONCURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.id</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.indexConfigurations</code> attribute defined at extension <code>searchservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the indexConfigurations
	 */
	@Accessor(qualifier = "indexConfigurations", type = Accessor.Type.GETTER)
	public List<SnIndexConfigurationModel> getIndexConfigurations()
	{
		return getPersistenceContext().getPropertyValue(INDEXCONFIGURATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.indexTypes</code> attribute defined at extension <code>searchservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the indexTypes
	 */
	@Accessor(qualifier = "indexTypes", type = Accessor.Type.GETTER)
	public List<SnIndexTypeModel> getIndexTypes()
	{
		return getPersistenceContext().getPropertyValue(INDEXTYPES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.name</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.name</code> attribute defined at extension <code>searchservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>SnIndexerConfiguration.retryConfiguration</code> attribute defined at extension <code>searchservices</code>. 
	 * @return the retryConfiguration
	 */
	@Accessor(qualifier = "retryConfiguration", type = Accessor.Type.GETTER)
	public SnRetryConfigurationModel getRetryConfiguration()
	{
		return getPersistenceContext().getPropertyValue(RETRYCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.batchSize</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the batchSize
	 */
	@Accessor(qualifier = "batchSize", type = Accessor.Type.SETTER)
	public void setBatchSize(final Integer value)
	{
		getPersistenceContext().setPropertyValue(BATCHSIZE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.concurrency</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the concurrency
	 */
	@Accessor(qualifier = "concurrency", type = Accessor.Type.SETTER)
	public void setConcurrency(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CONCURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.id</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.indexConfigurations</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the indexConfigurations
	 */
	@Accessor(qualifier = "indexConfigurations", type = Accessor.Type.SETTER)
	public void setIndexConfigurations(final List<SnIndexConfigurationModel> value)
	{
		getPersistenceContext().setPropertyValue(INDEXCONFIGURATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.indexTypes</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the indexTypes
	 */
	@Accessor(qualifier = "indexTypes", type = Accessor.Type.SETTER)
	public void setIndexTypes(final List<SnIndexTypeModel> value)
	{
		getPersistenceContext().setPropertyValue(INDEXTYPES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.name</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.name</code> attribute defined at extension <code>searchservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>SnIndexerConfiguration.retryConfiguration</code> attribute defined at extension <code>searchservices</code>. 
	 *  
	 * @param value the retryConfiguration
	 */
	@Accessor(qualifier = "retryConfiguration", type = Accessor.Type.SETTER)
	public void setRetryConfiguration(final SnRetryConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(RETRYCONFIGURATION, value);
	}
	
}

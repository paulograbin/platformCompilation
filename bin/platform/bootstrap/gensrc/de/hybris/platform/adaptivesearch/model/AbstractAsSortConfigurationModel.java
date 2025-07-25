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
import de.hybris.platform.adaptivesearch.model.AbstractAsItemConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AsSortExpressionModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type AbstractAsSortConfiguration first defined at extension adaptivesearch.
 */
@SuppressWarnings("all")
public class AbstractAsSortConfigurationModel extends AbstractAsItemConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractAsSortConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.code</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String PRIORITY = "priority";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.applyPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String APPLYPROMOTEDITEMS = "applyPromotedItems";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.highlightPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String HIGHLIGHTPROMOTEDITEMS = "highlightPromotedItems";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String UNIQUEIDX = "uniqueIdx";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractAsSortConfiguration.expressions</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String EXPRESSIONS = "expressions";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractAsSortConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractAsSortConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractAsSortConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractAsSortConfigurationModel(final String _code, final String _uid)
	{
		super();
		setCode(_code);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _code initial attribute declared by type <code>AbstractAsSortConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractAsSortConfigurationModel(final CatalogVersionModel _catalogVersion, final String _code, final ItemModel _owner, final String _uid)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setCode(_code);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.code</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.expressions</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the expressions
	 */
	@Accessor(qualifier = "expressions", type = Accessor.Type.GETTER)
	public List<AsSortExpressionModel> getExpressions()
	{
		return getPersistenceContext().getPropertyValue(EXPRESSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.GETTER)
	public Integer getPriority()
	{
		return getPersistenceContext().getPropertyValue(PRIORITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.GETTER)
	public String getUniqueIdx()
	{
		return getPersistenceContext().getPropertyValue(UNIQUEIDX);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.applyPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the applyPromotedItems
	 */
	@Accessor(qualifier = "applyPromotedItems", type = Accessor.Type.GETTER)
	public boolean isApplyPromotedItems()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(APPLYPROMOTEDITEMS));
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
	 * <i>Generated method</i> - Getter of the <code>AbstractAsSortConfiguration.highlightPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the highlightPromotedItems
	 */
	@Accessor(qualifier = "highlightPromotedItems", type = Accessor.Type.GETTER)
	public boolean isHighlightPromotedItems()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(HIGHLIGHTPROMOTEDITEMS));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.applyPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the applyPromotedItems
	 */
	@Accessor(qualifier = "applyPromotedItems", type = Accessor.Type.SETTER)
	public void setApplyPromotedItems(final boolean value)
	{
		getPersistenceContext().setPropertyValue(APPLYPROMOTEDITEMS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.code</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.expressions</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the expressions
	 */
	@Accessor(qualifier = "expressions", type = Accessor.Type.SETTER)
	public void setExpressions(final List<AsSortExpressionModel> value)
	{
		getPersistenceContext().setPropertyValue(EXPRESSIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.highlightPromotedItems</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the highlightPromotedItems
	 */
	@Accessor(qualifier = "highlightPromotedItems", type = Accessor.Type.SETTER)
	public void setHighlightPromotedItems(final boolean value)
	{
		getPersistenceContext().setPropertyValue(HIGHLIGHTPROMOTEDITEMS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.name</code> attribute defined at extension <code>adaptivesearch</code>. 
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
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.priority</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the priority
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.SETTER)
	public void setPriority(final Integer value)
	{
		getPersistenceContext().setPropertyValue(PRIORITY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractAsSortConfiguration.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.SETTER)
	public void setUniqueIdx(final String value)
	{
		getPersistenceContext().setPropertyValue(UNIQUEIDX, value);
	}
	
}

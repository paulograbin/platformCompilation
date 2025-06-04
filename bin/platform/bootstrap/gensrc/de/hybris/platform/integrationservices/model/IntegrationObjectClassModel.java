/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectClassAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type IntegrationObjectClass first defined at extension integrationservices.
 * <p>
 * Integration Object POJO type definition.
 */
@SuppressWarnings("all")
public class IntegrationObjectClassModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectClass";
	
	/**<i>Generated relation code constant for relation <code>IntegObj2IntegObjClass</code> defining source attribute <code>integrationObject</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJ2INTEGOBJCLASS = "IntegObj2IntegObjClass";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClass.code</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClass.root</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ROOT = "root";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClass.type</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClass.integrationObject</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECT = "integrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClass.attributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ATTRIBUTES = "attributes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectClassModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectClassModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 * @param _integrationObject initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectClassModel(final String _code, final IntegrationObjectModel _integrationObject, final Class _type)
	{
		super();
		setCode(_code);
		setIntegrationObject(_integrationObject);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 * @param _integrationObject initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _type initial attribute declared by type <code>IntegrationObjectClass</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectClassModel(final String _code, final IntegrationObjectModel _integrationObject, final ItemModel _owner, final Class _type)
	{
		super();
		setCode(_code);
		setIntegrationObject(_integrationObject);
		setOwner(_owner);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClass.attributes</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectClassAttributeModel> getAttributes()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClass.code</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClass.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObject
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.GETTER)
	public IntegrationObjectModel getIntegrationObject()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClass.root</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the root
	 */
	@Accessor(qualifier = "root", type = Accessor.Type.GETTER)
	public Boolean getRoot()
	{
		return getPersistenceContext().getPropertyValue(ROOT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClass.type</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public Class getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClass.attributes</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.SETTER)
	public void setAttributes(final Set<IntegrationObjectClassAttributeModel> value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClass.code</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClass.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObject
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.SETTER)
	public void setIntegrationObject(final IntegrationObjectModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClass.root</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the root
	 */
	@Accessor(qualifier = "root", type = Accessor.Type.SETTER)
	public void setRoot(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ROOT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClass.type</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final Class value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
}

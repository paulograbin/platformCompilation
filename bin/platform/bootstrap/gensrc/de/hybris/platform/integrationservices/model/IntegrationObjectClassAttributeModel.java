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
import de.hybris.platform.integrationservices.model.IntegrationObjectClassModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type IntegrationObjectClassAttribute first defined at extension integrationservices.
 * <p>
 * An Integration Object Class Attribute that uses standard POJO attributes.
 */
@SuppressWarnings("all")
public class IntegrationObjectClassAttributeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectClassAttribute";
	
	/**<i>Generated relation code constant for relation <code>IntegObjClas2IntegObjClassAttr</code> defining source attribute <code>integrationObjectClass</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJCLAS2INTEGOBJCLASSATTR = "IntegObjClas2IntegObjClassAttr";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClassAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ATTRIBUTENAME = "attributeName";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClassAttribute.readMethod</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String READMETHOD = "readMethod";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClassAttribute.returnIntegrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String RETURNINTEGRATIONOBJECTCLASS = "returnIntegrationObjectClass";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClassAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String UNIQUE = "unique";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectClassAttribute.integrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECTCLASS = "integrationObjectClass";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectClassAttributeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectClassAttributeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>IntegrationObjectClassAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectClass initial attribute declared by type <code>IntegrationObjectClassAttribute</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectClassAttributeModel(final String _attributeName, final IntegrationObjectClassModel _integrationObjectClass)
	{
		super();
		setAttributeName(_attributeName);
		setIntegrationObjectClass(_integrationObjectClass);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attributeName initial attribute declared by type <code>IntegrationObjectClassAttribute</code> at extension <code>integrationservices</code>
	 * @param _integrationObjectClass initial attribute declared by type <code>IntegrationObjectClassAttribute</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectClassAttributeModel(final String _attributeName, final IntegrationObjectClassModel _integrationObjectClass, final ItemModel _owner)
	{
		super();
		setAttributeName(_attributeName);
		setIntegrationObjectClass(_integrationObjectClass);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClassAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the attributeName
	 */
	@Accessor(qualifier = "attributeName", type = Accessor.Type.GETTER)
	public String getAttributeName()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClassAttribute.integrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObjectClass
	 */
	@Accessor(qualifier = "integrationObjectClass", type = Accessor.Type.GETTER)
	public IntegrationObjectClassModel getIntegrationObjectClass()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECTCLASS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClassAttribute.readMethod</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the readMethod - The method to call to read the value for the attribute
	 */
	@Accessor(qualifier = "readMethod", type = Accessor.Type.GETTER)
	public String getReadMethod()
	{
		return getPersistenceContext().getPropertyValue(READMETHOD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClassAttribute.returnIntegrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the returnIntegrationObjectClass - The IntegrationObjectClass to use when the type of the attribute is complex
	 */
	@Accessor(qualifier = "returnIntegrationObjectClass", type = Accessor.Type.GETTER)
	public IntegrationObjectClassModel getReturnIntegrationObjectClass()
	{
		return getPersistenceContext().getPropertyValue(RETURNINTEGRATIONOBJECTCLASS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectClassAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the unique - Determines whether this class attribute is a unique attribute for the IntegrationObjectClass,
	 *                         which makes it part of the key.
	 *                         Returns {@code true}, if the attribute is unique, and {@code false} if not.
	 */
	@Accessor(qualifier = "unique", type = Accessor.Type.GETTER)
	public Boolean getUnique()
	{
		return getPersistenceContext().getPropertyValue(UNIQUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClassAttribute.attributeName</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the attributeName
	 */
	@Accessor(qualifier = "attributeName", type = Accessor.Type.SETTER)
	public void setAttributeName(final String value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTENAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClassAttribute.integrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObjectClass
	 */
	@Accessor(qualifier = "integrationObjectClass", type = Accessor.Type.SETTER)
	public void setIntegrationObjectClass(final IntegrationObjectClassModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECTCLASS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClassAttribute.readMethod</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the readMethod - The method to call to read the value for the attribute
	 */
	@Accessor(qualifier = "readMethod", type = Accessor.Type.SETTER)
	public void setReadMethod(final String value)
	{
		getPersistenceContext().setPropertyValue(READMETHOD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClassAttribute.returnIntegrationObjectClass</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the returnIntegrationObjectClass - The IntegrationObjectClass to use when the type of the attribute is complex
	 */
	@Accessor(qualifier = "returnIntegrationObjectClass", type = Accessor.Type.SETTER)
	public void setReturnIntegrationObjectClass(final IntegrationObjectClassModel value)
	{
		getPersistenceContext().setPropertyValue(RETURNINTEGRATIONOBJECTCLASS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectClassAttribute.unique</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the unique - Determines whether this class attribute is a unique attribute for the IntegrationObjectClass,
	 *                         which makes it part of the key.
	 *                         Returns {@code true}, if the attribute is unique, and {@code false} if not.
	 */
	@Accessor(qualifier = "unique", type = Accessor.Type.SETTER)
	public void setUnique(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(UNIQUE, value);
	}
	
}

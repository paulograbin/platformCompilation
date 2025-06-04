/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:27:36 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectClassModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.odata2webservices.enums.IntegrationType;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type IntegrationObject first defined at extension integrationservices.
 */
@SuppressWarnings("all")
public class IntegrationObjectModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.code</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.rootItem</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ROOTITEM = "rootItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.rootClass</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ROOTCLASS = "rootClass";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.classificationAttributesPresent</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CLASSIFICATIONATTRIBUTESPRESENT = "classificationAttributesPresent";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.items</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ITEMS = "items";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.classes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CLASSES = "classes";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObject.integrationType</code> attribute defined at extension <code>odata2webservices</code>. */
	public static final String INTEGRATIONTYPE = "integrationType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObject</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObject</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.classes</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the classes
	 */
	@Accessor(qualifier = "classes", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectClassModel> getClasses()
	{
		return getPersistenceContext().getPropertyValue(CLASSES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.classificationAttributesPresent</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * @return the classificationAttributesPresent - Determines whether this integration object has items with {@link
	 *                         IntegrationObjectItemClassificationAttributeModel}.
	 *                         Returns {@code true}, if at least one {@link IntegrationObjectItemModel} in this integration
	 *                         object contains
	 *                         at least one {@link IntegrationObjectItemClassificationAttributeModel} attribute; {@code false},
	 *                         if there
	 *                         no {@link IntegrationObjectItemClassificationAttributeModel} within this integration object
	 *                         structure.
	 */
	@Accessor(qualifier = "classificationAttributesPresent", type = Accessor.Type.GETTER)
	public Boolean getClassificationAttributesPresent()
	{
		return getPersistenceContext().getDynamicValue(this,CLASSIFICATIONATTRIBUTESPRESENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.code</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.integrationType</code> attribute defined at extension <code>odata2webservices</code>. 
	 * @return the integrationType - Qualifier for the type of Integration related to an IntegrationObject
	 */
	@Accessor(qualifier = "integrationType", type = Accessor.Type.GETTER)
	public IntegrationType getIntegrationType()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.items</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the items
	 */
	@Accessor(qualifier = "items", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectItemModel> getItems()
	{
		return getPersistenceContext().getPropertyValue(ITEMS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.rootClass</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * @return the rootClass - Identifies the root {@code IntegrationObjectClass} for this {@code IntegrationObject}. There
	 *                         should only be one root {@code IntegrationObjectClass} for any {@code IntegrationObject}.
	 *                         If the IntegrationObject was misconfiguration where the IntegrationObject is found to have
	 *                         more than 1 root {@code IntegrationObjectClass} then an exception will be thrown.
	 */
	@Accessor(qualifier = "rootClass", type = Accessor.Type.GETTER)
	public IntegrationObjectClassModel getRootClass()
	{
		return getPersistenceContext().getDynamicValue(this,ROOTCLASS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObject.rootItem</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * @return the rootItem - Identifies the root {@code IntegrationObjectItem} for this {@code IntegrationObject}. There
	 *                         should only be
	 *                         one root {@code IntegrationObjectItem} for any {@code IntegrationObject}. If the
	 *                         IntegrationObject was
	 *                         misconfiguration where the IntegrationObject is found to have more than 1 root {@code
	 *                         IntegrationObjectItem}
	 *                         then an exception will be thrown.
	 */
	@Accessor(qualifier = "rootItem", type = Accessor.Type.GETTER)
	public IntegrationObjectItemModel getRootItem()
	{
		return getPersistenceContext().getDynamicValue(this,ROOTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObject.classes</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the classes
	 */
	@Accessor(qualifier = "classes", type = Accessor.Type.SETTER)
	public void setClasses(final Set<IntegrationObjectClassModel> value)
	{
		getPersistenceContext().setPropertyValue(CLASSES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObject.code</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObject.integrationType</code> attribute defined at extension <code>odata2webservices</code>. 
	 *  
	 * @param value the integrationType - Qualifier for the type of Integration related to an IntegrationObject
	 */
	@Accessor(qualifier = "integrationType", type = Accessor.Type.SETTER)
	public void setIntegrationType(final IntegrationType value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObject.items</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the items
	 */
	@Accessor(qualifier = "items", type = Accessor.Type.SETTER)
	public void setItems(final Set<IntegrationObjectItemModel> value)
	{
		getPersistenceContext().setPropertyValue(ITEMS, value);
	}
	
}

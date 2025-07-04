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
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.integrationservices.enums.ItemTypeMatchEnum;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemClassificationAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemVirtualAttributeModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Set;

/**
 * Generated model class for type IntegrationObjectItem first defined at extension integrationservices.
 */
@SuppressWarnings("all")
public class IntegrationObjectItemModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "IntegrationObjectItem";
	
	/**<i>Generated relation code constant for relation <code>IntegObj2IntegObjItem</code> defining source attribute <code>integrationObject</code> in extension <code>integrationservices</code>.</i>*/
	public static final String _INTEGOBJ2INTEGOBJITEM = "IntegObj2IntegObjItem";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.code</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.type</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.root</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ROOT = "root";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.itemTypeMatch</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ITEMTYPEMATCH = "itemTypeMatch";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.uniqueAttributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String UNIQUEATTRIBUTES = "uniqueAttributes";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.allowedItemTypeMatches</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ALLOWEDITEMTYPEMATCHES = "allowedItemTypeMatches";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.keyAttributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String KEYATTRIBUTES = "keyAttributes";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.integrationObject</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECT = "integrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.attributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String ATTRIBUTES = "attributes";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.classificationAttributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String CLASSIFICATIONATTRIBUTES = "classificationAttributes";
	
	/** <i>Generated constant</i> - Attribute key of <code>IntegrationObjectItem.virtualAttributes</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String VIRTUALATTRIBUTES = "virtualAttributes";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public IntegrationObjectItemModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public IntegrationObjectItemModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 * @param _integrationObject initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemModel(final String _code, final IntegrationObjectModel _integrationObject, final ComposedTypeModel _type)
	{
		super();
		setCode(_code);
		setIntegrationObject(_integrationObject);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 * @param _integrationObject initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _type initial attribute declared by type <code>IntegrationObjectItem</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public IntegrationObjectItemModel(final String _code, final IntegrationObjectModel _integrationObject, final ItemModel _owner, final ComposedTypeModel _type)
	{
		super();
		setCode(_code);
		setIntegrationObject(_integrationObject);
		setOwner(_owner);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.allowedItemTypeMatches</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the allowedItemTypeMatches - a collection of all ItemTypeMatchEnums that an IntegrationObjectItem of the current {@type} may
	 *                         have set on its {@itemTypeMatch} attribute.
	 */
	@Accessor(qualifier = "allowedItemTypeMatches", type = Accessor.Type.GETTER)
	public Collection<ItemTypeMatchEnum> getAllowedItemTypeMatches()
	{
		return getPersistenceContext().getDynamicValue(this,ALLOWEDITEMTYPEMATCHES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.attributes</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectItemAttributeModel> getAttributes()
	{
		return getPersistenceContext().getPropertyValue(ATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.classificationAttributes</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the classificationAttributes
	 */
	@Accessor(qualifier = "classificationAttributes", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectItemClassificationAttributeModel> getClassificationAttributes()
	{
		return getPersistenceContext().getPropertyValue(CLASSIFICATIONATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.code</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObject
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.GETTER)
	public IntegrationObjectModel getIntegrationObject()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.itemTypeMatch</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the itemTypeMatch
	 */
	@Accessor(qualifier = "itemTypeMatch", type = Accessor.Type.GETTER)
	public ItemTypeMatchEnum getItemTypeMatch()
	{
		return getPersistenceContext().getPropertyValue(ITEMTYPEMATCH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.keyAttributes</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the keyAttributes - a collection of all attributes with unique modifier set to {@code true} in this item type only.
	 *                         The collection does not contain attributes of the referenced types even if they are included in
	 *                         this item's
	 *                         key. For example, for a {@code Product} this collection will contain the 'code' attribute and
	 *                         the 'catalogVersion' attribute, which refers to {@code CatalogVersion} only.
	 */
	@Accessor(qualifier = "keyAttributes", type = Accessor.Type.GETTER)
	public Collection<IntegrationObjectItemAttributeModel> getKeyAttributes()
	{
		return getPersistenceContext().getDynamicValue(this,KEYATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.root</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the root
	 */
	@Accessor(qualifier = "root", type = Accessor.Type.GETTER)
	public Boolean getRoot()
	{
		return getPersistenceContext().getPropertyValue(ROOT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.type</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public ComposedTypeModel getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.uniqueAttributes</code> dynamic attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the uniqueAttributes - a collection of all attributes with unique modifier set to {@code true}, which define a
	 *                         composite key for this item. The collection contains only attributes of primitive types: if a
	 *                         relation attribute
	 *                         is set to 'unique', then key attributes of the referred type will be returned instead of the
	 *                         reference key
	 *                         attribute, e.g. unique key for a {@code Product} is the 'code' attribute and
	 *                         the 'catalogVersion' attribute, which refers to {@code CatalogVersion}; {@code CatalogVersion}
	 *                         in its turn has a unique attribute {@code version} and a unique reference attribute to {@code
	 *                         Catalog}. So,
	 *                         the result of calling the method will contain {@code Product.code}, {@code
	 *                         CatalogVersion.version}, and
	 *                         {@code Catalog.id} attribute models.
	 */
	@Accessor(qualifier = "uniqueAttributes", type = Accessor.Type.GETTER)
	public Collection<IntegrationObjectItemAttributeModel> getUniqueAttributes()
	{
		return getPersistenceContext().getDynamicValue(this,UNIQUEATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.virtualAttributes</code> attribute defined at extension <code>integrationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the virtualAttributes
	 */
	@Accessor(qualifier = "virtualAttributes", type = Accessor.Type.GETTER)
	public Set<IntegrationObjectItemVirtualAttributeModel> getVirtualAttributes()
	{
		return getPersistenceContext().getPropertyValue(VIRTUALATTRIBUTES);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.attributes</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the attributes
	 */
	@Accessor(qualifier = "attributes", type = Accessor.Type.SETTER)
	public void setAttributes(final Set<IntegrationObjectItemAttributeModel> value)
	{
		getPersistenceContext().setPropertyValue(ATTRIBUTES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.classificationAttributes</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the classificationAttributes
	 */
	@Accessor(qualifier = "classificationAttributes", type = Accessor.Type.SETTER)
	public void setClassificationAttributes(final Set<IntegrationObjectItemClassificationAttributeModel> value)
	{
		getPersistenceContext().setPropertyValue(CLASSIFICATIONATTRIBUTES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.code</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObject
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.SETTER)
	public void setIntegrationObject(final IntegrationObjectModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.itemTypeMatch</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the itemTypeMatch
	 */
	@Accessor(qualifier = "itemTypeMatch", type = Accessor.Type.SETTER)
	public void setItemTypeMatch(final ItemTypeMatchEnum value)
	{
		getPersistenceContext().setPropertyValue(ITEMTYPEMATCH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.root</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the root
	 */
	@Accessor(qualifier = "root", type = Accessor.Type.SETTER)
	public void setRoot(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ROOT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.type</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final ComposedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>IntegrationObjectItem.virtualAttributes</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the virtualAttributes
	 */
	@Accessor(qualifier = "virtualAttributes", type = Accessor.Type.SETTER)
	public void setVirtualAttributes(final Set<IntegrationObjectItemVirtualAttributeModel> value)
	{
		getPersistenceContext().setPropertyValue(VIRTUALATTRIBUTES, value);
	}
	
}

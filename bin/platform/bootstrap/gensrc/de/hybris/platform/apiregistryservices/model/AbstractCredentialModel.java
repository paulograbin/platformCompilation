/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.apiregistryservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AbstractCredential first defined at extension apiregistryservices.
 * <p>
 * Abstract Webservice Credential.
 */
@SuppressWarnings("all")
public class AbstractCredentialModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractCredential";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractCredential.id</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String ID = "id";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractCredentialModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractCredentialModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>AbstractCredential</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractCredentialModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>AbstractCredential</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public AbstractCredentialModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCredential.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the id - Unique Id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.GETTER)
	public String getId()
	{
		return getPersistenceContext().getPropertyValue(ID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractCredential.id</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the id - Unique Id
	 */
	@Accessor(qualifier = "id", type = Accessor.Type.SETTER)
	public void setId(final String value)
	{
		getPersistenceContext().setPropertyValue(ID, value);
	}
	
}

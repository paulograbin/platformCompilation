/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ticketsystem.events.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.ticketsystem.events.model.SessionEventModel;

/**
 * Generated model class for type SessionEndEvent first defined at extension ticketsystem.
 */
@SuppressWarnings("all")
public class SessionEndEventModel extends SessionEventModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SessionEndEvent";
	
	/** <i>Generated constant</i> - Attribute key of <code>SessionEndEvent.customer</code> attribute defined at extension <code>ticketsystem</code>. */
	public static final String CUSTOMER = "customer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SessionEndEventModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SessionEndEventModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SessionEndEventModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SessionEndEvent.customer</code> attribute defined at extension <code>ticketsystem</code>. 
	 * @return the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.GETTER)
	public UserModel getCustomer()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SessionEndEvent.customer</code> attribute defined at extension <code>ticketsystem</code>. 
	 *  
	 * @param value the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.SETTER)
	public void setCustomer(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMER, value);
	}
	
}

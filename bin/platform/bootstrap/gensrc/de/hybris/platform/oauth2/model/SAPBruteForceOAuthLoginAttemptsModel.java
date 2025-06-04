/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:27:36 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.oauth2.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type SAPBruteForceOAuthLoginAttempts first defined at extension oauth2.
 */
@SuppressWarnings("all")
public class SAPBruteForceOAuthLoginAttemptsModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SAPBruteForceOAuthLoginAttempts";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPBruteForceOAuthLoginAttempts.clientId</code> attribute defined at extension <code>oauth2</code>. */
	public static final String CLIENTID = "clientId";
	
	/** <i>Generated constant</i> - Attribute key of <code>SAPBruteForceOAuthLoginAttempts.attempts</code> attribute defined at extension <code>oauth2</code>. */
	public static final String ATTEMPTS = "attempts";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SAPBruteForceOAuthLoginAttemptsModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SAPBruteForceOAuthLoginAttemptsModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attempts initial attribute declared by type <code>SAPBruteForceOAuthLoginAttempts</code> at extension <code>oauth2</code>
	 * @param _clientId initial attribute declared by type <code>SAPBruteForceOAuthLoginAttempts</code> at extension <code>oauth2</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPBruteForceOAuthLoginAttemptsModel(final Integer _attempts, final String _clientId)
	{
		super();
		setAttempts(_attempts);
		setClientId(_clientId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _attempts initial attribute declared by type <code>SAPBruteForceOAuthLoginAttempts</code> at extension <code>oauth2</code>
	 * @param _clientId initial attribute declared by type <code>SAPBruteForceOAuthLoginAttempts</code> at extension <code>oauth2</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public SAPBruteForceOAuthLoginAttemptsModel(final Integer _attempts, final String _clientId, final ItemModel _owner)
	{
		super();
		setAttempts(_attempts);
		setClientId(_clientId);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPBruteForceOAuthLoginAttempts.attempts</code> attribute defined at extension <code>oauth2</code>. 
	 * @return the attempts
	 */
	@Accessor(qualifier = "attempts", type = Accessor.Type.GETTER)
	public Integer getAttempts()
	{
		return getPersistenceContext().getPropertyValue(ATTEMPTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SAPBruteForceOAuthLoginAttempts.clientId</code> attribute defined at extension <code>oauth2</code>. 
	 * @return the clientId - OAuth client identifier
	 */
	@Accessor(qualifier = "clientId", type = Accessor.Type.GETTER)
	public String getClientId()
	{
		return getPersistenceContext().getPropertyValue(CLIENTID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SAPBruteForceOAuthLoginAttempts.attempts</code> attribute defined at extension <code>oauth2</code>. 
	 *  
	 * @param value the attempts
	 */
	@Accessor(qualifier = "attempts", type = Accessor.Type.SETTER)
	public void setAttempts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ATTEMPTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SAPBruteForceOAuthLoginAttempts.clientId</code> attribute defined at extension <code>oauth2</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the clientId - OAuth client identifier
	 */
	@Accessor(qualifier = "clientId", type = Accessor.Type.SETTER)
	public void setClientId(final String value)
	{
		getPersistenceContext().setPropertyValue(CLIENTID, value);
	}
	
}

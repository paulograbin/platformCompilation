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
import de.hybris.platform.apiregistryservices.model.AbstractCredentialModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ConsumedOAuthCredential first defined at extension apiregistryservices.
 * <p>
 * OAuth credentials for external webservice.
 */
@SuppressWarnings("all")
public class ConsumedOAuthCredentialModel extends AbstractCredentialModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ConsumedOAuthCredential";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConsumedOAuthCredential.clientId</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String CLIENTID = "clientId";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConsumedOAuthCredential.oAuthUrl</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String OAUTHURL = "oAuthUrl";
	
	/** <i>Generated constant</i> - Attribute key of <code>ConsumedOAuthCredential.clientSecret</code> attribute defined at extension <code>apiregistryservices</code>. */
	public static final String CLIENTSECRET = "clientSecret";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConsumedOAuthCredentialModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConsumedOAuthCredentialModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _clientId initial attribute declared by type <code>ConsumedOAuthCredential</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractCredential</code> at extension <code>apiregistryservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConsumedOAuthCredentialModel(final String _clientId, final String _id)
	{
		super();
		setClientId(_clientId);
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _clientId initial attribute declared by type <code>ConsumedOAuthCredential</code> at extension <code>apiregistryservices</code>
	 * @param _id initial attribute declared by type <code>AbstractCredential</code> at extension <code>apiregistryservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConsumedOAuthCredentialModel(final String _clientId, final String _id, final ItemModel _owner)
	{
		super();
		setClientId(_clientId);
		setId(_id);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConsumedOAuthCredential.clientId</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the clientId - OAuth Client Id
	 */
	@Accessor(qualifier = "clientId", type = Accessor.Type.GETTER)
	public String getClientId()
	{
		return getPersistenceContext().getPropertyValue(CLIENTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConsumedOAuthCredential.clientSecret</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the clientSecret - OAuth Client Secret
	 */
	@Accessor(qualifier = "clientSecret", type = Accessor.Type.GETTER)
	public String getClientSecret()
	{
		return getPersistenceContext().getPropertyValue(CLIENTSECRET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ConsumedOAuthCredential.oAuthUrl</code> attribute defined at extension <code>apiregistryservices</code>. 
	 * @return the oAuthUrl - OAuth URL
	 */
	@Accessor(qualifier = "oAuthUrl", type = Accessor.Type.GETTER)
	public String getOAuthUrl()
	{
		return getPersistenceContext().getPropertyValue(OAUTHURL);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConsumedOAuthCredential.clientId</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the clientId - OAuth Client Id
	 */
	@Accessor(qualifier = "clientId", type = Accessor.Type.SETTER)
	public void setClientId(final String value)
	{
		getPersistenceContext().setPropertyValue(CLIENTID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConsumedOAuthCredential.clientSecret</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the clientSecret - OAuth Client Secret
	 */
	@Accessor(qualifier = "clientSecret", type = Accessor.Type.SETTER)
	public void setClientSecret(final String value)
	{
		getPersistenceContext().setPropertyValue(CLIENTSECRET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ConsumedOAuthCredential.oAuthUrl</code> attribute defined at extension <code>apiregistryservices</code>. 
	 *  
	 * @param value the oAuthUrl - OAuth URL
	 */
	@Accessor(qualifier = "oAuthUrl", type = Accessor.Type.SETTER)
	public void setOAuthUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(OAUTHURL, value);
	}
	
}

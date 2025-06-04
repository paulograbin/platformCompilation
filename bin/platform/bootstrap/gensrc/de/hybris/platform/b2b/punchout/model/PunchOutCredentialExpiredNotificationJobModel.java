/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 12, 2025, 10:11:41 AM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type PunchOutCredentialExpiredNotificationJob first defined at extension b2bpunchout.
 */
@SuppressWarnings("all")
public class PunchOutCredentialExpiredNotificationJobModel extends ServicelayerJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PunchOutCredentialExpiredNotificationJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>PunchOutCredentialExpiredNotificationJob.emailToAddress</code> attribute defined at extension <code>b2bpunchout</code>. */
	public static final String EMAILTOADDRESS = "emailToAddress";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PunchOutCredentialExpiredNotificationJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PunchOutCredentialExpiredNotificationJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _emailToAddress initial attribute declared by type <code>PunchOutCredentialExpiredNotificationJob</code> at extension <code>b2bpunchout</code>
	 * @param _springId initial attribute declared by type <code>ServicelayerJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PunchOutCredentialExpiredNotificationJobModel(final String _code, final String _emailToAddress, final String _springId)
	{
		super();
		setCode(_code);
		setEmailToAddress(_emailToAddress);
		setSpringId(_springId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _emailToAddress initial attribute declared by type <code>PunchOutCredentialExpiredNotificationJob</code> at extension <code>b2bpunchout</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _springId initial attribute declared by type <code>ServicelayerJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public PunchOutCredentialExpiredNotificationJobModel(final String _code, final String _emailToAddress, final Integer _nodeID, final ItemModel _owner, final String _springId)
	{
		super();
		setCode(_code);
		setEmailToAddress(_emailToAddress);
		setNodeID(_nodeID);
		setOwner(_owner);
		setSpringId(_springId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PunchOutCredentialExpiredNotificationJob.emailToAddress</code> attribute defined at extension <code>b2bpunchout</code>. 
	 * @return the emailToAddress
	 */
	@Accessor(qualifier = "emailToAddress", type = Accessor.Type.GETTER)
	public String getEmailToAddress()
	{
		return getPersistenceContext().getPropertyValue(EMAILTOADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>PunchOutCredentialExpiredNotificationJob.emailToAddress</code> attribute defined at extension <code>b2bpunchout</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the emailToAddress
	 */
	@Accessor(qualifier = "emailToAddress", type = Accessor.Type.SETTER)
	public void setEmailToAddress(final String value)
	{
		getPersistenceContext().setPropertyValue(EMAILTOADDRESS, value);
	}
	
}

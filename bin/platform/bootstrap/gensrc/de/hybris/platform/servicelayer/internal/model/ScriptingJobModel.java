/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.internal.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ScriptingJob first defined at extension processing.
 */
@SuppressWarnings("all")
public class ScriptingJobModel extends ServicelayerJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ScriptingJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>ScriptingJob.scriptURI</code> attribute defined at extension <code>processing</code>. */
	public static final String SCRIPTURI = "scriptURI";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ScriptingJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ScriptingJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _scriptURI initial attribute declared by type <code>ScriptingJob</code> at extension <code>processing</code>
	 * @param _springId initial attribute declared by type <code>ScriptingJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ScriptingJobModel(final String _code, final String _scriptURI, final String _springId)
	{
		super();
		setCode(_code);
		setScriptURI(_scriptURI);
		setSpringId(_springId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _scriptURI initial attribute declared by type <code>ScriptingJob</code> at extension <code>processing</code>
	 * @param _springId initial attribute declared by type <code>ScriptingJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ScriptingJobModel(final String _code, final Integer _nodeID, final ItemModel _owner, final String _scriptURI, final String _springId)
	{
		super();
		setCode(_code);
		setNodeID(_nodeID);
		setOwner(_owner);
		setScriptURI(_scriptURI);
		setSpringId(_springId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ScriptingJob.scriptURI</code> attribute defined at extension <code>processing</code>. 
	 * @return the scriptURI
	 */
	@Accessor(qualifier = "scriptURI", type = Accessor.Type.GETTER)
	public String getScriptURI()
	{
		return getPersistenceContext().getPropertyValue(SCRIPTURI);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ScriptingJob.scriptURI</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the scriptURI
	 */
	@Accessor(qualifier = "scriptURI", type = Accessor.Type.SETTER)
	public void setScriptURI(final String value)
	{
		getPersistenceContext().setPropertyValue(SCRIPTURI, value);
	}
	
}

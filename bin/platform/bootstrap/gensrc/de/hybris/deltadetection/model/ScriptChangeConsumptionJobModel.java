/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.deltadetection.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.deltadetection.model.AbstractChangeProcessorJobModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ScriptChangeConsumptionJob first defined at extension deltadetection.
 */
@SuppressWarnings("all")
public class ScriptChangeConsumptionJobModel extends AbstractChangeProcessorJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ScriptChangeConsumptionJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>ScriptChangeConsumptionJob.scriptURI</code> attribute defined at extension <code>deltadetection</code>. */
	public static final String SCRIPTURI = "scriptURI";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ScriptChangeConsumptionJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ScriptChangeConsumptionJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _input initial attribute declared by type <code>AbstractChangeProcessorJob</code> at extension <code>deltadetection</code>
	 * @param _scriptURI initial attribute declared by type <code>ScriptChangeConsumptionJob</code> at extension <code>deltadetection</code>
	 * @param _springId initial attribute declared by type <code>ScriptChangeConsumptionJob</code> at extension <code>deltadetection</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ScriptChangeConsumptionJobModel(final String _code, final MediaModel _input, final String _scriptURI, final String _springId)
	{
		super();
		setCode(_code);
		setInput(_input);
		setScriptURI(_scriptURI);
		setSpringId(_springId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _input initial attribute declared by type <code>AbstractChangeProcessorJob</code> at extension <code>deltadetection</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _scriptURI initial attribute declared by type <code>ScriptChangeConsumptionJob</code> at extension <code>deltadetection</code>
	 * @param _springId initial attribute declared by type <code>ScriptChangeConsumptionJob</code> at extension <code>deltadetection</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ScriptChangeConsumptionJobModel(final String _code, final MediaModel _input, final Integer _nodeID, final ItemModel _owner, final String _scriptURI, final String _springId)
	{
		super();
		setCode(_code);
		setInput(_input);
		setNodeID(_nodeID);
		setOwner(_owner);
		setScriptURI(_scriptURI);
		setSpringId(_springId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ScriptChangeConsumptionJob.scriptURI</code> attribute defined at extension <code>deltadetection</code>. 
	 * @return the scriptURI
	 */
	@Accessor(qualifier = "scriptURI", type = Accessor.Type.GETTER)
	public String getScriptURI()
	{
		return getPersistenceContext().getPropertyValue(SCRIPTURI);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ScriptChangeConsumptionJob.scriptURI</code> attribute defined at extension <code>deltadetection</code>. 
	 *  
	 * @param value the scriptURI
	 */
	@Accessor(qualifier = "scriptURI", type = Accessor.Type.SETTER)
	public void setScriptURI(final String value)
	{
		getPersistenceContext().setPropertyValue(SCRIPTURI, value);
	}
	
}

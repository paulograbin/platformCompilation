/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 4, 2025, 12:41:22 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cronjob.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.cronjob.model.StepModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type BatchJob first defined at extension processing.
 */
@SuppressWarnings("all")
public class BatchJobModel extends JobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "BatchJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>BatchJob.steps</code> attribute defined at extension <code>processing</code>. */
	public static final String STEPS = "steps";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public BatchJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public BatchJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BatchJobModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public BatchJobModel(final String _code, final Integer _nodeID, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setNodeID(_nodeID);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BatchJob.steps</code> attribute defined at extension <code>processing</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the steps
	 */
	@Accessor(qualifier = "steps", type = Accessor.Type.GETTER)
	public List<StepModel> getSteps()
	{
		return getPersistenceContext().getPropertyValue(STEPS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>BatchJob.steps</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the steps
	 */
	@Accessor(qualifier = "steps", type = Accessor.Type.SETTER)
	public void setSteps(final List<StepModel> value)
	{
		getPersistenceContext().setPropertyValue(STEPS, value);
	}
	
}

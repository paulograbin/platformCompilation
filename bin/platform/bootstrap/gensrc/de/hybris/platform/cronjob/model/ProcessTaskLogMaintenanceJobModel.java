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
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type ProcessTaskLogMaintenanceJob first defined at extension processing.
 */
@SuppressWarnings("all")
public class ProcessTaskLogMaintenanceJobModel extends ServicelayerJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProcessTaskLogMaintenanceJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProcessTaskLogMaintenanceJob.age</code> attribute defined at extension <code>processing</code>. */
	public static final String AGE = "age";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProcessTaskLogMaintenanceJob.numberOfLogs</code> attribute defined at extension <code>processing</code>. */
	public static final String NUMBEROFLOGS = "numberOfLogs";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProcessTaskLogMaintenanceJob.queryCount</code> attribute defined at extension <code>processing</code>. */
	public static final String QUERYCOUNT = "queryCount";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProcessTaskLogMaintenanceJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProcessTaskLogMaintenanceJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _age initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _numberOfLogs initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 * @param _springId initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProcessTaskLogMaintenanceJobModel(final int _age, final String _code, final int _numberOfLogs, final String _springId)
	{
		super();
		setAge(_age);
		setCode(_code);
		setNumberOfLogs(_numberOfLogs);
		setSpringId(_springId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _age initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _numberOfLogs initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _springId initial attribute declared by type <code>ProcessTaskLogMaintenanceJob</code> at extension <code>processing</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ProcessTaskLogMaintenanceJobModel(final int _age, final String _code, final Integer _nodeID, final int _numberOfLogs, final ItemModel _owner, final String _springId)
	{
		super();
		setAge(_age);
		setCode(_code);
		setNodeID(_nodeID);
		setNumberOfLogs(_numberOfLogs);
		setOwner(_owner);
		setSpringId(_springId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProcessTaskLogMaintenanceJob.age</code> attribute defined at extension <code>processing</code>. 
	 * @return the age
	 */
	@Accessor(qualifier = "age", type = Accessor.Type.GETTER)
	public int getAge()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(AGE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProcessTaskLogMaintenanceJob.numberOfLogs</code> attribute defined at extension <code>processing</code>. 
	 * @return the numberOfLogs
	 */
	@Accessor(qualifier = "numberOfLogs", type = Accessor.Type.GETTER)
	public int getNumberOfLogs()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(NUMBEROFLOGS));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProcessTaskLogMaintenanceJob.queryCount</code> attribute defined at extension <code>processing</code>. 
	 * @return the queryCount - Maximum number of items that can be retrieved form DB and thus removed
	 */
	@Accessor(qualifier = "queryCount", type = Accessor.Type.GETTER)
	public int getQueryCount()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(QUERYCOUNT));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProcessTaskLogMaintenanceJob.age</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the age
	 */
	@Accessor(qualifier = "age", type = Accessor.Type.SETTER)
	public void setAge(final int value)
	{
		getPersistenceContext().setPropertyValue(AGE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProcessTaskLogMaintenanceJob.numberOfLogs</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the numberOfLogs
	 */
	@Accessor(qualifier = "numberOfLogs", type = Accessor.Type.SETTER)
	public void setNumberOfLogs(final int value)
	{
		getPersistenceContext().setPropertyValue(NUMBEROFLOGS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProcessTaskLogMaintenanceJob.queryCount</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the queryCount - Maximum number of items that can be retrieved form DB and thus removed
	 */
	@Accessor(qualifier = "queryCount", type = Accessor.Type.SETTER)
	public void setQueryCount(final int value)
	{
		getPersistenceContext().setPropertyValue(QUERYCOUNT, toObject(value));
	}
	
}

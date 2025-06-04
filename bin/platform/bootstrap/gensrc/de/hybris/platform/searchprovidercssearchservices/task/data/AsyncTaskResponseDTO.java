/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.task.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.task.data.TaskDTO;


import java.util.Objects;
public  class AsyncTaskResponseDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsyncTaskResponseDTO.task</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private TaskDTO task;
	
	public AsyncTaskResponseDTO()
	{
		// default constructor
	}
	
	public void setTask(final TaskDTO task)
	{
		this.task = task;
	}

	public TaskDTO getTask() 
	{
		return task;
	}
	

}
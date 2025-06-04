/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.indexer.data;

import de.hybris.platform.searchprovidercssearchservices.index.data.AbstractIndexStateResponseDTO;
import de.hybris.platform.searchprovidercssearchservices.task.data.TaskDTO;


import java.util.Objects;
public  class TaskIndexStateResponseDTO extends AbstractIndexStateResponseDTO 

{



	/** <i>Generated property</i> for <code>TaskIndexStateResponseDTO.task</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private TaskDTO task;
	
	public TaskIndexStateResponseDTO()
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
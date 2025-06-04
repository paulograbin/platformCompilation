/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.task.data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonRawValue;
import de.hybris.platform.searchprovidercssearchservices.task.data.TaskStatusDTO;


import java.util.Objects;
public  class TaskDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TaskDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>TaskDTO.status</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private TaskStatusDTO status;

	/** <i>Generated property</i> for <code>TaskDTO.taskType</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String taskType;

	/** <i>Generated property</i> for <code>TaskDTO.data</code> property defined at extension <code>searchprovidercssearchservices</code>. */
@JsonRawValue 	
	private String data;
	
	public TaskDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setStatus(final TaskStatusDTO status)
	{
		this.status = status;
	}

	public TaskStatusDTO getStatus() 
	{
		return status;
	}
	
	public void setTaskType(final String taskType)
	{
		this.taskType = taskType;
	}

	public String getTaskType() 
	{
		return taskType;
	}
	
@JsonRawValue 	public void setData(final String data)
	{
		this.data = data;
	}

@JsonRawValue 	public String getData() 
	{
		return data;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final TaskDTO other = (TaskDTO) o;
		return Objects.equals(getStatus(), other.getStatus())

			&& Objects.equals(getTaskType(), other.getTaskType())

			&& Objects.equals(getData(), other.getData());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = status;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = taskType;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = data;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}
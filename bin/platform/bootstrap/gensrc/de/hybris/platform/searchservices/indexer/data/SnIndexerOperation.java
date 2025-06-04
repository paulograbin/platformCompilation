/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:39 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.indexer.data;

import java.io.Serializable;
import de.hybris.platform.searchservices.enums.SnIndexerOperationStatus;
import de.hybris.platform.searchservices.enums.SnIndexerOperationType;


import java.util.Objects;
public  class SnIndexerOperation  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SnIndexerOperation.id</code> property defined at extension <code>searchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SnIndexerOperation.indexTypeId</code> property defined at extension <code>searchservices</code>. */
	
	private String indexTypeId;

	/** <i>Generated property</i> for <code>SnIndexerOperation.indexId</code> property defined at extension <code>searchservices</code>. */
	
	private String indexId;

	/** <i>Generated property</i> for <code>SnIndexerOperation.operationType</code> property defined at extension <code>searchservices</code>. */
	
	private SnIndexerOperationType operationType;

	/** <i>Generated property</i> for <code>SnIndexerOperation.status</code> property defined at extension <code>searchservices</code>. */
	
	private SnIndexerOperationStatus status;

	/** <i>Generated property</i> for <code>SnIndexerOperation.totalItems</code> property defined at extension <code>searchservices</code>. */
	
	private Integer totalItems;

	/** <i>Generated property</i> for <code>SnIndexerOperation.processedItems</code> property defined at extension <code>searchservices</code>. */
	
	private Integer processedItems;
	
	public SnIndexerOperation()
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
	
	public void setIndexTypeId(final String indexTypeId)
	{
		this.indexTypeId = indexTypeId;
	}

	public String getIndexTypeId() 
	{
		return indexTypeId;
	}
	
	public void setIndexId(final String indexId)
	{
		this.indexId = indexId;
	}

	public String getIndexId() 
	{
		return indexId;
	}
	
	public void setOperationType(final SnIndexerOperationType operationType)
	{
		this.operationType = operationType;
	}

	public SnIndexerOperationType getOperationType() 
	{
		return operationType;
	}
	
	public void setStatus(final SnIndexerOperationStatus status)
	{
		this.status = status;
	}

	public SnIndexerOperationStatus getStatus() 
	{
		return status;
	}
	
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}

	public Integer getTotalItems() 
	{
		return totalItems;
	}
	
	public void setProcessedItems(final Integer processedItems)
	{
		this.processedItems = processedItems;
	}

	public Integer getProcessedItems() 
	{
		return processedItems;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SnIndexerOperation other = (SnIndexerOperation) o;
		return Objects.equals(getId(), other.getId())

			&& Objects.equals(getIndexTypeId(), other.getIndexTypeId())

			&& Objects.equals(getIndexId(), other.getIndexId())

			&& Objects.equals(getOperationType(), other.getOperationType())

			&& Objects.equals(getStatus(), other.getStatus())

			&& Objects.equals(getTotalItems(), other.getTotalItems())

			&& Objects.equals(getProcessedItems(), other.getProcessedItems());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = id;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexTypeId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = operationType;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = status;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = totalItems;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = processedItems;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.store;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.store.StoreCountWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Store Count
 */
@Schema(name="StoreCount", description="Representation of a Store Count")
public  class StoreCountWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of store count<br/><br/><i>Generated property</i> for <code>StoreCountWsDTO.type</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="type", description="Type of store count") 	
	private String type;

	/** Name of store count<br/><br/><i>Generated property</i> for <code>StoreCountWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="name", description="Name of store count") 	
	private String name;

	/** Iso code of store<br/><br/><i>Generated property</i> for <code>StoreCountWsDTO.isoCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="isoCode", description="Iso code of store") 	
	private String isoCode;

	/** Count<br/><br/><i>Generated property</i> for <code>StoreCountWsDTO.count</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="count", description="Count") 	
	private Integer count;

	/** List of store counts<br/><br/><i>Generated property</i> for <code>StoreCountWsDTO.storeCountDataList</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="storeCountDataList", description="List of store counts") 	
	private List<StoreCountWsDTO> storeCountDataList;
	
	public StoreCountWsDTO()
	{
		// default constructor
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setIsoCode(final String isoCode)
	{
		this.isoCode = isoCode;
	}

	public String getIsoCode() 
	{
		return isoCode;
	}
	
	public void setCount(final Integer count)
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	
	public void setStoreCountDataList(final List<StoreCountWsDTO> storeCountDataList)
	{
		this.storeCountDataList = storeCountDataList;
	}

	public List<StoreCountWsDTO> getStoreCountDataList() 
	{
		return storeCountDataList;
	}
	

}
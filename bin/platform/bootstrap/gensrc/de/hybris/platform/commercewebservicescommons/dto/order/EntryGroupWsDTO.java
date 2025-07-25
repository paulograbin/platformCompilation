/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.EntryGroupWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderEntryWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of an Entry Group
 */
@Schema(name="EntryGroup", description="Representation of an Entry Group")
public  class EntryGroupWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of order entries<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entries", description="List of order entries") 	
	private Collection<OrderEntryWsDTO> entries;

	/** List of child entry groups<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.entryGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entryGroups", description="List of child entry groups") 	
	private Collection<EntryGroupWsDTO> entryGroups;

	/** Identifier of the entry group<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.entryGroupNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="entryGroupNumber", description="Identifier of the entry group", example="1") 	
	private Integer entryGroupNumber;

	/** Label for the entry group<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.label</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="label", description="Label for the entry group", example="Photo On The Go Package") 	
	private String label;

	/** Indicates if the entry group is in an error state<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.erroneous</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="erroneous", description="Indicates if the entry group is in an error state", example="true") 	
	private Boolean erroneous;

	/** Indicates type of the group, possible values are STANDALONE, CONFIGURABLEBUNDLE or any customer implemented type for any new provider<br/><br/><i>Generated property</i> for <code>EntryGroupWsDTO.type</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="type", description="Indicates type of the group, possible values are STANDALONE, CONFIGURABLEBUNDLE or any customer implemented type for any new provider", example="STANDALONE") 	
	private String type;
	
	public EntryGroupWsDTO()
	{
		// default constructor
	}
	
	public void setEntries(final Collection<OrderEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public Collection<OrderEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
	public void setEntryGroups(final Collection<EntryGroupWsDTO> entryGroups)
	{
		this.entryGroups = entryGroups;
	}

	public Collection<EntryGroupWsDTO> getEntryGroups() 
	{
		return entryGroups;
	}
	
	public void setEntryGroupNumber(final Integer entryGroupNumber)
	{
		this.entryGroupNumber = entryGroupNumber;
	}

	public Integer getEntryGroupNumber() 
	{
		return entryGroupNumber;
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setErroneous(final Boolean erroneous)
	{
		this.erroneous = erroneous;
	}

	public Boolean getErroneous() 
	{
		return erroneous;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	

}
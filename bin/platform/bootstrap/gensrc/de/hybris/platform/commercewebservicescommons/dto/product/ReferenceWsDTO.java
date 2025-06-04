/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.ProductWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Representation of a Reference
 */
@Schema(name="Reference", description="Representation of a Reference")
public  class ReferenceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Reference type<br/><br/><i>Generated property</i> for <code>ReferenceWsDTO.referenceType</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="referenceType", description="Reference type") 	
	private String referenceType;

	/** Reference description<br/><br/><i>Generated property</i> for <code>ReferenceWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="description", description="Reference description") 	
	private String description;

	/** Reference quantity<br/><br/><i>Generated property</i> for <code>ReferenceWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="quantity", description="Reference quantity") 	
	private Integer quantity;

	/** Target product<br/><br/><i>Generated property</i> for <code>ReferenceWsDTO.target</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="target", description="Target product") 	
	private ProductWsDTO target;
	
	public ReferenceWsDTO()
	{
		// default constructor
	}
	
	public void setReferenceType(final String referenceType)
	{
		this.referenceType = referenceType;
	}

	public String getReferenceType() 
	{
		return referenceType;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}
	
	public void setTarget(final ProductWsDTO target)
	{
		this.target = target;
	}

	public ProductWsDTO getTarget() 
	{
		return target;
	}
	

}
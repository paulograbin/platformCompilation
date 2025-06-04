/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:40 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleocc.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import java.util.Objects;
/**
 * Mandatory data required to start a bundle. This includes the templateId of the bundle, the productCode, and the quantity of the product itself.
 */
@Schema(name="BundleStarter", description="Mandatory data required to start a bundle. This includes the templateId of the bundle, the productCode, and the quantity of the product itself.")
public  class BundleStarterWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Id of a template to create a bundle<br/><br/><i>Generated property</i> for <code>BundleStarterWsDTO.templateId</code> property defined at extension <code>configurablebundleocc</code>. */
@NotBlank@Schema(name="templateId", description="Id of a template to create a bundle", required=true, example="PhotoStarterPackage") 	
	private String templateId;

	/** Product code.<br/><br/><i>Generated property</i> for <code>BundleStarterWsDTO.productCode</code> property defined at extension <code>configurablebundleocc</code>. */
@NotBlank@Schema(name="productCode", description="Product code.", required=true, example="29925") 	
	private String productCode;

	/** Quantity of the product added to cart<br/><br/><i>Generated property</i> for <code>BundleStarterWsDTO.quantity</code> property defined at extension <code>configurablebundleocc</code>. */
@Min(value = 1)@Schema(name="quantity", description="Quantity of the product added to cart", required=true, example="1") 	
	private long quantity;
	
	public BundleStarterWsDTO()
	{
		// default constructor
	}
	
	public void setTemplateId(final String templateId)
	{
		this.templateId = templateId;
	}

	public String getTemplateId() 
	{
		return templateId;
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

	public long getQuantity() 
	{
		return quantity;
	}
	

}
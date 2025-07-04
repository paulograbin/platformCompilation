/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.VariantCategoryData;
import de.hybris.platform.commercefacades.product.data.VariantMatrixElementData;
import de.hybris.platform.commercefacades.product.data.VariantOptionData;
import de.hybris.platform.commercefacades.product.data.VariantValueCategoryData;
import java.util.List;


import java.util.Objects;
public  class VariantMatrixElementData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.variantValueCategory</code> property defined at extension <code>commercefacades</code>. */
	
	private VariantValueCategoryData variantValueCategory;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.parentVariantCategory</code> property defined at extension <code>commercefacades</code>. */
	
	private VariantCategoryData parentVariantCategory;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.variantOption</code> property defined at extension <code>commercefacades</code>. */
	
	private VariantOptionData variantOption;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.elements</code> property defined at extension <code>commercefacades</code>. */
	
	private List<VariantMatrixElementData> elements;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.isLeaf</code> property defined at extension <code>commercefacades</code>. */
	
	private Boolean isLeaf;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.orderFormQuantity</code> property defined at extension <code>savedorderforms</code>. */
	
	private Integer orderFormQuantity;
	
	public VariantMatrixElementData()
	{
		// default constructor
	}
	
	public void setVariantValueCategory(final VariantValueCategoryData variantValueCategory)
	{
		this.variantValueCategory = variantValueCategory;
	}

	public VariantValueCategoryData getVariantValueCategory() 
	{
		return variantValueCategory;
	}
	
	public void setParentVariantCategory(final VariantCategoryData parentVariantCategory)
	{
		this.parentVariantCategory = parentVariantCategory;
	}

	public VariantCategoryData getParentVariantCategory() 
	{
		return parentVariantCategory;
	}
	
	public void setVariantOption(final VariantOptionData variantOption)
	{
		this.variantOption = variantOption;
	}

	public VariantOptionData getVariantOption() 
	{
		return variantOption;
	}
	
	public void setElements(final List<VariantMatrixElementData> elements)
	{
		this.elements = elements;
	}

	public List<VariantMatrixElementData> getElements() 
	{
		return elements;
	}
	
	public void setIsLeaf(final Boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}

	public Boolean getIsLeaf() 
	{
		return isLeaf;
	}
	
	public void setOrderFormQuantity(final Integer orderFormQuantity)
	{
		this.orderFormQuantity = orderFormQuantity;
	}

	public Integer getOrderFormQuantity() 
	{
		return orderFormQuantity;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.search.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.AutocompleteSuggestionData;
import java.util.List;


import java.util.Objects;
public  class AutocompleteResultData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AutocompleteResultData.suggestions</code> property defined at extension <code>commercefacades</code>. */
	
	private List<AutocompleteSuggestionData> suggestions;

	/** <i>Generated property</i> for <code>AutocompleteResultData.products</code> property defined at extension <code>commercefacades</code>. */
	
	private List<ProductData> products;
	
	public AutocompleteResultData()
	{
		// default constructor
	}
	
	public void setSuggestions(final List<AutocompleteSuggestionData> suggestions)
	{
		this.suggestions = suggestions;
	}

	public List<AutocompleteSuggestionData> getSuggestions() 
	{
		return suggestions;
	}
	
	public void setProducts(final List<ProductData> products)
	{
		this.products = products;
	}

	public List<ProductData> getProducts() 
	{
		return products;
	}
	

}
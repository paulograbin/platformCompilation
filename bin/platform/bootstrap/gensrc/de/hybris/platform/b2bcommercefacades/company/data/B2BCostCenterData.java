/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import java.io.Serializable;
import de.hybris.platform.b2bcommercefacades.company.data.B2BBudgetData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import java.util.List;


import java.util.Objects;
public  class B2BCostCenterData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BCostCenterData.unit</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private B2BUnitData unit;

	/** <i>Generated property</i> for <code>B2BCostCenterData.code</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>B2BCostCenterData.originalCode</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String originalCode;

	/** <i>Generated property</i> for <code>B2BCostCenterData.name</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>B2BCostCenterData.currency</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private CurrencyData currency;

	/** <i>Generated property</i> for <code>B2BCostCenterData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean active;

	/** <i>Generated property</i> for <code>B2BCostCenterData.b2bBudgetData</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private List<B2BBudgetData> b2bBudgetData;

	/** <i>Generated property</i> for <code>B2BCostCenterData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
	
	private boolean selected;
	
	public B2BCostCenterData()
	{
		// default constructor
	}
	
	public void setUnit(final B2BUnitData unit)
	{
		this.unit = unit;
	}

	public B2BUnitData getUnit() 
	{
		return unit;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setOriginalCode(final String originalCode)
	{
		this.originalCode = originalCode;
	}

	public String getOriginalCode() 
	{
		return originalCode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCurrency(final CurrencyData currency)
	{
		this.currency = currency;
	}

	public CurrencyData getCurrency() 
	{
		return currency;
	}
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

	public boolean isActive() 
	{
		return active;
	}
	
	public void setB2bBudgetData(final List<B2BBudgetData> b2bBudgetData)
	{
		this.b2bBudgetData = b2bBudgetData;
	}

	public List<B2BBudgetData> getB2bBudgetData() 
	{
		return b2bBudgetData;
	}
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelected() 
	{
		return selected;
	}
	

}
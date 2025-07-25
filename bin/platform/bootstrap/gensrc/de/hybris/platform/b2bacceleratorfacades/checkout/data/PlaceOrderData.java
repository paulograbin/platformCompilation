/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:23 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.checkout.data;

import java.io.Serializable;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BReplenishmentRecurrenceEnum;
import de.hybris.platform.cronjob.enums.DayOfWeek;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class PlaceOrderData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PlaceOrderData.securityCode</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String securityCode;

	/** <i>Generated property</i> for <code>PlaceOrderData.termsCheck</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Boolean termsCheck;

	/** <i>Generated property</i> for <code>PlaceOrderData.negotiateQuote</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Boolean negotiateQuote;

	/** <i>Generated property</i> for <code>PlaceOrderData.quoteRequestDescription</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String quoteRequestDescription;

	/** <i>Generated property</i> for <code>PlaceOrderData.replenishmentOrder</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Boolean replenishmentOrder;

	/** <i>Generated property</i> for <code>PlaceOrderData.replenishmentStartDate</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Date replenishmentStartDate;

	/** <i>Generated property</i> for <code>PlaceOrderData.replenishmentRecurrence</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private B2BReplenishmentRecurrenceEnum replenishmentRecurrence;

	/** <i>Generated property</i> for <code>PlaceOrderData.nDaysOfWeek</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private List<DayOfWeek> nDaysOfWeek;

	/** <i>Generated property</i> for <code>PlaceOrderData.nDays</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String nDays;

	/** <i>Generated property</i> for <code>PlaceOrderData.nWeeks</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String nWeeks;

	/** <i>Generated property</i> for <code>PlaceOrderData.nthDayOfMonth</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String nthDayOfMonth;
	
	public PlaceOrderData()
	{
		// default constructor
	}
	
	public void setSecurityCode(final String securityCode)
	{
		this.securityCode = securityCode;
	}

	public String getSecurityCode() 
	{
		return securityCode;
	}
	
	public void setTermsCheck(final Boolean termsCheck)
	{
		this.termsCheck = termsCheck;
	}

	public Boolean getTermsCheck() 
	{
		return termsCheck;
	}
	
	/**
	 * @deprecated Please see quote functionality from commerce.
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public void setNegotiateQuote(final Boolean negotiateQuote)
	{
		this.negotiateQuote = negotiateQuote;
	}

	/**
	 * @deprecated Please see quote functionality from commerce.
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public Boolean getNegotiateQuote() 
	{
		return negotiateQuote;
	}
	
	/**
	 * @deprecated Please see quote functionality from commerce.
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public void setQuoteRequestDescription(final String quoteRequestDescription)
	{
		this.quoteRequestDescription = quoteRequestDescription;
	}

	/**
	 * @deprecated Please see quote functionality from commerce.
	 */
	@Deprecated(since = "6.3", forRemoval = true)
	public String getQuoteRequestDescription() 
	{
		return quoteRequestDescription;
	}
	
	public void setReplenishmentOrder(final Boolean replenishmentOrder)
	{
		this.replenishmentOrder = replenishmentOrder;
	}

	public Boolean getReplenishmentOrder() 
	{
		return replenishmentOrder;
	}
	
	public void setReplenishmentStartDate(final Date replenishmentStartDate)
	{
		this.replenishmentStartDate = replenishmentStartDate;
	}

	public Date getReplenishmentStartDate() 
	{
		return replenishmentStartDate;
	}
	
	public void setReplenishmentRecurrence(final B2BReplenishmentRecurrenceEnum replenishmentRecurrence)
	{
		this.replenishmentRecurrence = replenishmentRecurrence;
	}

	public B2BReplenishmentRecurrenceEnum getReplenishmentRecurrence() 
	{
		return replenishmentRecurrence;
	}
	
	public void setNDaysOfWeek(final List<DayOfWeek> nDaysOfWeek)
	{
		this.nDaysOfWeek = nDaysOfWeek;
	}

	public List<DayOfWeek> getNDaysOfWeek() 
	{
		return nDaysOfWeek;
	}
	
	public void setNDays(final String nDays)
	{
		this.nDays = nDays;
	}

	public String getNDays() 
	{
		return nDays;
	}
	
	public void setNWeeks(final String nWeeks)
	{
		this.nWeeks = nWeeks;
	}

	public String getNWeeks() 
	{
		return nWeeks;
	}
	
	public void setNthDayOfMonth(final String nthDayOfMonth)
	{
		this.nthDayOfMonth = nthDayOfMonth;
	}

	public String getNthDayOfMonth() 
	{
		return nthDayOfMonth;
	}
	

}
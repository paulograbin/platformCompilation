/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.AmountBalanceWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.OrgUnitReferenceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Account summary of an organizational unit.
 */
@Schema(name="AccountSummary", description="Account summary of an organizational unit.")
public  class AccountSummaryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Reference to organizational unit.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgUnit", description="Reference to organizational unit.") 	
	private OrgUnitReferenceWsDTO orgUnit;

	/** Account balance details.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.amountBalance</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="amountBalance", description="Account balance details.") 	
	private AmountBalanceWsDTO amountBalance;

	/** Billing address info.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.billingAddress</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="billingAddress", description="Billing address info.") 	
	private AddressWsDTO billingAddress;

	/** Credit limit amount, formatted as per the selected currency.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.creditLimit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="creditLimit", description="Credit limit amount, formatted as per the selected currency.", example="$15,000.00") 	
	private String creditLimit;

	/** Name of the account manager.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.accountManagerName</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="accountManagerName", description="Name of the account manager.", example="Elke Vogel") 	
	private String accountManagerName;

	/** Email of the account manager.<br/><br/><i>Generated property</i> for <code>AccountSummaryWsDTO.accountManagerEmail</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="accountManagerEmail", description="Email of the account manager.", example="elke.vogel@rustic.com") 	
	private String accountManagerEmail;
	
	public AccountSummaryWsDTO()
	{
		// default constructor
	}
	
	public void setOrgUnit(final OrgUnitReferenceWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public OrgUnitReferenceWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setAmountBalance(final AmountBalanceWsDTO amountBalance)
	{
		this.amountBalance = amountBalance;
	}

	public AmountBalanceWsDTO getAmountBalance() 
	{
		return amountBalance;
	}
	
	public void setBillingAddress(final AddressWsDTO billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public AddressWsDTO getBillingAddress() 
	{
		return billingAddress;
	}
	
	public void setCreditLimit(final String creditLimit)
	{
		this.creditLimit = creditLimit;
	}

	public String getCreditLimit() 
	{
		return creditLimit;
	}
	
	public void setAccountManagerName(final String accountManagerName)
	{
		this.accountManagerName = accountManagerName;
	}

	public String getAccountManagerName() 
	{
		return accountManagerName;
	}
	
	public void setAccountManagerEmail(final String accountManagerEmail)
	{
		this.accountManagerEmail = accountManagerEmail;
	}

	public String getAccountManagerEmail() 
	{
		return accountManagerEmail;
	}
	

}
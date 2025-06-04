/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.LanguageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a User
 */
@Schema(name="User", description="Representation of a User")
public  class UserWsDTO extends PrincipalWsDTO 

{



	/** User address<br/><br/><i>Generated property</i> for <code>UserWsDTO.defaultAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="defaultAddress", description="User address") 	
	private AddressWsDTO defaultAddress;

	/** User title code<br/><br/><i>Generated property</i> for <code>UserWsDTO.titleCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="titleCode", description="User title code") 	
	private String titleCode;

	/** User title<br/><br/><i>Generated property</i> for <code>UserWsDTO.title</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="title", description="User title") 	
	private String title;

	/** User first name<br/><br/><i>Generated property</i> for <code>UserWsDTO.firstName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="firstName", description="User first name") 	
	private String firstName;

	/** User last name<br/><br/><i>Generated property</i> for <code>UserWsDTO.lastName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="lastName", description="User last name") 	
	private String lastName;

	/** User preferred currency<br/><br/><i>Generated property</i> for <code>UserWsDTO.currency</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="currency", description="User preferred currency") 	
	private CurrencyWsDTO currency;

	/** User preferred language<br/><br/><i>Generated property</i> for <code>UserWsDTO.language</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="language", description="User preferred language") 	
	private LanguageWsDTO language;

	/** User identifier<br/><br/><i>Generated property</i> for <code>UserWsDTO.displayUid</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="displayUid", description="User identifier") 	
	private String displayUid;

	/** Customer identifier<br/><br/><i>Generated property</i> for <code>UserWsDTO.customerId</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="customerId", description="Customer identifier") 	
	private String customerId;

	/** Deactivation date<br/><br/><i>Generated property</i> for <code>UserWsDTO.deactivationDate</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="deactivationDate", description="Deactivation date") 	
	private Date deactivationDate;

	/** Name of the default pick up location<br/><br/><i>Generated property</i> for <code>UserWsDTO.defaultPointOfServiceName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="defaultPointOfServiceName", description="Name of the default pick up location", example="Misato") 	
	private String defaultPointOfServiceName;
	
	public UserWsDTO()
	{
		// default constructor
	}
	
	public void setDefaultAddress(final AddressWsDTO defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}

	public AddressWsDTO getDefaultAddress() 
	{
		return defaultAddress;
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setLanguage(final LanguageWsDTO language)
	{
		this.language = language;
	}

	public LanguageWsDTO getLanguage() 
	{
		return language;
	}
	
	public void setDisplayUid(final String displayUid)
	{
		this.displayUid = displayUid;
	}

	public String getDisplayUid() 
	{
		return displayUid;
	}
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setDeactivationDate(final Date deactivationDate)
	{
		this.deactivationDate = deactivationDate;
	}

	public Date getDeactivationDate() 
	{
		return deactivationDate;
	}
	
	public void setDefaultPointOfServiceName(final String defaultPointOfServiceName)
	{
		this.defaultPointOfServiceName = defaultPointOfServiceName;
	}

	public String getDefaultPointOfServiceName() 
	{
		return defaultPointOfServiceName;
	}
	

}
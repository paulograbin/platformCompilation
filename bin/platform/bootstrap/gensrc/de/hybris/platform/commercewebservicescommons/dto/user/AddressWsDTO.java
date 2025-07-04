/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.CountryWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.RegionWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on address data. The DTO is in XML or .json format
 */
@Schema(name="Address", description="Request body fields required and optional to operate on address data. The DTO is in XML or .json format")
public  class AddressWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique id value of the address which is optional while creating new address. While performing other address operations this value is the key<br/><br/><i>Generated property</i> for <code>AddressWsDTO.id</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="id", description="Unique id value of the address which is optional while creating new address. While performing other address operations this value is the key") 	
	private String id;

	/** Title of the address person<br/><br/><i>Generated property</i> for <code>AddressWsDTO.title</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="title", description="Title of the address person", example="Mr.") 	
	private String title;

	/** Code of the title<br/><br/><i>Generated property</i> for <code>AddressWsDTO.titleCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="titleCode", description="Code of the title", required=true, example="MR") 	
	private String titleCode;

	/** First name of the address person<br/><br/><i>Generated property</i> for <code>AddressWsDTO.firstName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="firstName", description="First name of the address person", required=true, example="John") 	
	private String firstName;

	/** Last name of the address person<br/><br/><i>Generated property</i> for <code>AddressWsDTO.lastName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="lastName", description="Last name of the address person", required=true, example="Doe") 	
	private String lastName;

	/** Company Name<br/><br/><i>Generated property</i> for <code>AddressWsDTO.companyName</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="companyName", description="Company Name", example="Global Corp.") 	
	private String companyName;

	/** First line of the address<br/><br/><i>Generated property</i> for <code>AddressWsDTO.line1</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="line1", description="First line of the address", required=true, example="123 Main Street") 	
	private String line1;

	/** Second line of the address<br/><br/><i>Generated property</i> for <code>AddressWsDTO.line2</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="line2", description="Second line of the address", example="Garden Level") 	
	private String line2;

	/** Town, field required<br/><br/><i>Generated property</i> for <code>AddressWsDTO.town</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="town", description="Town, field required", required=true, example="New York City") 	
	private String town;

	/** Region where address belongs to<br/><br/><i>Generated property</i> for <code>AddressWsDTO.region</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="region", description="Region where address belongs to") 	
	private RegionWsDTO region;

	/** District name<br/><br/><i>Generated property</i> for <code>AddressWsDTO.district</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="district", description="District name", example="8th") 	
	private String district;

	/** Postal code of the address<br/><br/><i>Generated property</i> for <code>AddressWsDTO.postalCode</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="postalCode", description="Postal code of the address", required=true, example="10001") 	
	private String postalCode;

	/** Phone number<br/><br/><i>Generated property</i> for <code>AddressWsDTO.phone</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="phone", description="Phone number", example="+1 (123) 456-7890") 	
	private String phone;

	/** Cellphone number<br/><br/><i>Generated property</i> for <code>AddressWsDTO.cellphone</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="cellphone", description="Cellphone number", example="+1 (123) 456-7890") 	
	private String cellphone;

	/** Email address<br/><br/><i>Generated property</i> for <code>AddressWsDTO.email</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="email", description="Email address", example="johndoe@domain.com") 	
	private String email;

	/** Country where address is located<br/><br/><i>Generated property</i> for <code>AddressWsDTO.country</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="country", description="Country where address is located") 	
	private CountryWsDTO country;

	/** Boolean flag if address is for shipping<br/><br/><i>Generated property</i> for <code>AddressWsDTO.shippingAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="shippingAddress", description="Boolean flag if address is for shipping") 	
	private Boolean shippingAddress;

	/** Boolean flag if address is default<br/><br/><i>Generated property</i> for <code>AddressWsDTO.defaultAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="defaultAddress", description="Boolean flag if address is default") 	
	private Boolean defaultAddress;

	/** Boolean flag if address is visible in the Address Book<br/><br/><i>Generated property</i> for <code>AddressWsDTO.visibleInAddressBook</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="visibleInAddressBook", description="Boolean flag if address is visible in the Address Book") 	
	private Boolean visibleInAddressBook;

	/** Boolean flag if address is formatted<br/><br/><i>Generated property</i> for <code>AddressWsDTO.formattedAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="formattedAddress", description="Boolean flag if address is formatted") 	
	private String formattedAddress;
	
	public AddressWsDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	public String getTitleCode() 
	{
		return titleCode;
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
	
	public void setCompanyName(final String companyName)
	{
		this.companyName = companyName;
	}

	public String getCompanyName() 
	{
		return companyName;
	}
	
	public void setLine1(final String line1)
	{
		this.line1 = line1;
	}

	public String getLine1() 
	{
		return line1;
	}
	
	public void setLine2(final String line2)
	{
		this.line2 = line2;
	}

	public String getLine2() 
	{
		return line2;
	}
	
	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getTown() 
	{
		return town;
	}
	
	public void setRegion(final RegionWsDTO region)
	{
		this.region = region;
	}

	public RegionWsDTO getRegion() 
	{
		return region;
	}
	
	public void setDistrict(final String district)
	{
		this.district = district;
	}

	public String getDistrict() 
	{
		return district;
	}
	
	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getPostalCode() 
	{
		return postalCode;
	}
	
	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	
	public void setCellphone(final String cellphone)
	{
		this.cellphone = cellphone;
	}

	public String getCellphone() 
	{
		return cellphone;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setCountry(final CountryWsDTO country)
	{
		this.country = country;
	}

	public CountryWsDTO getCountry() 
	{
		return country;
	}
	
	public void setShippingAddress(final Boolean shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public Boolean getShippingAddress() 
	{
		return shippingAddress;
	}
	
	public void setDefaultAddress(final Boolean defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}

	public Boolean getDefaultAddress() 
	{
		return defaultAddress;
	}
	
	public void setVisibleInAddressBook(final Boolean visibleInAddressBook)
	{
		this.visibleInAddressBook = visibleInAddressBook;
	}

	public Boolean getVisibleInAddressBook() 
	{
		return visibleInAddressBook;
	}
	
	public void setFormattedAddress(final String formattedAddress)
	{
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress() 
	{
		return formattedAddress;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import de.hybris.platform.assistedservicewebservices.dto.image.UserAvatarWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.AddressWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a overview Data
 */
@Schema(name="C360OverviewData", description="Representation of a overview Data")
public  class C360OverviewDataWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Name of the customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.name</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="name", description="Name of the customer", example="John Doe") 	
	private String name;

	/** Size of the current cart for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.cartSize</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="cartSize", description="Size of the current cart for a given customer", example="5") 	
	private Integer cartSize;

	/** Code of the current cart for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.cartCode</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="cartCode", description="Code of the current cart for a given customer", example="00001185") 	
	private String cartCode;

	/** Total of the most recent order for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.latestOrderTotal</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="latestOrderTotal", description="Total of the most recent order for a given customer", example="$12.34") 	
	private String latestOrderTotal;

	/** Code of the most recent order for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.latestOrderCode</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="latestOrderCode", description="Code of the most recent order for a given customer", example="00001185") 	
	private String latestOrderCode;

	/** Date of the most recent order for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.latestOrderTime</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="latestOrderTime", description="Date of the most recent order for a given customer", example="2022-09-12T12:56:57.624Z") 	
	private Date latestOrderTime;

	/** ID of the most recent ticket for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.latestOpenedTicketId</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="latestOpenedTicketId", description="ID of the most recent ticket for a given customer", example="00000001") 	
	private String latestOpenedTicketId;

	/** Creation date of the most recent ticket for a given customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.latestOpenedTicketCreatedAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="latestOpenedTicketCreatedAt", description="Creation date of the most recent ticket for a given customer", example="2022-09-12T12:56:57.624Z") 	
	private Date latestOpenedTicketCreatedAt;

	/** Email address of the customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.email</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="email", description="Email address of the customer", example="johndoe@example.com") 	
	private String email;

	/** Date that the customer signed up<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.signedUpAt</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="signedUpAt", description="Date that the customer signed up", example="2022-09-12T12:56:57.624Z") 	
	private Date signedUpAt;

	/** Address of the customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.address</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="address", description="Address of the customer") 	
	private AddressWsDTO address;

	/** User avatar of the customer<br/><br/><i>Generated property</i> for <code>C360OverviewDataWsDTO.userAvatar</code> property defined at extension <code>assistedservicewebservices</code>. */
@Schema(name="userAvatar", description="User avatar of the customer") 	
	private UserAvatarWsDTO userAvatar;
	
	public C360OverviewDataWsDTO()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCartSize(final Integer cartSize)
	{
		this.cartSize = cartSize;
	}

	public Integer getCartSize() 
	{
		return cartSize;
	}
	
	public void setCartCode(final String cartCode)
	{
		this.cartCode = cartCode;
	}

	public String getCartCode() 
	{
		return cartCode;
	}
	
	public void setLatestOrderTotal(final String latestOrderTotal)
	{
		this.latestOrderTotal = latestOrderTotal;
	}

	public String getLatestOrderTotal() 
	{
		return latestOrderTotal;
	}
	
	public void setLatestOrderCode(final String latestOrderCode)
	{
		this.latestOrderCode = latestOrderCode;
	}

	public String getLatestOrderCode() 
	{
		return latestOrderCode;
	}
	
	public void setLatestOrderTime(final Date latestOrderTime)
	{
		this.latestOrderTime = latestOrderTime;
	}

	public Date getLatestOrderTime() 
	{
		return latestOrderTime;
	}
	
	public void setLatestOpenedTicketId(final String latestOpenedTicketId)
	{
		this.latestOpenedTicketId = latestOpenedTicketId;
	}

	public String getLatestOpenedTicketId() 
	{
		return latestOpenedTicketId;
	}
	
	public void setLatestOpenedTicketCreatedAt(final Date latestOpenedTicketCreatedAt)
	{
		this.latestOpenedTicketCreatedAt = latestOpenedTicketCreatedAt;
	}

	public Date getLatestOpenedTicketCreatedAt() 
	{
		return latestOpenedTicketCreatedAt;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setSignedUpAt(final Date signedUpAt)
	{
		this.signedUpAt = signedUpAt;
	}

	public Date getSignedUpAt() 
	{
		return signedUpAt;
	}
	
	public void setAddress(final AddressWsDTO address)
	{
		this.address = address;
	}

	public AddressWsDTO getAddress() 
	{
		return address;
	}
	
	public void setUserAvatar(final UserAvatarWsDTO userAvatar)
	{
		this.userAvatar = userAvatar;
	}

	public UserAvatarWsDTO getUserAvatar() 
	{
		return userAvatar;
	}
	

}
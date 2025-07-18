/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicefacades.customer360;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import java.util.Date;


import java.util.Objects;
public  class CustomerViewHeadingData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.name</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.cartSize</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private Integer cartSize;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.cartCode</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String cartCode;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.latestOrderTotal</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String latestOrderTotal;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.latestOrderCode</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String latestOrderCode;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.latestOrderTime</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private Date latestOrderTime;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.latestOpenedTicketId</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String latestOpenedTicketId;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.latestOpenedTicketCreated</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private Date latestOpenedTicketCreated;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.email</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private String email;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.signedUp</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private Date signedUp;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.address</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private AddressData address;

	/** <i>Generated property</i> for <code>CustomerViewHeadingData.profilePicture</code> property defined at extension <code>assistedservicefacades</code>. */
	
	private ImageData profilePicture;
	
	public CustomerViewHeadingData()
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
	
	public void setLatestOpenedTicketCreated(final Date latestOpenedTicketCreated)
	{
		this.latestOpenedTicketCreated = latestOpenedTicketCreated;
	}

	public Date getLatestOpenedTicketCreated() 
	{
		return latestOpenedTicketCreated;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setSignedUp(final Date signedUp)
	{
		this.signedUp = signedUp;
	}

	public Date getSignedUp() 
	{
		return signedUp;
	}
	
	public void setAddress(final AddressData address)
	{
		this.address = address;
	}

	public AddressData getAddress() 
	{
		return address;
	}
	
	public void setProfilePicture(final ImageData profilePicture)
	{
		this.profilePicture = profilePicture;
	}

	public ImageData getProfilePicture() 
	{
		return profilePicture;
	}
	

}
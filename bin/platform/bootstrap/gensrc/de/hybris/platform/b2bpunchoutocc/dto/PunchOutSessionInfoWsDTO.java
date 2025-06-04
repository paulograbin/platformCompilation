/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bpunchoutocc.dto;

import java.io.Serializable;
import de.hybris.platform.b2b.punchout.constants.PunchOutSetupOperation;
import de.hybris.platform.b2b.punchout.enums.PunchOutLevel;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * PunchOutSessionInfo contains the user ID, cart ID, token, PunchOut level, PunchOut operation and
            selected item.
        
 */
@Schema(name="PunchOutSessionInfo", description="PunchOutSessionInfo contains the user ID, cart ID, token, PunchOut level, PunchOut operation and selected item.")
public  class PunchOutSessionInfoWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** CustomerID of the user<br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.customerId</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="customerId", description="CustomerID of the user", required=true, example="punchout.customer@punchoutorg.com") 	
	private String customerId;

	/** ID of the cart<br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.cartId</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="cartId", description="ID of the cart", required=true, example="00002159") 	
	private String cartId;

	/** The punchoutLevel is an attribute that allows suppliers to specify how procurement applications
                should present the PunchOut item to users.
            <br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.punchOutLevel</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="punchOutLevel", description="The punchoutLevel is an attribute that allows suppliers to specify how procurement applications should present the PunchOut item to users.", required=true) 	
	private PunchOutLevel punchOutLevel;

	/** Supported PunchOut operations<br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.punchOutOperation</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="punchOutOperation", description="Supported PunchOut operations", required=true) 	
	private PunchOutSetupOperation punchOutOperation;

	/** The selected item specify PunchOut for an entire store or any subset of product offerings
            <br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.selectedItem</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="selectedItem", description="The selected item specify PunchOut for an entire store or any subset of product offerings", example="300000029") 	
	private String selectedItem;

	/** Holds the token info for the user<br/><br/><i>Generated property</i> for <code>PunchOutSessionInfoWsDTO.token</code> property defined at extension <code>b2bpunchoutocc</code>. */
@Schema(name="token", description="Holds the token info for the user", required=true) 	
	private PunchOutTokenWsDTO token;
	
	public PunchOutSessionInfoWsDTO()
	{
		// default constructor
	}
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		return cartId;
	}
	
	public void setPunchOutLevel(final PunchOutLevel punchOutLevel)
	{
		this.punchOutLevel = punchOutLevel;
	}

	public PunchOutLevel getPunchOutLevel() 
	{
		return punchOutLevel;
	}
	
	public void setPunchOutOperation(final PunchOutSetupOperation punchOutOperation)
	{
		this.punchOutOperation = punchOutOperation;
	}

	public PunchOutSetupOperation getPunchOutOperation() 
	{
		return punchOutOperation;
	}
	
	public void setSelectedItem(final String selectedItem)
	{
		this.selectedItem = selectedItem;
	}

	public String getSelectedItem() 
	{
		return selectedItem;
	}
	
	public void setToken(final PunchOutTokenWsDTO token)
	{
		this.token = token;
	}

	public PunchOutTokenWsDTO getToken() 
	{
		return token;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.voucher;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.voucher.VoucherWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a Voucher List
 */
@Schema(name="VoucherList", description="Representation of a Voucher List")
public  class VoucherListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of vouchers<br/><br/><i>Generated property</i> for <code>VoucherListWsDTO.vouchers</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="vouchers", description="List of vouchers") 	
	private List<VoucherWsDTO> vouchers;
	
	public VoucherListWsDTO()
	{
		// default constructor
	}
	
	public void setVouchers(final List<VoucherWsDTO> vouchers)
	{
		this.vouchers = vouchers;
	}

	public List<VoucherWsDTO> getVouchers() 
	{
		return vouchers;
	}
	

}
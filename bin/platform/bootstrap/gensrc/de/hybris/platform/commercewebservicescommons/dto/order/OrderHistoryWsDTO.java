/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of an Order History
 */
@Schema(name="OrderHistory", description="Representation of an Order History")
public  class OrderHistoryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code of Order History<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="code", description="Code of Order History") 	
	private String code;

	/** Status of Order History<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="status", description="Status of Order History") 	
	private String status;

	/** Status display<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="statusDisplay", description="Status display") 	
	private String statusDisplay;

	/** Date of placing order<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.placed</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="placed", description="Date of placing order") 	
	private Date placed;

	/** Guest user identifier<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.guid</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="guid", description="Guest user identifier") 	
	private String guid;

	/** Total price<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.total</code> property defined at extension <code>commercewebservicescommons</code>. */
@Schema(name="total", description="Total price") 	
	private PriceWsDTO total;

	/** Order Cost Center<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.costCenter</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="costCenter", description="Order Cost Center") 	
	private B2BCostCenterWsDTO costCenter;

	/** User's organizational unit at order creation. This field is only filled in if the user is a member of an organization.<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgUnit", description="User's organizational unit at order creation. This field is only filled in if the user is a member of an organization.") 	
	private B2BUnitWsDTO orgUnit;

	/** Purchase order number<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.purchaseOrderNumber</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="purchaseOrderNumber", description="Purchase order number") 	
	private String purchaseOrderNumber;

	/** Customer who placed the order. This field is only filled in if the user is a member of an organization.<br/><br/><i>Generated property</i> for <code>OrderHistoryWsDTO.orgCustomer</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgCustomer", description="Customer who placed the order. This field is only filled in if the user is a member of an organization.") 	
	private UserWsDTO orgCustomer;
	
	public OrderHistoryWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
	public void setPlaced(final Date placed)
	{
		this.placed = placed;
	}

	public Date getPlaced() 
	{
		return placed;
	}
	
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}

	public String getGuid() 
	{
		return guid;
	}
	
	public void setTotal(final PriceWsDTO total)
	{
		this.total = total;
	}

	public PriceWsDTO getTotal() 
	{
		return total;
	}
	
	public void setCostCenter(final B2BCostCenterWsDTO costCenter)
	{
		this.costCenter = costCenter;
	}

	public B2BCostCenterWsDTO getCostCenter() 
	{
		return costCenter;
	}
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setPurchaseOrderNumber(final String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getPurchaseOrderNumber() 
	{
		return purchaseOrderNumber;
	}
	
	public void setOrgCustomer(final UserWsDTO orgCustomer)
	{
		this.orgCustomer = orgCustomer;
	}

	public UserWsDTO getOrgCustomer() 
	{
		return orgCustomer;
	}
	

}
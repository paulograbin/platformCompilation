/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPeriodRangeWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BPermissionTypeWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Order Approval Permission data.
 */
@Schema(name="OrderApprovalPermission", description="Request body fields required and optional to operate on Order Approval Permission data.")
public  class B2BPermissionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Boolean flag of whether Order Approval Permission is active<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="active", description="Boolean flag of whether Order Approval Permission is active", example="true") 	
	private Boolean active;

	/** Type of the Order Approval Permission<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.orderApprovalPermissionType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orderApprovalPermissionType", description="Type of the Order Approval Permission") 	
	private B2BPermissionTypeWsDTO orderApprovalPermissionType;

	/** Code of the Order Approval Permission<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="code", description="Code of the Order Approval Permission", required=true, example="Rustic_10K_USD_MONTH") 	
	private String code;

	/** Currency of the Order Approval Permission, used for type B2BOrderThresholdPermission and B2BOrderThresholdTimespanPermission<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.currency</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="currency", description="Currency of the Order Approval Permission, used for type B2BOrderThresholdPermission and B2BOrderThresholdTimespanPermission") 	
	private CurrencyWsDTO currency;

	/** Period range of the Order Approval Permission, used for type B2BOrderThresholdTimespanPermission<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.periodRange</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="periodRange", description="Period range of the Order Approval Permission, used for type B2BOrderThresholdTimespanPermission", example="MONTH") 	
	private B2BPeriodRangeWsDTO periodRange;

	/** Order Approval Permission's organizational unit<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgUnit", description="Order Approval Permission's organizational unit") 	
	private B2BUnitWsDTO orgUnit;

	/** Threshold value of the Order Approval Permission, used for type B2BOrderThresholdPermission and B2BOrderThresholdTimespanPermission<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.threshold</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="threshold", description="Threshold value of the Order Approval Permission, used for type B2BOrderThresholdPermission and B2BOrderThresholdTimespanPermission", example="10000") 	
	private Double threshold;

	/** Boolean flag of whether the user is selected<br/><br/><i>Generated property</i> for <code>B2BPermissionWsDTO.selected</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="selected", description="Boolean flag of whether the user is selected", example="true") 	
	private Boolean selected;
	
	public B2BPermissionWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setOrderApprovalPermissionType(final B2BPermissionTypeWsDTO orderApprovalPermissionType)
	{
		this.orderApprovalPermissionType = orderApprovalPermissionType;
	}

	public B2BPermissionTypeWsDTO getOrderApprovalPermissionType() 
	{
		return orderApprovalPermissionType;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setPeriodRange(final B2BPeriodRangeWsDTO periodRange)
	{
		this.periodRange = periodRange;
	}

	public B2BPeriodRangeWsDTO getPeriodRange() 
	{
		return periodRange;
	}
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setThreshold(final Double threshold)
	{
		this.threshold = threshold;
	}

	public Double getThreshold() 
	{
		return threshold;
	}
	
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}

	public Boolean getSelected() 
	{
		return selected;
	}
	

}
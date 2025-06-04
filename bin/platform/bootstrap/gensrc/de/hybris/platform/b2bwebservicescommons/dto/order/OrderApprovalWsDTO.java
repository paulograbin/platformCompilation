/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:45 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.order.OrderApprovalRecordWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.order.TriggerWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.OrderWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Details of one specific order approval
 */
@Schema(name="OrderApproval", description="Details of one specific order approval")
public  class OrderApprovalWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Code that identifies the approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="code", description="Code that identifies the approval.", required=true, example="00000005") 	
	private String code;

	/** Order linked to this approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.order</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="order", description="Order linked to this approval.") 	
	private OrderWsDTO order;

	/** Boolean flag which states whether an approval decision is required.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.approvalDecisionRequired</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="approvalDecisionRequired", description="Boolean flag which states whether an approval decision is required.") 	
	private Boolean approvalDecisionRequired;

	/** Customer approval records related to this order approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.customerOrderApprovalRecords</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="customerOrderApprovalRecords", description="Customer approval records related to this order approval.") 	
	private List<OrderApprovalRecordWsDTO> customerOrderApprovalRecords;

	/** Merchant approval records related to this order approval.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.merchantOrderApprovalRecords</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="merchantOrderApprovalRecords", description="Merchant approval records related to this order approval.") 	
	private List<OrderApprovalRecordWsDTO> merchantOrderApprovalRecords;

	/** Replenishment trigger if this is an approval for a replenishment order.<br/><br/><i>Generated property</i> for <code>OrderApprovalWsDTO.trigger</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="trigger", description="Replenishment trigger if this is an approval for a replenishment order.") 	
	private TriggerWsDTO trigger;
	
	public OrderApprovalWsDTO()
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
	
	public void setOrder(final OrderWsDTO order)
	{
		this.order = order;
	}

	public OrderWsDTO getOrder() 
	{
		return order;
	}
	
	public void setApprovalDecisionRequired(final Boolean approvalDecisionRequired)
	{
		this.approvalDecisionRequired = approvalDecisionRequired;
	}

	public Boolean getApprovalDecisionRequired() 
	{
		return approvalDecisionRequired;
	}
	
	public void setCustomerOrderApprovalRecords(final List<OrderApprovalRecordWsDTO> customerOrderApprovalRecords)
	{
		this.customerOrderApprovalRecords = customerOrderApprovalRecords;
	}

	public List<OrderApprovalRecordWsDTO> getCustomerOrderApprovalRecords() 
	{
		return customerOrderApprovalRecords;
	}
	
	public void setMerchantOrderApprovalRecords(final List<OrderApprovalRecordWsDTO> merchantOrderApprovalRecords)
	{
		this.merchantOrderApprovalRecords = merchantOrderApprovalRecords;
	}

	public List<OrderApprovalRecordWsDTO> getMerchantOrderApprovalRecords() 
	{
		return merchantOrderApprovalRecords;
	}
	
	public void setTrigger(final TriggerWsDTO trigger)
	{
		this.trigger = trigger;
	}

	public TriggerWsDTO getTrigger() 
	{
		return trigger;
	}
	

}
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
import de.hybris.platform.b2bwebservicescommons.dto.OrgDocumentAttachmentWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BOrgDocumentTypeWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational document.
 */
@Schema(name="OrgDocument", description="Representation of an organizational document.")
public  class B2BOrgDocumentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Unique identifier for the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.id</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="id", description="Unique identifier for the organizational document.", required=true, example="DOC-01234") 	
	private String id;

	/** <i>Generated property</i> for <code>B2BOrgDocumentWsDTO.orgDocumentType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="orgDocumentType") 	
	private B2BOrgDocumentTypeWsDTO orgDocumentType;

	/** Organizational document status. Possible values are: open, closed.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.status</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="status", description="Organizational document status. Possible values are: open, closed.", required=true, example="open") 	
	private String status;

	/** Creation date for the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.createdAtDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="createdAtDate", description="Creation date for the organizational document.", example="2022-04-14") 	
	private String createdAtDate;

	/** Due date for the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.dueAtDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="dueAtDate", description="Due date for the organizational document.", example="2022-06-18") 	
	private String dueAtDate;

	/** Original amount due for the organizational document, formatted as per the selected currency.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.formattedAmount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="formattedAmount", description="Original amount due for the organizational document, formatted as per the selected currency.", required=true, example="$1230.45") 	
	private String formattedAmount;

	/** Original amount due for the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.amount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="amount", description="Original amount due for the organizational document.", required=true, example="1230.45") 	
	private BigDecimal amount;

	/** Open amount due for the organizational document, formatted as per the selected currency.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.formattedOpenAmount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="formattedOpenAmount", description="Open amount due for the organizational document, formatted as per the selected currency.", example="$430.45") 	
	private String formattedOpenAmount;

	/** Open amount due for the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.openAmount</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="openAmount", description="Open amount due for the organizational document.", example="430.45") 	
	private BigDecimal openAmount;

	/** <i>Generated property</i> for <code>B2BOrgDocumentWsDTO.currency</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="currency", required=true) 	
	private CurrencyWsDTO currency;

	/** Attachments associated to the organizational document.<br/><br/><i>Generated property</i> for <code>B2BOrgDocumentWsDTO.attachments</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="attachments", description="Attachments associated to the organizational document.", required=false) 	
	private List<OrgDocumentAttachmentWsDTO> attachments;
	
	public B2BOrgDocumentWsDTO()
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
	
	public void setOrgDocumentType(final B2BOrgDocumentTypeWsDTO orgDocumentType)
	{
		this.orgDocumentType = orgDocumentType;
	}

	public B2BOrgDocumentTypeWsDTO getOrgDocumentType() 
	{
		return orgDocumentType;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setCreatedAtDate(final String createdAtDate)
	{
		this.createdAtDate = createdAtDate;
	}

	public String getCreatedAtDate() 
	{
		return createdAtDate;
	}
	
	public void setDueAtDate(final String dueAtDate)
	{
		this.dueAtDate = dueAtDate;
	}

	public String getDueAtDate() 
	{
		return dueAtDate;
	}
	
	public void setFormattedAmount(final String formattedAmount)
	{
		this.formattedAmount = formattedAmount;
	}

	public String getFormattedAmount() 
	{
		return formattedAmount;
	}
	
	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public BigDecimal getAmount() 
	{
		return amount;
	}
	
	public void setFormattedOpenAmount(final String formattedOpenAmount)
	{
		this.formattedOpenAmount = formattedOpenAmount;
	}

	public String getFormattedOpenAmount() 
	{
		return formattedOpenAmount;
	}
	
	public void setOpenAmount(final BigDecimal openAmount)
	{
		this.openAmount = openAmount;
	}

	public BigDecimal getOpenAmount() 
	{
		return openAmount;
	}
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setAttachments(final List<OrgDocumentAttachmentWsDTO> attachments)
	{
		this.attachments = attachments;
	}

	public List<OrgDocumentAttachmentWsDTO> getAttachments() 
	{
		return attachments;
	}
	

}
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:25 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.fraud.data;

import java.io.Serializable;
import de.hybris.platform.ordermanagementfacades.fraud.data.FraudSymptomScoringsData;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class FraudReportData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FraudReportData.explanation</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private String explanation;

	/** <i>Generated property</i> for <code>FraudReportData.fraudSymptomScorings</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<FraudSymptomScoringsData> fraudSymptomScorings;

	/** <i>Generated property</i> for <code>FraudReportData.provider</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private String provider;

	/** <i>Generated property</i> for <code>FraudReportData.status</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private String status;

	/** <i>Generated property</i> for <code>FraudReportData.timestamp</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private Date timestamp;
	
	public FraudReportData()
	{
		// default constructor
	}
	
	public void setExplanation(final String explanation)
	{
		this.explanation = explanation;
	}

	public String getExplanation() 
	{
		return explanation;
	}
	
	public void setFraudSymptomScorings(final List<FraudSymptomScoringsData> fraudSymptomScorings)
	{
		this.fraudSymptomScorings = fraudSymptomScorings;
	}

	public List<FraudSymptomScoringsData> getFraudSymptomScorings() 
	{
		return fraudSymptomScorings;
	}
	
	public void setProvider(final String provider)
	{
		this.provider = provider;
	}

	public String getProvider() 
	{
		return provider;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setTimestamp(final Date timestamp)
	{
		this.timestamp = timestamp;
	}

	public Date getTimestamp() 
	{
		return timestamp;
	}
	

}
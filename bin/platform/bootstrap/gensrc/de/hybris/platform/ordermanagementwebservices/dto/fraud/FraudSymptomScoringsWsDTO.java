/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.fraud;

import java.io.Serializable;


import java.util.Objects;
public  class FraudSymptomScoringsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsWsDTO.explanation</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String explanation;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsWsDTO.name</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>FraudSymptomScoringsWsDTO.score</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private Double score;
	
	public FraudSymptomScoringsWsDTO()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setScore(final Double score)
	{
		this.score = score;
	}

	public Double getScore() 
	{
		return score;
	}
	

}
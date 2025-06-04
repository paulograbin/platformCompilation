/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:27:38 PM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yhacext.data;

import java.io.Serializable;
import de.hybris.platform.yhacext.data.SampleMonitorResultData;
import java.util.List;


import java.util.Objects;
public  class SampleMonitorData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SampleMonitorData.results</code> property defined at extension <code>yhacext</code>. */
	
	private List<SampleMonitorResultData> results;
	
	public SampleMonitorData()
	{
		// default constructor
	}
	
	public void setResults(final List<SampleMonitorResultData> results)
	{
		this.results = results;
	}

	public List<SampleMonitorResultData> getResults() 
	{
		return results;
	}
	

}
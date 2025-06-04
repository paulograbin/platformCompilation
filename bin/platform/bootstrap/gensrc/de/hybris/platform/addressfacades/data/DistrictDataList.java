/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.addressfacades.data;

import java.io.Serializable;
import de.hybris.platform.addressfacades.data.DistrictData;
import java.util.List;


import java.util.Objects;
public  class DistrictDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DistrictDataList.districts</code> property defined at extension <code>chineseaddressfacades</code>. */
	
	private List<DistrictData> districts;
	
	public DistrictDataList()
	{
		// default constructor
	}
	
	public void setDistricts(final List<DistrictData> districts)
	{
		this.districts = districts;
	}

	public List<DistrictData> getDistricts() 
	{
		return districts;
	}
	

}
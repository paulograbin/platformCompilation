/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:43 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.mycompany;

import de.hybris.platform.b2bwebservicescommons.dto.mycompany.BudgetBaseWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Budget data.
		This bean is shallow, which means its potential relationship fields to other Org Unit fields are simple ids.
		No Org Unit WsDTO should be declared in this bean to avoid circular references.
 */
@Schema(name="BudgetShallow", description="Request body fields required and optional to operate on Budget data. This bean is shallow, which means its potential relationship fields to other Org Unit fields are simple ids. No Org Unit WsDTO should be declared in this bean to avoid circular references.")
public  class BudgetShallowWsDTO extends BudgetBaseWsDTO 

{


	
	public BudgetShallowWsDTO()
	{
		// default constructor
	}
	

}
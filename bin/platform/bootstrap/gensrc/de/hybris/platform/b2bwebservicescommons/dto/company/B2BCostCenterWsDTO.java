/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 12, 2025, 10:11:44 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterBaseWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.mycompany.BudgetShallowWsDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a cost center. This bean may have relationships to other Org Unit WsDTO, whose type are WsDTO beans as well.
 */
@Schema(name="B2BCostCenter", description="Representation of a cost center. This bean may have relationships to other Org Unit WsDTO, whose type are WsDTO beans as well.")
public  class B2BCostCenterWsDTO extends B2BCostCenterBaseWsDTO 

{



	/** The parent unit of the cost center<br/><br/><i>Generated property</i> for <code>B2BCostCenterWsDTO.unit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="unit", description="The parent unit of the cost center") 	
	private B2BUnitWsDTO unit;

	/** Budgets assigned to this cost center<br/><br/><i>Generated property</i> for <code>B2BCostCenterWsDTO.assignedBudgets</code> property defined at extension <code>b2bwebservicescommons</code>. */
@Schema(name="assignedBudgets", description="Budgets assigned to this cost center") 	
	private List<BudgetShallowWsDTO> assignedBudgets;
	
	public B2BCostCenterWsDTO()
	{
		// default constructor
	}
	
	public void setUnit(final B2BUnitWsDTO unit)
	{
		this.unit = unit;
	}

	public B2BUnitWsDTO getUnit() 
	{
		return unit;
	}
	
	public void setAssignedBudgets(final List<BudgetShallowWsDTO> assignedBudgets)
	{
		this.assignedBudgets = assignedBudgets;
	}

	public List<BudgetShallowWsDTO> getAssignedBudgets() 
	{
		return assignedBudgets;
	}
	

}
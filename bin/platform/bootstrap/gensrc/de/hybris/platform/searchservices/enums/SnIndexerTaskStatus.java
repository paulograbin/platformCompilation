/*
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum SnIndexerTaskStatus declared at extension searchservices.
 */
public enum SnIndexerTaskStatus implements HybrisEnumValue
{
	/**
	 * Generated enum value for SnIndexerTaskStatus.RUNNING declared at extension searchservices.
	 */
	RUNNING("RUNNING"),
	/**
	 * Generated enum value for SnIndexerTaskStatus.COMPLETED declared at extension searchservices.
	 */
	COMPLETED("COMPLETED"),
	/**
	 * Generated enum value for SnIndexerTaskStatus.ABORTED declared at extension searchservices.
	 */
	ABORTED("ABORTED"),
	/**
	 * Generated enum value for SnIndexerTaskStatus.FAILED declared at extension searchservices.
	 */
	FAILED("FAILED");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "SnIndexerTaskStatus";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "SnIndexerTaskStatus";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private SnIndexerTaskStatus(final String code)
	{
		this.code = code.intern();
	}
	
	
	/**
	 * Gets the code of this enum value.
	 *  
	 * @return code of value
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}
	
	/**
	 * Gets the type this enum value belongs to.
	 *  
	 * @return code of type
	 */
	@Override
	public String getType()
	{
		return SIMPLE_CLASSNAME;
	}
	
}

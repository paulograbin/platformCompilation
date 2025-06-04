/*
 *  
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.basecommerce.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum SAPCapturePattern declared at extension basecommerce.
 */
public enum SAPCapturePattern implements HybrisEnumValue
{
	/**
	 * Generated enum value for SAPCapturePattern.AUTO_CAPTURE declared at extension basecommerce.
	 */
	AUTO_CAPTURE("AUTO_CAPTURE"),
	/**
	 * Generated enum value for SAPCapturePattern.CAPTURE_PER_SHIPMENT declared at extension basecommerce.
	 */
	CAPTURE_PER_SHIPMENT("CAPTURE_PER_SHIPMENT"),
	/**
	 * Generated enum value for SAPCapturePattern.PARTIAL_CAPTURE declared at extension basecommerce.
	 */
	PARTIAL_CAPTURE("PARTIAL_CAPTURE");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "SAPCapturePattern";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "SAPCapturePattern";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private SAPCapturePattern(final String code)
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

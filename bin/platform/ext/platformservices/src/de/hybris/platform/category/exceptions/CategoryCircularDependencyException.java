/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.category.exceptions;

import de.hybris.platform.servicelayer.interceptor.Interceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;


public class CategoryCircularDependencyException extends InterceptorException
{
	public CategoryCircularDependencyException(String message)
	{
		super(message);
	}

	public CategoryCircularDependencyException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CategoryCircularDependencyException(String message, Interceptor inter)
	{
		super(message, inter);
	}

	public CategoryCircularDependencyException(String message, Throwable cause, Interceptor inter)
	{
		super(message, cause, inter);
	}
}

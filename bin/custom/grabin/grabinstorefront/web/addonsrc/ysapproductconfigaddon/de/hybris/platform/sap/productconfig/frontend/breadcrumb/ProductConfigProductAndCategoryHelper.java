/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.frontend.breadcrumb;

import de.hybris.platform.commerceservices.helper.ProductAndCategoryHelper;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.sap.productconfig.services.impl.CPQConfigurableChecker;
import de.hybris.platform.variants.model.VariantProductModel;


public class ProductConfigProductAndCategoryHelper extends ProductAndCategoryHelper
{
	private CPQConfigurableChecker cpqConfigurableChecker;

	@Override
	public ProductModel getBaseProduct(final ProductModel product)
	{
		if ((product instanceof VariantProductModel) && !getCpqConfigurableChecker().isCPQConfiguratorApplicableProduct(product))
		{
			return getBaseProduct(((VariantProductModel) product).getBaseProduct());
		}
		return product;
	}

	protected CPQConfigurableChecker getCpqConfigurableChecker()
	{
		return cpqConfigurableChecker;
	}

	public void setCpqConfigurableChecker(final CPQConfigurableChecker cpqConfigurableChecker)
	{
		this.cpqConfigurableChecker = cpqConfigurableChecker;
	}
}



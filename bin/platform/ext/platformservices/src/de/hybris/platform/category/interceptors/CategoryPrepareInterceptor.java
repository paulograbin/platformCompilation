/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.category.interceptors;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.exceptions.CategoryCircularDependencyException;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.CollectionUtils;


/**
 * {@link PrepareInterceptor} for the {@link CategoryModel}.
 */
public class CategoryPrepareInterceptor implements PrepareInterceptor<CategoryModel>
{
	private CategoryService categoryService;

	private static final Logger LOG = Logger.getLogger(CategoryPrepareInterceptor.class);
	private static final String RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS = "resolved.categories.for.allowed.principals";

	@Override
	public void onPrepare(final CategoryModel categoryModel, final InterceptorContext ctx) throws InterceptorException
	{
		if (ctx.isNew(categoryModel))
		{
			if (!CollectionUtils.isEmpty(categoryModel.getAllowedPrincipals()))
			{
				handleAllowedPrincipals(categoryModel, ctx, false);
			}
		}
		else if (ctx.isModified(categoryModel, CategoryModel.ALLOWEDPRINCIPALS))
		{
			handleAllowedPrincipals(categoryModel, ctx, false);
		}
		else if (ctx.isModified(categoryModel, CategoryModel.CATEGORIES)
				|| ctx.isModified(categoryModel, CategoryModel.SUPERCATEGORIES))
		{
			handleCategoriesAndSuperCategories(categoryModel, ctx);
		}
	}

	private void handleCategoriesAndSuperCategories(final CategoryModel categoryModel, final InterceptorContext ctx)
			throws CategoryCircularDependencyException
	{
		if (ctx.isModified(categoryModel, CategoryModel.CATEGORIES) && ctx.isModified(categoryModel, CategoryModel.SUPERCATEGORIES) && (hasCycle(categoryModel)))
		{
			throw new CategoryCircularDependencyException("Category loop dependency for category " + categoryModel.getCode());
		}
		handleCategoriesOrSuperCategories(categoryModel, ctx);
	}

	private void handleCategoriesOrSuperCategories(final CategoryModel categoryModel, final InterceptorContext ctx)
			throws CategoryCircularDependencyException
	{
		if (((ctx.isModified(categoryModel, CategoryModel.CATEGORIES)
				|| ctx.isModified(categoryModel, CategoryModel.SUPERCATEGORIES))
				&& (hasCycle(categoryModel, false) || hasCycle(categoryModel, true))))
		{
			throw new CategoryCircularDependencyException("Category loop dependency for category " + categoryModel.getCode());
		}
	}

	/**
	 * Checks if a category has a cycle in its hierarchy.
	 *
	 * @param category
	 *           the category to check for cycles
	 * @return true if a cycle is found, false otherwise
	 */
	private boolean hasCycle(final CategoryModel category)
	{
		final List<CategoryModel> categories = category.getCategories();
		final List<CategoryModel> superCategories = category.getSupercategories();
		// Convert the first list to a set
		Set<CategoryModel> categoryModelSet = new HashSet<>(categories);

		// Check if any element in the second list is in the set
		for (CategoryModel cate : superCategories)
		{
			if (categoryModelSet.contains(cate))
			{
				return true;
			}
		}

		// No common elements found
		return false;
	}

	/**
	 * Checks if a category has a cycle in its hierarchy.
	 *
	 * @param category
	 *           the category to check for cycles
	 * @param isLoopSuper
	 *           flag indicating whether to consider supercategories in the cycle check
	 * @return true if a cycle is found, false otherwise
	 */
	private boolean hasCycle(final CategoryModel category, final boolean isLoopSuper)
	{
		Set<CategoryModel> visited = new HashSet<>();
		Set<CategoryModel> stack = new HashSet<>();
		return hasCycleHelper(category, category, null, visited, stack, isLoopSuper);
	}

	/**
	 * Checks if a category has a cycle in its hierarchy.
	 *
	 * @param initialCategory
	 *           the initial category being checked for cycles
	 * @param category
	 *           the current category being checked for cycles
	 * @param originCategory
	 *           the origin category from which the cycle is being checked
	 * @param visited
	 *           a set of visited categories to avoid redundant checks
	 * @param stack
	 *           a set of categories in the current path to detect cycles
	 * @param isLoopSuper
	 *           a flag indicating whether to check supercategories or subcategories
	 * @return true if a cycle is detected, false otherwise
	 */
	private boolean hasCycleHelper(final CategoryModel initialCategory, final CategoryModel category, final CategoryModel originCategory,
			final Set<CategoryModel> visited, final Set<CategoryModel> stack, final boolean isLoopSuper)
	{
		if (stack.contains(category) && isCycleExists(initialCategory, category, originCategory, stack, isLoopSuper))
		{
			return true;
		}
		if (visited.contains(category))
		{
			return false; // Already visited. No need to check again
		}

		visited.add(category);
		stack.add(category);
		final List<CategoryModel> categories = isLoopSuper ? category.getSupercategories() : category.getCategories();

		if (categories == null)
		{
			stack.remove(category);
			return false;
		}

		for (CategoryModel subCategory : categories)
		{
			if (hasCycleHelper(initialCategory, subCategory, category, visited, stack, isLoopSuper))
			{
				return true;
			}
		}

		stack.remove(category);
		return false;
	}

	private boolean isCycleExists(final CategoryModel initialCategory, final CategoryModel category,
			final CategoryModel originCategory, final Set<CategoryModel> stack, final boolean isLoopSuper)
	{
		if (!stack.isEmpty() && initialCategory.equals(category) && originCategory != null
				&& !originCategory.equals(initialCategory))
		{
			final List<CategoryModel> recallCategories = isLoopSuper ? initialCategory.getCategories()
					: initialCategory.getSupercategories();
			if (!recallCategories.contains(originCategory))
			{
				return false; // No cycle detected
			}
		}
		return true; // Cycle detected
	}

	protected void handleAllowedPrincipals(final CategoryModel categoryModel, final InterceptorContext ctx,
			final boolean skipRootSearch)
	{
		final List<PrincipalModel> newPrincipals = categoryModel.getAllowedPrincipals() == null ? Collections.EMPTY_LIST
				: categoryModel.getAllowedPrincipals();
		//no need to call the service method for setting principals only for given category, because it's already set here

		if (!categoryService.isSetAllowedPrincipalsRecursivelyDisabled())
		{
			if (!skipRootSearch && !categoryService.isRoot(categoryModel))
			{
				for (final CategoryModel superCategory : categoryModel.getAllSupercategories())
				{
					if (categoryService.isRoot(superCategory) && ctx.isModified(superCategory, CategoryModel.ALLOWEDPRINCIPALS)
							&& !isCategoryForPrincipalsResolved(superCategory, ctx))
					{
						handleAllowedPrincipals(superCategory, ctx, true); //start processing from modified root
					}
				}
			}

			if (isCategoryForPrincipalsResolved(categoryModel, ctx))
			{
				if (LOG.isDebugEnabled())
				{
					LOG.debug("handling principals for category " + categoryModel.getCode() + "was already done");
					LOG.debug("assigned principals: ");
					categoryModel.getAllowedPrincipals().forEach(e -> LOG.debug(e.getUid()));
				}
			}
			else
			{
				replacePrincipalsForSubCategories(categoryModel, newPrincipals, ctx);
				markCategoryToPrincipalsResolved(categoryModel, ctx);
				addPrincipalsToSuperCategories(categoryModel, newPrincipals, ctx);
			}
		}
	}

	protected void replacePrincipalsForSubCategories(final CategoryModel category, final List<PrincipalModel> newPrincipals,
			final InterceptorContext ctx)
	{
		if (category.getCategories() == null)
		{
			return;
		}
		for (final CategoryModel subCategory : category.getCategories()) //only direct subcategories, not all
		{
			if (isCategoryForPrincipalsResolved(subCategory, ctx))
			{
				continue;
			}

			if (ctx.isModified(subCategory, CategoryModel.ALLOWEDPRINCIPALS))
			{
				//subcategory has modified principals - not copy down - only register to process afterwards
				ctx.registerElement(subCategory);
				continue;
			}
			else
			{
				subCategory.setAllowedPrincipals(newPrincipals);
				ctx.registerElement(subCategory);
				markCategoryToPrincipalsResolved(subCategory, ctx);
			}
			replacePrincipalsForSubCategories(subCategory, subCategory.getAllowedPrincipals(), ctx);
		}
	}

	protected void addPrincipalsToSuperCategories(final CategoryModel category, final List<PrincipalModel> newPrincipals,
			final InterceptorContext ctx)
	{
		if (category.getSupercategories() == null)
		{
			return;
		}
		//get only direct SuperCategories direct and process recursively
		for (final CategoryModel superCategory : category.getSupercategories())
		{
			if (ctx.isModified(superCategory, CategoryModel.ALLOWEDPRINCIPALS)
					&& !isCategoryForPrincipalsResolved(superCategory, ctx))
			{
				replacePrincipalsForSubCategories(superCategory, superCategory.getAllowedPrincipals(), ctx);
			}

			final Set<PrincipalModel> principals = superCategory.getAllowedPrincipals() == null ? new HashSet<>()
					: new HashSet(superCategory.getAllowedPrincipals());
			principals.addAll(newPrincipals);
			superCategory.setAllowedPrincipals(new ArrayList<>(principals));
			ctx.registerElement(superCategory);
			markCategoryToPrincipalsResolved(superCategory, ctx);

			addPrincipalsToSuperCategories(superCategory, superCategory.getAllowedPrincipals(), ctx);
		}
	}

	protected void markCategoryToPrincipalsResolved(final CategoryModel category, final InterceptorContext ctx)
	{
		final Set<CategoryModel> resolvedCategories = ctx.getAttribute(RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS) == null
				? new HashSet<>()
				: new HashSet((Collection) ctx.getAttribute(RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS));

		resolvedCategories.add(category);
		ctx.setAttribute(RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS, resolvedCategories);
	}

	protected boolean isCategoryForPrincipalsResolved(final CategoryModel category, final InterceptorContext ctx)
	{
		if (ctx.getAttribute(RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS) == null)
		{
			return false;
		}
		return ((Set<CategoryModel>) ctx.getAttribute(RESOLVED_CATEGORIES_FOR_ALLOWED_PRINCIPALS)).contains(category);
	}

	@Required
	public void setCategoryService(final CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

}

/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.category.interceptors;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.util.AssertionErrors.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.jalo.Catalog;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.daos.CategoryDao;
import de.hybris.platform.category.exceptions.CategoryCircularDependencyException;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.internal.model.impl.DefaultModelServiceInterceptorContext;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;


@IntegrationTest
public class CategoryPrepareInterceptorIntegrationTest extends ServicelayerTransactionalTest
{
	@Resource
	private ModelService modelService;
	@Resource
	CategoryService categoryService;
	@Resource
	CategoryDao categoryDao;
	@InjectMocks
	private final CategoryPrepareInterceptor categoryPrepareInterceptor = new CategoryPrepareInterceptor();

	private CategoryModel a;
	private CategoryModel b;
	private CategoryModel c;
	private CatalogModel catalog;
	private CatalogVersionModel catalogVersion;

	@Before
	public void setUp() throws Exception
	{
		catalog = new CatalogModel("testCatalog");
        modelService.save(catalog);
        catalogVersion = new CatalogVersionModel(catalog, "stages");
		modelService.save(catalogVersion);
		a = new CategoryModel(catalogVersion, "a");
		b = new CategoryModel(catalogVersion, "b");
		c = new CategoryModel(catalogVersion, "c");
		modelService.saveAll(a,b,c);
	}

	@After
	public void tearDown() throws Exception
	{
		a.setSupercategories(Arrays.asList());
		a.setCategories(Arrays.asList());
		b.setCategories(Arrays.asList());
		c.setCategories(Arrays.asList());
		modelService.saveAll(a,b,c);
		modelService.remove(a);
		modelService.remove(b);
		modelService.remove(c);
        modelService.remove(catalogVersion);
		modelService.remove(catalog);
	}

	@Test
	public void shouldNotThrowInterceptorExceptionWhenCategoryHasNoSupercategories()
	{
		// given
		try
		{
			final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
			doReturn(false).when(ctx).isModified(a, CategoryModel.SUPERCATEGORIES);
			categoryPrepareInterceptor.onPrepare(a, ctx);
		}
		catch (final InterceptorException e)
		{
			// then
			fail("should not throw InterceptorException");
		}
	}

	@Test
	public void shouldNotThrowInterceptorExceptionWhenCategoryCase1()
	{
		// given
		try
		{
			a.setCategories(Arrays.asList(b));
			modelService.save(a);
			a.setCategories(Arrays.asList());
			a.setSupercategories(Arrays.asList(b));
			final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
			doReturn(true).when(ctx).isModified(a, CategoryModel.CATEGORIES);
			doReturn(true).when(ctx).isModified(a, CategoryModel.SUPERCATEGORIES);
			categoryPrepareInterceptor.onPrepare(a, ctx);
		}
		catch (final InterceptorException e)
		{
			// then
			fail("should not throw InterceptorException");
		}
	}

	@Test
	public void shouldNotThrowInterceptorExceptionWhenCategoryCase2()
	{
		// given
		try
		{
			a.setCategories(Arrays.asList(b));
			b.setCategories(Arrays.asList(c));
			modelService.saveAll(a,b,c);
			c.setSupercategories(Arrays.asList());
			c.setCategories(Arrays.asList(a));
			final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
			doReturn(true).when(ctx).isModified(c, CategoryModel.CATEGORIES);
			doReturn(true).when(ctx).isModified(c, CategoryModel.SUPERCATEGORIES);
			categoryPrepareInterceptor.onPrepare(c, ctx);
		}
		catch (final InterceptorException e)
		{
			// then
			fail("should not throw InterceptorException");
		}
	}

	@Test(expected = CategoryCircularDependencyException.class)
	public void shouldThrowInterceptorExceptionWhenCategoryHasSupercategories() throws InterceptorException
	{
		// given
		a.setSupercategories(Arrays.asList(a));
		final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
		doReturn(true).when(ctx).isModified(a, CategoryModel.SUPERCATEGORIES);
		categoryPrepareInterceptor.onPrepare(a, ctx);
	}

	@Test(expected = CategoryCircularDependencyException.class)
	public void shouldThrowInterceptorExceptionWhenCategoryHasSubcategoriesCase1() throws InterceptorException
	{
		// given
		a.setCategories(Arrays.asList(a));
		final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
		doReturn(true).when(ctx).isModified(a, CategoryModel.CATEGORIES);
		categoryPrepareInterceptor.onPrepare(a, ctx);
	}

	@Test(expected = CategoryCircularDependencyException.class)
	public void shouldThrowInterceptorExceptionWhenCategoryHasSubcategoriesCase2() throws InterceptorException
	{
		// given
		a.setCategories(Arrays.asList(b));
		a.setCategories(Arrays.asList(a));
		final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
		doReturn(true).when(ctx).isModified(a, CategoryModel.CATEGORIES);
		categoryPrepareInterceptor.onPrepare(a, ctx);
	}

	@Test(expected = CategoryCircularDependencyException.class)
	public void shouldThrowInterceptorExceptionWhenCategoryHasSubcategoriesCase3() throws InterceptorException
	{
		// given
		a.setCategories(Arrays.asList(b));
		b.setCategories(Arrays.asList(c));
		c.setCategories(Arrays.asList(b));
		final InterceptorContext ctx = mock(DefaultModelServiceInterceptorContext.class);
		doReturn(true).when(ctx).isModified(a, CategoryModel.CATEGORIES);
		categoryPrepareInterceptor.onPrepare(a, ctx);
	}
}

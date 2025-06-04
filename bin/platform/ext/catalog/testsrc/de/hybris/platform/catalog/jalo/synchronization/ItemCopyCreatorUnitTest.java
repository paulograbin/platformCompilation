/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.jalo.synchronization;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.SynchronizationPersistenceAdapter;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.RuntimeSQLException;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.persistence.hjmp.HJMPUtils;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.util.Utilities;

import java.sql.SQLException;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.DuplicateKeyException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ItemCopyCreatorUnitTest
{
	@Mock
	private GenericCatalogCopyContext genericCatalogCopyContext;
	@Mock
	private TypeCopyDescriptor typeCopyDescriptor;
	@Mock
	private SynchronizationPersistenceAdapter<Item, ComposedType> persistenceAdapter;

	@Mock
	private ItemCopyCreator parent;
	@Mock
	private Item source;
	@Mock
	private Transaction transaction;
	@Mock
	private ComposedType composedType;

	@Before
	public void setUp()
	{
		when(genericCatalogCopyContext.isDebugEnabled()).thenReturn(false);
		when(genericCatalogCopyContext.getTypeCopyDescriptor(any())).thenReturn(typeCopyDescriptor);
		when(genericCatalogCopyContext.getPersistenceAdapter()).thenReturn(persistenceAdapter);
	}

	@Test
	public void shouldReThrowDuplicateKeyExceptionIfHasParent()
	{
		//given
		final var subject = new ItemCopyCreator(genericCatalogCopyContext, parent, source, null, null, null, Collections.emptyMap());
		final var errorMsg = "duplicate key error message";

		when(composedType.getCode()).thenReturn(ProductModel._TYPECODE);
		when(source.getPK()).thenReturn(PK.createUUIDPK(1));
		when(source.getComposedType()).thenReturn(composedType);

		try (final MockedStatic<Transaction> transactionStatic = Mockito.mockStatic(Transaction.class))
		{
			//given
			transactionStatic.when(Transaction::current).thenReturn(transaction);
			when(transaction.isRunning()).thenReturn(true);

			when(typeCopyDescriptor.getInitial(anyBoolean(), any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getPartOf(any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getOther(any(), any())).thenReturn(Collections.emptySet());

			final var duplicateKeyException = new DuplicateKeyException(errorMsg);
			final var runtimeSQLException = new RuntimeSQLException(duplicateKeyException, "sql error");
			when(persistenceAdapter.create(any(), any())).thenThrow(runtimeSQLException);

			//when
			subject.copy();
			Assert.fail("Should throw an exception");
		}
		catch (final JaloSystemException e)
		{
			//then
			Assert.assertEquals("An exception occurred during synchronization for item: " + source.getPK() + " of type: "
				+ source.getComposedType().getCode(), e.getMessage());
			final var rootCauseOfType = Utilities.getRootCauseOfType(e, DuplicateKeyException.class);
			Assert.assertNotNull(rootCauseOfType);
			Assert.assertTrue(rootCauseOfType instanceof DuplicateKeyException);

			final var duplicateKeyException = (DuplicateKeyException) rootCauseOfType;
			Assert.assertNotNull(duplicateKeyException.getMessage());
			Assert.assertEquals(errorMsg, duplicateKeyException.getMessage());
		}
	}

	@Test
	public void shouldCreateAlternativeErrorMessageWhenComposedTypeThrowsException()
	{
		//given
		final var subject = new ItemCopyCreator(genericCatalogCopyContext, parent, source, null, null, null, Collections.emptyMap());

		when(composedType.getCode()).thenThrow(new RuntimeException("get composed type code error"));
		when(source.getPK()).thenReturn(PK.createUUIDPK(1));
		when(source.getComposedType()).thenReturn(composedType);

		try (final MockedStatic<Transaction> transactionStatic = Mockito.mockStatic(Transaction.class);
			 final MockedStatic<HJMPUtils> hjmpUtils = Mockito.mockStatic(HJMPUtils.class))
		{
			//given
			transactionStatic.when(Transaction::current).thenReturn(transaction);
			when(transaction.isRunning()).thenReturn(true);


			when(typeCopyDescriptor.getInitial(anyBoolean(), any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getPartOf(any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getOther(any(), any())).thenReturn(Collections.emptySet());

			when(typeCopyDescriptor.getInitial(anyBoolean(), any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getPartOf(any(), any())).thenReturn(Collections.emptySet());
			when(typeCopyDescriptor.getOther(any(), any())).thenReturn(Collections.emptySet());

			final var sqlException = new SQLException("sql exception deadlock");
			final var deadlockException = new DeadlockLoserDataAccessException("deadlock exception error", sqlException);
			when(persistenceAdapter.create(any(), any())).thenThrow(deadlockException);

			hjmpUtils.when(HJMPUtils::isOptimisticLockingEnabled).thenReturn(true);
			hjmpUtils.when(() -> HJMPUtils.isConcurrentModificationException(any(JaloSystemException.class))).thenReturn(true);

			//when
			subject.copy();
			Assert.fail("Should throw an exception");
		}
		catch (final Exception e)
		{
			//then
			Assert.assertTrue(e instanceof JaloSystemException);
			Assert.assertNotNull(e.getMessage());
			Assert.assertEquals("An exception occurred during synchronization for item: " + source.getPK(), e.getMessage());

			final var rootCauseOfType = Utilities.getRootCauseOfType(e, DeadlockLoserDataAccessException.class);
			Assert.assertNotNull(rootCauseOfType);
			Assert.assertTrue(rootCauseOfType instanceof DeadlockLoserDataAccessException);

			final var deadlockException = (DeadlockLoserDataAccessException) rootCauseOfType;
			Assert.assertNotNull(deadlockException.getMessage());
			Assert.assertTrue(deadlockException.getMessage().contains("deadlock exception error"));
		}
	}
}

package de.hybris.platform.testframework.runlistener;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import org.junit.Test;
import org.mockito.Mockito;

@IntegrationTest
public class ItemCreationListenerTest extends ServicelayerBaseTest
{
	@Test
	public void shouldAddItemToCreationListWhenTransactionIsDisabled()
	{
		final PK pk = PK.fromLong(1);
		final ItemCreationListener itemCreationListener = new ItemCreationListener();
		itemCreationListener.entityCreated(pk);
		assertThat(itemCreationListener.isTransactionDisabled()).isTrue();

		assertThat(itemCreationListener.getCreatedPKs()).containsOnly(pk);
	}

	@Test
	public void shouldAddItemToCreationListWhenTransactionIsEnabledButDiffrentThreadIsUsed()
	{

		final PK pk = PK.fromLong(1);
		final ItemCreationListener itemCreationListener1 = Mockito.spy(new ItemCreationListener());

		Mockito.doReturn(false)
		       .when(itemCreationListener1).isTransactionDisabled();

		Mockito.doReturn(true)
		       .when(itemCreationListener1).isDifferentThread();

		itemCreationListener1.entityCreated(pk);
		assertThat(itemCreationListener1.getCreatedPKs()).containsOnly(pk);
	}

	@Test
	public void shouldNotAddItemToCreationListIfItemIsBackedByEJBRepositoryAndTransactionIsEnabled()
	{
		final PK pk = PK.fromLong(1);
		final ItemCreationListener itemCreationListener1 = Mockito.spy(new ItemCreationListener());
		Mockito.doReturn(false)
		       .when(itemCreationListener1).isDifferentThread();
		Mockito.doReturn(false)
		       .when(itemCreationListener1).isTransactionDisabled();
		Mockito.doReturn(false)
		       .when(itemCreationListener1).existInPolyglotPersistenceButIsNotBackedByTransactionalRepository(pk);

		itemCreationListener1.entityCreated(pk);
		assertThat(itemCreationListener1.getCreatedPKs()).isEmpty();
	}

	@Test
	public void shouldAddItemToCreationListIfTransactionIsEnabledButItemIsNotBackedByTransactionRepo()
	{

		final PK polyglotItemBackedByTransactionalRepo = PK.fromLong(1);
		final PK polyglotItemNotBackedByTransactionalRepo = PK.fromLong(2);

		final ItemCreationListener itemCreationListener1 = Mockito.spy(new ItemCreationListener());

		Mockito.doReturn(false)
		       .when(itemCreationListener1).isDifferentThread();
		Mockito.doReturn(false)
		       .when(itemCreationListener1).isTransactionDisabled();

		Mockito.doReturn(true)
		       .when(itemCreationListener1)
		       .existInPolyglotPersistenceButIsNotBackedByTransactionalRepository(polyglotItemBackedByTransactionalRepo);
		Mockito.doReturn(false)
		       .when(itemCreationListener1)
		       .existInPolyglotPersistenceButIsNotBackedByTransactionalRepository(polyglotItemNotBackedByTransactionalRepo);

		itemCreationListener1.entityCreated(polyglotItemNotBackedByTransactionalRepo);
		itemCreationListener1.entityCreated(polyglotItemBackedByTransactionalRepo);

		assertThat(itemCreationListener1.getCreatedPKs()).containsOnly(polyglotItemBackedByTransactionalRepo);

	}

}

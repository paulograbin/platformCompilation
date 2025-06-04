/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.catalog.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.jalo.type.AttributeDescriptor;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jdbcwrapper.HybrisDataSource;
import de.hybris.platform.persistence.property.PersistenceManager;
import de.hybris.platform.persistence.property.TypeInfoMap;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultModelDBUtilsServiceUnitTest
{

	@InjectMocks
	private DefaultModelDBUtilsService testee;

	@Mock
	private TypeService typeService;

	@Mock
	private ModelService modelService;

	@Test
	public void shouldNotComputeColumnSizeWhenColumnSizeIsAlreadyCached() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final ResultSet resultSetForGetColumns = mockResultSetForGetColumns(10);
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumns(resultSetForGetColumns);
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(false);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			mockModelService("testDbColumn", false);

			// when
			final long firstResult = testee.findColumnSize("testType", "testQualifier");
			final long secondResult = testee.findColumnSize("testType", "testQualifier");

			// then
			assertThat(firstResult)
					.isEqualTo(secondResult)
					.isEqualTo(10);
			verify(databaseMetaDataForGetColumns).getColumns(anyString(), anyString(), anyString(), anyString());
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionWhenQualifierHasNoColumnInCorrespondingTable() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final ResultSet resultSetForGetColumns = mockResultSetForGetColumns(10);
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumns(resultSetForGetColumns);
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(false);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			mockModelService(null, false);

			// when
			final ThrowableAssert.ThrowingCallable throwingCallable = () -> testee.findColumnSize("testType", "testQualifier");

			// then
			assertThatThrownBy(throwingCallable)
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Qualifier testQualifier has no column in corresponding testTable table.");
		}
	}

	@Test
	public void shouldReturnZeroWhenSQLExceptionIsThrownUponColumnRetrieval() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumnsWithSQLException();
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(false);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			mockModelService("testDbColumn", false);

			// when
			final long result = testee.findColumnSize("testType", "testQualifier");

			// then
			assertThat(result)
					.isZero();
		}
	}

	@Test
	public void shouldReturnZeroWhenColumnIsNotFoundInDatabaseTable() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final ResultSet resultSetForGetColumns = mockResultSetForGetColumns(null);
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumns(resultSetForGetColumns);
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(false);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			mockModelService("testDbColumn", false);

			// when
			final long result = testee.findColumnSize("testType", "testQualifier");

			// then
			assertThat(result)
					.isZero();
		}
	}

	@Test
	public void shouldReturnColumnSizeInTableStoredInTypeUtilizingJDBCAPI() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final ResultSet resultSetForGetColumns = mockResultSetForGetColumns(10);
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumns(resultSetForGetColumns);
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(false);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			final ComposedTypeModel composedTypeModel = mockTypeService();
			mockModelService("testDbColumn", false);

			// when
			final long columnSize = testee.findColumnSize("testType", "testQualifier");

			// then
			assertThat(columnSize)
					.isEqualTo(10);
			verify(typeService).getComposedTypeForCode("testType");
			verify(modelService).getSource(composedTypeModel);
			verify(databaseMetaDataForGetColumns).getColumns("testCatalog", "testSchema", "TESTTABLE", "TESTDBCOLUMN");
			verify(resultSetForGetColumns).next();
			verify(resultSetForGetColumns).getInt("COLUMN_SIZE");
		}
	}

	@Test
	public void shouldReturnColumnSizeInLpTableDerivedFromTableStoredInTypeUtilizingJDBCAPI() throws SQLException
	{
		// given
		try (final MockedStatic<Registry> registryMockedStatic = mockStatic(Registry.class))
		{
			final ResultSet resultSetForGetColumns = mockResultSetForGetColumns(20);
			final DatabaseMetaData databaseMetaDataForGetColumns = mockDatabaseMetaDataForGetColumns(resultSetForGetColumns);
			final Connection connection = mockConnection(databaseMetaDataForGetColumns);
			final HybrisDataSource hybrisDataSource = mockHybrisDataSource(
					connection);
			final Tenant tenant = mockTenant(
					hybrisDataSource);
			registryMockedStatic.when(Registry::getCurrentTenant)
			                    .thenReturn(tenant);
			final PersistenceManager persistenceManager = mockPersistenceManager(true);
			registryMockedStatic.when(Registry::getPersistenceManager)
			                    .thenReturn(persistenceManager);
			final ComposedTypeModel composedTypeModel = mockTypeService();
			mockModelService("testDbColumn", true);

			// when
			final long columnSize = testee.findColumnSize("testType", "testQualifier");

			// then
			assertThat(columnSize)
					.isEqualTo(20);
			verify(typeService).getComposedTypeForCode("testType");
			verify(modelService).getSource(composedTypeModel);
			verify(databaseMetaDataForGetColumns).getColumns("testCatalog", "testSchema", "TESTTABLELP", "TESTDBCOLUMN");
			verify(resultSetForGetColumns).next();
			verify(resultSetForGetColumns).getInt("COLUMN_SIZE");
		}
	}

	private PersistenceManager mockPersistenceManager(final boolean localized)
	{
		final PersistenceManager persistenceManager = mock(PersistenceManager.class);
		final TypeInfoMap typeInfoMap = mock(TypeInfoMap.class);
		if (localized)
		{
			when(typeInfoMap.getTableName(anyBoolean()))
					.thenReturn("testTablelp");
		}
		else
		{
			when(typeInfoMap.getItemTableName())
					.thenReturn("testTable");
		}
		when(persistenceManager.getPersistenceInfo(anyString()))
				.thenReturn(typeInfoMap);
		return persistenceManager;
	}

	private ResultSet mockResultSetForGetColumns(final Integer getIntResult) throws SQLException
	{
		final ResultSet getColumnsResultSet = mock(ResultSet.class);
		when(getColumnsResultSet.next())
				.thenReturn(true);
		if (getIntResult != null)
		{
			when(getColumnsResultSet.getInt(anyString()))
					.thenReturn(getIntResult);
		}
		return getColumnsResultSet;
	}

	private DatabaseMetaData mockDatabaseMetaDataForGetColumns(final ResultSet resultSet)
			throws SQLException
	{
		final DatabaseMetaData databaseMetaData = mock(DatabaseMetaData.class);
		when(databaseMetaData.getColumns(anyString(), anyString(), anyString(), anyString()))
				.thenReturn(resultSet);

		return databaseMetaData;
	}

	private DatabaseMetaData mockDatabaseMetaDataForGetColumnsWithSQLException()
			throws SQLException
	{
		final DatabaseMetaData databaseMetaData = mock(DatabaseMetaData.class);
		when(databaseMetaData.getColumns(anyString(), anyString(), anyString(), nullable(String.class)))
				.thenThrow(SQLException.class);
		return databaseMetaData;
	}

	private Connection mockConnection(final DatabaseMetaData... databaseMetaData) throws SQLException
	{
		final Connection connection = mock(Connection.class);
		when(connection.getMetaData())
				.thenAnswer(AdditionalAnswers.returnsElementsOf(List.of(databaseMetaData)));
		when(connection.getCatalog())
				.thenReturn("testCatalog");
		return connection;
	}

	private HybrisDataSource mockHybrisDataSource(final Connection connection) throws SQLException
	{
		final HybrisDataSource hybrisDataSource = mock(HybrisDataSource.class);
		when(hybrisDataSource.getConnection())
				.thenReturn(connection);
		when(hybrisDataSource.getSchemaName())
				.thenReturn("testSchema");
		return hybrisDataSource;
	}

	private Tenant mockTenant(final HybrisDataSource hybrisDataSource)
	{
		final Tenant tenant = mock(Tenant.class);
		when(tenant.getDataSource())
				.thenReturn(hybrisDataSource);
		return tenant;
	}

	private void mockModelService(final String databaseColumnName, final boolean localized)
	{
		final AttributeDescriptor attributeDescriptor = mock(AttributeDescriptor.class);
		when(attributeDescriptor.getDatabaseColumn())
				.thenReturn(databaseColumnName);
		when(attributeDescriptor.isLocalized())
				.thenReturn(localized);
		final ComposedType composedType = mock(ComposedType.class);
		when(composedType.getAttributeDescriptorIncludingPrivate(anyString()))
				.thenReturn(attributeDescriptor);
		when(modelService.getSource(any()))
				.thenReturn(composedType);
	}

	private ComposedTypeModel mockTypeService()
	{
		final ComposedTypeModel composedTypeModel = mock(ComposedTypeModel.class);
		when(typeService.getComposedTypeForCode(anyString()))
				.thenReturn(composedTypeModel);
		return composedTypeModel;
	}

}

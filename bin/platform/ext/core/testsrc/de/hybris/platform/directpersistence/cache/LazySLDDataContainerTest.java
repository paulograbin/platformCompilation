/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.directpersistence.cache;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class LazySLDDataContainerTest
{
	@Mock
	SLDDataContainerProvider sldDataContainerProviderMock;
	static final PK TEST_ITEM_PK = PK.fromLong(50);
	static final PK TEST_ITEM_TYPE_PK = PK.fromLong(100);

	private static final List<Pair<String, Class<?>[]>> EXCLUDED_METHODS_NAMES = List.of(Pair.of("getPk", new Class<?>[0]));
	private static final Predicate<Method> IS_DECLARED_IN_SLD_DATA_CONTAINER = method -> method.getDeclaringClass()
	                                                                                           .equals(SLDDataContainer.class);
	private static final Predicate<Method> IS_DECLARED_IN_LAZY_SLD_DATA_CONTAINER = method -> method.getDeclaringClass()
	                                                                                                .equals(LazySLDDataContainer.class);
	private static final Predicate<Method> IS_PUBLIC_NON_STATIC_METHOD = method -> Modifier.isPublic(
			method.getModifiers()) && !Modifier.isStatic(method.getModifiers());

	private static final Predicate<Method> EXCLUDED_FROM_CHECK = method -> EXCLUDED_METHODS_NAMES.stream()
	                                                                                             .noneMatch(
			                                                                                             pair -> pair.getLeft()
			                                                                                                         .equals(method.getName())
					                                                                                             && Arrays.equals(
					                                                                                             pair.getRight(),
					                                                                                             method.getParameterTypes()));


	/**
	 * This test assures that for each method defined in the parent class - {@link SLDDataContainer}, there is a corresponding
	 * method in the {@link LazySLDDataContainer} class that delegates the call to the wrapped container.
	 * This is necessary to ensure that the {@link LazySLDDataContainer} class is a proper and fully working decorator that
	 * delegates all additional methods of SLDDataContainer to the wrapped container.
	 * </br>
	 * If you add new public method to the {@link SLDDataContainer} you should
	 * add an implementation to the {@link LazySLDDataContainer} that delegates the call to the wrapped container
	 * unless we have data available without additional loading.
	 * <p>
	 * {@link LazySLDDataContainer} is used for DB Auditing to avoid unnecessary loading of data from the database.
	 */
	@Test
	public void shouldOverrideAndDelegateAllPublicNonStaticMethodsFromSLDDataContainer()
	{
		//Method name with number of method parameters that should be excluded from the test


		final List<Method> lazySLDDataContainerMethods = Stream.of(LazySLDDataContainer.class.getMethods())
		                                                       .filter(IS_DECLARED_IN_LAZY_SLD_DATA_CONTAINER)
		                                                       .filter(IS_PUBLIC_NON_STATIC_METHOD)
		                                                       .toList();

		final List<Method> sldDataContainerMethods = Stream.of(SLDDataContainer.class.getMethods())
		                                                   .filter(IS_DECLARED_IN_SLD_DATA_CONTAINER)
		                                                   .filter(IS_PUBLIC_NON_STATIC_METHOD)
		                                                   .filter(EXCLUDED_FROM_CHECK)
		                                                   .toList();

		for (final Method sldDataContainerMethod : sldDataContainerMethods)
		{
			boolean isOverridden = false;
			for (final Method lazySLDDataContainerMethod : lazySLDDataContainerMethods)
			{
				if (sldDataContainerMethod.getName().equals(lazySLDDataContainerMethod.getName()) &&
						Arrays.equals(sldDataContainerMethod.getParameterTypes(), lazySLDDataContainerMethod.getParameterTypes()))
				{
					isOverridden = true;
					break;
				}
			}
			assertTrue("Method " + sldDataContainerMethod.getName() + " is not overridden in LazySLDDataContainer", isOverridden);
		}
	}

	@Test
	public void shouldNotCallWrappedContainerWhenFetchingTypePkOrItemPk()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);

		//when
		final PK itemPk = lazySLDDataContainer.getPk();
		final PK itemTypePk = lazySLDDataContainer.getTypePk();

		//then
		assertThat(itemPk).isEqualTo(TEST_ITEM_PK);
		assertThat(itemTypePk).isEqualTo(TEST_ITEM_TYPE_PK);
		verify(sldDataContainerProviderMock, never()).get(any(PK.class));
	}

	@Test
	public void shouldCallFetchWrappedContainerWhenItemTypePkNotSpecified()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, null,
				sldDataContainerProviderMock);
		final PK fetchedItemTypePk = PK.fromLong(250);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);
		given(mockedWrappedContainer.getTypePk()).willReturn(fetchedItemTypePk);

		//when
		final PK itemTypePk = lazySLDDataContainer.getTypePk();

		//then
		assertThat(itemTypePk).isEqualTo(fetchedItemTypePk);
	}

	@Test
	public void shouldFetchWrappedSldContainerOnlyOnce()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, null,
				sldDataContainerProviderMock);
		final PK fetchedItemTypePk = PK.fromLong(250);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);
		given(mockedWrappedContainer.getTypePk()).willReturn(fetchedItemTypePk);

		//when
		final PK itemTypePk = lazySLDDataContainer.getTypePk();
		final PK itemTypePk2 = lazySLDDataContainer.getTypePk();

		//then
		assertThat(itemTypePk).isEqualTo(fetchedItemTypePk);
		assertThat(itemTypePk2).isEqualTo(fetchedItemTypePk);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(2)).getTypePk();
	}

	@Test
	public void shouldDelegateGetTypeCodeToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		final String fetchedTypeCode = "testTypeCode";
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);
		given(mockedWrappedContainer.getTypeCode()).willReturn(fetchedTypeCode);

		//when
		final String typeCode = lazySLDDataContainer.getTypeCode();

		//then
		assertThat(typeCode).isEqualTo(fetchedTypeCode);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getTypeCode();
	}

	@Test
	public void shouldDelegateGetVersionToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		final long fetchedVersion = 123L;
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);
		given(mockedWrappedContainer.getVersion()).willReturn(fetchedVersion);

		//when
		final long version = lazySLDDataContainer.getVersion();

		//then
		assertThat(version).isEqualTo(fetchedVersion);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getVersion();
	}

	@Test
	public void shouldDelegateGetAllAttributesToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);

		final List<SLDDataContainer.AttributeValue> attributeValueList = List.of(
				new SLDDataContainer.AttributeValue("attr1", "value1"));
		given(mockedWrappedContainer.getAllAttributes()).willReturn(attributeValueList);

		//when
		final List<SLDDataContainer.AttributeValue> attributes = lazySLDDataContainer.getAllAttributes();

		//then
		assertThat(attributes).isEqualTo(attributeValueList);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getAllAttributes();
	}

	@Test
	public void shouldDelegateGetAllLocalizedAttributesToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);

		final List<SLDDataContainer.AttributeValue> localizedAttributeValueList = List.of(
				new SLDDataContainer.AttributeValue("attr1", "value1"));
		given(mockedWrappedContainer.getAllLocalizedAttributes()).willReturn(localizedAttributeValueList);

		//when
		final List<SLDDataContainer.AttributeValue> localizedAttributes = lazySLDDataContainer.getAllLocalizedAttributes();

		//then
		assertThat(localizedAttributes).isEqualTo(localizedAttributeValueList);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getAllLocalizedAttributes();
	}

	@Test
	public void shouldDelegateGetAllPropertyValuesToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);

		final List<SLDDataContainer.AttributeValue> propertyValueList = List.of(
				new SLDDataContainer.AttributeValue("attr1", "value1"));
		given(mockedWrappedContainer.getAllPropertyValues()).willReturn(propertyValueList);

		//when
		final List<SLDDataContainer.AttributeValue> propertyValues = lazySLDDataContainer.getAllPropertyValues();

		//then
		assertThat(propertyValues).isEqualTo(propertyValueList);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getAllPropertyValues();
	}

	@Test
	public void shouldDelegateGetAttributeValueToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);

		//and
		final PK langPk = PK.fromLong(300);
		final String attributeName = "attr1";
		final String attribValue = "value1";

		//and
		final SLDDataContainer.AttributeValue attributeValue = new SLDDataContainer.AttributeValue(attributeName, attribValue);
		given(mockedWrappedContainer.getAttributeValue(attributeName, langPk)).willReturn(attributeValue);

		//when
		final SLDDataContainer.AttributeValue attribute = lazySLDDataContainer.getAttributeValue(attributeName, langPk);

		//then
		assertThat(attribute).isEqualTo(attributeValue);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getAttributeValue(attributeName, langPk);
	}

	@Test
	public void shouldDelegateGetPropertyValueToWrappedContainer()
	{
		//given
		final LazySLDDataContainer lazySLDDataContainer = new LazySLDDataContainer(TEST_ITEM_PK, TEST_ITEM_TYPE_PK,
				sldDataContainerProviderMock);
		//and
		final SLDDataContainer mockedWrappedContainer = mock(SLDDataContainer.class);
		given(sldDataContainerProviderMock.get(TEST_ITEM_PK)).willReturn(mockedWrappedContainer);

		//and
		final PK langPk = PK.fromLong(300);
		final String propertyName = "prop1";
		final String propValue = "value1";

		//and
		final SLDDataContainer.AttributeValue propertyValue = new SLDDataContainer.AttributeValue(propertyName, propValue);
		given(mockedWrappedContainer.getPropertyValue(propertyName, langPk)).willReturn(propertyValue);

		//when
		final SLDDataContainer.AttributeValue property = lazySLDDataContainer.getPropertyValue(propertyName, langPk);

		//then
		assertThat(property).isEqualTo(propertyValue);
		verify(sldDataContainerProviderMock, times(1)).get(TEST_ITEM_PK);
		verify(mockedWrappedContainer, times(1)).getPropertyValue(propertyName, langPk);
	}
}

/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.jalo;


import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.jalo.security.JaloSecurityException;
import de.hybris.platform.jalo.type.AttributeDescriptor;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloTypeException;
import de.hybris.platform.jalo.type.ReflectionAttributeAccess;
import de.hybris.platform.util.SingletonCreator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class ItemToStringTest
{
	@Spy
	private Item item = new GenericItem();

	@Mock
	private ComposedType composedType;

	@Mock
	private AttributeDescriptor attrib;

	@Mock
	private ReflectionAttributeAccess attribAccess;

	@Mock
	private Tenant tenant;

	@Test
	public void shouldNotCallFindForNonexistentAttribute()
	{
		// given
		doReturn(composedType).when(item).getComposedType();
		doNothing().when(item).assureExtensionsLoaded();
		doReturn(Boolean.FALSE).when(composedType).hasAttribute("code");
		doReturn(tenant).when(item).getTenant();
		doReturn(new SingletonCreator()).when(tenant).getSingletonCreator();
		doReturn(PK.fromLong(1L)).when(item).getPK();

		//when
		String itemString = item.toString();

		//then
		assertThat(itemString).isEqualTo("1");
		verify(composedType, Mockito.never()).getAttributeDescriptorIncludingPrivate("code");
	}

	@Test
	public void shouldCallFindForExistingAttribute() throws JaloTypeException, JaloSecurityException
	{
		// given
		doReturn("code").when(attrib).getQualifier();
		doReturn(composedType).when(attrib).getEnclosingType();
		doReturn("super").when(composedType).getCode();
		doReturn(composedType).when(item).getComposedType();
		doNothing().when(item).assureExtensionsLoaded();
		doReturn(Boolean.TRUE).when(composedType).hasAttribute("code");
		doReturn(attrib).when(composedType).getAttributeDescriptorIncludingPrivate("code");
		doReturn(tenant).when(item).getTenant();
		doReturn(new SingletonCreator()).when(tenant).getSingletonCreator();
		doReturn(PK.fromLong(1L)).when(item).getPK();
		doReturn("code").when(attribAccess).getValue(any(), eq(item));

		String itemString;
		try (MockedStatic<ReflectionAttributeAccess> mockedReflectionAttributeAccess = Mockito.mockStatic(
				ReflectionAttributeAccess.class))
		{
			mockedReflectionAttributeAccess.when(
							() -> ReflectionAttributeAccess.createReflectionAccess(tenant, GenericItem.class, attrib))
					.thenReturn(attribAccess);

			//when
			itemString = item.toString();
		}

		//then
		assertThat(itemString).isEqualTo("code(1)");
		verify(composedType, Mockito.atLeastOnce()).getAttributeDescriptorIncludingPrivate("code");
	}
}

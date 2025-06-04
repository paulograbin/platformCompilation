/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.persistence.audit.impl;

import static de.hybris.platform.persistence.audit.impl.AuditDataProvider.getSuitableDataContainerFor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.directpersistence.cache.LazySLDDataContainer;
import de.hybris.platform.directpersistence.cache.SLDDataContainer;
import de.hybris.platform.directpersistence.cache.SLDDataContainerProvider;
import de.hybris.platform.persistence.audit.InternalAuditableOperation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class AuditDataProviderTest
{
	@Mock
	private SLDDataContainerProvider mockSlDDataContainerProvider;

	@Test
	public void shouldCallSldDataContainerProviderWhenFullSldContainerRequired()
	{
		//given
		final SLDContainerSelector sldContainerSelector = mock(SLDContainerSelector.class);
		given(sldContainerSelector.calculateIfUseFullSLDContainer()).willReturn(true);
		//and
		final PK itemPk = PK.fromLong(234);
		given(sldContainerSelector.getPkForItem()).willReturn(itemPk);

		//and
		final SLDDataContainer fullSldDataContainer = mock(SLDDataContainer.class);
		given(mockSlDDataContainerProvider.get(itemPk)).willReturn(fullSldDataContainer);

		//when
		final SLDDataContainer returnedContainer = getSuitableDataContainerFor(sldContainerSelector,
				mockSlDDataContainerProvider);

		//then
		assertThat(returnedContainer).isEqualTo(fullSldDataContainer);
	}

	@Test
	public void shouldReturnLazySldContainerWhenFullContainerNotRequired()
	{
		//given
		final SLDContainerSelector sldContainerSelector = mock(SLDContainerSelector.class);
		given(sldContainerSelector.calculateIfUseFullSLDContainer()).willReturn(false);

		//and
		final PK itemPk = PK.fromLong(2456);
		given(sldContainerSelector.getPkForItem()).willReturn(itemPk);
		//and
		final PK itemTypePk = PK.fromLong(2354);
		given(sldContainerSelector.getPkForItemType()).willReturn(itemTypePk);

		//when
		final SLDDataContainer returnedContainer = getSuitableDataContainerFor(sldContainerSelector,
				mockSlDDataContainerProvider);

		//then
		assertThat(returnedContainer).isInstanceOf(LazySLDDataContainer.class);
		assertThat(returnedContainer.getPk()).isEqualTo(itemPk);
		assertThat(returnedContainer.getTypePk()).isEqualTo(itemTypePk);
	}

	@Test
	public void shouldWrapAuditStateChange()
	{
		//given
		final AuditStateData stateDataToWrap = mock(AuditStateData.class);
		final PK itemPk = PK.fromLong(24234);

		//when
		final AuditStateChangeWrapper auditStateChangeWrapper = AuditDataProvider.wrap(stateDataToWrap, itemPk);

		//then
		assertThat(auditStateChangeWrapper).isInstanceOf(SLDContainerSelector.class);
		assertThat(auditStateChangeWrapper.getPkForItem()).isEqualTo(itemPk);
	}

	@Test
	public void shouldWrapInternalAuditableOperation()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);
		final PK itemPk = PK.fromLong(124);
		//and
		given(operationToWrap.getItemPk()).willReturn(itemPk);

		//when
		final InternalAuditableOperationWrapper wrapper = AuditDataProvider.wrap(operationToWrap);

		//then
		assertThat(wrapper).isInstanceOf(SLDContainerSelector.class);
		assertThat(wrapper.getPkForItem()).isEqualTo(itemPk);
	}

}

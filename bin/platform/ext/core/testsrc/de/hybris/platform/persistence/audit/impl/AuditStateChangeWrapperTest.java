/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.persistence.audit.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.directpersistence.cache.SLDDataContainer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class AuditStateChangeWrapperTest
{
	@Test
	public void shouldCalculateUsageOfFullSldContainerBasedOnGDPRAuditFlagForAuditStateData()
	{
		//given
		final AuditStateData stateDataToWrap = mock(AuditStateData.class);
		given(stateDataToWrap.isGDPRAudited()).willReturn(true);

		//when
		final SLDContainerSelector auditStateChangeWrapper = new AuditStateChangeWrapper(stateDataToWrap,
				PK.fromLong(234));

		//then
		assertThat(auditStateChangeWrapper.calculateIfUseFullSLDContainer()).isTrue();
		verify(stateDataToWrap, times(1)).isGDPRAudited();
	}

	@Test
	public void shouldFallbackToContainerWhenItemTypePkForAuditStateChangeWrapperNotSpecified()
	{
		//given
		final AuditStateData stateDataToWrap = mock(AuditStateData.class);
		final SLDDataContainer container = mock(SLDDataContainer.class);
		//and
		final PK itemTypePk = PK.fromLong(124);
		given(container.getTypePk()).willReturn(itemTypePk);
		given(stateDataToWrap.getContainer()).willReturn(container);

		//when
		final PK returnerItemTypePK = AuditDataProvider.wrap(stateDataToWrap, null).getPkForItemType();

		//then
		assertThat(returnerItemTypePK).isEqualTo(itemTypePk);
	}

	@Test
	public void shouldReturnCorrectItemPk(){
		//given
		final PK itemPk = PK.fromLong(234);
		final AuditStateData stateDataToWrap = mock(AuditStateData.class);

		//when
		final PK returnerItemPk = AuditDataProvider.wrap(stateDataToWrap, itemPk).getPkForItem();

		//then
		assertThat(returnerItemPk).isEqualTo(itemPk);
		verifyNoInteractions(stateDataToWrap);

	}

}

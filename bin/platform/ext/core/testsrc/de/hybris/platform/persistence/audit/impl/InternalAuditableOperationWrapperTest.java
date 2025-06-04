/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.persistence.audit.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.type.TypeModel;
import de.hybris.platform.persistence.audit.InternalAuditableOperation;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.type.TypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class InternalAuditableOperationWrapperTest
{
	@Mock
	private TypeService mockTypeService;

	@Test
	public void shouldResolveItemTypePkFromTypeCodeWhenItemTypePkNotSpecified()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);
		final String itemTypeCode = "itemTypeCode";

		//and
		given(operationToWrap.getItemTypePk()).willReturn(null);
		given(operationToWrap.getItemTypeCode()).willReturn(itemTypeCode);
		//and
		final TypeModel mockedTypeModel = mock(TypeModel.class);
		final PK itemTypePk = PK.fromLong(124);
		given(mockedTypeModel.getPk()).willReturn(itemTypePk);
		given(mockTypeService.getTypeForCode(itemTypeCode)).willReturn(mockedTypeModel);

		//and
		final InternalAuditableOperationWrapper testWrapper = new InternalAuditableOperationWrapper(operationToWrap,
				mockTypeService);

		//when
		final PK resolvedItemTypePk = testWrapper.getPkForItemType();

		//then
		assertThat(resolvedItemTypePk).isEqualTo(itemTypePk);
	}

	@Test
	public void shouldReturnNullWhenExceptionThrownWhileSearchingForTypePkUsingTypeCode()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);
		final String itemTypeCode = "itemTypeCode";

		//and
		given(operationToWrap.getItemTypePk()).willReturn(null);
		given(operationToWrap.getItemTypeCode()).willReturn(itemTypeCode);
		//and
		given(mockTypeService.getTypeForCode(itemTypeCode)).willThrow(UnknownIdentifierException.class);

		//and
		final InternalAuditableOperationWrapper testWrapper = new InternalAuditableOperationWrapper(operationToWrap,
				mockTypeService);

		//when
		final PK resolvedItemTypePk = testWrapper.getPkForItemType();

		//then
		assertThat(resolvedItemTypePk).isNull();
	}

	@Test
	public void shouldReturnNullWhenNeitherItemTypePkNorTypeCodeDefinedInTheOperationThatIsWrapped()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);

		//and
		given(operationToWrap.getItemTypePk()).willReturn(null);
		given(operationToWrap.getItemTypeCode()).willReturn(null);

		//and
		final InternalAuditableOperationWrapper testWrapper = new InternalAuditableOperationWrapper(operationToWrap,
				mockTypeService);

		//when
		final PK resolvedItemTypePk = testWrapper.getPkForItemType();

		//then
		assertThat(resolvedItemTypePk).isNull();
	}

	@Test
	public void shouldCalculateUsageOfFullSldContainerBasedOnGDPRAuditFlagForAuditStateData()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);
		given(operationToWrap.storeGDPRAudit()).willReturn(true);

		//when
		final InternalAuditableOperationWrapper testWrapper = new InternalAuditableOperationWrapper(operationToWrap,
				mockTypeService);

		//then
		assertThat(testWrapper.calculateIfUseFullSLDContainer()).isTrue();
		verify(operationToWrap, times(1)).storeGDPRAudit();
	}

	@Test
	public void shouldFulfillSldContainerSelectorContractForAuditableOperationWrapper()
	{
		//given
		final InternalAuditableOperation operationToWrap = mock(InternalAuditableOperation.class);
		final PK itemPk = PK.fromLong(124);

		//and
		given(operationToWrap.storeGDPRAudit()).willReturn(true);
		given(operationToWrap.getItemPk()).willReturn(itemPk);

		//when
		final SLDContainerSelector sldContainerSelector = new InternalAuditableOperationWrapper(operationToWrap, mockTypeService);

		//then
		assertThat(sldContainerSelector.calculateIfUseFullSLDContainer()).isTrue();
		assertThat(sldContainerSelector.getPkForItem()).isEqualTo(itemPk);
		verify(operationToWrap, times(1)).storeGDPRAudit();
		verify(operationToWrap, times(1)).getItemPk();
	}
}

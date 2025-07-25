/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.paulograbin.fulfilmentprocess.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.RetryLaterException;
import com.paulograbin.fulfilmentprocess.actions.order.PrepareOrderForManualCheckAction;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PrepareOrderForManualCheckTest {
	
	private PrepareOrderForManualCheckAction prepareOrderForManualCheck;
	@Mock
	private ModelService modelService;
	@Mock 
	private EventService eventService;

	@Before
	public void setUp() {
		prepareOrderForManualCheck = new PrepareOrderForManualCheckAction();
		prepareOrderForManualCheck.setModelService(modelService);
		prepareOrderForManualCheck.setEventService(eventService);
	}
	
	@Test
	public void testExecute() throws RetryLaterException, Exception {
		
		final OrderProcessModel orderProcess = new OrderProcessModel();
		final OrderModel order = new OrderModel();
		order.setStatus(OrderStatus.CREATED);
		orderProcess.setOrder(order);
		prepareOrderForManualCheck.executeAction(orderProcess);
		Assert.assertEquals(OrderStatus.WAIT_FRAUD_MANUAL_CHECK, orderProcess.getOrder().getStatus());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExecuteNullProcess() throws RetryLaterException, Exception {
		
		prepareOrderForManualCheck.executeAction(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExecuteNullOrder() throws RetryLaterException, Exception {
		
		prepareOrderForManualCheck.executeAction(new OrderProcessModel());
	}

}

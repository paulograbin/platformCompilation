/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.processengine.interceptors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.processengine.definition.ProcessDefinition;
import de.hybris.platform.processengine.definition.XMLProcessDefinitionsReader;
import de.hybris.platform.processengine.model.DynamicProcessDefinitionModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.xml.sax.InputSource;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DynamicProcessDefinitionPrepareInterceptorTest
{
	private static final String PROCESS_NAME = "testProcessName";
	private static final String PROCESS_CONTENT = "<?xml version=\"1.0\" encoding=\"utf-8\"?> " +
			"<process xmlns=\"http://www.hybris.de/xsd/processdefinition\" start=\"start\" name=\"testProcessName\"> " +
			" <action id=\"start\" bean=\"noAction\"> " +
			"   <transition name=\"OK\" to=\"success\"/> " +
			" </action> " +
			" <end id=\"success\" state=\"SUCCEEDED\">Everything was fine</end> " +
			"</process>";
	@Mock
	private XMLProcessDefinitionsReader xmlProcessDefinitionsReader;
	@Mock
	private DynamicProcessDefinitionModel processDefinitionModel;
	@Mock
	private ProcessDefinition processDefinition;
	@Mock
	private InterceptorContext ctx;

	private final DynamicProcessDefinitionPrepareInterceptor prepareInterceptor = new DynamicProcessDefinitionPrepareInterceptor();

	@Before
	public void setUp()
	{
		prepareInterceptor.setXmlProcessDefinitionsReader(xmlProcessDefinitionsReader);
	}

	@Test
	public void testOnPrepareForNewProcessDefinition() throws InterceptorException
	{
		//given
		when(processDefinitionModel.getContent()).thenReturn(PROCESS_CONTENT);
		when(processDefinitionModel.getActive()).thenReturn(Boolean.TRUE);
		when(processDefinition.getName()).thenReturn(PROCESS_NAME);
		when(ctx.isNew(processDefinitionModel)).thenReturn(true);
		when(xmlProcessDefinitionsReader.from(any(InputSource.class))).thenReturn(processDefinition);

		//when
		prepareInterceptor.onPrepare(processDefinitionModel, ctx);

		//then
		verify(processDefinitionModel).setCode(PROCESS_NAME);
	}

	@Test
	public void testOnPrepareForProcessWithoutContent() throws InterceptorException
	{
		//given
		when(processDefinitionModel.getContent()).thenReturn(null);

		//when
		prepareInterceptor.onPrepare(processDefinitionModel, ctx);

		//then
		verify(processDefinitionModel, times(0)).setCode(PROCESS_NAME);
	}

	@Test
	public void testOnPrepareForInvalidContent() throws InterceptorException
	{
		//given
		when(processDefinitionModel.getContent()).thenReturn("invalidContent");
		when(processDefinitionModel.getActive()).thenReturn(Boolean.TRUE);
		when(ctx.isNew(processDefinitionModel)).thenReturn(true);
		when(xmlProcessDefinitionsReader.from(any(InputSource.class))).thenThrow(
				new RuntimeException("InvalidProcessDefinitionException"));

		//when
		prepareInterceptor.onPrepare(processDefinitionModel, ctx);

		//then
		verify(processDefinitionModel, times(0)).setCode(PROCESS_NAME);
	}

	@Test
	public void testOnPrepareForExistingProcess() throws InterceptorException
	{
		//given
		when(processDefinitionModel.getContent()).thenReturn(PROCESS_CONTENT);
		when(ctx.isNew(processDefinitionModel)).thenReturn(false);

		//when
		prepareInterceptor.onPrepare(processDefinitionModel, ctx);

		//then
		verify(processDefinitionModel, times(0)).setCode(PROCESS_NAME);
	}
}


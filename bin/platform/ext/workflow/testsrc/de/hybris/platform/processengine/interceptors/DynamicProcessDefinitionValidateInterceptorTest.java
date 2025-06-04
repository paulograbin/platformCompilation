
/*
 * Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.processengine.interceptors;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DynamicProcessDefinitionValidateInterceptorTest
{
	private static final String PROCESS_NAME = "testProcessName";

	private static final String PROCESS_CONTENT = """
			<?xml version="1.0" encoding="utf-8"?>
			<process xmlns="http://www.hybris.de/xsd/processdefinition" start="start" name="testProcessName">
			    <action id="start" bean="noAction">
			        <transition name="OK" to="success"/>
			    </action>
			    <end id="success" state="SUCCEEDED">Everything was fine</end>
			</process>
			""";

	@Mock
	private XMLProcessDefinitionsReader xmlProcessDefinitionsReader;

	@Mock
	private ProcessDefinition processDefinition;
	@Mock
	private InterceptorContext ctx;

	private final DynamicProcessDefinitionValidateInterceptor validateInterceptor = new DynamicProcessDefinitionValidateInterceptor();

	@Before
	public void setUp()
	{
		validateInterceptor.setXmlProcessDefinitionsReader(xmlProcessDefinitionsReader);
	}

	@Test
	public void shouldNotValidateInactiveProcessDefinition() throws InterceptorException
	{
		//given
		final DynamicProcessDefinitionModel model = new DynamicProcessDefinitionModel();
		model.setContent(PROCESS_CONTENT);
		model.setCode(PROCESS_NAME);
		model.setActive(false);

		//when
		validateInterceptor.onValidate(model, ctx);

		//then
		verify(xmlProcessDefinitionsReader, never()).from(any(InputSource.class));
	}

	@Test
	public void shouldValidateActiveProcessDefinition() throws InterceptorException
	{
		//given
		final DynamicProcessDefinitionModel model = new DynamicProcessDefinitionModel();
		model.setContent(PROCESS_CONTENT);
		model.setCode(PROCESS_NAME);
		model.setActive(true);

		when(xmlProcessDefinitionsReader.from(any(InputSource.class))).thenReturn(processDefinition);
		when(processDefinition.getName()).thenReturn(PROCESS_NAME);

		//when
		validateInterceptor.onValidate(model, ctx);

		//then
		verify(xmlProcessDefinitionsReader).from(any(InputSource.class));
	}

	@Test
	public void shouldThrowExceptionWhenDefinitionContentIsInvalid()
	{
		//given
		final DynamicProcessDefinitionModel model = new DynamicProcessDefinitionModel();
		model.setContent("invalidContent");
		model.setCode(PROCESS_NAME);
		model.setActive(true);

		when(xmlProcessDefinitionsReader.from(any(InputSource.class))).thenThrow(
				new RuntimeException("InvalidProcessDefinitionException"));

		//when
		try
		{
			validateInterceptor.onValidate(model, ctx);
		}
		catch (final InterceptorException e)
		{
			//then
			assertThat(e.getMessage()).contains("Given content is not a valid process definition.");
		}
	}

	@Test
	public void shouldThrowExceptionWhenDefinitionNameIsDifferentFromCode()
	{
		//given
		final DynamicProcessDefinitionModel model = new DynamicProcessDefinitionModel();
		model.setContent(PROCESS_CONTENT);
		model.setCode(PROCESS_NAME);
		model.setActive(true);

		when(xmlProcessDefinitionsReader.from(any(InputSource.class))).thenReturn(processDefinition);
		when(processDefinition.getName()).thenReturn("differentName");

		//when
		try
		{
			validateInterceptor.onValidate(model, ctx);
		}
		catch (final InterceptorException e)
		{
			//then
			assertThat(e.getMessage()).contains("Process definition's name must be the same as the code.");
		}
	}
}

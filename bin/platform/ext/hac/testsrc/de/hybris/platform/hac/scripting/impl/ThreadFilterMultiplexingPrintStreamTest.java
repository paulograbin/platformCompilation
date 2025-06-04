/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.hac.scripting.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import de.hybris.bootstrap.annotations.UnitTest;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ThreadFilterMultiplexingPrintStreamTest
{

	private ThreadFilterMultiplexingPrintStream testee;

	private PrintStream primaryStream;

	private PrintStream secondaryStream;

	@Captor
	private ArgumentCaptor<byte[]> primaryStreamByteArrayCaptor;
	@Captor
	private ArgumentCaptor<Integer> primaryStreamIntCaptor;
	@Captor
	private ArgumentCaptor<byte[]> secondaryStreamByteArrayCaptor;
	@Captor
	private ArgumentCaptor<Integer> secondaryStreamIntCaptor;

	@Before
	public void setup()
	{
		primaryStream = mock(PrintStream.class);
		secondaryStream = mock(PrintStream.class);
		testee = new ThreadFilterMultiplexingPrintStream(primaryStream, secondaryStream);
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println());

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnOnTheSameThread()
	{
		// when
		testee.println();

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnBooleanOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(true));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnBooleanOnTheSameThread()
	{
		// when
		testee.println(true);

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnCharOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println('a'));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnCharOnTheSameThread()
	{
		// when
		testee.println('a');

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnIntOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(1));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnIntOnTheSameThread()
	{
		// when
		testee.println(1);

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnLongOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(1L));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnLongOnTheSameThread()
	{
		// when
		testee.println(1L);

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnFloatOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(1.0f));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnFloatOnTheSameThread()
	{
		// when
		testee.println(1.0f);

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnDoubleOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(1.0));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnDoubleOnTheSameThread()
	{
		// when
		testee.println(1.0);

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnCharArrayOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(new char[]{ 'a', 'b' }));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnCharArrayOnTheSameThread()
	{
		// when
		testee.println(new char[]{ 'a', 'b' });

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnStringOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println("str"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnStringOnTheSameThread()
	{
		// when
		testee.println("str");

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintlnObjectOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.println(Map.of()));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream, times(2)).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintlnObjectOnTheSameThread()
	{
		// when
		testee.println(Map.of());

		// then
		verify(primaryStream, times(2)).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream, times(2)).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getAllValues()).containsExactlyElementsOf(
				primaryStreamByteArrayCaptor.getAllValues());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintBooleanOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(true));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintBooleanOnTheSameThread()
	{
		// when
		testee.print(true);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintCharOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print('a'));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintCharOnTheSameThread()
	{
		// when
		testee.print('a');

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintIntOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(1));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintIntOnTheSameThread()
	{
		// when
		testee.print(1);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintLongOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(1L));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintLongOnTheSameThread()
	{
		// when
		testee.print(1L);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintFloatOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(1.0f));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintFloatOnTheSameThread()
	{
		// when
		testee.print(1.0f);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintDoubleOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(1.0));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintDoubleOnTheSameThread()
	{
		// when
		testee.print(1.0);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintCharArrayOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(new char[]{ 'a', 'b' }));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintCharArrayOnTheSameThread()
	{
		// when
		testee.print(new char[]{ 'a', 'b' });

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintStringOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print("str"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintStringOnTheSameThread()
	{
		// when
		testee.print("str");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintObjectOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.print(Map.of()));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintObjectOnTheSameThread()
	{
		// when
		testee.print(Map.of());

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintfOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.printf("%s", "asd"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintfOnTheSameThread()
	{
		// when
		testee.printf("%s", "asd");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingPrintfWithLocaleOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.printf(Locale.ENGLISH, "%s", "asd"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingPrintfWithLocaleOnTheSameThread()
	{
		// when
		testee.printf(Locale.ENGLISH, "%s", "asd");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingWriteIntOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.write(1));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingWriteIntOnTheSameThread()
	{
		// when
		testee.write(1);

		// then
		verify(primaryStream).write(primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamIntCaptor.getValue()).isEqualTo(primaryStreamIntCaptor.getValue());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingWriteBytesArrayOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> {
			try
			{
				testee.write("str".getBytes());
			}
			catch (final IOException e)
			{
				Assertions.fail("Should not have failed", e);
			}
		});

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingWriteBytesArrayOnTheSameThread()
	{
		// when
		try
		{
			testee.write("str".getBytes());
		}
		catch (final IOException e)
		{
			Assertions.fail("Should not have failed", e);
		}

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingWriteBytesArrayWithOffAndLenOnOtherThread()
			throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.write("str".getBytes(), 0, 1));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingWriteBytesArrayWithOffAndLenOnTheSameThread()
	{
		// when
		testee.write("str".getBytes(), 0, 1);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingWriteBytesOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.writeBytes("str".getBytes()));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingWriteBytesOnTheSameThread()
	{
		// when
		testee.writeBytes("str".getBytes());

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingFormatOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.format("%s", "str"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingFormatOnTheSameThread()
	{
		// when
		testee.format("%s", "str");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingFormatWithLocaleOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.format(Locale.ENGLISH, "%s", "str"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingFormatWithLocaleOnTheSameThread()
	{
		// when
		testee.format(Locale.ENGLISH, "%s", "str");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingAppendCharOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.append('c'));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingAppendCharOnTheSameThread()
	{
		// when
		testee.append('c');

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingAppendCharSequenceOnOtherThread() throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.append("str"));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingAppendCharSequenceOnTheSameThread()
	{
		// when
		testee.append("str");

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}

	@Test
	public void shouldNotWriteDataToSecondaryStreamWhenCallingAppendCharSequenceWithStartAndEndOnOtherThread()
			throws InterruptedException
	{
		// given
		final Thread thread = new Thread(() -> testee.append("str", 0, 1));

		// when
		thread.start();
		thread.join();

		// then
		verify(primaryStream).write(any(byte[].class), anyInt(), anyInt());
		verifyNoInteractions(secondaryStream);
	}

	@Test
	public void shouldWriteTheSameDataToSecondaryStreamWhenCallingAppendCharSequenceWithStartAndEndOnTheSameThread()
	{
		// when
		testee.append("str", 0, 1);

		// then
		verify(primaryStream).write(primaryStreamByteArrayCaptor.capture(), primaryStreamIntCaptor.capture(),
				primaryStreamIntCaptor.capture());
		verify(secondaryStream).write(secondaryStreamByteArrayCaptor.capture(), secondaryStreamIntCaptor.capture(),
				secondaryStreamIntCaptor.capture());
		assertThat(secondaryStreamByteArrayCaptor.getValue()).isEqualTo(primaryStreamByteArrayCaptor.getValue());
		assertThat(secondaryStreamIntCaptor.getAllValues()).containsExactlyElementsOf(primaryStreamIntCaptor.getAllValues());
	}
}

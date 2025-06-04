/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.hac.scripting.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class ThreadFilterMultiplexingPrintStreamIntegrationTest
{

	private ThreadFilterMultiplexingPrintStream threadFilterMultiplexingPrintStream;
	private ByteArrayOutputStream mainOutputStream;
	private ByteArrayOutputStream auxiliaryOutputStream;

	@Before
	public void setup()
	{
		mainOutputStream = new ByteArrayOutputStream();
		auxiliaryOutputStream = new ByteArrayOutputStream();
		threadFilterMultiplexingPrintStream = new ThreadFilterMultiplexingPrintStream(
				new PrintStream(mainOutputStream, true, StandardCharsets.UTF_8),
				new PrintStream(auxiliaryOutputStream, true, StandardCharsets.UTF_8));
	}

	@Test
	public void shouldCollectAllMessagesFromAllThreadsForMainStreamAndOnlyMessagesFromTheCallingThreadForAuxiliaryStream()
			throws InterruptedException, IOException
	{
		// given
		final String expectedMainStreamOutput = "YOUR ORDERDebug msg 1\n" +
		                                        "\n" +
		                                        "Debug msg 2\n" +
		                                        "Items:\n" +
		                                        "Debug msg 3\n" +
		                                        "\tItem 1:\tEUR Debug msg 4\n" +
		                                        "10.0\n" +
		                                        "Debug msg 5\n" +
		                                        "\tItem 2:\tEUR Debug msg 6\n" +
		                                        "2.5\n" +
		                                        "Debug msg 7\n" +
		                                        "\tItem 3:\tEUR Debug msg 8\n" +
		                                        "4.25\n" +
		                                        "Debug msg 9\n" +
		                                        "Total: EUR 16.75Debug msg 10\n" +
		                                        "!Debug msg 11\n" +
		                                        "!Debug msg 12\n" +
		                                        "!!Debug msg 13\n" +
		                                        "\nThanks!";

		final String expectedAuxiliaryStreamOutput = "YOUR ORDER\n" +
		                                             "Items:\n" +
		                                             "\tItem 1:\tEUR 10.0\n" +
		                                             "\tItem 2:\tEUR 2.5\n" +
		                                             "\tItem 3:\tEUR 4.25\n" +
		                                             "Total: EUR 16.75!!!!\n" +
		                                             "Thanks!";

		// when
		threadFilterMultiplexingPrintStream.print("YOUR ORDER");
		printlnOnOtherThread("Debug msg 1");
		threadFilterMultiplexingPrintStream.println();
		printlnOnOtherThread("Debug msg 2");
		threadFilterMultiplexingPrintStream.println("Items:");
		printlnOnOtherThread("Debug msg 3");
		threadFilterMultiplexingPrintStream.print("\tItem 1:\tEUR ");
		printlnOnOtherThread("Debug msg 4");
		threadFilterMultiplexingPrintStream.println(10.00);
		printlnOnOtherThread("Debug msg 5");
		threadFilterMultiplexingPrintStream.print("\tItem 2:\tEUR ");
		printlnOnOtherThread("Debug msg 6");
		threadFilterMultiplexingPrintStream.println(2.50);
		printlnOnOtherThread("Debug msg 7");
		threadFilterMultiplexingPrintStream.print("\tItem 3:\tEUR ");
		printlnOnOtherThread("Debug msg 8");
		threadFilterMultiplexingPrintStream.println(4.25);
		printlnOnOtherThread("Debug msg 9");
		threadFilterMultiplexingPrintStream.printf(Locale.US, "Total: EUR %.2f", 16.75);
		printlnOnOtherThread("Debug msg 10");
		threadFilterMultiplexingPrintStream.write('!');
		printlnOnOtherThread("Debug msg 11");
		threadFilterMultiplexingPrintStream.write("!".getBytes());
		printlnOnOtherThread("Debug msg 12");
		threadFilterMultiplexingPrintStream.write("!!!".getBytes(), 0, 2);
		printlnOnOtherThread("Debug msg 13");
		threadFilterMultiplexingPrintStream.writeBytes("\nThanks!".getBytes());

		// then
		final String resultingMainStreamOutput = mainOutputStream.toString();
		final String resultingAuxiliaryStreamOutput = auxiliaryOutputStream.toString();
		assertThat(resultingMainStreamOutput).isEqualTo(expectedMainStreamOutput);
		assertThat(resultingAuxiliaryStreamOutput).isEqualTo(expectedAuxiliaryStreamOutput);
	}

	private void printlnOnOtherThread(final String msg) throws InterruptedException
	{
		final Thread thread = new Thread(() -> threadFilterMultiplexingPrintStream.println(msg));
		thread.start();
		thread.join();
	}
}

/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.web.session;

import static de.hybris.platform.servicelayer.web.session.HybrisSpringSessionFilter.DEFAULT_COOKIE_NAME;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.tomcat.cookieprocessor.CookieHandler;
import de.hybris.bootstrap.tomcat.cookieprocessor.Rfc6265CookieProcessorLogicHolder;
import de.hybris.platform.util.Config;

import java.util.Optional;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.session.web.http.CookieSerializer;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class HybrisSpringSessionFilterUnitTest
{
	private static final String EXTENSION_NAME = "testextension";
	private static final String COOKIE_PATH_PROPERTY = String.format("spring.session.%s.cookie.path", EXTENSION_NAME);
	private static final String COOKIE_NAME_PROPERTY = String.format("spring.session.%s.cookie.name", EXTENSION_NAME);

	private static final String COOKIE_NAME = "JSESSIONID";
	private static final String COOKIE_PATH = "/";
	private static final String SAME_SITE_VALUE = "None";

	private HybrisSpringSessionFilter filter;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setUp()
	{
		filter = new HybrisSpringSessionFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}


	@Test
	public void shouldSetSameSiteForCookie()
	{
		try (final MockedStatic<Config> configStaticMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Rfc6265CookieProcessorLogicHolder> cookieProcessorLogicHolderMock = Mockito.mockStatic(
				     Rfc6265CookieProcessorLogicHolder.class))
		{
			//given
			configStaticMock.when(() -> Config.getString(COOKIE_NAME_PROPERTY, DEFAULT_COOKIE_NAME))
			            .thenReturn(COOKIE_NAME);
			configStaticMock.when(() -> Config.getString(eq(COOKIE_PATH_PROPERTY), any()))
			                .thenReturn(COOKIE_PATH);
			final MockedCookieHandler mockedCookieHandler = new MockedCookieHandler(SAME_SITE_VALUE);
			cookieProcessorLogicHolderMock.when(() -> Rfc6265CookieProcessorLogicHolder.getCookieHandler())
			                              .thenReturn(Optional.of(mockedCookieHandler));

			//when
			final CookieSerializer serializer = filter.createCookieSerializer(EXTENSION_NAME, request);
			serializer.writeCookieValue(new CookieSerializer.CookieValue(request, response, COOKIE_NAME));

			//then
			assertThat(mockedCookieHandler.cookieName).isEqualTo(COOKIE_NAME);
			assertThat(mockedCookieHandler.cookiePath).isEqualTo(COOKIE_PATH);
			assertThat(response.getCookie(COOKIE_NAME) instanceof final MockCookie mockCookie
					&& SAME_SITE_VALUE.equals(mockCookie.getSameSite())).isTrue();

		}
	}

	@Test
	public void shouldNotSetSameSiteForCookie()
	{
		try (final MockedStatic<Config> configStaticMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Rfc6265CookieProcessorLogicHolder> cookieProcessorLogicHolderMock = Mockito.mockStatic(
				     Rfc6265CookieProcessorLogicHolder.class))
		{
			//given
			configStaticMock.when(() -> Config.getString(COOKIE_NAME_PROPERTY, DEFAULT_COOKIE_NAME))
			            .thenReturn(COOKIE_NAME);
			configStaticMock.when(() -> Config.getString(eq(COOKIE_PATH_PROPERTY), any()))
			                .thenReturn(COOKIE_PATH);
			final MockedCookieHandler mockedCookieHandler = new MockedCookieHandler(null);
			cookieProcessorLogicHolderMock.when(() -> Rfc6265CookieProcessorLogicHolder.getCookieHandler())
			                              .thenReturn(Optional.of(mockedCookieHandler));

			//when
			final CookieSerializer serializer = filter.createCookieSerializer(EXTENSION_NAME, request);
			serializer.writeCookieValue(new CookieSerializer.CookieValue(request, response, COOKIE_NAME));

			//then
			assertThat(mockedCookieHandler.cookieName).isEqualTo(COOKIE_NAME);
			assertThat(mockedCookieHandler.cookiePath).isEqualTo(COOKIE_PATH);
			assertThat(response.getCookie(COOKIE_NAME) instanceof final MockCookie mockCookie
					&& mockCookie.getSameSite() == null).isTrue();

		}
	}

	private static class MockedCookieHandler implements CookieHandler
	{
		private final String sameSite;
		private String cookieName;
		private String cookiePath;

		public MockedCookieHandler(final String sameSite)
		{
			this.sameSite = sameSite;
		}

		@Override
		public Optional<String> getSameSiteParameter(final Cookie cookie)
		{
			cookieName = cookie.getName();
			cookiePath = cookie.getPath();
			return Optional.ofNullable(sameSite);
		}
	}
}


/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.web.session;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.testframework.BulkPropertyConfigSwitcher;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;


@IntegrationTest
public class DefaultHybrisSpringSessionIntegrationTest extends ServicelayerBaseTest
{
	private static final String CUSTOM_EXTENSION = "testresponsesplitting";
	private static final String CUSTOM_EXTENSION_WEBROOT = CUSTOM_EXTENSION + ".webroot";
	public static final String JSESSIONID = "JSESSIONID";
	private static final String WEBROOT_MAPPING = "/" + CUSTOM_EXTENSION;
	private static final PropertyConfigSwitcher SESSION_SESSION_ENABLED = new PropertyConfigSwitcher("spring.session.enabled");
	private static final PropertyConfigSwitcher SESSION_COOKIE_NAME = new PropertyConfigSwitcher("spring.session." + CUSTOM_EXTENSION + ".cookie.name");
	private static final BulkPropertyConfigSwitcher PROPERTY_CONFIG_SWITCHER = new BulkPropertyConfigSwitcher();


	@Mock
	private HttpServletRequest httpRequest;
	@Mock
	private HttpServletResponse httpResponse;
	@Mock
	private ServletContext servletContext;

	@Resource
	private HybrisSpringSessionFilter defaultHybrisSpringSessionFilter;

	private MockitoSession mockitoSession;

	@Before
	public void setUp() throws Exception
	{
		SESSION_SESSION_ENABLED.switchToValue("true");
		SESSION_COOKIE_NAME.switchToValue(JSESSIONID);
		mockitoSession = Mockito.mockitoSession().initMocks(this).strictness(Strictness.LENIENT).startMocking();
		Registry.getMasterTenant().getConfig().setParameter(CUSTOM_EXTENSION_WEBROOT, WEBROOT_MAPPING);
	}

	@After
	public void tearDown() throws Exception
	{
		Registry.getMasterTenant().getConfig().removeParameter(CUSTOM_EXTENSION_WEBROOT);
		SESSION_SESSION_ENABLED.switchBackToDefault();
		PROPERTY_CONFIG_SWITCHER.switchAllBack();

		defaultHybrisSpringSessionFilter.init();
		mockitoSession.finishMocking();
	}


	@Test
	public void testHTTPResponseSplittingUsingBadChars() throws ServletException, IOException
	{

		defaultHybrisSpringSessionFilter.init();

		final Cookie[] cookies = { new Cookie(JSESSIONID, "the!#SessionId.afterTheDot") };
		final FilterChain chain = (req, res) -> {};

		// given
		given(httpRequest.getCookies()).willReturn(cookies);
		given(httpRequest.getServletContext()).willReturn(servletContext);
		given(servletContext.getContextPath()).willReturn(WEBROOT_MAPPING);
		given(servletContext.getAttribute("de.hybris.tomcat.jvmRoute")).willReturn("jvm!#route");

		// when
		defaultHybrisSpringSessionFilter.doFilter(httpRequest, httpResponse, chain);

		// then
		verify(httpResponse, times(1)).addCookie(
				argThat(cookie -> JSESSIONID.equals(cookie.getName()) && "theSessionId.jvmroute".equals(cookie.getValue())));

	}

	@Test
	public void shouldRecreateSessionFilterAfterSameSitePropertiesChanged() throws ServletException, IOException
	{
		//given
		given(httpRequest.getServletContext()).willReturn(servletContext);
		given(servletContext.getContextPath()).willReturn(WEBROOT_MAPPING);
		PROPERTY_CONFIG_SWITCHER.switchToValue(String.format("spring.session.%s.save", CUSTOM_EXTENSION), "sync");
		defaultHybrisSpringSessionFilter.init();
		final Filter sessionFilter = defaultHybrisSpringSessionFilter.getOrCreateSessionRepositoryFilter(CUSTOM_EXTENSION,
				httpRequest);

		//when
		Filter newFilter = defaultHybrisSpringSessionFilter.getOrCreateSessionRepositoryFilter(CUSTOM_EXTENSION, httpRequest);
		//then
		assertThat(newFilter).isEqualTo(sessionFilter);

		//when
		PROPERTY_CONFIG_SWITCHER.switchToValue("cookies.SameSite", "Lax");
		newFilter = defaultHybrisSpringSessionFilter.getOrCreateSessionRepositoryFilter(CUSTOM_EXTENSION, httpRequest);
		//then
		assertThat(newFilter).isNotEqualTo(sessionFilter);
	}
}

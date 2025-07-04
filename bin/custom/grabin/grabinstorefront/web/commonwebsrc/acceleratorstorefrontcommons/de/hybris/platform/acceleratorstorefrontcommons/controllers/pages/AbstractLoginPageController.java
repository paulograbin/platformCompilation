/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorstorefrontcommons.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.GuestForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.LoginForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commerceservices.config.SiteConfigService;
import de.hybris.platform.site.BaseSiteService;

import java.util.Collections;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;


/**
 * Abstract base class for login page controllers
 */
public abstract class AbstractLoginPageController extends AbstractRegisterPageController
{
	@Resource(name = "baseSiteService")
	private BaseSiteService baseSiteService;

	@Resource(name = "commerceSiteConfigService")
	private SiteConfigService siteConfigService;
	protected static final String SPRING_SECURITY_LAST_USERNAME = "SPRING_SECURITY_LAST_USERNAME";

	protected String getDefaultLoginPage(final boolean loginError, final HttpSession session, final Model model)
			throws CMSItemNotFoundException
	{
		final LoginForm loginForm = new LoginForm();
		final RegisterForm registerForm = new RegisterForm();
		model.addAttribute(loginForm);
		model.addAttribute(new GuestForm());
		final boolean otpVerificationTokenEnabled = getSiteConfigService().getBoolean(WebConstants.OTP_CUSTOMER_LOGIN_ENABLED, false);
		String currentBaseSite = null;
		if (baseSiteService.getCurrentBaseSite() != null)
		{
			currentBaseSite = baseSiteService.getCurrentBaseSite().getUid();
		}
		final Boolean otpForRegistrationEnabled = Boolean.parseBoolean(siteConfigService.getProperty(currentBaseSite,
				WebConstants.OTP_CUSTOMER_REGISTRATION_ENABLED));
		final int secondsForLogin = getSiteConfigService().getInt("otp.customer.login.token.ttlseconds", 300);
		final int secondsForRegistration = getSiteConfigService().getInt("otp.customer.registration.token.ttlseconds", 300);
		model.addAttribute("secondsForRegistration",secondsForRegistration);
		model.addAttribute("secondsForLogin", secondsForLogin);
		registerForm.setOtpForRegistrationEnabled(otpForRegistrationEnabled);
		model.addAttribute(registerForm);
		final String username = (String) session.getAttribute(SPRING_SECURITY_LAST_USERNAME);
		final String tokenId = (String) session.getAttribute(WebConstants.OTP_TOKEN_ID);
		if (username != null)
		{
			session.removeAttribute(SPRING_SECURITY_LAST_USERNAME);
		}

		if (tokenId != null)
		{
			session.removeAttribute(WebConstants.OTP_TOKEN_ID);
		}

		if (otpVerificationTokenEnabled)
		{
			loginForm.setOtpUserName(username);
			loginForm.setJ_username(tokenId);
		}
		else
		{
			loginForm.setJ_username(username);
		}

		storeCmsPageInModel(model, getCmsPage());
		setUpMetaDataForContentPage(model, (ContentPageModel) getCmsPage());
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.INDEX_NOFOLLOW);

		addRegistrationConsentDataToModel(model);

		final Breadcrumb loginBreadcrumbEntry = new Breadcrumb("#",
				getMessageSource().getMessage("header.link.login", null, "header.link.login", getI18nService().getCurrentLocale()),
				null);
		model.addAttribute("breadcrumbs", Collections.singletonList(loginBreadcrumbEntry));

		if (loginError)
		{
			model.addAttribute("loginError", Boolean.valueOf(loginError));
			final Boolean usernameChanged = (Boolean) session.getAttribute(WebConstants.OTP_USERNAME_CHANGED);
			if (usernameChanged != null)
			{
				session.removeAttribute(WebConstants.OTP_USERNAME_CHANGED);
			}
			if (otpVerificationTokenEnabled && Boolean.TRUE.equals(usernameChanged))
			{
				GlobalMessages.addErrorMessage(model, "login.error.otp.email.changed");
			}
			else if (otpVerificationTokenEnabled)
			{
				GlobalMessages.addErrorMessage(model, "login.error.otp.bad.credentials");
			}
			else
			{
				GlobalMessages.addErrorMessage(model, "login.error.account.not.found.title");
			}
		}

		return getView();
	}

}

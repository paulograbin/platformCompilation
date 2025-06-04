/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user.interceptors;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.AbstractUserAuditModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.core.model.user.UserPasswordChangeAuditModel;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.daos.UserAuditDao;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.RandomTextUtils;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class UserAuditJaloTest extends ServicelayerTransactionalBaseTest
{
	@Resource
	ModelService modelService;

	@Resource
	UserService userService;

	@Resource
	UserAuditDao userAuditDao;

	@Resource
	FlexibleSearchService flexibleSearchService;

	private final PropertyConfigSwitcher userAuditSwitcher = new PropertyConfigSwitcher("user.audit.enabled");

	@Before
	public void enableAudit()
	{
		userAuditSwitcher.switchToValue("true");
	}

	@After
	public void revertAuditSettings()
	{
		userAuditSwitcher.switchBackToDefault();
	}


	@Test
	public void shouldRecordPreviousPasswordOnPasswordChange() throws ConsistencyCheckException
	{
		final User user = UserManager.getInstance().createUser(UUID.randomUUID().toString());

		user.setPassword(RandomTextUtils.randomText(3));
		final String firstPasswordEncoded = user.getEncodedPassword();

		user.setPassword(RandomTextUtils.randomText(3));
		final String secondPasswordEncoded = user.getEncodedPassword();

		final UserModel userModel = modelService.get(user.getPK());
		final List<AbstractUserAuditModel> userAudits = userService.getUserAudits(userModel);

		assertThat(userAudits).hasSize(1);
		assertThat(userAudits).extracting(UserPasswordChangeAuditModel.ENCODEDPASSWORD)
		                      .containsOnly(firstPasswordEncoded);
	}

	@Test
	public void shouldNotAuditIfDisabled() throws ConsistencyCheckException
	{
		userAuditSwitcher.switchToValue("false");
		final User user = UserManager.getInstance().createUser(UUID.randomUUID().toString());

		user.setPassword(RandomTextUtils.randomText(3));
		user.setPassword(RandomTextUtils.randomText(3));

		final UserModel userModel = modelService.get(user.getPK());
		final List<AbstractUserAuditModel> userAudit = userService.getUserAudits(userModel);
		assertThat(userAudit).isEmpty();
	}
}

/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user.interceptors;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.AbstractUserAuditModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.core.model.user.UserPasswordChangeAuditModel;
import de.hybris.platform.persistence.security.PasswordEncoder;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
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
public class UserPasswordChangeAuditPrepareInterceptorTest extends ServicelayerTransactionalBaseTest
{
	@Resource
	ModelService modelService;

	@Resource
	UserService userService;

	@Resource
	UserAuditDao userAuditDao;

	@Resource
	FlexibleSearchService flexibleSearchService;

	@Resource(name = "core.passwordEncoderFactory")
	private PasswordEncoderFactory encoderFactory;

	final String encoding = de.hybris.platform.persistence.SystemEJB.DEFAULT_ENCODING;
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
	public void shouldRecordPasswordChanges()
	{
		final UserModel user = givenUser();

		changePasswordInRange(user, 1, 5);

		final List<AbstractUserAuditModel> allAudit = getAllAuditData();
		final List<AbstractUserAuditModel> userAudit = userService.getUserAudits(user);

		assertThat(allAudit).extracting(AbstractUserAuditModel.UID).containsOnly(user.getUid());
		assertThat(allAudit).extracting(AbstractUserAuditModel.USERPK).containsOnly(user.getPk().getLong());

		verifyAuditsPassword(userAudit, 1, 5);
	}

	@Test
	public void shouldRecordPreviousPasswordOnPasswordChange()
	{
		final UserModel user = givenUser();

		userService.setPassword(user, RandomTextUtils.randomText(3), encoding);
		modelService.save(user);
		final String firstPasswordEncoded = user.getEncodedPassword();

		userService.setPassword(user, RandomTextUtils.randomText(3), encoding);
		modelService.save(user);
		final String secondPasswordEncoded = user.getEncodedPassword();

		final List<AbstractUserAuditModel> allAudit = getAllAuditData();
		final List<AbstractUserAuditModel> userAudit = userService.getUserAudits(user);

		assertThat(allAudit).extracting(AbstractUserAuditModel.UID).containsOnly(user.getUid());
		assertThat(allAudit).extracting(AbstractUserAuditModel.USERPK).containsOnly(user.getPk().getLong());

		assertThat(allAudit).hasSize(1);
		assertThat(allAudit).extracting(UserPasswordChangeAuditModel.ENCODEDPASSWORD)
		                    .containsOnly(firstPasswordEncoded);

		assertThat(userAudit).hasSize(1);
		assertThat(userAudit).extracting(UserPasswordChangeAuditModel.ENCODEDPASSWORD)
		                     .containsOnly(firstPasswordEncoded);
	}

	@Test
	public void shouldNotAuditIfDisabled()
	{
		userAuditSwitcher.switchToValue("false");
		final UserModel user = givenUser();

		changePasswordInRange(user, 1, 5);

		final List<AbstractUserAuditModel> userAudit = userService.getUserAudits(user);
		assertThat(userAudit).isEmpty();
	}

	@Test
	public void shouldKeepAuditDataAfterUserDeletion()
	{
		final UserModel user = givenUser();

		changePasswordInRange(user, 1, 2);
		modelService.remove(user);
		modelService.saveAll();

		final List<AbstractUserAuditModel> audit = getAllAuditData();

		verifyAuditsPassword(audit, 1, 2);
	}

	@Test
	public void shouldCorrectlyAuditUserWithUidChange()
	{
		final UserModel user = givenUser();

		changePasswordInRange(user, 1, 2);

		user.setUid(UUID.randomUUID().toString());
		modelService.saveAll();

		changePasswordInRange(user, 3, 4);

		final List<AbstractUserAuditModel> userAuditData = userService.getUserAudits(user);

		verifyAuditsPassword(userAuditData, 1, 4);
	}

	@Test
	public void shouldNotAuditChangeFromEmptyPassword()
	{
		final UserModel user = givenUser();
		modelService.save(user);
		userService.setPassword(user.getUid(), RandomTextUtils.randomText(3));

		final List<AbstractUserAuditModel> userAuditData = userService.getUserAudits(user);
		assertThat(userAuditData).isEmpty();
	}

	@Test
	public void shouldComparePasswordWithAudit()
	{
		final UserModel user = givenUser();
		final String password = RandomTextUtils.randomText(3);
		final AbstractUserAuditModel audit = givenAudit(user, password);

		assertThat(userService.isPasswordIdenticalToAudited(user, password, (UserPasswordChangeAuditModel) audit)).isTrue();
		assertThat(userService.isPasswordIdenticalToAudited(user, RandomTextUtils.randomText(4), (UserPasswordChangeAuditModel) audit)).isFalse();
	}

	private AbstractUserAuditModel givenAudit(final UserModel user, final String password)
	{
		userService.setPassword(user, password);
		modelService.save(user);

		userService.setPassword(user, RandomTextUtils.randomText(8));
		modelService.save(user);

		final List<AbstractUserAuditModel> userAudits = userService.getUserAudits(user);
		assertThat(userAudits).hasSize(1);
		return userAudits.get(0);
	}

	private void changePasswordInRange(final UserModel user, final int start, final int end)
	{
		for (int i = start; i <= end; i++)
		{
			userService.setPassword(user, "pass_no" + i, encoding);
			modelService.save(user);
		}
	}

	private void verifyAuditsPassword(final List<AbstractUserAuditModel> allAudits, final int start, final int end)
	{
		int n = end-1;
		for(int i = 0; 0 < n; i++) {
			final var audit = (UserPasswordChangeAuditModel) allAudits.get(i);
			final PasswordEncoder encoder = encoderFactory.getEncoder(audit.getPasswordEncoding());
			assertThat(encoder.check(audit.getUid(), audit.getEncodedPassword(), "pass_no" + n))
					.isTrue();
			n--;
		}
	}

	private List<AbstractUserAuditModel> getAllAuditData()
	{
		return flexibleSearchService.<AbstractUserAuditModel>search(
				"SELECT {PK} FROM {" + AbstractUserAuditModel._TYPECODE + "} " +
						"WHERE {" + AbstractUserAuditModel.UID + "} NOT IN ('admin', 'anonymous') " +
						"ORDER BY {" + AbstractUserAuditModel.CREATIONTIME + "} DESC")
				.getResult();
	}

	private UserModel givenUser()
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(UUID.randomUUID().toString());
		return user;
	}
}

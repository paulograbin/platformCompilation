/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.servicelayer.user.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.audit.AuditableActionsUtil;
import de.hybris.platform.audit.actions.AuditableActionHandler;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.BruteForceLoginAttemptsModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;


@IntegrationTest
public class DefaultUserAuditLoginStrategyTest extends ServicelayerBaseTest
{
	@Resource
	private DefaultUserAuditLoginStrategy defaultUserAuditLoginStrategy;

	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	private DefaultUserService defaultUserService;

	private AuditableActionHandler testAuditableActionHandler;
	private Supplier<AuditableActionHandler> originalActionHandler;

	private static final String USER_ID = "test@sap.com";
	private static final String FOO_DECORATOR = "|foo";
	private static final String BAR_DECORATOR = "|bar";
	private static final String GROUP_ID = "testGroup";


	@Before
	public void setUp()
	{
		defaultUserService = mock(DefaultUserService.class);
		defaultUserAuditLoginStrategy.setUserService(defaultUserService);

		testAuditableActionHandler = mock(AuditableActionHandler.class);
		originalActionHandler = AuditableActionsUtil.getAuditableActionHandlerFactory();
		AuditableActionsUtil.setAuditableActionHandlerFactory(() -> testAuditableActionHandler);
	}

	@After
	public void tearDown()
	{
		defaultUserAuditLoginStrategy.setUserService(userService);

		AuditableActionsUtil.setAuditableActionHandlerFactory(originalActionHandler);
	}

	@Test
	public void shouldCreateAttemptsModelForUserWithDecoratedUid()
	{
		//given
		final String decoratedUserId = USER_ID + FOO_DECORATOR;
		final UserGroupModel testGroup = createGroupWithMaxAttempts(GROUP_ID, 3);
		final UserModel decoratedUser = createUser(decoratedUserId, Set.of(testGroup));
		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(decoratedUser);

		//when
		auditUserOnWrongCredentials(USER_ID, 1);

		//then
		assertThat(getAttemptsModelForUid(USER_ID)).isNull();
		assertThat(getAttemptsModelForUid(decoratedUserId)).isNotNull();
	}

	@Test
	public void shouldCreateSeparateAttemptsModelForEachUserWithDecoratedUid()
	{
		//given
		final String fooDecoratedUserId = USER_ID + FOO_DECORATOR;
		final String barDecoratedUserId = USER_ID + BAR_DECORATOR;
		final UserGroupModel testGroup = createGroupWithMaxAttempts(GROUP_ID, 3);
		final UserModel fooDecoratedUser = createUser(fooDecoratedUserId, Set.of(testGroup));
		final UserModel barDecoratedUser = createUser(barDecoratedUserId, Set.of(testGroup));

		//when
		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(fooDecoratedUser);
		auditUserOnWrongCredentials(USER_ID, 1);
		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(barDecoratedUser);
		auditUserOnWrongCredentials(USER_ID, 1);

		//then
		assertThat(getAttemptsModelForUid(USER_ID)).isNull();
		assertThat(getAttemptsModelForUid(fooDecoratedUserId)).isNotNull();
		assertThat(getAttemptsModelForUid(barDecoratedUserId)).isNotNull();
	}

	@Test
	public void shouldBlockAppropriateUser()
	{
		//given
		final String fooDecoratedUserId = USER_ID + FOO_DECORATOR;
		final String barDecoratedUserId = USER_ID + BAR_DECORATOR;
		final UserGroupModel testGroup = createGroupWithMaxAttempts(GROUP_ID, 3);
		final UserModel fooDecoratedUser = createUser(fooDecoratedUserId, Set.of(testGroup));
		final UserModel barDecoratedUser = createUser(barDecoratedUserId, Set.of(testGroup));
		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(fooDecoratedUser);

		//when
		auditUserOnWrongCredentials(USER_ID, 3);

		//then
		modelService.refresh(fooDecoratedUser);
		modelService.refresh(barDecoratedUser);
		assertThat(fooDecoratedUser.isLoginDisabled()).isTrue();
		assertThat(barDecoratedUser.isLoginDisabled()).isFalse();

		// failed attempts audit actions are created
		final var failedUserAuthentications = getAuditableActions("failed user authentication");
		assertThat(failedUserAuthentications).hasSize(3);
		assertThat(failedUserAuthentications.stream()
				.filter(authentication -> fooDecoratedUser.getPk().equals(authentication.getActionAttributes().get("user")))
				.filter(authentication -> Boolean.FALSE.equals(authentication.getActionAttributes().get("userLoginDisabled")))
				.toList()).hasSize(3);

		//user disabled auditable action is recorded
		final Optional<AuditableActions.Action> optionalAction = getLastAuditableAction("user account disabled");
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(entry("user", fooDecoratedUser.getPk()),
				entry("message",
						"user with uid test@sap.com decorated to test@sap.com|foo has reached the max number of failed logins (3). The user login will be disabled"));
	}

	@Test
	public void shouldCorrectlyIncrementAttemptsForUsers()
	{
		//given
		final String fooDecoratedUserId = USER_ID + FOO_DECORATOR;
		final String barDecoratedUserId = USER_ID + BAR_DECORATOR;
		final UserGroupModel testGroup = createGroupWithMaxAttempts(GROUP_ID, 3);
		final UserModel fooDecoratedUser = createUser(fooDecoratedUserId, Set.of(testGroup));
		final UserModel barDecoratedUser = createUser(barDecoratedUserId, Set.of(testGroup));

		//when
		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(fooDecoratedUser);
		auditUserOnWrongCredentials(USER_ID, 2);

		when(defaultUserService.getUserForUID(USER_ID)).thenReturn(barDecoratedUser);
		auditUserOnWrongCredentials(USER_ID, 1);

		//then
		assertThat(getAttemptsModelForUid(fooDecoratedUserId).getAttempts()).isEqualTo(2);
		assertThat(getAttemptsModelForUid(barDecoratedUserId).getAttempts()).isEqualTo(1);

		// failed attempts audit actions are created
		final var failedUserAuthentications = getAuditableActions("failed user authentication");
		assertThat(failedUserAuthentications).hasSize(3);
		assertThat(failedUserAuthentications.stream()
				.filter(authentication -> fooDecoratedUser.getPk().equals(authentication.getActionAttributes().get("user")))
				.filter(authentication -> Boolean.FALSE.equals(authentication.getActionAttributes().get("userLoginDisabled")))
				.toList()).hasSize(2);
		assertThat(failedUserAuthentications.stream()
				.filter(authentication -> barDecoratedUser.getPk().equals(authentication.getActionAttributes().get("user")))
				.filter(authentication -> Boolean.FALSE.equals(authentication.getActionAttributes().get("userLoginDisabled")))
				.toList()).hasSize(1);

		// no user disabled audit actions are created
		final Optional<AuditableActions.Action> optionalAction = getLastAuditableAction("user account disabled");
		assertThat(optionalAction).isEmpty();
	}

	private UserModel createUser(final String userId, final Set<PrincipalGroupModel> groups)
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(userId);
		user.setGroups(groups);
		modelService.save(user);

		return user;
	}

	private UserGroupModel createGroupWithMaxAttempts(final String groupId, final int maxAttempts)
	{
		final UserGroupModel testUserGroup = modelService.create(UserGroupModel.class);
		testUserGroup.setUid(groupId);
		testUserGroup.setProperty(PrincipalGroupModel.MAXBRUTEFORCELOGINATTEMPTS, maxAttempts);
		modelService.save(testUserGroup);

		return testUserGroup;
	}

	private BruteForceLoginAttemptsModel getAttemptsModelForUid(final String userId)
	{
		return defaultUserAuditLoginStrategy.loadAttempts(userId).orElse(null);
	}

	private void auditUserOnWrongCredentials(final String userId, final int times)
	{
		IntStream.range(0, times).forEach(i -> defaultUserAuditLoginStrategy.auditUserOnWrongCredentials(userId));
	}

	private List<AuditableActions.Action> getAuditableActions(final String actionName)
	{

		final ArgumentCaptor<AuditableActions.Action> argCaptor = ArgumentCaptor.forClass(AuditableActions.Action.class);
		verify(testAuditableActionHandler, atLeastOnce()).auditAction(argCaptor.capture());

		return argCaptor.getAllValues().stream().filter(action -> actionName.equals(action.getActionName())).toList();

	}

	private Optional<AuditableActions.Action> getLastAuditableAction(final String actionName)
	{
		return getAuditableActions(actionName).stream().findFirst();
	}
}

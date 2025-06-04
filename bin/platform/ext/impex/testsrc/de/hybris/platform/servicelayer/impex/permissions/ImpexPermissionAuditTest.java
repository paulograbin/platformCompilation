/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.impex.permissions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.audit.AuditableActionsUtil;
import de.hybris.platform.audit.actions.AuditableActionHandler;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

@IntegrationTest
public class ImpexPermissionAuditTest extends ServicelayerBaseTest
{
	private static final String AUDIT_PERMISSION_AUDIT = "PERMISSION_AUDIT";
	private static final String AUDIT_MESSAGE = "message";
	private static final String AUDIT_TYPE_PK = "typePK";
	private static final String AUDIT_PRINCIPAL_PK = "principalPK";
	private static final String AUDIT_PERMISSION = "permission";
	private static final String TEST_USER = "test_user";
	private static final String AUDIT_PERMISSION_POSITIVE = "granted";
	private static final String AUDIT_PERMISSION_NEGATIVE = "denied";
	@Resource
	private ModelService modelService;
	@Resource
	private TypeService typeService;
	@Resource
	private ImportService importService;
	private AuditableActionHandler testAuditableActionHandler;
	private Supplier<AuditableActionHandler> originalActionHandler;

	@Before
	public void setUp()
	{
		testAuditableActionHandler = mock(AuditableActionHandler.class);
		originalActionHandler = AuditableActionsUtil.getAuditableActionHandlerFactory();
		AuditableActionsUtil.setAuditableActionHandlerFactory(() -> testAuditableActionHandler);
	}

	@After
	public void tearDown()
	{
		AuditableActionsUtil.setAuditableActionHandlerFactory(originalActionHandler);
	}


	@Test
	public void shouldLogsPermissionSetForImportedImpexFile()
	{
		final PK principlePK = createTestUser(TEST_USER);
		final ImportConfig importConfig = givenImpExImport();
		final ImportResult importResult = importService.importData(importConfig);

		final List<AuditableActions.Action> actionList = getAuditableActions(AUDIT_PERMISSION_AUDIT);
		assertThat(actionList).isNotEmpty();
		assertThat(actionList).hasSize(4);
		assertThat(actionList.get(0).getActionAttributes()).contains(
				entry(AUDIT_TYPE_PK, "82"),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_PERMISSION, permission(false)),
				entry(AUDIT_MESSAGE, "permission set"));
		assertThat(actionList.get(1).getActionAttributes()).contains(
				entry(AUDIT_TYPE_PK, "82"),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_PERMISSION, permission(true)),
				entry(AUDIT_MESSAGE, "permission set"));
		assertThat(actionList.get(2).getActionAttributes()).contains(
				entry(AUDIT_TYPE_PK, "82"),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_PERMISSION, permission(false)),
				entry(AUDIT_MESSAGE, "permission set"));
		assertThat(actionList.get(3).getActionAttributes()).contains(
				entry(AUDIT_TYPE_PK, "82"),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_PERMISSION, permission(true)),
				entry(AUDIT_MESSAGE, "permission set"));
	}

	private ImportConfig givenImpExImport()
	{
		final String script = givenUserRightsScript(UserModel.class, TEST_USER, "Title", ";+;-;+;-;;");
		final ImportConfig config = new ImportConfig();
		config.setEnableCodeExecution(Boolean.TRUE);
		config.setDistributedImpexEnabled(false);
		config.setLegacyMode(false);
		config.setScript(script);
		return config;
	}

	private String givenUserRightsScript(final Class<? extends UserModel> userClass, final String uid, final String target,
	                                     final String permissions)
	{
		final ComposedTypeModel userType = typeService.getComposedTypeForClass(userClass);
		final StringBuilder header = new StringBuilder("$START_USERRIGHTS").append("\nType;UID;MemberOfGroups");
		final StringBuilder data = new StringBuilder(userType.getCode()).append(";").append(uid).append(";;;;;;;");
		header.append(";Target;read;change;create;remove;change_perm");
		data.append("\n");
		data.append(";;;").append(target).append(permissions);
		return header.append("\n").append(data.toString()).append("\n").append("$END_USERRIGHTS").toString();
	}

	private PK createTestUser(final String userName)
	{
		final UserModel user = new UserModel();
		user.setUid(userName);
		modelService.save(user);
		return user.getPk();
	}

	private List<AuditableActions.Action> getAuditableActions(final String actionName)
	{
		final ArgumentCaptor<AuditableActions.Action> argCaptor = ArgumentCaptor.forClass(AuditableActions.Action.class);
		verify(testAuditableActionHandler, atLeastOnce()).auditAction(argCaptor.capture());

		return argCaptor.getAllValues().stream().filter(action -> actionName.equals(action.getActionName())).toList();
	}

	private String permission(final boolean negative)
	{
		if (negative)
		{
			return AUDIT_PERMISSION_NEGATIVE;
		}
		return AUDIT_PERMISSION_POSITIVE;
	}
}

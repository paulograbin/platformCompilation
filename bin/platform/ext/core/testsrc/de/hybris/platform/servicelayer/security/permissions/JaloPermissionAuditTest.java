/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.security.permissions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.core.PK;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.Arrays;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class JaloPermissionAuditTest extends PermissionAuditTest
{
	private final PropertyConfigSwitcher persistenceLegacyModeSwitch = new PropertyConfigSwitcher("persistence.legacy.mode");

	@Before
	public void enableLegacyPersistence()
	{
		persistenceLegacyModeSwitch.switchToValue("true");
		setUp();
	}

	@After
	public void resetPersistence()
	{
		persistenceLegacyModeSwitch.switchBackToDefault();
		tearDown();
	}

	@Test
	public void shouldLogPermissionRemoveForPrincipalPKs()
	{
		final PK itemWithPermission = itemPKWithPermission.getKey();
		permissionManagementStrategyFactory.getStrategy()
		                                   .removePermissionsByPrincipalPks(itemWithPermission,
				                                   Arrays.asList(itemPKWithPermission.getValue().getPrincipalPK()));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemWithPermission),
				entry(AUDIT_TYPE_PK, itemWithPermission.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_MESSAGE, "permission remove"));
	}

	@Test
	public void shouldLogGlobalPermissionRemoveByPermissionPKs()
	{
		final PK itemWithPermission = globalItemPKWithPermission.getKey();
		permissionManagementStrategyFactory.getStrategy()
		                                   .removeGlobalPermissionsByPermissionPks(
				                                   Arrays.asList(globalItemPKWithPermission.getValue().getRightPK()));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemWithPermission),
				entry(AUDIT_TYPE_PK, itemWithPermission.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePKForGlobalPermission),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_MESSAGE, "global permission remove"));
	}

	@Test
	public void shouldLogPermissionRemoveForPermissionPKs()
	{
		final PK itemWithPermission = itemPKWithPermission.getKey();
		permissionManagementStrategyFactory.getStrategy()
		                                   .removePermissionsByPermissionPks(itemWithPermission,
				                                   Arrays.asList(itemPKWithPermission.getValue().getRightPK()));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemWithPermission),
				entry(AUDIT_TYPE_PK, itemWithPermission.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_MESSAGE, "permission remove"));
	}
}

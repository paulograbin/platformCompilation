/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.security.permissions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import de.hybris.platform.audit.AuditableActions;
import de.hybris.platform.audit.AuditableActionsUtil;
import de.hybris.platform.audit.actions.AuditableActionHandler;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.security.UserRightModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.security.PermissionContainer;
import de.hybris.platform.persistence.meta.MetaInformationEJB;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.google.common.collect.ImmutableMap;

public abstract class PermissionAuditTest extends ServicelayerBaseTest
{
	protected static final String TEST_PERMISSION_1 = "TP1";
	protected static final String TEST_PERMISSION_2 = "TP2";
	private static final String TEST_USER = "test_user";
	private static final String TEST_USER_2 = "test_user_2";
	protected static final String AUDIT_PERMISSION_AUDIT = "PERMISSION_AUDIT";
	protected static final String AUDIT_PRINCIPAL_PK = "principalPK";
	protected static final String AUDIT_RIGHT_PK = "rightPK";
	protected static final String AUDIT_PERMISSION = "permission";
	private static final String AUDIT_PERMISSION_SET = "permission set";
	protected static final String AUDIT_PERMISSION_POSITIVE = "granted";
	protected static final String AUDIT_PERMISSION_NEGATIVE = "denied";
	protected static final String AUDIT_ITEM_PK = "PK";
	protected static final String AUDIT_TYPE_PK = "typePK";
	protected static final String AUDIT_MESSAGE = "message";
	private AuditableActionHandler testAuditableActionHandler;
	private Supplier<AuditableActionHandler> originalActionHandler;

	@Resource
	protected PermissionManagementStrategyFactory permissionManagementStrategyFactory;

	@Resource
	protected PermissionManagementService permissionManagementService;
	@Resource
	private ModelService modelService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private TypeService typeService;

	protected PK principlePK;
	protected PK principlePKForGlobalPermission;
	protected PK userRightPK;

	protected Pair<PK, PermissionContainer> itemPKWithPermission;

	protected Pair<PK, PermissionContainer> globalItemPKWithPermission;


	public void setUp()
	{
		principlePK = createTestUser(TEST_USER);
		principlePKForGlobalPermission = createTestUser(TEST_USER_2);

		permissionManagementService.createPermission(TEST_PERMISSION_1);
		userRightPK = getPermissionPKForName(TEST_PERMISSION_1);

		itemPKWithPermission = createTitleWithPermission(true, userRightPK);
		globalItemPKWithPermission = createGlobalPermission(true);

		testAuditableActionHandler = mock(AuditableActionHandler.class);
		originalActionHandler = AuditableActionsUtil.getAuditableActionHandlerFactory();
		AuditableActionsUtil.setAuditableActionHandlerFactory(() -> testAuditableActionHandler);
	}


	public void tearDown()
	{
		AuditableActionsUtil.setAuditableActionHandlerFactory(originalActionHandler);
	}

	@Test
	public void shouldLogPermissionSetForItemWithDeniedAccess()
	{
		final PK itemPK = createTitle(UUID.randomUUID().toString());
		final boolean negative = true;

		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		//when
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(permissionContainer));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(negative)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));
	}

	@Test
	public void shouldLogPermissionSetForComposedType()
	{
		final ComposedTypeModel itemType = typeService.getComposedTypeForCode(ItemModel._TYPECODE);
		final PK itemPK = itemType.getPk();
		final boolean negative = true;

		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		//when
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(permissionContainer));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(negative)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));
	}

	@Test
	public void shouldLogPermissionSetForAttributeDescriptor()
	{
		final ComposedTypeModel composedType = typeService.getComposedTypeForCode(ItemModel._TYPECODE);
		final AttributeDescriptorModel attributeDescriptor = typeService.getAttributeDescriptor(composedType.getCode(), "pk");
		final PK itemPK = attributeDescriptor.getPk();
		final boolean negative = true;

		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		//when
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(permissionContainer));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(negative)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));
	}

	@Test
	public void shouldLogsMultiplePermissionSet()
	{
		final PK itemPK = createTitle(UUID.randomUUID().toString());
		permissionManagementService.createPermission(TEST_PERMISSION_2);
		final PK userRightPK2 = getPermissionPKForName(TEST_PERMISSION_2);

		final PermissionContainer pc1 = createPC(principlePK, userRightPK, true);
		final PermissionContainer pc2 = createPC(principlePK, userRightPK2, false);

		//when
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(pc1,pc2));

		final List<AuditableActions.Action> actionList = getAuditableActions(AUDIT_PERMISSION_AUDIT);
		assertThat(actionList).isNotEmpty();
		assertThat(actionList).hasSize(2);
		assertThat(actionList.get(0).getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(true)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));

		assertThat(actionList.get(1).getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK2),
				entry(AUDIT_PERMISSION, permission(false)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));

	}
	@Test
	public void shouldLogPermissionSetForItemWithAllowedAccess()
	{
		final PK itemPK = createTitle(UUID.randomUUID().toString());
		final boolean negative = false;

		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		//when
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(permissionContainer));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemPK),
				entry(AUDIT_TYPE_PK, itemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(negative)),
				entry(AUDIT_MESSAGE, AUDIT_PERMISSION_SET));
	}

	@Test
	public void shouldLogPermissionSetForGlobalItem()
	{
		final boolean negative = true;

		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		//when
		permissionManagementStrategyFactory.getStrategy().writeGlobalPermissions(principlePK, Arrays.asList(permissionContainer));
		final PK globalAclItemPK = getGlobalAclItemPk();
		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, globalAclItemPK),
				entry(AUDIT_TYPE_PK, globalAclItemPK.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePK),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_PERMISSION, permission(negative)),
				entry(AUDIT_MESSAGE, "global permission set"));
	}


	@Test
	public void shouldLogPermissionRemoveForItem()
	{
		final PK itemWithPermission = itemPKWithPermission.getKey();
		permissionManagementStrategyFactory.getStrategy()
		                                   .removePermissionsByContainers(itemWithPermission,
				                                   Arrays.asList(itemPKWithPermission.getValue()));

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
	public void shouldLogGlobalPermissionRemove()
	{
		final PK itemWithPermission = globalItemPKWithPermission.getKey();
		permissionManagementStrategyFactory.getStrategy()
		                                   .removeGlobalPermissions(globalItemPKWithPermission.getValue().getPrincipalPK(),
				                                   Arrays.asList(globalItemPKWithPermission.getValue()));

		final Optional<AuditableActions.Action> optionalAction = getAuditableAction(AUDIT_PERMISSION_AUDIT);
		assertThat(optionalAction).isNotEmpty();
		assertThat(optionalAction.get().getActionAttributes()).containsOnly(
				entry(AUDIT_ITEM_PK, itemWithPermission),
				entry(AUDIT_TYPE_PK, itemWithPermission.getTypeCodeAsString()),
				entry(AUDIT_PRINCIPAL_PK, principlePKForGlobalPermission),
				entry(AUDIT_RIGHT_PK, userRightPK),
				entry(AUDIT_MESSAGE, "global permission remove"));
	}

	private Pair<PK, PermissionContainer> createTitleWithPermission(final Boolean negative, final PK userRightPK)
	{
		final PK itemPK = createTitle(UUID.randomUUID().toString());
		final PermissionContainer permissionContainer = createPC(principlePK, userRightPK, negative);
		permissionManagementStrategyFactory.getStrategy().writePermissionsForItem(itemPK, Arrays.asList(permissionContainer));
		return Pair.of(itemPK, permissionContainer);
	}

	private Pair<PK, PermissionContainer> createGlobalPermission(final Boolean negative)
	{
		final PK itemPK = getGlobalAclItemPk();
		final PermissionContainer permissionContainer = createPC(principlePKForGlobalPermission, userRightPK, negative);
		permissionManagementStrategyFactory.getStrategy()
		                                   .writeGlobalPermissions(principlePKForGlobalPermission,
				                                   Arrays.asList(permissionContainer));
		return Pair.of(itemPK, permissionContainer);
	}


	private String permission(final boolean negative)
	{
		if (negative)
		{
			return AUDIT_PERMISSION_NEGATIVE;
		}
		return AUDIT_PERMISSION_POSITIVE;
	}


	private PK createTestUser(final String userName)
	{
		final UserModel user = new UserModel();
		user.setUid(userName);
		modelService.save(user);
		return user.getPk();
	}

	private PK createTitle(final String code)
	{
		final TitleModel title = modelService.create(TitleModel.class);
		title.setCode(code);
		modelService.save(title);
		return title.getPk();
	}

	private PermissionContainer createPC(final PK principalPK, final PK rightPK, final boolean negative)
	{
		return new PermissionContainer(principalPK, rightPK, negative);
	}

	protected Optional<AuditableActions.Action> getAuditableAction(final String actionName)
	{
		final ArgumentCaptor<AuditableActions.Action> argCaptor = ArgumentCaptor.forClass(AuditableActions.Action.class);
		verify(testAuditableActionHandler, atLeastOnce()).auditAction(argCaptor.capture());

		return argCaptor.getAllValues().stream().filter(action -> actionName.equals(action.getActionName())).findFirst();
	}

	protected List<AuditableActions.Action> getAuditableActions(final String actionName)
	{
		final ArgumentCaptor<AuditableActions.Action> argCaptor = ArgumentCaptor.forClass(AuditableActions.Action.class);
		verify(testAuditableActionHandler, atLeastOnce()).auditAction(argCaptor.capture());

		return argCaptor.getAllValues().stream().filter(action -> actionName.equals(action.getActionName())).toList();
	}

	private PK getPermissionPKForName(final String permissionName)
	{
		final UserRightModel userRight = getPermissionForName(permissionName);
		return userRight.getPk();
	}

	private UserRightModel getPermissionForName(final String permissionName)
	{
		final String query = "SELECT {pk} FROM {" + UserRightModel._TYPECODE + "} WHERE {code}=?code";
		final Map<String, String> params = ImmutableMap.of("code", permissionName);
		final SearchResult<UserRightModel> results = flexibleSearchService.search(query, params);
		return results.getResult().get(0);
	}

	static PK getGlobalAclItemPk()
	{
		return MetaInformationEJB.DEFAULT_PRIMARY_KEY;
	}
}

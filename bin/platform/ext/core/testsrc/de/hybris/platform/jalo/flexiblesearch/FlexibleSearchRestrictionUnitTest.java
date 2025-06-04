/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.jalo.flexiblesearch;

import static de.hybris.platform.jalo.flexiblesearch.FlexibleSearch.DISABLE_INDIVIDUAL_SEARCHRESTRICTION_GROUPS_PROPERTY;
import static de.hybris.platform.jalo.flexiblesearch.FlexibleSearch.DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.jalo.JaloConnection;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.security.PrincipalGroup;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.config.ConfigIntf;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class FlexibleSearchRestrictionUnitTest
{
	private static final String USER_GROUP_1 = "group1";
	private static final String USER_GROUP_2 = "group2";
	@Mock
	private Tenant tenant;
	@Mock
	private JaloConnection jaloConnection;
	@Mock
	private ConfigIntf configIntf;
	@Mock
	private Principal principal;
	@Mock
	private PrincipalGroup group1;
	@Mock
	private PrincipalGroup group2;

	@Before
	public void setUp()
	{
		when(tenant.getJaloConnection()).thenReturn(jaloConnection);
		when(tenant.getConfig()).thenReturn(configIntf);
	}

	@Test
	public void shouldReturnNoPrincipalsForSearchRestrictionWhenGroupNotIncludedAndIndividualRestrictionDisabled()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			final boolean includeGroups = false;
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, includeGroups);

			// then
			assertThat(result).isEmpty();
		}
	}

	@Test
	public void shouldReturnNoUserFilterWhenGroupNotIncludedAndIndividualRestrictionDisabled()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			final boolean includeGroups = false;
			when(principal.isAdmin()).thenReturn(false);
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<AbstractQueryFilter> result = flexibleSearch.getUserFilters(principal, includeGroups, List.of());

			// then
			assertThat(result).isEmpty();
		}
	}

	@Test
	public void shouldReturnPrincipalIdForSearchRestrictionsWhenIndividualRestrictionEnabled()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(false);
			final boolean includeGroups = false;
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, includeGroups);

			// then
			assertThat(result).hasSize(1);
			assertThat(result).contains(principal);
		}
	}

	@Test
	public void shouldReturnGroupIdsForSearchRestrictionsWhenGroupsIncluded()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			final boolean includeGroups = true;
			when(principal.getAllGroups()).thenReturn(Set.of(group1, group2));
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, includeGroups);

			// then
			assertThat(result).hasSize(2);
			assertThat(result).contains(group1, group2);
		}
	}

	@Test
	public void shouldReturnGroupAndPrincipalIdsForSearchRestrictionsWhenGroupsIncludedAndIndividualRestrictionEnabled()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(false);
			final boolean includeGroups = true;
			when(principal.getAllGroups()).thenReturn(Set.of(group1, group2));
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, includeGroups);

			// then
			assertThat(result).hasSize(3);
			assertThat(result).contains(principal, group1, group2);
		}
	}

	@Test
	public void shouldNotReturnPrincipalIdForSearchRestrictionsWhenIndividualRestrictionDisabledAndUserBelongToConfiguredGroup()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			configMock.when(() -> Config.getString(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_GROUPS_PROPERTY, null))
			          .thenReturn(USER_GROUP_1);
			when(principal.getAllGroups()).thenReturn(Set.of(group1));
			when(group1.getUid()).thenReturn(USER_GROUP_1);
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			final Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);

			// then
			assertThat(result).isEmpty();
		}
	}

	@Test
	public void shouldReturnPrincipalIdForSearchRestrictionsWhenIndividualRestrictionDisabledButUserNotBelongToConfiguredGroup()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			configMock.when(() -> Config.getString(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_GROUPS_PROPERTY, null))
			          .thenReturn(USER_GROUP_1);
			final FlexibleSearch flexibleSearch = new FlexibleSearch();
			when(principal.getAllGroups()).thenReturn(Set.of());

			//when
			Collection<Principal> result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);

			// then
			assertThat(result).hasSize(1);
			assertThat(result).contains(principal);


			//given
			when(principal.getAllGroups()).thenReturn(Set.of(group2));
			when(group2.getUid()).thenReturn(USER_GROUP_2);

			//when
			result = flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);

			// then
			assertThat(result).hasSize(1);
			assertThat(result).contains(principal);
		}
	}

	@Test
	public void shouldReadDisableIndividualSearchRestrictionPropertiesOnlyOnceFromConfig()
	{
		try (final MockedStatic<Config> configMock = Mockito.mockStatic(Config.class);
		     final MockedStatic<Registry> registryMock = Mockito.mockStatic(Registry.class))
		{
			// given
			registryMock.when(Registry::getCurrentTenantNoFallback).thenReturn(tenant);
			configMock.when(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false)).thenReturn(true);
			configMock.when(() -> Config.getString(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_GROUPS_PROPERTY, null))
			          .thenReturn(USER_GROUP_1);
			when(principal.getAllGroups()).thenReturn(Set.of(group1));
			when(group1.getUid()).thenReturn(USER_GROUP_1);
			final FlexibleSearch flexibleSearch = new FlexibleSearch();

			//when
			flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);
			flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);
			flexibleSearch.getPrincipalsForSearchRestrictions(principal, false);

			// then
			configMock.verify(() -> Config.getBoolean(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_PROPERTY, false), times(1));
			configMock.verify(() -> Config.getString(DISABLE_INDIVIDUAL_SEARCHRESTRICTION_GROUPS_PROPERTY, null), times(1));
		}
	}
}

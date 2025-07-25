/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user.interceptors;

import static com.google.common.collect.ImmutableMap.of;
import static java.lang.String.format;

import de.hybris.platform.core.model.user.BruteForceLoginAttemptsModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.servicelayer.user.listener.util.OAuthUsernamePasswordAuthenticationToken;

import java.util.Collections;

import javax.annotation.Resource;

import org.junit.Before;
import org.springframework.security.core.Authentication;

import com.google.common.collect.ImmutableSet;

public abstract class AbstractAuthenticationEventListenerTest extends ServicelayerTransactionalBaseTest
{
	protected static final String testUid = "test";
	@Resource(name = "userService")
	protected UserService userService;
	@Resource(name = "modelService")
	protected ModelService modelService;
	@Resource(name = "flexibleSearchService")
	protected FlexibleSearchService searchService;

	@Before
	public void setUp() throws Exception
	{
		final UserModel user = modelService.create(UserModel.class);
		final UserGroupModel group = modelService.create(UserGroupModel.class);
		group.setUid("testGroup");
		user.setUid(testUid);
		group.setMaxBruteForceLoginAttempts(Integer.valueOf(2));
		user.setGroups(ImmutableSet.of(group));
		modelService.saveAll(user, group);
	}

	protected BruteForceLoginAttemptsModel findAttempts()
	{
		return searchService.searchUnique(new FlexibleSearchQuery(
				format("select {pk} from {%s} where {%s}= ?uid", BruteForceLoginAttemptsModel._TYPECODE,
						BruteForceLoginAttemptsModel.UID), of("uid", testUid)));
	}

	protected Authentication createNotAllowedAuthentication(final String uid)
	{
		return new OAuthUsernamePasswordAuthenticationToken(uid, "testPassword", Collections.emptyList());
	}
}

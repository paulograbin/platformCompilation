/*
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.security.AccessManager;
import de.hybris.platform.jalo.security.UserRight;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.testframework.HybrisJUnit4Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class SecurityAdminTest extends HybrisJUnit4Test
{
	private UserManager userManager;
	private UserRight userRight;
	private User user;
	private User admin;
	private UserGroup adminGroup;

	@Before
	public void setUp() throws ConsistencyCheckException
	{
		final AccessManager accessManager = jaloSession.getAccessManager();
		assertNotNull(userRight = accessManager.createUserRight("newUserRight"));

		userManager = jaloSession.getUserManager();
		admin = userManager.getAdminEmployee();
		adminGroup = userManager.getAdminUserGroup();

		assertNotNull(user = userManager.createUser("newUser"));
	}

	@After
	public void tearDown() throws Exception
	{
		userManager.removeItem(user);
		userRight.remove();
	}

	@Test
	public void testAdminRights()
	{
		assertNotNull(admin);
		assertNotNull(adminGroup);

		// check global permissions
		assertTrue(admin.checkGlobalPermission(userRight));
		assertTrue(adminGroup.checkGlobalPermission(userRight));
		assertFalse(user.checkGlobalPermission(userRight));

		checkGlobalPermissionsForUserInAdminGroup(user, userRight);

		// check item permissions
		final Item item = jaloSession.getSessionContext().getLanguage();
		assertNotNull(item);

		assertTrue(item.checkPermission(admin, userRight));
		assertTrue(item.checkPermission(adminGroup, userRight));
		assertFalse(item.checkPermission(user, userRight));

		checkItemPermissionsForUserInAdminGroup(item, user, userRight);
	}

	private void checkGlobalPermissionsForUserInAdminGroup(final User user, final UserRight userRight)
	{

		user.addToGroup(adminGroup);
		assertTrue(user.checkGlobalPermission(userRight));

		user.removeFromGroup(adminGroup);
		assertFalse(user.checkGlobalPermission(userRight));

		user.addGlobalPositivePermission(userRight);
		assertTrue(user.checkGlobalPermission(userRight));

		user.addGlobalNegativePermission(userRight);
		assertFalse(user.checkGlobalPermission(userRight));

		user.clearGlobalPermission(userRight);
		assertFalse(user.checkGlobalPermission(userRight));
	}

	private void checkItemPermissionsForUserInAdminGroup(final Item item, final User user, final UserRight userRight)
	{
		user.addToGroup(adminGroup);
		assertTrue(item.checkPermission(user, userRight));

		user.removeFromGroup(adminGroup);
		assertFalse(item.checkPermission(user, userRight));

		item.addPositivePermission(user, userRight);
		assertTrue(item.checkPermission(user, userRight));

		item.addNegativePermission(user, userRight);
		assertFalse(item.checkPermission(user, userRight));

		item.clearPermission(user, userRight);
		assertFalse(item.checkPermission(user, userRight));
	}

}

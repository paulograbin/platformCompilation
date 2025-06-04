/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import de.hybris.platform.core.Constants;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.JaloConnection;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Currency;
import de.hybris.platform.jalo.order.Cart;
import de.hybris.platform.jalo.order.Order;
import de.hybris.platform.jalo.order.OrderManager;
import de.hybris.platform.jalo.security.JaloSecurityException;
import de.hybris.platform.jalo.security.PasswordEncoderNotFoundException;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.persistence.security.PasswordEncoder;
import de.hybris.platform.persistence.security.PasswordEncoderFactory;
import de.hybris.platform.testframework.HybrisJUnit4Test;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.Config;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests group assignment of users
 */
public class UserTest extends HybrisJUnit4Test
{
	static final Logger log = Logger.getLogger(UserTest.class.getName());
	private User user, user2, user3, user4, user5;
	private UserGroup g1, g2, g3;
	private UserManager um;
	private OrderManager om;
	@SuppressWarnings("unused")
	private Order o1, o2;
	private final String cartCode1 = "cartCode1";
	private final String cartCode2 = "cartCode2";
	@SuppressWarnings("unused")
	private Cart cart1, cart2;
	private final String exampleTextToEncode = "TestText";
	private Address address1, address2;
	private final PropertyConfigSwitcher pcsDeactivateAdminsBlocked = new PropertyConfigSwitcher(User.USER_DEACTIVATION_BLOCK_FOR_ALL_ADMINS);
	private PasswordEncoderFactory passwordEncoderFactory;

	@Before
	public void setUp() throws Exception
	{
		om = jaloSession.getOrderManager();
		um = jaloSession.getUserManager();
		final Currency curr = jaloSession.getC2LManager().createCurrency("testCurr");
		passwordEncoderFactory = jaloSession.getTenant().getJaloConnection().getPasswordEncoderFactory();

		user = um.createCustomer("UserTest.heinz");
		user2 = um.createCustomer("UserTest2.markut");
		user3 = um.createCustomer("UserTest3.markut2");
		user4 = um.createCustomer("UserTest4.markut3");
		user5 = um.createCustomer("UserTest5.markut5");
		g1 = um.createUserGroup("UserTest.g1" + System.currentTimeMillis());
		g2 = um.createUserGroup("UserTest.g2" + System.currentTimeMillis());
		g3 = um.createUserGroup("UserTest.g3" + System.currentTimeMillis());
		o1 = om.createOrder("orderCode1", user, curr, new Date(), true);
		o2 = om.createOrder("orderCode2", user, curr, new Date(), true);
		cart1 = om.createCart(cartCode1, user, curr, new Date(), true);
		cart2 = om.createCart(cartCode2, user, curr, new Date(), false);

		address1 = um.createAddress(user5);
		address2 = um.createAddress(user5);

		final String defaultEncoding = Config.getString("default.password.encoding", "argon2");
		final String exampleTextEncoded = passwordEncoderFactory.getEncoder(defaultEncoding).encode(user2.getUid(), exampleTextToEncode);
		user2.setEncodedPassword(exampleTextEncoded);
		user3.setEncodedPassword(exampleTextEncoded, defaultEncoding);
		user4.setPassword(exampleTextToEncode, defaultEncoding);
	}

	@Test
	public void shouldSucceedSetLoginDisabledForAdminsWhenBlockIsFalse() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("false");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		newUserInAdmin.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setLoginDisabled(true);

		assertTrue(newUserInAdmin.isLoginDisabled());
	}

	@Test
	public void shouldSucceedSetDeactivationDateForAdminsWhenBlockIsFalse() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("false");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		newUserInAdmin.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setDeactivationDate(new Date());

		assertNotNull(newUserInAdmin.getDeactivationDate());
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetLoginDisabledForAdminsWhenBlockIsTrue() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("true");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		newUserInAdmin.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setLoginDisabled(true);
		fail("should fail to set loginDisabled for admins");
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetDeactivationDateForAdminsWhenBlockIsTrue() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("true");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		newUserInAdmin.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setDeactivationDate(new Date());
		fail("should fail to set deactivationDate for admins");
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetLoginDisabledForTheAdminEmployee() {
		final User admin = um.getAdminEmployee();
		admin.setLoginDisabled(true);
		fail("User with uid='admin' cannot be disabled for login");
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetDeactivationDateForTheAdminEmployee() {
		final User admin = um.getAdminEmployee();
		admin.setDeactivationDate(new Date());
		fail("User with uid='admin' cannot be deactivated");
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetLoginDisabledForSubGroupOfAdminWhenBlockIsTrue() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("true");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		final UserGroup subGroup = um.createUserGroup(UUID.randomUUID().toString());
		subGroup.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setGroups(Collections.singleton(subGroup));
		newUserInAdmin.setLoginDisabled(true);
		fail("should fail to set loginDisabled for admins");
	}

	@Test(expected = JaloSystemException.class)
	public void shouldBeBlockedSetDeactivationDateForSubGroupOfAdminWhenBlockIsTrue() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchToValue("true");
		final User newUserInAdmin = um.createEmployee(UUID.randomUUID().toString());
		final UserGroup subGroup = um.createUserGroup(UUID.randomUUID().toString());
		subGroup.setGroups(Collections.singleton(um.getAdminUserGroup()));
		newUserInAdmin.setGroups(Collections.singleton(subGroup));
		newUserInAdmin.setDeactivationDate(new Date());
		fail("should fail to set deactivationDate for admins");
	}

	/*
	 * Tests getEncodedPassword and setEncodedPassword methods
	 */
	@Test
	public void testEncodePasswordMethods()
	{
		assertTrue(passwordEncoderFactory.getEncoder(user2.getPasswordEncoding()).check(user2.getUid(), user2.getEncodedPassword(), exampleTextToEncode));
		assertTrue(passwordEncoderFactory.getEncoder(user3.getPasswordEncoding()).check(user3.getUid(), user2.getEncodedPassword(), exampleTextToEncode));
		assertTrue(passwordEncoderFactory.getEncoder(user4.getPasswordEncoding()).check(user4.getUid(), user2.getEncodedPassword(), exampleTextToEncode));
	}

	@Test
	public void testWrongEncoding()
	{
		final String old = user.getEncodedPassword();
		final String firstPassword = RandomStringUtils.randomAlphanumeric(16);
		final String secondPassword = RandomStringUtils.randomAlphanumeric(15);
		try
		{
			try
			{
				user.setPassword(firstPassword);
			}
			catch (final PasswordEncoderNotFoundException e)
			{
				fail("no default password encoder installed : " + e);
			}
			try
			{
				user.setPassword(firstPassword);
			}
			catch (final PasswordEncoderNotFoundException e)
			{
				fail("no default password encoder installed : " + e);
			}
			try
			{
				user.setPassword(secondPassword, "ENC");
				fail("there should be no ENC encoding - so expected an exception here");
			}
			catch (final PasswordEncoderNotFoundException e)
			{
				// fine here
			}
		}
		finally
		{
			user.setEncodedPassword(old);
		}
	}


	@Test
	public void testWrongUID()
	{
		Customer dbl = null;
		try
		{
			dbl = um.createCustomer("UserTest.heinz");
		}
		catch (final ConsistencyCheckException e)
		{
			// fine here
			/* conv-log */
			log.debug("ok: exception caught");
		}
		catch (final Exception e)
		{
			// unexpected exception !!!
			log.error(e.getMessage(), e);
			fail("unexpected exception : " + e.getClass().getName() + " message was " + e);
		}
		finally
		{
			if (dbl != null)
			{
				// wrong end: customer was created :-(
				try
				{
					dbl.remove();
					fail("duplicate customer was created!");
				}
				catch (final Exception e)
				{
					// what the ...
				}
			}
		}
	}

	@Test
	public void testGetOrders() throws Exception
	{
		final Collection coll = user.getOrders();
		assertEquals(2, coll.size());
	}

	@Test
	public void testGetCarts() throws Exception
	{
		final Collection coll = user.getCarts();
		assertEquals(2, coll.size());
	}

	@Test
	public void testGetCart() throws Exception
	{
		final Cart cart = user.getCart(cartCode1);
		assertEquals(cart1, cart);
	}

	@After
	public void tearDown() throws Exception
	{
		pcsDeactivateAdminsBlocked.switchBackToDefault();
	}

	@Test
	public void testGroups() throws ConsistencyCheckException
	{


		// test add
		g1.addMember(user);
		g2.addMember(user);
		g3.addMember(user);
		Collection groups = user.getGroups();
		assertTrue("user was not correctly added to groups",
				groups != null && groups.size() == 3 && groups.contains(g1) && groups.contains(g2) && groups.contains(g3));
		// test remove
		log.info(g2.getClass().getName());
		g2.removeMember(user);
		groups = user.getGroups();
		log.info(groups);
		assertTrue("g2 was not correctly removed from groups",
				groups != null && groups.size() == 2 && groups.contains(g1) && groups.contains(g3) && !groups.contains(g2));
		assertFalse("g2 was not correctly removed from groups", g2.getMembers().contains(user));
		assertFalse("g2 was not correctly removed from groups", g2.containsMember(user));
		// try to do things a second time: caching works?!
		g2.addMember(user);
		assertTrue(g2.containsMember(user));
		// /*conv-log*/ log.debug("---");
		// /*conv-log*/ log.debug("Inhalt der usergroup "+g2.getPK()+":"+ g2.getMembers() );
		// /*conv-log*/ log.debug("Inhalt des users "+user.getPK()+":"+ user.getGroups() );
		assertTrue("user did not belont to assigned group g2", user.getGroups().contains(g2));
		g2.removeMember(user);
		assertFalse(g2.containsMember(user));
		assertFalse(g2.getMembers().contains(user));
		assertFalse(user.getGroups().contains(g2));
		// rest removal upon deletion of group
		g3.remove();
		groups = user.getGroups();
		assertTrue("g3 was not corretly removed from groups", groups != null && groups.size() == 1 && groups.contains(g1));

	}

	@Test
	public void testCreateAnonymousCustomerSession() throws JaloSecurityException
	{
		final User anon = UserManager.getInstance().getAnonymousCustomer();

		final JaloConnection conn = JaloConnection.getInstance();
		final JaloSession s1 = conn.createAnonymousCustomerSession();
		final String password = RandomStringUtils.randomAlphanumeric(16);
		assertEquals(Constants.USER.ANONYMOUS_CUSTOMER, s1.getUser().getUID());


		anon.setPassword(password, "argon2");
		final JaloSession s2 = conn.createAnonymousCustomerSession();
		assertEquals(Constants.USER.ANONYMOUS_CUSTOMER, s2.getUser().getUID());
		assertEquals(s1.getUser(), s2.getUser());
		assertNotSame(s1, s2);

		final User s1User = s1.getUser();
		final String s1Encoding = s1User.getPasswordEncoding();
		final PasswordEncoder s1Encoder = passwordEncoderFactory.getEncoder(s1Encoding);
		assertTrue(s1Encoder.check(s1User.getUid(), s1User.getEncodedPassword(), password));
	}

	/**
	 * Tests for anonymous login are placed in {@link SessionTest#testJaloSessionPerformLogin()}
	 */
	@Test
	public void testAnonymousPasswordCheck()
	{
		final Customer anon = UserManager.getInstance().getAnonymousCustomer();

		final String firstPassword = RandomStringUtils.randomAlphanumeric(16);
		final String secondPassword = RandomStringUtils.randomAlphanumeric(15);
		final String pwBefore = anon.getEncodedPassword();
		final String encBefore = anon.getPasswordEncoding();
		final String alwaysDisableSettingBefore = Config.getParameter(Customer.LOGIN_ANONYMOUS_ALWAYS_DISABLED);
		Boolean isDisabledBefore = null;
		try
		{
			// need to enable ability to get real password check
			Config.setParameter(Customer.LOGIN_ANONYMOUS_ALWAYS_DISABLED, "false");
			isDisabledBefore = anon.isLoginDisabledAsPrimitive();
			anon.setLoginDisabled(false);
			assertFalse(anon.isLoginDisabledAsPrimitive());
			anon.setPassword(firstPassword);
			final String firstEncodedPassword = anon.getEncodedPassword();
			assertTrue(anon.checkPassword(firstPassword));
			assertFalse(anon.checkPassword(secondPassword));
			assertFalse(anon.checkPassword(firstEncodedPassword));

			anon.setPassword(secondPassword);
			final String secondEncodedPassword = anon.getEncodedPassword();
			assertTrue(anon.checkPassword(secondPassword));
			assertFalse(anon.checkPassword(firstPassword));
			assertFalse(anon.checkPassword(firstEncodedPassword));
			assertFalse(anon.checkPassword(secondEncodedPassword));

			// now test enforcing anonymous being disabled
			Config.setParameter(Customer.LOGIN_ANONYMOUS_ALWAYS_DISABLED, "true");
			assertFalse(anon.isLoginDisabledAsPrimitive());
			assertFalse(anon.checkPassword(firstPassword));
			assertFalse(anon.checkPassword(secondPassword));
			assertFalse(anon.checkPassword(firstEncodedPassword));
			assertFalse(anon.checkPassword(secondEncodedPassword));
		}
		finally
		{
			if (isDisabledBefore != null)
			{
				anon.setLoginDisabled(isDisabledBefore.booleanValue());
			}
			Config.setParameter(Customer.LOGIN_ANONYMOUS_ALWAYS_DISABLED, alwaysDisableSettingBefore);
			anon.setEncodedPassword(pwBefore, encBefore);
		}
	}

	@Test
	public void testRemoveAllAddressesAttachedToOwner()
	{
		assertTrue(user5.isAlive());
		assertTrue(address1.isAlive());
		assertTrue(address2.isAlive());

		try
		{
			um.removeItem(user5);
		}
		catch (final ConsistencyCheckException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}

		assertFalse(user5.isAlive());
		assertFalse(address1.isAlive());
		assertFalse(address2.isAlive());
	}

	@Test
	public void testSetEncodedPasswordUsesDefaultEncoderInsteadOfPlainEncoderWhenItIsNotServiceLayer()
	{
		//given
		final String password = RandomStringUtils.randomAlphanumeric(16);;
		final String plainEncoding = "plain";
		final String defaultEncoding = Config.getString("default.password.encoding", "argon2");
		final SessionContext ctx = jaloSession.createSessionContext();

		//when password encoding is plain and the change is not through the service layer
		user.setEncodedPassword(ctx, password, plainEncoding);

		//then encoding ia automatically set to default encoding and password is encoded accordingly
		assertNotEquals(plainEncoding, user.getPasswordEncoding());
		assertEquals(defaultEncoding, user.getPasswordEncoding());

		assertTrue(passwordEncoderFactory.getEncoder(defaultEncoding).check(user.getUid(), user.getEncodedPassword(), password));
	}
}

package com.epam.freelancer.business.manager;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.model.Customer;

public class UserManagerTest {
	private static UserManager userManager;

	@BeforeClass
	public static void init() {
		userManager = (UserManager) ApplicationContext.getInstance().getBean(
				"userManager");
	}

	@Test
	public final void testModify() {
		Customer customer = (Customer) userManager
				.findUserByEmail("kumar@gmail.com");
		customer.setUuid(UUID.randomUUID().toString());

		userManager.modifyUser(customer);
	}

	@Test
	public final void testFind() {
		assertNotNull(userManager.findUserByEmail("belousov@gmail.com"));
		assertNull(userManager.findUserByEmail("asgas@sdfs.sdgsd"));

		assertNotNull(userManager
				.findUserByUUID("f284afa5-757e-4916-a103-a768d3ba70eb"));
		assertNull(userManager.findUserByUUID("f284adgsd3ba70eb"));
	}

	@Test
	public final void testAvailable() {
		assertTrue(userManager.isEmailAvailable("asfag@adfsdg.agdsg"));
		assertFalse(userManager.isEmailAvailable("ryzkov@gmail.com"));

		assertTrue(userManager
				.isUUIDAvailable("f284afa5-75a-49asga768d3ba70eb"));
		assertFalse(userManager
				.isUUIDAvailable("f284afa5-757e-4916-a103-a768d3ba70eb"));
	}

}

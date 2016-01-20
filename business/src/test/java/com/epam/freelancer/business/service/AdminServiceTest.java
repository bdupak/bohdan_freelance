package com.epam.freelancer.business.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.dao.AdminDao;
import com.epam.freelancer.database.dao.GenericDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Admin;

public class AdminServiceTest {
	private static AdminService service;

	@BeforeClass
	public static void prepare() {
		service = (AdminService) ApplicationContext.getInstance().getBean(
				"adminService");
	}

	@Test
	public final void testFind() {
		assertNotNull(service.findById(1));
		assertNull(service.findById(4));
		assertNull(service.findById(5));

		assertNotNull(service.findAll());

		assertTrue(service.findAll().size() >= 1);
	}

	@Test
	public final void testModify() {
		Admin admin = service.findByEmail("adminfreelancer@gnail.com");
		assertNotNull(admin);
		admin.setUuid(UUID.randomUUID().toString());
		GenericDao<Admin, Integer> dao = DAOManager.getInstance().getDAO(
				AdminDao.class.getSimpleName());
		assertNotNull(dao.update(admin));
	}

	@Test
	public final void testSpecific() {
		assertFalse(service.emailAvailable("adminfreelancer@gnail.com"));
		assertTrue(service.emailAvailable("adminsdgsdglancer@gnail.com"));
	}

}

package com.epam.freelancer.business.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.dao.DeveloperDao;
import com.epam.freelancer.database.dao.GenericDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Developer;

public class DeveloperServiceTest {
	private static DeveloperService service;

	@BeforeClass
	public static void prepare() {
		service = (DeveloperService) ApplicationContext.getInstance().getBean(
				"developerService");
	}

	@Test
	public final void testFind() {
		assertNotNull(service.findById(3));
		assertNotNull(service.findById(4));
		assertNotNull(service.findById(5));

		assertNotNull(service.findAll());

		assertTrue(service.findAll().size() == 10);
	}

	@Test
	public final void testModify() {
		Developer developer = service.findByEmail("iuliana@gmail.com");
		developer.setRegUrl(UUID.randomUUID().toString());

		GenericDao<Developer, Integer> dao = DAOManager.getInstance().getDAO(
				DeveloperDao.class.getSimpleName());
		dao.save(developer);
	}

	@Test
	public final void testDeleteCreate() {
	}
}

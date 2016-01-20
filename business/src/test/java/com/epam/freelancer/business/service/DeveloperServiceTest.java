package com.epam.freelancer.business.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.dao.DeveloperDao;
import com.epam.freelancer.database.dao.GenericDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Ordering;

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

		assertTrue(service.findAll().size() >= 8);
	}

	@Test
	public final void testModify() {
		Developer developer = service.findByEmail("iuliana@gmail.com");
		assertNotNull(developer);
		developer.setRegUrl(UUID.randomUUID().toString());

		GenericDao<Developer, Integer> dao = DAOManager.getInstance().getDAO(
				DeveloperDao.class.getSimpleName());
		assertNotNull(dao.update(developer));
	}

	@Test
	public final void testSpecific() {
		assertFalse(service.emailAvailable("iuliana@gmail.com"));
		List<Ordering> portfolio = service.getDeveloperPortfolio(4);
		assertTrue(portfolio.size() == 1);
		assertTrue(service.getAllWorkers().size() > 7);

		assertTrue(service.getContactByDevId(4).getPhone()
				.equals("87274859032"));
		assertTrue(service.getWorkerById(5).getSumHours().equals(130.0));
	}

}

package com.epam.freelancer.business.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.dao.FeedbackDao;
import com.epam.freelancer.database.dao.GenericDao;
import com.epam.freelancer.database.dao.jdbc.DAOManager;
import com.epam.freelancer.database.model.Feedback;

public class FeedbackServiceTest {
	private static FeedbackService service;

	@BeforeClass
	public static void prepare() {
		service = (FeedbackService) ApplicationContext.getInstance().getBean(
				"feedbackService");
	}

	@Test
	public final void testFind() {
		assertNotNull(service.findById(3));
		assertNotNull(service.findById(4));
		assertNull(service.findById(5));

		assertNotNull(service.findAll());

		assertTrue(service.findAll().size() >= 3);
	}

	@Test
	public final void testModify() {
		Feedback feedback = new Feedback();
		assertNotNull(feedback);
		feedback.setComment(UUID.randomUUID().toString());

		GenericDao<Feedback, Integer> dao = DAOManager.getInstance().getDAO(
				FeedbackDao.class.getSimpleName());
		assertNotNull(dao.update(feedback));
	}

	@Test
	public final void testSpecific() {
		List<Feedback> feedbacks = service.findFeedbacksByCustId(4);
		assertTrue(feedbacks.size() == 3);
		feedbacks = service.findFeedbacksByDevId(4);
		assertTrue(feedbacks.size() == 3);
	}

}

package com.epam.freelancer.business.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.freelancer.business.context.ApplicationContext;
import com.epam.freelancer.database.model.Contact;

public class DeveloperServiceTest {

	@Test
	public final void test() {
		DeveloperService developerService = (DeveloperService) ApplicationContext
				.getInstance().getBean("developerService");
		Contact contact = developerService.getContactByDevId(2);
		
		assertNotNull(contact);
		System.out.println(contact);
	}

}

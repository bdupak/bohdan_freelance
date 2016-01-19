package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.Contact;

/**
 * Created by ������ on 17.01.2016.
 */
public interface ContactDao extends GenericDao<Contact, Integer> {

	public Contact getContactByDevId(Integer id);

	public Contact getContactByCustId(Integer id);

}

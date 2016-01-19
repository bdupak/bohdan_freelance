package com.epam.freelancer.database.dao.jdbc;

import com.epam.freelancer.database.dao.OrderingDao;
import com.epam.freelancer.database.model.Ordering;

/**
 * Created by ������ on 17.01.2016.
 */
public class OrderingJdbcDao extends GenericJdbcDao<Ordering, Integer>
		implements OrderingDao
{
	public OrderingJdbcDao() throws Exception {
		super(Ordering.class);
	}
}

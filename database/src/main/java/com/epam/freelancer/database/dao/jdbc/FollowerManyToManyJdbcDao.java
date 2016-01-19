package com.epam.freelancer.database.dao.jdbc;

import com.epam.freelancer.database.dao.FollowerManyToManyDao;
import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Follower;
import com.epam.freelancer.database.model.Ordering;
import com.epam.freelancer.database.transformer.DataTransformer;

public class FollowerManyToManyJdbcDao extends
		GenericJdbcManyToManyDao<Developer, Ordering, Follower, Integer>
		implements FollowerManyToManyDao
{
	public FollowerManyToManyJdbcDao() throws Exception {
		super("follower", "developer", "ordering", "dev_id", "order_id",
				new DataTransformer<>(Developer.class), new DataTransformer<>(
						Ordering.class), new DataTransformer<>(Follower.class));
	}
}

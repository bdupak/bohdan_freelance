package com.epam.freelancer.database.dao.jdbc;

import com.epam.freelancer.database.dao.TechnologyDao;
import com.epam.freelancer.database.model.Technology;

/**
 * Created by ������ on 17.01.2016.
 */
public class TechnologyJdbcDao extends GenericJdbcDao<Technology, Integer>
		implements TechnologyDao
{
	public TechnologyJdbcDao() throws Exception {
		super(Technology.class);
	}
}

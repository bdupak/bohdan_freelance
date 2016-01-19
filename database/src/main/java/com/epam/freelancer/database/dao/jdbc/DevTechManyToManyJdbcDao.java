package com.epam.freelancer.database.dao.jdbc;

import com.epam.freelancer.database.dao.DevTechManyToManyDao;
import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Technology;
import com.epam.freelancer.database.model.Worker;
import com.epam.freelancer.database.transformer.DataTransformer;

public class DevTechManyToManyJdbcDao extends
		GenericJdbcManyToManyDao<Developer, Technology, Worker, Integer>
		implements DevTechManyToManyDao
{

	public DevTechManyToManyJdbcDao() throws Exception {
		super("dev_tech", "developer", "technology", "dev_id", "tech_id",
				new DataTransformer<>(Developer.class), new DataTransformer<>(
						Technology.class), new DataTransformer<>(Worker.class));
	}

}

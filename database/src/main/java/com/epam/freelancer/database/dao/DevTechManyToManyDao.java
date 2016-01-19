package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Technology;
import com.epam.freelancer.database.model.Worker;

public interface DevTechManyToManyDao extends
		GenericManyToManyDao<Developer, Technology, Worker, Integer>
{

}

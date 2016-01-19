package com.epam.freelancer.database.dao;

import com.epam.freelancer.database.model.Developer;
import com.epam.freelancer.database.model.Follower;
import com.epam.freelancer.database.model.Ordering;

public interface FollowerManyToManyDao extends
		GenericManyToManyDao<Developer, Ordering, Follower, Integer>
{

}

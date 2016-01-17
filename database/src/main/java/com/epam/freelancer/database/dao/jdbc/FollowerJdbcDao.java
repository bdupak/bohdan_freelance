package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.dao.FollowerDao;
import com.epam.freelancer.database.model.Follower;

/**
 * Created by ������ on 17.01.2016.
 */
public class FollowerJdbcDao extends GenericJdbcDao<Follower, Integer> implements FollowerDao {
    public FollowerJdbcDao(Class<Follower> class1) throws Exception {
        super(class1);
    }
}

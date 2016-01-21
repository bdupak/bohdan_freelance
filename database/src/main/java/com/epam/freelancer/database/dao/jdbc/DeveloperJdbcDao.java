package com.epam.freelancer.database.dao.jdbc;

import com.epam.freelancer.database.dao.DeveloperDao;
import com.epam.freelancer.database.model.Developer;

/**
 * Created by ������ on 17.01.2016.
 */
public class DeveloperJdbcDao extends UserJdbcDao<Developer, Integer> implements DeveloperDao {
    public DeveloperJdbcDao() throws Exception {
        super(Developer.class);
    }
}

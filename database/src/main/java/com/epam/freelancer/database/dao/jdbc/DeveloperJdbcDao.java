package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.model.Developer;

/**
 * Created by ������ on 17.01.2016.
 */
public class DeveloperJdbcDao extends UserJdbcDao<Developer, Integer> {
    public DeveloperJdbcDao(Class<Developer> class1) throws Exception {
        super(class1);
    }
}

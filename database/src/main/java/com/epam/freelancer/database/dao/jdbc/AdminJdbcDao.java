package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.model.Admin;

/**
 * Created by ������ on 17.01.2016.
 */
public class AdminJdbcDao extends UserJdbcDao<Admin, Integer> {
    public AdminJdbcDao() throws Exception {
        super(Admin.class);
    }
}

package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.model.Customer;

/**
 * Created by ������ on 17.01.2016.
 */
public class CustomerJdbcDao extends UserJdbcDao<Customer, Integer> {
    public CustomerJdbcDao() throws Exception {
        super(Customer.class);
    }
}

package com.epam.freelancer.database.dao;


import com.epam.freelancer.database.model.DeveloperQA;

/**
 * Created by ������ on 17.01.2016.
 */
public interface DeveloperQADao extends GenericDao<DeveloperQA, Integer> {
    public DeveloperQA getDevQAByDevId(Integer id);
}

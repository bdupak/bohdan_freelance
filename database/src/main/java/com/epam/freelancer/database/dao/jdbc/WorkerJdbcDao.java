package com.epam.freelancer.database.dao.jdbc;


import com.epam.freelancer.database.dao.WorkerDao;
import com.epam.freelancer.database.model.Worker;

/**
 * Created by ������ on 17.01.2016.
 */
public class WorkerJdbcDao extends GenericJdbcDao<Worker, Integer> implements WorkerDao {
    public WorkerJdbcDao(Class<Worker> class1) throws Exception {
        super(class1);
    }
}
